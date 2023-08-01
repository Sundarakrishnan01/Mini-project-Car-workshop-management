package Car_Garrage;

import java.sql.SQLException;
import java.util.Scanner;
import Car_Garrage.user_registration;
import Car_Garrage.employee_register;
import Car_Garrage.login;

public class mainCar {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        int p = 1;
        int choice = 0;
        while (choice != 5) {
            System.out.println(" _____________________________");
            System.out.println("|                             |");
            System.out.println("|  1. User Registration       |");
            System.out.println("|  2. Login                   |");
            System.out.println("|  3. Admin login             |");
            System.out.println("|  4. Exit                    |");
            System.out.println("|_____________________________|");
            // System.out.println(" ____________________________");
            System.out.println("\nEnter your choice: ");
            choice = sc.nextInt();
            // sc.close();
            if (choice == 4) {
                System.out.println("Thank you for visiting");
                break;
            } else if (choice == 1) {
                user_registration obj = new user_registration();
                obj.hello();
            } else if (choice == 2) {
                login obj = new login();
                obj.log();
            } else if (choice == 3) {
                adminLogin obj = new adminLogin();
                obj.admin();
            } else {
                System.out.println("Invalid choice");
            }

        }

    }
}
