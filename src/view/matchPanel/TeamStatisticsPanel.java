package view.matchPanel;

import javax.swing.JPanel;

import view.SVGLabel;
import view.SizeAndLocationAndFont;

public class TeamStatisticsPanel extends JPanel{
	
	SVGLabel team;
	
	OneTeamMatchStatisticsTablePanel statisticsPanel;
	
	public TeamStatisticsPanel(java.io.File svg, String[][] content, String[] headListForRow, String[] headListForColumn){
		team = new SVGLabel(svg, SizeAndLocationAndFont.teamStatisticsPanelSVGLabelWidth, SizeAndLocationAndFont.teamStatisticsPanelSVGLabelHeight);
		team.setLocation(0, 0);
		statisticsPanel = new OneTeamMatchStatisticsTablePanel(content, headListForRow, headListForColumn);
		
		this.add(team);
		this.add(statisticsPanel);
		
		this.setOpaque(false);
		this.setLayout(null);
		this.setSize(SizeAndLocationAndFont.teamStatisticsPanelWidth, SizeAndLocationAndFont.teamStatisticsPanelHeight);
	}
	
}
