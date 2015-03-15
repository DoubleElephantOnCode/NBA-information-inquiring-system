package view.playerCount;

import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;
import view.mainFrame.ExitLabel;
import view.mainFrame.LabelEnterListener;
import view.mainFrame.Main;
import view.mainFrame.MenuLabel;
import view.searchPanel.SearchPanel;
import view.startView.StartPanel;

public class PlayerCountPanel extends JPanel{
	static JLabel background;
	String[] headList;
	static PlayerCountTablePanel table;
	
	static int width = 1000;
	static int height = 550;
	
	static ExitLabel exit = StartPanel.exit;
	static MenuLabel menu = StartPanel.menu;
	
	static SearchPanel search;
	
	public PlayerCountPanel(String[][] content, String[] player, String[] headListForColumn){
		
		background = Main.setJLabelWithIcon(File.file + File.playerCountBackground + File.GIF, width, height);
		table = new PlayerCountTablePanel(content, player, headListForColumn);
		
		search = new SearchPanel(300, 30);
		search.setLocation(650, 100);
		
		search.area.setForeground(table.fontColor);
		search.area.setFont(new Font("黑体",Font.BOLD,25));
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
					search.area.setText(null);
				}
				else{
					table.p.changeRow(t-table.p.pointerRow);
					table.hpR.moveToIndex(table.p.pointerRow);
					table.bcp.setPosition(table.p.pointerRow);
				}
			}
		});
		
		setSize(width, height);
		setLayout(null);
		setLocation(0, -5);
	}
	
	public void resetTableInfo(String[][] content, String[] team){
		table.p.setContent(content);
		table.hpR.resetInfo(team);
	}
}
