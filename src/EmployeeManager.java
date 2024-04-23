import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeManager {
    public EmployeeManager(String social_security_number) {
    }
    Scanner scanner = new Scanner(System.in);
    private void makeQuery(String query) throws SQLException {
        Connection connection = SQL_Connection.ConnectToDB();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
    public void changeBalance() throws SQLException {
        System.out.println("Enter the social security number of the person you want to change the balance of: ");
        String social_security_number = scanner.nextLine();
        System.out.println("Enter the amount you want to change the balance by: ");
        Integer amount = scanner.nextInt();
        String query = String.format("UPDATE account SET balance = balance + %d WHERE person = '%s'", amount, social_security_number);
        makeQuery(query);
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
        String query = String.format("INSERT INTO users VALUES ('%s', '%s', '%s', '%s', '%s', %d, 'customer')", social_security_number_customer, username, password, name, last_name, age);
        makeQuery(query);
        System.out.println("You have added " + name + " with social security number " + social_security_number_customer);
    }
}
