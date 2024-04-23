import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) throws SQLException {
        Connection connection = SQL_Connection.ConnectToDB();
        Statement statement = connection.createStatement();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        String query = String.format("SELECT username, password FROM users WHERE username = '%s' AND password = '%s'", username, password);
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }
}
