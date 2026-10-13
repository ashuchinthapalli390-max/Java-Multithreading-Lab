import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public static void main(String[] args) {
        String url = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/mydatabase");
        String user = System.getenv().getOrDefault("DB_USER", "root");
        String password = System.getenv("DB_PASSWORD");
        if (password == null) {
            System.err.println("Set DB_PASSWORD before running this program.");
            return;
        }
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet rows = statement.executeQuery("SELECT id, username, email FROM users ORDER BY id")) {
            while (rows.next()) {
                System.out.printf("User ID: %d, Username: %s, Email: %s%n",
                        rows.getInt("id"), rows.getString("username"), rows.getString("email"));
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            System.exit(1);
        }
    }
}
