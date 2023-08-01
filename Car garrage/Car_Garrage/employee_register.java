package Car_Garrage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

class Employee {
    String name;
    String password;
    String address;
    long phone;

    String url = "jdbc:mysql://localhost:3306/workshop";
    String user = "root";
    String pass = "Sundar@$2004";

    Employee(String name, String password, String address, long phone) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }

    // void display() {
    // System.out.println("Employee Name: " + name);
    // System.out.println("Employee Password: " + password);
    // System.out.println("Employee Address: " + address);
    // System.out.println("Employee Phone Number: " + phone);
    // }

    void insert() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        // Statement st = con.createStatement();
        PreparedStatement ps = con
                .prepareStatement("insert into employee_details (Name,Password,Address,MobileNo) values (?,?,?,?)");
        ps.setString(1, name);
        ps.setString(2, password);
        ps.setString(3, address);
        ps.setLong(4, phone);
        int i = ps.executeUpdate();
        String qur = "Select id from employee_details where MobileNo=" + phone;
        PreparedStatement pqr = con.prepareStatement(qur);
        // pqr.setLong(1, phone);
        // int id = pqr.executeUpdate();
        ResultSet rs = pqr.executeQuery();
        System.out.println("Employee Registered Successfully: ");
        while (rs.next()) {
            System.out.println("Your Id is: " + rs.getInt(1));
        }
        // String query = "insert into user_registration
        // (Name,Password,Address,MobileNo) values ('" + name + "','"
        // + password + "','" + address + "',"
        // + MobileNo + ")";
        // ResultSet rs = st.executeQuery(query);
        // System.out.println("User Registered Successfully: " + rs);

    }
}

public class employee_register {
    public void reg() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter the password: ");
        String password = sc.nextLine();

        System.out.print("Enter the password again: ");
        String cnfpassword = sc.nextLine();

        System.out.print("Enter the Employee address: ");
        String address = sc.nextLine();

        System.out.print("Enter the Employee phone number: ");
        long phone = sc.nextLong();

        if (password.equals(cnfpassword)) {
            // System.out.println("Employee Name: " + name);
            // System.out.println("Employee Password: " + password);
            // System.out.println("Employee Address: " + address);
            // System.out.println("Employee Phone Number: " + phone);
            Employee obj = new Employee(name, password, address, phone);
            obj.insert();
        } else {
            System.out.println("Password does not match");
        }

    }
}
