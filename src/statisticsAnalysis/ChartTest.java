package statisticsAnalysis;

import javax.swing.JFrame;

public class ChartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame("Java数据统计图");
		frame.add(new RadarChart("test", 5).getChartPanel());
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
