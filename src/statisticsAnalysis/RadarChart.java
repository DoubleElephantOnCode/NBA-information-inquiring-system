package statisticsAnalysis;

import java.awt.Color;
import java.awt.GradientPaint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class RadarChart {
	ChartPanel p;
	JFreeChart jfreechart;
	public int NumOfAngle;
	public double angle;
	
	String title;
	XYSeriesCollection xyseriescollection;
	
	public RadarChart(String title, int NumOfAngle){
		this.NumOfAngle = NumOfAngle;
		this.title = title;
		angle = 360.0/(double)NumOfAngle;
		xyseriescollection = new XYSeriesCollection();
	}
	
	public void setBackground(Color c){
		PolarPlot polarplot = (PolarPlot) jfreechart.getPlot();
		polarplot.setBackgroundPaint(c);
		polarplot.setAngleGridlinesVisible(false);
	}
	
	public void add(XYSeries series){
		xyseriescollection.addSeries(series);
	}
	
	public ChartPanel getChartPanel(Color c, boolean colorEx){
		jfreechart = ChartFactory.createPolarChart(title, xyseriescollection, colorEx, false, false);
		PolarPlot polarplot = (PolarPlot) jfreechart.getPlot();
		polarplot.setBackgroundPaint(c);
		polarplot.setAngleGridlinesVisible(false);
		((NumberAxis)polarplot.getAxis()).setTickUnit(new NumberTickUnit(0.1));
		((NumberAxis)polarplot.getAxis()).setVisible(false);
		p = new ChartPanel(jfreechart);
		return p;
	}
	
}
