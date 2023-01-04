import java.sql.*;

public class SelectJPmax{
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

    public void select(){
        String sql = "SELECT *, MAX(JP_Sales) FROM games WHERE Year>=2000 and Year<=2006 and Genre='Sports'";

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
}
