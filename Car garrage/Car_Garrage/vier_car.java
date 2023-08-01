package Car_Garrage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class vier_car {
    public void view(long id) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/workshop";
        String user = "root";
        String pass = "Sundar@$2004";

        String query = "select serviceId,c.CarNumber,s.issues,TotalPrice from service_details s join car_details c on c.CarNumber=s.CarNumber where OwnerId="
                + id;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        System.out.println("_________________________");
        System.out.format("%-1s %-10s %-10s %-10s \n",
                "Service Id", "CarNumber ", "Issues", "Total cost");
        while (rs.next()) {
            // System.out.print(rs.getInt(1));
            // System.out.printf("%7s", rs.getString(2));
            // System.out.printf("%7s", rs.getString(3));
            // System.out.printf("%7ld%n\n", rs.getLong(4));
            System.out.format("%-10s %-10s %-10s %-10s \n",
                    rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4));
        }
        Scanner sc = new Scanner(System.in);
        int p = 0;
        while (p != 3) {
            System.out.println(" _____________________________");
            System.out.println("|                             |");
            System.out.println("|  1. Register for service    |");
            System.out.println("|  2. Exit                    |");
            System.out.println("|_____________________________|");
            // System.out.println(" ____________________________");
            System.out.println("\nEnter your choice: ");
            p = sc.nextInt();
            if (p == 1) {
                car_details ca = new car_details();
                ca.car(id);

            } else if (p == 2) {
                System.out.println("Thank You!!!");
                break;
            } else {
                System.out.println("Enter valid input");
            }
        }

    }
}
