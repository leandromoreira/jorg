package jorg.gui.statistics;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public final class GraphGenerator {

    private DefaultCategoryDataset datasetGroup;
    private JFreeChart chartGroup;

    public JPanel getGroupChart() {
        return new ChartPanel(chartGroup);
    }
    
    public void generateGroupGraph(Map<String, Double> groupByPercent) {
        datasetGroup = new DefaultCategoryDataset();
        chartGroup = ChartFactory.createBarChart("", "Group", "Percent", datasetGroup, PlotOrientation.HORIZONTAL, true, true, true);
        double total = 0;
        Iterator<String> it1 = groupByPercent.keySet().iterator();
        while (it1.hasNext()) {
            String key = it1.next();
            double value = groupByPercent.get(key);
            total += value;
            NumberFormat df = DecimalFormat.getInstance();
            df.setMaximumFractionDigits(4);
            datasetGroup.addValue(value, "", key);
        }
        NumberFormat df = DecimalFormat.getInstance();
        df.setMaximumFractionDigits(4);
        datasetGroup.addValue((100.0d - total), "", "Others");
    }

    private DefaultCategoryDataset datasetPopularExtension;
    private JFreeChart chartPopularExtension;

    public JPanel getPopularExtensionChart() {
        return new ChartPanel(chartPopularExtension);
    }

    public void generateExtensionGraph(Map<String, Integer> groupByPercent) {
        datasetPopularExtension = new DefaultCategoryDataset();
        chartPopularExtension = ChartFactory.createBarChart("", "Extension", "Quantity", datasetPopularExtension, PlotOrientation.HORIZONTAL, true, true, true);
        Iterator<String> it1 = groupByPercent.keySet().iterator();
        while (it1.hasNext()) {
            String key = it1.next();
            Number value = groupByPercent.get(key);
            datasetPopularExtension.addValue(value, "", key);
        }
    }

    
}
