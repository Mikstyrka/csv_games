import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OpenCsv {
    ArrayList<String> column_name = new ArrayList<>();
    ArrayList<String> full_game_info = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> platforms = new ArrayList<>();
    ArrayList<String> years = new ArrayList<>();
    ArrayList<String> genres = new ArrayList<>();
    ArrayList<String> publishers = new ArrayList<>();
    ArrayList<String> all_NA_Sales = new ArrayList<>();
    ArrayList<String> all_EU_Sales = new ArrayList<>();
    ArrayList<String> all_JP_Sales = new ArrayList<>();
    ArrayList<String> all_other_Sales = new ArrayList<>();
    ArrayList<String> all_global_Sales = new ArrayList<>();

    public void main() {

        String line = "";
        var flag = true;

        try (BufferedReader br = new BufferedReader(new FileReader("Игры.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] game = line.split(",");
                if (flag == true){
                    column_name.add(game[1]);
                    column_name.add(game[2]);
                    column_name.add(game[3]);
                    column_name.add(game[4]);
                    column_name.add(game[5]);
                    column_name.add(game[6]);
                    column_name.add(game[7]);
                    column_name.add(game[8]);
                    column_name.add(game[9]);
                    column_name.add(game[10]);
                    flag = false;
                }
                else{
                    names.add(game[1]);
                    //
                    platforms.add(game[2]);
                    //
                    years.add(game[3]);
                    //
                    genres.add(game[4]);
                    //
                    publishers.add(game[5]);
                    //
                    all_NA_Sales.add(game[6]);
                    //
                    all_EU_Sales.add(game[7]);
                    //
                    all_JP_Sales.add(game[8]);
                    //
                    all_other_Sales.add(game[9]);
                    //
                    all_global_Sales.add(game[10]);
                }
                full_game_info.add(game[1] + ' ' + ' ' + game[2] + ' ' + ' ' + game[3] + ' ' + ' ' + game[4] + ' ' + ' ' + game[5] + ' ' + ' ' + game[6]
                        + ' ' + ' ' + game[7] + ' ' + ' ' + game[8] + ' ' + ' ' + game[9] + ' ' + ' ' + game[10]);

            }
            full_game_info.remove(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
