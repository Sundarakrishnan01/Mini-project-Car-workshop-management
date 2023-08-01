package Car_Garrage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

class details {
    String car_number;
    String issue;
    long id;
    String url = "jdbc:mysql://localhost:3306/workshop";
    String user = "root";
    String pass = "Sundar@$2004";

    details(String car_number, String issue, long id) {
        this.car_number = car_number;
        this.issue = issue;
        this.id = id;
    }

    // void display() {
    // System.out.println("Car Number: " + car_number);
    // System.out.println("Issue: " + issue);
    // System.out.println("Id: " + id);
    // }
    void insert() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        // Statement st = con.createStatement();
        PreparedStatement ps = con
                .prepareStatement("insert into car_details (CarNumber,Issues,OwnerId) values (?,?,?)");
        ps.setString(1, car_number);
        ps.setString(2, issue);
        ps.setLong(3, id);
        int i = ps.executeUpdate();
        System.out.println("Car Details Inserted Successfully: ");
        // String qur = "insert into service_details (car_number) values (?)";

        PreparedStatement pqr = con
                .prepareStatement("insert into service_details (carnumber,issues,EmployeeId) values (?,?,?)");
        pqr.setString(1, car_number);
        pqr.setString(2, issue);
        pqr.setLong(3, 7);
        int j = pqr.executeUpdate();
        System.out.println("Service Details Inserted Successfully: ");
        PreparedStatement rst = con
                .prepareStatement("select serviceid from service_details order by serviceid desc limit 1");
        ResultSet rs = rst.executeQuery();
        while (rs.next()) {
            System.out.println("Your service id: " + rs.getInt(1));
        }
        Scanner sc = new Scanner(System.in);
        int p = 0;
        while (p != 3) {
            System.out.println(" _____________________________");
            System.out.println("|                             |");
            System.out.println("|  1. View car details        |");
            System.out.println("|  2. Exit                    |");
            System.out.println("|_____________________________|");
            // System.out.println(" ____________________________");
            System.out.println("\nEnter your choice: ");
            p = sc.nextInt();
            if (p == 1) {
                vier_car vi = new vier_car();
                vi.view(id);

            } else if (p == 2) {
                System.out.println("Thank You!!!");
                break;
            } else {
                System.out.println("Enter valid input");
            }
        }

    }
}

public class car_details {
    public void car(long id) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter the Car Number: ");
            String car_number = sc.nextLine();

            System.out.print("Enter the Issue of the car: ");
            String issue = sc.nextLine();

            details obj = new details(car_number, issue, id);
            obj.insert();
        } catch (InputMismatchException e) {
            System.out.println("Enter the valid data: ");
        }

    }
}
