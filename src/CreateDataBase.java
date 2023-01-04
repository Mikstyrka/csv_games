import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDataBase {

    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:" + fileName;

        try (Connection conn = DriverManager.getConnection(url)){
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewDatabase("game.db");
    }

}