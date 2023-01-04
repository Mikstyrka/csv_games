import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class Ghistogramm extends ApplicationFrame {
    public Ghistogramm(String applicationTitle , String chartTitle) {
        super(applicationTitle);
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Platform",
                "Mean sales",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new java.awt.Dimension(1000 ,700 ));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {
        final String sales = "Sales";
        var data = new AvgPlatform();
        data.select();
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();
        for(int i = 0; i < 30; i++){
            dataset.addValue(data.avg_collection[i], sales, data.platforms_collection[i]);
        }

        return dataset;
    }
}
