import java.sql.*;

public class AvgPlatform {
    double[] avg_collection = new double[31];
    String[] platforms_collection = new String[31];
    int i = 0;
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
        String sql = "SELECT Platform, AVG(Global_Sales) FROM games GROUP BY Platform";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()) {
                var platfotm = rs.getString("Platform");
                var avg = rs.getDouble("AVG(Global_Sales)");
                avg_collection[i] = avg;
                platforms_collection[i] = platfotm;
                i+=1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
