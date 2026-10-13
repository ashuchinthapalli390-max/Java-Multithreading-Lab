import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        String url = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/mydatabase");
        String user = System.getenv().getOrDefault("DB_USER", "root");
        String password = System.getenv("DB_PASSWORD");
        if (password == null) {
            System.err.println("Set DB_PASSWORD before running this program.");
            return;
        }
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement create = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(100) NOT NULL, email VARCHAR(255) NOT NULL)")) {
                create.executeUpdate();
            }
            connection.setAutoCommit(false);
            try (PreparedStatement insert = connection.prepareStatement(
                    "INSERT INTO users (name, email) VALUES (?, ?)")) {
                insert.setString(1, "John Doe");
                insert.setString(2, "johndoe@example.com");
                insert.executeUpdate();
                insert.setString(1, "Jane Doe");
                insert.setString(2, "janedoe@example.com");
                insert.executeUpdate();
                connection.commit();
                System.out.println("Data inserted successfully.");
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            System.exit(1);
        }
    }
}
