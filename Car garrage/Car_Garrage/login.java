package Car_Garrage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class Auth {
    long userId;
    String password;

    Auth(long userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    Auth(long userId) {
        this.userId = userId;
    }

    // void display() {
    // System.out.println("User Id: " + userId);
    // System.out.println("Password: " + password);
    // }
    String url = "jdbc:mysql://localhost:3306/workshop";
    String user = "root";
    String pass = "Sundar@$2004";

    public void val() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        // Statement st = con.createStatement();
        String query = "select password from user_register where MobileNo=" + userId;
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        int choice;
        while (rs.next()) {
            if (rs.getString(1).equals(password)) {
                System.out.println("Login Successfull");
                System.out.println(" _____________________________");
                System.out.println("|                             |");
                System.out.println("|  1. Register for service    |");
                System.out.println("|  2. View car details        |");
                // System.out.println("| 3. Admin login |");
                System.out.println("|  3. Exit                    |");
                System.out.println("|_____________________________|");
                // System.out.println(" ____________________________");
                System.out.println("\nEnter your choice: ");
                choice = sc.nextInt();
                // System.out.println("Welcome "+rs.getString(1));
                // System.out.println("Your Address: "+rs.getString(3));
                // System.out.println("Your Mobile Number: "+rs.getLong(4));
                if (choice == 1) {

                    System.out.println("Enter the Car details: ");
                    car_details cd = new car_details();
                    cd.car(userId);
                } else if (choice == 2) {
                    vier_car ni = new vier_car();
                    ni.view(userId);
                } else if (choice == 3) {
                    break;
                } else {
                    System.out.println("Enter the valid input!!!");
                }
            } else {
                System.out.println("Invalid Password");
            }
        }
    }
}

public class login {
    public void log() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the userId: ");
        long userId = sc.nextLong();

        System.out.println("Enter the password: ");
        String password = sc.next();

        Auth obj = new Auth(userId, password);
        obj.val();

    }

}
