package menus;

import managers.EmployeeManager;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuEmployee {

    public MenuEmployee(String social_security_number) {
    }

    public void showMenu(String social_security_number) throws SQLException {
        System.out.println("Menu");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            EmployeeManager employeeManager = new EmployeeManager(social_security_number);
            System.out.println("1. Change balance");
            System.out.println("2. Add account");
            System.out.println("3. Add customer");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 4) {
                break;
            }
            switch (choice) {
                case 1:
                    employeeManager.changeBalance();
                    break;
                case 2:
                    employeeManager.addAccount();
                    break;
                case 3:
                    employeeManager.addCustomer();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}
