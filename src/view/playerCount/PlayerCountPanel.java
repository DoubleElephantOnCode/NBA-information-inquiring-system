package view.playerCount;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;
import view.QuickCheckFrame;
import view.SizeAndLocationAndFont;
import view.mainFrame.ExitLabel;
import view.mainFrame.LabelEnterListener;
import view.mainFrame.Main;
import view.mainFrame.MenuLabel;
import view.searchPanel.SearchPanel;
import view.selectedPanel.SelectPanel;
import view.startView.StartPanel;
import control.ShowPlayerController;

public class PlayerCountPanel extends JPanel{
	static JLabel background;
	String[] headList;
	static PlayerCountTablePanel table;
	
	static int width = SizeAndLocationAndFont.frameWidth;
	static int height = SizeAndLocationAndFont.frameHeight;
	
	static ExitLabel exit = StartPanel.exit;
	static MenuLabel menu = StartPanel.menu;
	
	static SearchPanel search;
	
	static SelectPanel position, area;
	
	static JLabel quickCheck, quickCheckEnter;
	
	static QuickCheckFrame quickCheckFrame;
	
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
		
		search = new SearchPanel(SizeAndLocationAndFont.searchPanelWidth, SizeAndLocationAndFont.searchPanelHeight);
		search.setLocation(SizeAndLocationAndFont.searchPanelLocationX, SizeAndLocationAndFont.searchPanelLocationY);
		
		search.area.setForeground(table.fontColor);
		search.area.setFont(SizeAndLocationAndFont.searchPanelFont);
		search.area.setCaretColor(table.fontColor);
		
		position = new SelectPanel(SizeAndLocationAndFont.selectPanelWidth, SizeAndLocationAndFont.selectPanelHeight, Position);
		position.setLocation(SizeAndLocationAndFont.playerPositionSelectPanelLocationX, SizeAndLocationAndFont.playerPositionSelectPanelLocationY);
		
		area = new SelectPanel(SizeAndLocationAndFont.selectPanelWidth, SizeAndLocationAndFont.selectPanelHeight, Area);
		area.setLocation(SizeAndLocationAndFont.playerAreaSelectPanelLocationX, SizeAndLocationAndFont.playerAreaSelectPanelLocationY);
		
//		quickCheck = setJLabelWithIcon(File.file + File.quickCheck + File.PNG, SizeAndLocationAndFont.quickCheckWidth, SizeAndLocationAndFont.quickCheckHeight);
//		quickCheck.setLocation(SizeAndLocationAndFont.quickCheckLocationX, SizeAndLocationAndFont.quickCheckLocationY);
//		
//		quickCheckEnter = setJLabelWithIcon(File.file + File.quickCheck + File.enter + File.PNG, SizeAndLocationAndFont.quickCheckWidth, SizeAndLocationAndFont.quickCheckHeight);
//		quickCheckEnter.setLocation(SizeAndLocationAndFont.quickCheckLocationX, SizeAndLocationAndFont.quickCheckLocationY);
//		
//		quickCheckFrame = new QuickCheckFrame(headListForColumn, 640, 30, 1, 8);
//		quickCheckFrame.setVisible(false);
		
		add(background);
		add(table, 0);
		add(search, 0);
		add(position, 0);
		add(area, 0);
//		add(quickCheck, 0);
//		add(quickCheckEnter, 0);
//		
//		quickCheckEnter.setVisible(false);
//		
//		quickCheck.addMouseListener(new MouseListener(){
//
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				quickCheckFrame.setVisible(true);
//			}
//			public void mouseEntered(MouseEvent arg0) {
//				quickCheckEnter.setVisible(true);
//			}
//			public void mouseExited(MouseEvent arg0) {
//				quickCheckEnter.setVisible(false);
//			}
//			public void mousePressed(MouseEvent arg0) {}
//			public void mouseReleased(MouseEvent arg0) {}
//			
//		});
//		
//		quickCheckEnter.addMouseListener(new MouseListener(){
//
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				quickCheckFrame.setVisible(true);
//			}
//			public void mouseEntered(MouseEvent arg0) {
//				quickCheckEnter.setVisible(true);
//			}
//			public void mouseExited(MouseEvent arg0) {
//				quickCheckEnter.setVisible(false);
//			}
//			public void mousePressed(MouseEvent arg0) {}
//			public void mouseReleased(MouseEvent arg0) {}
//			
//		});
		
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
	
	private JLabel setJLabelWithIcon(String IconPath, int width, int height){
		ImageIcon icon = new ImageIcon(IconPath);
		icon.setImage(icon.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
		JLabel label = new JLabel(icon);
		label.setSize(width, height);
		label.setOpaque(false);
		return label;
	}
}
