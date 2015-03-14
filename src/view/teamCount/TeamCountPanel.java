package view.teamCount;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;
import view.mainFrame.ExitLabel;
import view.mainFrame.Main;
import view.mainFrame.MenuLabel;
import view.startView.StartPanel;

public class TeamCountPanel extends JPanel{

	static JLabel background;
	String[] headList;
	static TeamCountTablePanel table;
	
	static int width = 1000;
	static int height = 550;
	
	static ExitLabel exit = StartPanel.exit;
	static MenuLabel menu = StartPanel.menu;
	
	public TeamCountPanel(String[][] content, String[] team, String[] headListForColumn){
		
		background = Main.setJLabelWithIcon(File.file + File.teamCountBackground + File.GIF, width, height);
		table = new TeamCountTablePanel(content, team, headListForColumn);
		
		add(background);
		add(table, 0);
		if(exit == null) exit = new ExitLabel();
		exit.addToPanel(this);
		if(menu == null) menu = new MenuLabel();
		menu.addToPanel(this);
		
		setSize(width, height);
		setLayout(null);
		setLocation(0, -5);
	}
	
	public void resetTableInfo(String[][] content, String[] team){
		table.p.setContent(content);
		table.hpR.resetInfo(team);
	}
	
}
