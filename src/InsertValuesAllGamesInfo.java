import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertValuesAllGamesInfo {
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
    public void insert(String name, String platform, Integer year, String genre, String publisher, Double NA_Sales, Double EU_Sales, Double JP_Sales, Double Other_Sales, Double Global_Sales) {
        String sql = "INSERT INTO games(Name, Platform, Year, Genre, Publisher, NA_Sales, EU_Sales, JP_Sales, Other_Sales, Global_Sales) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, platform);
            ps.setInt(3, year);
            ps.setString(4, genre);
            ps.setString(5, publisher);
            ps.setDouble(6, NA_Sales);
            ps.setDouble(7, EU_Sales);
            ps.setDouble(8, JP_Sales);
            ps.setDouble(9, Other_Sales);
            ps.setDouble(10, Global_Sales);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        var app = new InsertValuesAllGamesInfo();
        var open = new OpenCsv();
        open.main();
        for (int i = 0; i < open.names.size(); i++) {
            try{
                var year = Integer.valueOf(open.years.get(i));
                var NA = Double.valueOf(open.all_NA_Sales.get(i));
                var EU = Double.valueOf(open.all_EU_Sales.get(i));
                var JP = Double.valueOf(open.all_JP_Sales.get(i));
                var other = Double.valueOf(open.all_other_Sales.get(i));
                var global = Double.valueOf(open.all_global_Sales.get(i));
            }
            catch (NumberFormatException e){
                continue;
            }
            app.insert(open.names.get(i), open.platforms.get(i), Integer.valueOf(open.years.get(i)), open.genres.get(i),
                    open.publishers.get(i), Double.valueOf(open.all_NA_Sales.get(i)), Double.valueOf(open.all_EU_Sales.get(i)),
                    Double.valueOf(open.all_JP_Sales.get(i)), Double.valueOf(open.all_other_Sales.get(i)), Double.valueOf(open.all_global_Sales.get(i)));
        }
    }
}
