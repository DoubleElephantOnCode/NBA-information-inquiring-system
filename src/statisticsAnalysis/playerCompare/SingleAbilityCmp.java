package statisticsAnalysis.playerCompare;

import statisticsAnalysis.BoxChart;

public class SingleAbilityCmp {
	BoxChart chart;
	String title;
	String x_name, y_name;
	
	public SingleAbilityCmp(String ability, String player1, String player2, String season, int after){
		
		chart = new BoxChart(title, x_name, y_name);
		
	}
	
}
