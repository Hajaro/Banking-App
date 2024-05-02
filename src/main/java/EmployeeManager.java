import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManager {
    public EmployeeManager(String social_security_number) {
    }
    Scanner scanner = new Scanner(System.in);
    SQL_Connection sql_connection = new SQL_Connection();
    public void changeBalance() throws SQLException {
        System.out.println("Enter the social security number of the person you want to change the balance of: ");
        String social_security_number = scanner.nextLine();
        System.out.println("Enter the amount you want to change the balance by: ");
        Integer amount = scanner.nextInt();
        String query = String.format("UPDATE account SET balance = balance + %d WHERE person = '%s'", amount, social_security_number);
        sql_connection.makeQuery(query);
        System.out.println("You have changed the balance of " + social_security_number + " by " + amount);
    }
    public void addCustomer() throws SQLException {
        System.out.println("Enter the social security number of the person you want to add: ");
        String social_security_number_customer = scanner.nextLine();
        System.out.println("Enter the username of the person you want to add: ");
        String username = scanner.nextLine();
        System.out.println("Enter the password of the person you want to add: ");
        String password = scanner.nextLine();
        System.out.println("Enter the name of the person you want to add: ");
        String name = scanner.nextLine();
        System.out.println("Enter the last name of the person you want to add: ");
        String last_name = scanner.nextLine();
        System.out.println("Enter the age of the person you want to add: ");
        Integer age = scanner.nextInt();
        String query = String.format("INSERT INTO users VALUES ('%s', '%s', MD5('%s'), '%s', '%s', %d, 'customer')", social_security_number_customer, username, password, name, last_name, age);
        sql_connection.makeQuery(query);
        System.out.println("You have added " + name + " with social security number " + social_security_number_customer);
    }

    public void addAccount() throws SQLException {
        System.out.println("Enter the social security number of the person you want to add an account to: ");
        String social_security_number_account = scanner.nextLine();
        System.out.println("Enter the account number of the account you want to add: ");
        String account_number = scanner.nextLine();
        System.out.println("Enter the balance of the account you want to add: ");
        Integer balance = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the currency for the account: ");
        String currency = scanner.nextLine();
        String query = String.format("INSERT INTO account VALUES ('%s', '%s', '%s', %d)", social_security_number_account, account_number, currency, balance);
        sql_connection.makeQuery(query);
        System.out.println("You have added an account with number " + account_number + " to " + social_security_number_account);
    }
}
