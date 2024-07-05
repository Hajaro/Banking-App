package menus;

import managers.AdminManager;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuAdmin {

    public MenuAdmin(String social_security_number) {
    }

    public void showMenu(String social_security_number) throws SQLException {
        System.out.println("Menu");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            AdminManager adminManager = new AdminManager(social_security_number);
            System.out.println("1. Add user");
            System.out.println("2. Remove user");
            System.out.println("3. Modify user");
            System.out.println("4. Modify account");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 5) {
                break;
            }
            switch (choice) {
                case 1:
//                    adminManager.addUser();
                    break;
                case 2:
                    adminManager.removeUser();
                    break;
                case 3:
                    adminManager.modifyUser();
                    break;
                case 4:
                    adminManager.modifyAccount();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}

