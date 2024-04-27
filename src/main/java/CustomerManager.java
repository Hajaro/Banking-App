import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerManager {
    private final String social_security_number;

    public CustomerManager(String social_security_number) {
        this.social_security_number = social_security_number;
    }

    Scanner scanner = new Scanner(System.in);
    SQL_Connection sql_connection = new SQL_Connection();

    public void deposit() throws SQLException {
        System.out.println("What account number would you like to deposit to?");
        String account_number = scanner.nextLine();
        System.out.println("How much would you like to deposit?");
        Integer deposit_amount = scanner.nextInt();
        String query = String.format("UPDATE account SET balance = balance + %d WHERE person = '%s' AND number = '%s'", deposit_amount, social_security_number, account_number);
        sql_connection.makeQuery(query);
        System.out.println("You have deposited " + deposit_amount);
    }

    public void withdraw() throws SQLException {
        System.out.println("What account number would you like to withdraw from?");
        String account_number = scanner.nextLine();
        System.out.println("How much would you like to withdraw?");
        int withdraw_amount = scanner.nextInt();
        String query = String.format("SELECT balance FROM account WHERE person = '%s' AND number = '%s'", social_security_number, account_number);
        if (withdraw_amount < 0) {
            System.out.println("You can't withdraw a negative amount");
            return;
        }
        ResultSet result_set = sql_connection.makeQuerySelect(query);
        if (result_set.next()) {
            int balance = result_set.getInt("balance");
            if (balance < withdraw_amount) {
                System.out.println("You only have " + balance + " in your account\nYou can't withdraw " + withdraw_amount + " from your account");
                return;
            }
            query = String.format("UPDATE account SET balance = balance - %d WHERE person = '%s'", withdraw_amount, social_security_number);
            sql_connection.makeQuery(query);
            System.out.println("You have withdrawn " + withdraw_amount + "\nYour new balance is " + (balance - withdraw_amount));
        }


    }

    public void takeLoan() throws SQLException {
        //TODO: Implement account number
        System.out.println("How much would you like to take out?");
        Integer loan_amount = scanner.nextInt();
        String query = String.format("UPDATE account SET balance = balance + %d WHERE person = '%s'", loan_amount, social_security_number);
        sql_connection.makeQuery(query);
        System.out.println("You have taken out a loan of " + loan_amount);
    }
}
