package statisticsAnalysis.playerCompare;

import java.util.ArrayList;

import org.jfree.chart.ChartPanel;
import org.jfree.data.statistics.BoxAndWhiskerCalculator;
import org.jfree.data.statistics.BoxAndWhiskerItem;

import statisticsAnalysis.BoxChart;

public class SingleAbilityCmp {
	BoxChart chart;
	String title;
	String x_name, y_name;
	
	public SingleAbilityCmp(String ability, String player1, ArrayList<Double> list1,String player2, ArrayList<Double> list2){
		
		chart = new BoxChart(title, x_name, y_name);
		BoxAndWhiskerItem item1 = BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(list1);
		BoxAndWhiskerItem item2 = BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(list2);
		chart.add(item1, "1", player1);
		chart.add(item2, "1", player2);
	}
	
	public ChartPanel getChartPanel(){
		return chart.getChartPanel();
	}
	
}
