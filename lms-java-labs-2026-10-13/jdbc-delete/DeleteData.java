import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) {
        String url = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/mydatabase");
        String user = System.getenv().getOrDefault("DB_USER", "root");
        String password = System.getenv("DB_PASSWORD");
        if (password == null) {
            System.err.println("Set DB_PASSWORD before running this program.");
            return;
        }
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement delete = connection.prepareStatement("DELETE FROM users WHERE id = ?")) {
            delete.setInt(1, 2);
            int rowsDeleted = delete.executeUpdate();
            System.out.println(rowsDeleted > 0 ? "Row deleted successfully." : "No rows were deleted.");
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            System.exit(1);
        }
    }
}
