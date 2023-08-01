package Car_Garrage;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class adminLogin {
    public void admin() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the admin password: ");
        String password = sc.nextLine();
        String pass = "Osama bin laden";
        int p = 0;
        int choice = 0;

        while (p != 1) {
            if (password.equals(pass)) {
                System.out.println("Login Successfull");
                while (choice != 4) {
                    System.out.println(" ___________________________");
                    System.out.println("|                           |");
                    System.out.println("| 1. Employee Registration  |");
                    System.out.println("| 2. Service Details        |");
                    System.out.println("| 3. New Cars Arraival      |");
                    System.out.println("| 4. Exit                   |");
                    System.out.println("|___________________________|");
                    System.out.println("\nEnter your choice: ");
                    try {

                        choice = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Enter the valid details");
                    }
                    if (choice == 1) {
                        employee_register obj = new employee_register();
                        obj.reg();
                    } else if (choice == 2) {
                        service_details obj = new service_details();
                        obj.ser();
                    } else if (choice == 3) {
                        newCar obj = new newCar();
                        obj.car();

                    } else if (choice == 4) {
                        System.out.println("Thank you for visiting");
                        break;
                    } else {
                        System.out.println("Invalid choice");
                    }
                }

                p = 1;
            } else {
                System.out.println("Invalid Password");
                System.out.println("Enter the admin password: ");
                password = sc.nextLine();
            }
        }

        // if (password.equals(pass)) {
        // System.out.println("Login Successfull");

        // } else {
        // System.out.println("Invalid Password");
        // }
    }
}
