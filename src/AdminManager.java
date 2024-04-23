import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminManager {

    public AdminManager(String social_security_number) {
    }

    Scanner scanner = new Scanner(System.in);

    private void makeQuery(String query) throws SQLException {
        Connection connection = SQL_Connection.ConnectToDB();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void addUser() throws SQLException {
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
        System.out.println("Enter the role of the person you want to add: ");
        String role = scanner.nextLine();
        String query = String.format("INSERT INTO users VALUES ('%s', '%s', '%s', '%s', '%s', %d, '%s')", social_security_number_customer, username, password, name, last_name, age, role);
        makeQuery(query);
        System.out.println("You have added " + name + " with social security number " + social_security_number_customer);
    }

    public void removeUser() throws SQLException {
        System.out.println("Enter the social security number of the person you want to remove: ");
        String social_security_number_customer = scanner.nextLine();
        String query = String.format("DELETE FROM users WHERE socialSecNum = '%s'", social_security_number_customer);
        makeQuery(query);
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
        System.out.println("Enter the new role of the person you want to modify: ");
        String role = scanner.nextLine();
        String query = String.format("UPDATE users SET username = '%s', password = '%s', name = '%s', lastName = '%s', age = %d, role = '%s' WHERE socialSecNum = '%s'", username, password, name, last_name, age, role, social_security_number_customer);
        makeQuery(query);
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
        makeQuery(query);
        System.out.println("You have modified the account with account number " + account_number);
    }

}

