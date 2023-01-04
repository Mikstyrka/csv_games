import java.sql.*;

public class SelectAll {
    private Connection connect() {
        String url = "jdbc:sqlite:game.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectAll(){
        String sql = "SELECT * FROM games";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()) {
                System.out.println(rs.getInt("ID") + " || " +
                       rs.getString("Name") + " || " +
                       rs.getString("Platform") + " || " +
                       rs.getInt("Year") + " || " +
                       rs.getString("Genre") + " || " +
                       rs.getString("Publisher") + " || " +
                       rs.getString("NA_Sales") + " || " +
                       rs.getString("EU_Sales") + " || " +
                       rs.getString("JP_Sales") + " || " +
                       rs.getString("Other_Sales") + " || " +
                       rs.getString("Global_Sales"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        var app = new SelectAll();
        app.selectAll();
    }
}
