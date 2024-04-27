import java.sql.*;

public class SQL_Connection {
    public static Connection ConnectToDB() {
        String url = "jdbc:mysql://localhost:3306/banking_system?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "";
        try {
            //            System.out.println("Connected to the database");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public void makeQuery(String query) throws SQLException {
        Connection connection = ConnectToDB();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public ResultSet makeQuerySelect(String query) throws SQLException {
        Connection connection = ConnectToDB();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);

    }
}
