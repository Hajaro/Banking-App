import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

    public static String[] login(Boolean isGui, String default_username,String default_password) throws SQLException {
        Connection connection = SQL_Connection.ConnectToDB();
        Statement statement = connection.createStatement();
        String username = default_username;
        String password = default_password;
        if(isGui) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your username: ");
            username = scanner.nextLine();
            System.out.println("Enter your password: ");
            password = scanner.nextLine();
        }
        String query = String.format("SELECT username, password, socialSecNum, role FROM users WHERE username = '%s' AND password = MD5('%s')", username, password);
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            System.out.println("Login successful");
            String social_security_number = resultSet.getString("socialSecNum");
            String role = resultSet.getString("role");
            switch (role) {
                case "customer" -> {
                    return new String[]{social_security_number, "customer"};
                }
                case "employee" -> {
                    return new String[]{social_security_number, "employee"};
                }
                case "admin" -> {
                    return new String[]{social_security_number, "admin"};
                }
            }
        }
        return new String[]{"Invalid login credentials", "invalid"};
    }

}

