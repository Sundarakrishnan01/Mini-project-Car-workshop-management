package JavaFile;

import java.util.*;

public class Register {
    public static void main(String arn[]) {
        Scanner sc = new Scanner(System.in);
        String name, address, mobileNo, password, confirmPassword;
        // sc.open();
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        // name="Sundarki";
        System.out.println("Enter your Password: ");
        password = sc.nextLine();
        System.out.println("Enter your Confirm Password: ");
        confirmPassword = sc.nextLine();
        System.out.println("Enter your Address: ");
        address = sc.nextLine();
        System.out.println("Enter your Mobile Number: ");
        mobileNo = sc.nextLine();
        sc.close();
        if (password.equals(confirmPassword)) {
            System.out.println("Registration Successful");
            System.out.println("Name: " + name);
            System.out.println("Address: " + address);
            System.out.println("Mobile Number: " + mobileNo);
        } else {
            System.out.println("Password and Confirm Password doesn't match");
        }
    }

}
