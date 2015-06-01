package statisticsAnalysis;

import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class TimeSeriesChart {
	TimeSeriesCollection xydataset;
	
	ChartPanel p;
	
	String title, x_name, y_name;
	
	public TimeSeriesChart(String title, String x_name, String y_name){
		this.title = title;
		this.x_name = x_name;
		this.y_name = y_name;
		xydataset = new TimeSeriesCollection();
	}
	
	public void add(TimeSeries series){
//		series.add(new Day(new Date()), 1);
		xydataset.addSeries(series);
	}
	
	public ChartPanel getChartPanel(){
		JFreeChart jfreeChart = ChartFactory.createTimeSeriesChart(title, x_name, y_name, xydataset, true, true, true);
		p = new ChartPanel(jfreeChart, true);
		return p;
	}
}
