package managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import sql.SQL_Connection;

public class CustomerManager {
    private final String social_security_number;

    public CustomerManager(String social_security_number) {
        this.social_security_number = social_security_number;
    }

    Scanner scanner = new Scanner(System.in);
    SQL_Connection sql_connection = new SQL_Connection();

    private String checkDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
    public void deposit() throws SQLException {
        System.out.println("What account number would you like to deposit to?");
        String account_number = scanner.nextLine();
        System.out.println("How much would you like to deposit?");
        Integer deposit_amount = scanner.nextInt();
        String query = String.format("UPDATE account SET balance = balance + %d WHERE person = '%s' AND number = '%s'", deposit_amount, social_security_number, account_number);
        sql_connection.makeQuery(query);
        String dateTime = checkDateTime();
        String query2 = String.format("INSERT INTO transaction_history (time_and_date, type, amount, from_account, to_account) VALUES ('%s', 'deposit', %d, 'outside', '%s')", dateTime, deposit_amount, account_number);
        sql_connection.makeQuery(query2);
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
            String query2 = String.format("UPDATE account SET balance = balance - %d WHERE person = '%s'", withdraw_amount, social_security_number);
            sql_connection.makeQuery(query2);
            String dateTime = checkDateTime();
            String query3 = String.format("INSERT INTO transaction_history (time_and_date, type, amount, from_account, to_account) VALUES ('%s', 'withdrawal', %d, '%s', 'withdrawal')", dateTime, withdraw_amount, account_number);
            sql_connection.makeQuery(query3);
            System.out.println("You have withdrawn " + withdraw_amount + "\nYour new balance is " + (balance - withdraw_amount));
        }


    }

    public void takeLoan() throws SQLException {
        //TODO: Implement account number
        LoanManager loanManager = new LoanManager(sql_connection);
        System.out.println("How much would you like to take out?");
        Integer loan_amount = scanner.nextInt();
        scanner.nextLine();
        loanManager.instantLoan(loan_amount, social_security_number, checkDateTime());
    }
}
