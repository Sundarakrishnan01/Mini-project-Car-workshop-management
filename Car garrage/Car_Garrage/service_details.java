package Car_Garrage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

interface service {
    int ser();

}

class hello implements service {
    private int service_id;

    public void setId(int service_id) {
        this.service_id = service_id;
    }

    public int getId() {
        return service_id;
    }

    public int ser() {
        return service_id;
    }
}

class calculatePrice {
    private long service_charge, extra_service_charge;
    long total_price;

    public void setServiceCharge(long service_charge, long extra_service_charge) {
        this.service_charge = service_charge;
        this.extra_service_charge = extra_service_charge;
    }

    long calc() {
        total_price = service_charge * 118 / 100 + extra_service_charge;
        return total_price;

    }
}

class setEmployee {
    public void setting(int service_id, int new_id, long total_price) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/workshop";
        String user = "root";
        String pass = "Sundar@$2004";
        String query = "update service_details set EmployeeId=?,TotalPrice=? where ServiceId=?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, new_id);
        ps.setLong(2, total_price);
        ps.setInt(3, service_id);
        int i = ps.executeUpdate();
        System.out.println("Employee Id and Service Charge Updated Successfully: ");
        System.out.println("________________________________________________________________");

    }
}

public class service_details {
    public void ser() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the car number: ");
        // String car_number = sc.nextLine();

        // System.out.print("Enter the Id of employee working in the car: ");
        // int id = sc.nextInt();

        // System.out.print("Enter the service charge: ");
        // long service_charge = sc.nextLong();
        try {
            System.out.print("Enter the service Id: ");
            int service_id = sc.nextInt();

            System.out.println("Enter the new Employee Id: ");
            int new_id = sc.nextInt();

            System.out.println("Enter the new service charge: ");
            long new_service_charge = sc.nextLong();

            System.out.println("Enter the extra service charge: ");
            long extra_service_charge = sc.nextLong();

            calculatePrice obj = new calculatePrice();
            obj.setServiceCharge(new_service_charge, extra_service_charge);
            long total_price = obj.calc();
            System.out.println("Total Price: " + total_price);
            System.out.println("________________________________________________________________");
            // System.out.print("Car Number: ");
            setEmployee obj1 = new setEmployee();
            obj1.setting(service_id, new_id, total_price);
        } catch (InputMismatchException e) {
            System.out.println("Please enter the valid value !!");
            System.out.println("________________________________________________________________");
        }

    }
}
