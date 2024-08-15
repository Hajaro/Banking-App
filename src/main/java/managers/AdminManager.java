package managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import sql.SQL_Connection;

public class AdminManager {

    public AdminManager(String social_security_number) {
    }

    Scanner scanner = new Scanner(System.in);

    SQL_Connection sql_connection = new SQL_Connection();

    public void addUser(String social_security_number_customer, String username, String password, String name, String last_name, Integer age, String role) throws SQLException {
//        System.out.println("Enter the social security number of the person you want to add: ");
//        String social_security_number_customer = scanner.nextLine();
//        System.out.println("Enter the username of the person you want to add: ");
//        String username = scanner.nextLine();
//        System.out.println("Enter the password of the person you want to add: ");
//        String password = scanner.nextLine();
//        System.out.println("Enter the name of the person you want to add: ");
//        String name = scanner.nextLine();
//        System.out.println("Enter the last name of the person you want to add: ");
//        String last_name = scanner.nextLine();
//        System.out.println("Enter the age of the person you want to add: ");
//        Integer age = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Enter the role of the person you want to add: ");
//        String role = scanner.nextLine();
        String query = String.format("INSERT INTO users VALUES ('%s', '%s', MD5('%s'), '%s', '%s', %d, '%s')", social_security_number_customer, username, password, name, last_name, age, role);
        sql_connection.makeQuery(query);
        System.out.println("You have added " + name + " with social security number " + social_security_number_customer);
    }

    public void removeUser() throws SQLException {
        System.out.println("Enter the social security number of the person you want to remove: ");
        String social_security_number_customer = scanner.nextLine();
        String query = String.format("DELETE FROM users WHERE socialSecNum = '%s'", social_security_number_customer);
        sql_connection.makeQuery(query);
        System.out.println("You have removed the user with social security number " + social_security_number_customer);
    }

    public void modifyUser() throws SQLException {
        System.out.println("Enter the social security number of the person you want to modify: ");
        String social_security_number_customer = scanner.nextLine();
        System.out.println("Enter the new username of the person you want to modify: ");
        String username = scanner.nextLine();
        System.out.println("Enter the new password of the person you want to modify: ");
        String password = scanner.nextLine();
        System.out.println("Enter the new name of the person you want to modify: ");
        String name = scanner.nextLine();
        System.out.println("Enter the new last name of the person you want to modify: ");
        String last_name = scanner.nextLine();
        System.out.println("Enter the new age of the person you want to modify: ");
        Integer age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the new role of the person you want to modify: ");
        String role = scanner.nextLine();
        String query = String.format("UPDATE users SET username = '%s', password = MD5('%s'), firstName = '%s', lastName = '%s', age = %d, role = '%s' WHERE socialSecNum = '%s'", username, password, name, last_name, age, role, social_security_number_customer);
        sql_connection.makeQuery(query);
        System.out.println("You have modified the user with social security number " + social_security_number_customer);
    }

    public void modifyAccount() throws SQLException {
        System.out.println("Enter the account number of the account you want to modify: ");
        Integer account_number = scanner.nextInt();
        System.out.println("Enter the new balance of the account you want to modify: ");
        Integer balance = scanner.nextInt();
        System.out.println("Enter the new owner of the account you want to modify: ");
        String owner = scanner.nextLine();
        String query = String.format("UPDATE account SET balance = %d, person = '%s' WHERE accountNumber = %d", balance, owner, account_number);
        sql_connection.makeQuery(query);
        System.out.println("You have modified the account with account number " + account_number);
    }

    public ResultSet searchUser(String social_security_number) throws SQLException {
        String query = String.format("SELECT * FROM users WHERE socialSecNum = '%s'", social_security_number);
        return sql_connection.makeQuerySelect(query);
    }

}

