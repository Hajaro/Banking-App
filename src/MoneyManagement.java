import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MoneyManagement {
    private final String social_security_number;
    public MoneyManagement(String social_security_number) {
        this.social_security_number = social_security_number;
    }
    Scanner scanner = new Scanner(System.in);
    private void makeQuery(String query) throws SQLException {
        Connection connection = SQL_Connection.ConnectToDB();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void deposit() throws SQLException {
        //TODO: Implement account number
        System.out.println("How much would you like to deposit?");
        Integer deposit_amount = scanner.nextInt();
        String query = String.format("UPDATE account SET balance = balance + %d WHERE person = '%s'", deposit_amount, social_security_number);
        makeQuery(query);
        System.out.println("You have deposited " + deposit_amount);
    }

    public void withdraw() throws SQLException {
        //TODO: Implement account number
        System.out.println("How much would you like to withdraw?");
        Integer withdraw_amount = scanner.nextInt();
        String query = String.format("UPDATE account SET balance = balance - %d WHERE person = '%s'", withdraw_amount, social_security_number);
        makeQuery(query);
        System.out.println("You have withdrawn " + withdraw_amount);
    }

    public void takeLoan() throws SQLException {
        //TODO: Implement account number
        System.out.println("How much would you like to take out?");
        Integer loan_amount = scanner.nextInt();
        String query = String.format("UPDATE account SET balance = balance + %d WHERE person = '%s'", loan_amount, social_security_number);
        makeQuery(query);
        System.out.println("You have taken out a loan of " + loan_amount);
    }
}
