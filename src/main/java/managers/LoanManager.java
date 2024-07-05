package managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import sql.SQL_Connection;

public class LoanManager {
    private final SQL_Connection sql_connection;
    Scanner scanner = new Scanner(System.in);
    public LoanManager(SQL_Connection sql_connection) {
        this.sql_connection = sql_connection;
    }
    public void instantLoan(Integer loan_amount, String social_security_number,String dateTime) throws SQLException {
        System.out.println("What account number would you like funds to go into?");
        String account_number = scanner.nextLine();
        String query = String.format("UPDATE account SET balance = balance + %d WHERE person = '%s' AND number = '%s'", loan_amount, social_security_number, account_number);
        sql_connection.makeQuery(query);
        System.out.println("You have received a loan of " + loan_amount + " into account number " + account_number);
        String query2 = String.format("INSERT INTO transaction_history (time_and_date, type, amount, from_account, to_account) VALUES ('%s', 'loan', %d, '999999' ,'%s')", dateTime, loan_amount, account_number);
        sql_connection.makeQuery(query2);
        String loan_account_number = account_number + "_loan";
        String query3 = String.format("SELECT number FROM account WHERE person = '%s'", social_security_number);
        ResultSet resultSet = sql_connection.makeQuerySelect(query3);
        boolean userAlreadyHasLoan = false;
        while (resultSet.next()) {
            if (resultSet.getString("number").equals(loan_account_number)) {
                userAlreadyHasLoan = true;
                break;
            }
        }
        if (userAlreadyHasLoan) {
            String query5 = String.format("UPDATE account SET balance = balance - %d WHERE person = '%s' AND number = '%s'", loan_amount, social_security_number, loan_account_number);
            sql_connection.makeQuery(query5);
            return;
        }
        String query4 = String.format("INSERT INTO account VALUES ('%s', '%s', 'PLN', %d)", loan_account_number,social_security_number, loan_amount * -1);
        sql_connection.makeQuery(query4);
    }
}
