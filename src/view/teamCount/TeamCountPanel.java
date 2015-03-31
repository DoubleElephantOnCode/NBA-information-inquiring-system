package view.teamCount;

import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;
import view.SizeAndLocationAndFont;
import view.mainFrame.ExitLabel;
import view.mainFrame.LabelEnterListener;
import view.mainFrame.Main;
import view.mainFrame.MenuLabel;
import view.searchPanel.SearchPanel;
import view.startView.StartPanel;

public class TeamCountPanel extends JPanel{

	static JLabel background;
	String[] headList;
	static TeamCountTablePanel table;
	
	static int width = SizeAndLocationAndFont.frameWidth;
	static int height = SizeAndLocationAndFont.frameHeight;
	
	static ExitLabel exit = StartPanel.exit;
	static MenuLabel menu = StartPanel.menu;
	
	static SearchPanel search;
	
	public TeamCountPanel(String[][] content, String[] team, String[] headListForColumn, JLabel[] pic){
		
		background = Main.setJLabelWithIcon(File.file + File.teamCountBackground + File.GIF, width, height);
		table = new TeamCountTablePanel(content, team, headListForColumn, pic);
		
		search = new SearchPanel(SizeAndLocationAndFont.searchPanelWidth, SizeAndLocationAndFont.searchPanelHeight);
		search.setLocation(SizeAndLocationAndFont.searchPanelLocationX, SizeAndLocationAndFont.searchPanelLocationY);
		
		search.area.setForeground(table.fontColor);
		search.area.setFont(SizeAndLocationAndFont.searchPanelFont);
		search.area.setCaretColor(table.fontColor);
		
		add(background);
		add(table, 0);
		add(search, 0);
		
		if(exit == null) exit = new ExitLabel();
		exit.addToPanel(this);
		if(menu == null) menu = new MenuLabel();
		menu.addToPanel(this);
		
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
