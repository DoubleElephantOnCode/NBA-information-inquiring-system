package view.playerCount;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import control.ShowPlayerController;
import view.File;
import view.mainFrame.ExitLabel;
import view.mainFrame.LabelEnterListener;
import view.mainFrame.Main;
import view.mainFrame.MenuLabel;
import view.searchPanel.SearchPanel;
import view.selectedPanel.SelectPanel;
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
	
	static SelectPanel position, area;
	
	static String[] Position = {"-ALL","前锋-F", "中锋-C", "后卫-G"};
	
	static String[] Area = {
		"-ALL",
		"东部联盟-E",
		"大西洋分区-Atlantic", "中部分区-Central", "东南分区-Southeast",
		"西部联盟-W",
		"西南分区-Southwest", "西北分区-Northwest", "太平洋分区-Pacific"
	};
	
	public PlayerCountPanel(String[][] content, String[] player, String[] headListForColumn){
		
		background = Main.setJLabelWithIcon(File.file + File.playerCountBackground + File.GIF, width, height);
		table = new PlayerCountTablePanel(content, player, headListForColumn);
		
		search = new SearchPanel(300, 30);
		search.setLocation(650, 100);
		
		search.area.setForeground(table.fontColor);
		search.area.setFont(new Font("黑体",Font.BOLD,25));
		search.area.setCaretColor(table.fontColor);
		
		position = new SelectPanel(200, 30, Position);
		position.setLocation(400, 100);
		
		area = new SelectPanel(200, 30, Area);
		area.setLocation(150, 100);
		
		add(background);
		add(table, 0);
		add(search, 0);
		add(position, 0);
		add(area, 0);
		
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
				}
			}
		});
		
		position.box.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				position.action();
				new ShowPlayerController().selectByAreaOrPosition(
						position.getSelectedItem(), area.getSelectedItem());
//				new ShowPlayerController().sortPlayer(position.getSelectedItem(), area.getSelectedItem(), table.selectedColumn, table.sort);
			}
			
		});
		
		area.box.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				area.action();
				new ShowPlayerController().selectByAreaOrPosition(
						position.getSelectedItem(), area.getSelectedItem());
//				new ShowPlayerController().sortPlayer(position.getSelectedItem(), area.getSelectedItem(), table.selectedColumn, table.sort);
			}
			
		});
		
		setSize(width, height);
		setLayout(null);
		setLocation(0, -5);
	}
	
	public void resetTableInfo(String[][] content, String[] player){
//		table.p.setContent(content);
//		table.hpR.resetInfo(player);
		table.resetTableInfoAndSize(content, player);
	}
}
