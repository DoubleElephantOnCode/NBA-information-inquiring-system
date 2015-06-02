package statisticsAnalysis.playerAbility;

import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYSeries;

import statisticsAnalysis.RadarChart;

public class PlayerRadarChartPanel {
	public ChartPanel p;
	public PlayerRadarChartPanel(double score, double board, double assistant, double steal, double block){
		RadarChart chart = new RadarChart(null, 5);
		XYSeries s = new XYSeries("player");
		s.add(0, score/30D);
		s.add(chart.angle, board/15D);
		s.add(chart.angle*2, assistant/10D);
		s.add(chart.angle*3, steal/5D);
		s.add(chart.angle*4, block/3D);
		chart.add(s);
		p = chart.getChartPanel(Color.LIGHT_GRAY, false);
	}
	
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize(400, 400);
		PlayerRadarChartPanel p = new PlayerRadarChartPanel(25.5, 13.2, 6.7, 2.1, 1.2);
		p.p.setSize(400, 400);
		p.p.setLocation(-5, -5);
		f.setLayout(null);
		f.add(p.p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
