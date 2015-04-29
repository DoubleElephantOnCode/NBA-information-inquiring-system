package view.matchPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import view.SVGLabel;
import view.SizeAndLocationAndFont;
import view.TimeSetting;
import view.singleTeamPanel.SingleTeamPanel;
import control.ShowTeamController;

public class TeamStatisticsPanel extends JPanel{
	String name;
	
	SVGLabel team;
	
	OneTeamMatchStatisticsTablePanel statisticsPanel;
	
	public TeamStatisticsPanel(java.io.File svg, String[][] content, String[] headListForRow, String[] headListForColumn, String teamName){
		name = teamName;
		
		team = new SVGLabel(svg, SizeAndLocationAndFont.teamStatisticsPanelSVGLabelWidth, SizeAndLocationAndFont.teamStatisticsPanelSVGLabelHeight);
		team.setLocation(0, 0);
		team.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				SingleTeamPanel.initialTime();
				new ShowTeamController().showTeamFrame(name, TimeSetting.begin, TimeSetting.end);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		statisticsPanel = new OneTeamMatchStatisticsTablePanel(content, headListForRow, headListForColumn);
		
		this.add(team);
		this.add(statisticsPanel);
		
		this.setOpaque(false);
		this.setLayout(null);
		this.setSize(SizeAndLocationAndFont.teamStatisticsPanelWidth, SizeAndLocationAndFont.teamStatisticsPanelHeight);
	}
	
}
