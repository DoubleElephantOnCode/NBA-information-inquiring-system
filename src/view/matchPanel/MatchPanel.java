package view.matchPanel;

import javax.swing.JPanel;

import view.SizeAndLocationAndFont;

public class MatchPanel extends JPanel{
	
	TeamStatisticsPanel t1, t2;

	public MatchPanel(java.io.File team1, String[][] content1, String[] headListForRow1, String[] headListForColumn1,
			java.io.File team2, String[][] content2, String[] headListForRow2, String[] headListForColumn2){
		t1 = new TeamStatisticsPanel(team1, content1, headListForRow1, headListForColumn1);
		t1.setLocation(0, 0);
		
		t2 = new TeamStatisticsPanel(team2, content2, headListForRow2, headListForColumn2);
		t2.setLocation(0, t1.getHeight());
		
		this.add(t1);
		this.add(t2);
		this.setOpaque(false);
		this.setLayout(null);
		this.setSize(SizeAndLocationAndFont.matchPanelWidth, SizeAndLocationAndFont.matchPanelHeight);
		this.setLocation(SizeAndLocationAndFont.matchPanelLocationX, SizeAndLocationAndFont.matchPanelLocationY);
	}
	
}
