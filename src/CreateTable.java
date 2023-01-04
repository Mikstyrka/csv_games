import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void createNewTable() {

        String url = "jdbc:sqlite:game.db";

        String sql = "CREATE TABLE IF NOT EXISTS games (\n"
                + "	ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "	Name text NOT NULL,\n"
                + "	Platform text NOT NULL,\n"
                + "	Year int NOT NULL,\n"
                + "	Genre text NOT NULL,\n"
                + "	Publisher text NOT NULL,\n"
                + "	NA_Sales real NOT NULL,\n"
                + "	EU_Sales real NOT NULL,\n"
                + "	JP_Sales real NOT NULL,\n"
                + "	Other_Sales real NOT NULL,\n"
                + "	Global_Sales real NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewTable();
        }
}
