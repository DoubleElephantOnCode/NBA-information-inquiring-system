package view.teamCount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import control.ShowTeamController;
import view.File;
import view.SizeAndLocationAndFont;
import view.Team;
import view.mainFrame.ExitLabel;
import view.mainFrame.LabelEnterListener;
import view.mainFrame.Main;
import view.mainFrame.MenuLabel;
import view.mainFrame.GoForwardOrBackward.GoForwardOrBackwardPanel;
import view.searchPanel.SearchPanel;
import view.selectedPanel.SelectPanel;
import view.startView.StartPanel;

public class TeamCountPanel extends JPanel{

	static JLabel background;
	String[] headList;
	static TeamCountTablePanel table;
	
	static int width = SizeAndLocationAndFont.frameWidth;
	static int height = SizeAndLocationAndFont.frameHeight;
	
	static ExitLabel exit = StartPanel.exit;
	static MenuLabel menu = StartPanel.menu;
	static GoForwardOrBackwardPanel goForwardOrBackward = StartPanel.goForwardOrBackward;
	
	static SearchPanel search;
	static SelectPanel season, isAfter;
	
	public TeamCountPanel(String[][] content, String[] team, String[] headListForColumn, JLabel[] pic){
		
		background = Main.setJLabelWithIcon(File.file + File.teamCountBackground + File.GIF, width, height);
		table = new TeamCountTablePanel(content, team, headListForColumn, pic);
		
		search = new SearchPanel(SizeAndLocationAndFont.searchPanelWidth, SizeAndLocationAndFont.searchPanelHeight);
		search.setLocation(SizeAndLocationAndFont.searchPanelLocationX, SizeAndLocationAndFont.searchPanelLocationY);
		
		search.area.setForeground(table.fontColor);
		search.area.setFont(SizeAndLocationAndFont.searchPanelFont);
		search.area.setCaretColor(table.fontColor);
		
		season = new SelectPanel(SizeAndLocationAndFont.teamCountSelectSeasonWidth, SizeAndLocationAndFont.teamCountSelectSeasonHeight, Team.SEASON);
		season.setLocation(SizeAndLocationAndFont.teamCountSelectSeasonLocationX, SizeAndLocationAndFont.teamCountSelectSeasonLocationY);
		
		isAfter = new SelectPanel(SizeAndLocationAndFont.teamCountSelectAfterWidth, SizeAndLocationAndFont.teamCountSelectAfterHeight, Team.ISAFTER);
		isAfter.setLocation(SizeAndLocationAndFont.teamCountSelectAfterLocationX, SizeAndLocationAndFont.teamCountSelectSeasonLocationY);
		
		add(background);
		add(table, 0);
		add(search, 0);
		add(season, 0);
		add(isAfter, 0);
		
		if(exit == null) exit = new ExitLabel();
		exit.addToPanel(this);
		if(menu == null) menu = new MenuLabel();
		menu.addToPanel(this);
		if(goForwardOrBackward == null) goForwardOrBackward = new GoForwardOrBackwardPanel();
		goForwardOrBackward.addToPanel(this);
		
		search.searchEnter.addMouseListener(new LabelEnterListener(search.search, search.searchEnter){
			public void mouseClicked(MouseEvent e) {
				String temp = search.getInputText();
				int t = table.hpR.findIndex(temp);
				if(t < 0){
					t = table.hpC.findIndex(temp);
					if(t < 0){
						search.area.setText(null);
					}
					else{
						table.p.changeColumn(t-table.p.pointerColumn);
						table.hpC.moveToIndex(table.p.pointerColumn);
						table.brp.setPosition(table.p.pointerColumn);
					}
				}
				else{
					table.p.changeRow(t-table.p.pointerRow);
					table.hpR.moveToIndex(table.p.pointerRow);
					table.bcp.setPosition(table.p.pointerRow);
					table.teamPic.moveToIndex(table.p.pointerRow);
				}
			}
		});
		
		season.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				season.action();
				new ShowTeamController(false).chooseSeasonAndIsPlayOff(season.getSelectedItem(), isAfter.getSelectedIndex());
			}
		});
		
		isAfter.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				isAfter.action();
				new ShowTeamController(false).chooseSeasonAndIsPlayOff(season.getSelectedItem(), isAfter.getSelectedIndex());
			}
		});
		
		setSize(width, height);
		setLayout(null);
		setLocation(0, -5);
	}
	
	public void resetTableInfo(String[][] content, String[] team, JLabel[] teamPic){
		table.p.setContent(content);
		table.hpR.resetInfo(team);
		table.teamPic.resetJLabel(teamPic);
	}
	
}
