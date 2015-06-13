package statisticsAnalysis;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
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
		XYPlot xyplot = (XYPlot) jfreeChart.getPlot();
		DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
// 		dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
		dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
		dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
		ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状
		rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
		jfreeChart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		if(jfreeChart.getTitle() != null){
			jfreeChart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
		}
		p = new ChartPanel(jfreeChart, true);
		return p;
	}
	
	public JFreeChart getJFreeChart(){
		JFreeChart jfreeChart = ChartFactory.createTimeSeriesChart(title, x_name, y_name, xydataset, true, true, true);
		XYPlot xyplot = (XYPlot) jfreeChart.getPlot();
		DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
// 		dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
		dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
		dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
		ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状
		rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
		jfreeChart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		if(jfreeChart.getTitle() != null){
			jfreeChart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
		}
		return jfreeChart;
	}
	
	public static void setRange(JFreeChart jfreeChart, Date lower, Date up){
		XYPlot xyplot = (XYPlot) jfreeChart.getPlot();
		DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
		dateaxis.setRange(lower, up);
	}
}
