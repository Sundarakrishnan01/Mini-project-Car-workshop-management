package Car_Garrage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

class Register {
    String name;
    String password;
    String Confirmpassword;
    String address;
    long MobileNo;
    String url = "jdbc:mysql://localhost:3306/workshop";
    String user = "root";
    String pass = "Sundar@$2004";

    // Register(String name, String password, String Confirmpassword, String
    // address, long MobileNo) {
    // this.name = name;
    // this.password = password;
    // this.Confirmpassword = Confirmpassword;
    // this.address = address;
    // this.MobileNo = MobileNo;
    // }
    void setValues(String name, String password, String Confirmpassword) {
        this.name = name;
        this.password = password;
        this.Confirmpassword = Confirmpassword;
        // this.address = address;
        // this.MobileNo = MobileNo;
    }

    void setValues(String address, long MobileNo) {
        // this.name = name;
        // this.password = password;
        // this.Confirmpassword = Confirmpassword;
        this.address = address;
        this.MobileNo = MobileNo;
    }

    // void display() {
    // System.out.println("Name: " + name);
    // System.out.println("Password: " + password);
    // System.out.println("Address: " + address);
    // System.out.println("Mobile No: " + MobileNo);
    // }
    void insert() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement st = con.createStatement();
        PreparedStatement ps = con
                .prepareStatement("insert into user_register (Name,Password,Address,MobileNo) values (?,?,?,?)");
        ps.setString(1, name);
        ps.setString(2, password);
        ps.setString(3, address);
        ps.setLong(4, MobileNo);
        int i = ps.executeUpdate();

        System.out.println("User Registered Successfully: ");
        System.out.println("Your Id is: " + MobileNo);
        System.out.println("________________________________________________________________");
        // String query = "insert into user_registration
        // (Name,Password,Address,MobileNo) values ('" + name + "','"
        // + password + "','" + address + "',"
        // + MobileNo + ")";
        // ResultSet rs = st.executeQuery(query);
        // System.out.println("User Registered Successfully: " + rs);

    }
}

class child extends Register {
    public void setValues(String address, long MobileNo) {
        super.setValues(address, MobileNo);
    }

    public void setValues(String name, String password, String Confirmpassword) {
        super.setValues(name, password, Confirmpassword);
    }
}

public class user_registration {
    public void hello() throws ClassNotFoundException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Enter your password: ");
        String password = input.nextLine();
        System.out.println("Enter your Confirm password: ");
        String Confirmpassword = input.nextLine();
        System.out.println("Enter your address: ");
        String address = input.nextLine();
        System.out.println("Enter your phone number: ");
        long MobileNo = input.nextLong();
        // input.close();
        if (password.equals(Confirmpassword)) {
            // System.out.println("Name: "+name);
            // System.out.println("Password: "+password);
            // System.out.println("Address: "+address);
            // System.out.println("Mobile No: "+MobileNo);
            child obj = new child();
            obj.setValues(address, MobileNo);
            obj.setValues(name, password, Confirmpassword);
            obj.insert();
        } else {
            System.out.println("Password and Confirm password are not same. Please try again.");
            System.out.println("________________________________________________________________");
        }

    }
}
