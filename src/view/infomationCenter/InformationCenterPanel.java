package view.infomationCenter;

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

public class InformationCenterPanel extends JPanel{
	
	int width = SizeAndLocationAndFont.frameWidth,
			height = SizeAndLocationAndFont.frameHeight;
	
	static JLabel background;
	static ExitLabel exit = StartPanel.exit;
	static MenuLabel menu = StartPanel.menu;
	
	static SearchPanel searchPlayer;
	
	static TeamLogoChosenPane teamChosen;
	
	static int index = 0;
	
	public InformationCenterPanel(int index){
		this.index = index;
		
		background = Main.setJLabelWithIcon(File.file + File.infomationFrame + File.PNG, width, height);
		
		this.add(background);
		
		if(exit == null) exit = new ExitLabel();
		exit.addToPanel(this);
		if(menu == null) menu = new MenuLabel();
		menu.addToPanel(this);
		
		searchPlayer = new SearchPanel(SizeAndLocationAndFont.searchPlayerPanelWidth, SizeAndLocationAndFont.searchPlayerPanelHeight);
		searchPlayer.setLocation(SizeAndLocationAndFont.searchPlayerPanelLocationX, SizeAndLocationAndFont.searchPlayerPanelLocationY);
		searchPlayer.area.setFont(SizeAndLocationAndFont.searchPlayerPanelFont);
		searchPlayer.area.setForeground(SizeAndLocationAndFont.tableLabelColor);
		searchPlayer.area.setCaretColor(SizeAndLocationAndFont.tableLabelColor);
		
		searchPlayer.searchEnter.addMouseListener(new LabelEnterListener(searchPlayer.search, searchPlayer.searchEnter){
			public void mouseClicked(MouseEvent e) {
				//TODO 查找事项
				String temp = searchPlayer.getInputText();
			}
		});
		
		teamChosen = new TeamLogoChosenPane();
		
		this.add(teamChosen);
		this.add(searchPlayer, 0);
		this.setLayout(null);
		this.setSize(width, height);
		this.setLocation(0, 0);
	}
	
	
	
}
