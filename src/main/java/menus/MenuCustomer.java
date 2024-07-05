package menus;

import managers.CustomerManager;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuCustomer {

    public MenuCustomer(String social_security_number) {
    }

    public void showMenu(String social_security_number) throws SQLException {
        System.out.println("Menu");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            CustomerManager money_management = new CustomerManager(social_security_number);
            System.out.println("1. Make a deposit");
            System.out.println("2. Make a withdrawal");
            System.out.println("3. Take out a loan");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 4) {
                break;
            }
            switch (choice) {
                case 1:
                    money_management.deposit();
                    break;
                case 2:
                    money_management.withdraw();
                    break;
                case 3:
                    money_management.takeLoan();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}
