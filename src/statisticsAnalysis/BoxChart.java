package statisticsAnalysis;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.BoxAndWhiskerItem;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

public class BoxChart {
	
	String title = "3";//标题
	String categoryAxisLabel = "4";//x轴命名
	String valueAxisLabel = "5";//y轴命名
	DefaultBoxAndWhiskerCategoryDataset dataset;//箱形图列表
	
	ChartPanel p;
	
	public BoxChart(String title, String x, String y){
		this.title = title;
		this.categoryAxisLabel = x;
		this.valueAxisLabel = y;
		dataset = new DefaultBoxAndWhiskerCategoryDataset();
	}
	
	public void add(BoxAndWhiskerItem item, String type, String x_value){
		dataset.add(item, type, x_value);
	}
	
	public ChartPanel getChartPanel(boolean e){
		JFreeChart jfreeChart = ChartFactory.createBoxAndWhiskerChart(title, categoryAxisLabel, valueAxisLabel, dataset, e);
		
		if(jfreeChart.getTitle() != null){
			jfreeChart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
		}
		p = new ChartPanel(jfreeChart, true);
		return p;
	}
	
}
