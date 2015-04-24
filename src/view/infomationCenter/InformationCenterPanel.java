package view.infomationCenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;
import view.SizeAndLocationAndFont;
import view.hotPlayerPanel.HotPlayerPanel;
import view.hotTeamPanel.HotTeamPanel;
import view.mainFrame.ExitLabel;
import view.mainFrame.LabelEnterListener;
import view.mainFrame.Main;
import view.mainFrame.MenuLabel;
import view.searchPanel.SearchPanel;
import view.selectedPanel.SelectPanel;
import view.singlePlayerPanel.SinglePlayerPanel;
import view.singleTeamPanel.SingleTeamPanel;
import view.startView.StartPanel;

public class InformationCenterPanel extends JPanel{
	
	static String[] items = {"赛季热点球员", "当日热点球员", "进步最快球员", "赛季热点球队", "球员信息", "球队信息", "对阵信息"};
	
	int width = SizeAndLocationAndFont.frameWidth,
			height = SizeAndLocationAndFont.frameHeight;
	
	static JLabel background;
	static ExitLabel exit = StartPanel.exit;
	static MenuLabel menu = StartPanel.menu;
	
	static SearchPanel searchPlayer;
	
	static TeamLogoChosenPane teamChosen;
	
	static SelectPanel panelBox;
	
	static int index = 0;
	
	static HotPlayerPanel hotPlayerPanel;
	static HotTeamPanel hotTeamPanel;
	static SinglePlayerPanel singlePlayerPanel;
	static SingleTeamPanel singleTeamPanel;
	
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
		
		panelBox = new SelectPanel(SizeAndLocationAndFont.panelBoxWidth, SizeAndLocationAndFont.panelBoxHeight, items);
		panelBox.setLocation(SizeAndLocationAndFont.panelBoxLocationX, SizeAndLocationAndFont.panelBoxLocationY);
		
		panelBox.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 界面切换
				panelBox.action();
			}
		});
		
		this.add(teamChosen, 0);
		this.add(searchPlayer, 0);
		this.add(panelBox, 0);
		this.setLayout(null);
		this.setSize(width, height);
		this.setLocation(0, 0);
	}
	
	public void setHotPlayerTodayPanel(String[] picPath, String[][][] playerContents){
		removeInformationPanel();
		hotPlayerPanel = new HotPlayerPanel(picPath, playerContents, 0);
		this.add(hotPlayerPanel, 0);
	}
	
	public void setHotPlayerThisYearPanel(String[] picPath, String[][][] playerContents){
		removeInformationPanel();
		hotPlayerPanel = new HotPlayerPanel(picPath, playerContents, 1);
		this.add(hotPlayerPanel, 0);
		this.updateUI();
	}
	
	public void setProgressGreatPlayerPanel(String[] picPath, String[][][] playerContents){
		removeInformationPanel();
		hotPlayerPanel = new HotPlayerPanel(picPath, playerContents, 2);
		this.add(hotPlayerPanel, 0);
		this.updateUI();
	}
	
	public void setHotTeamPanel(java.io.File[] teamPics, String[][][] teamContents){
		removeInformationPanel();
		hotTeamPanel = new HotTeamPanel(teamPics, teamContents);
		this.add(hotTeamPanel, 0);
		this.updateUI();
	}
	
	public void setSinglePlayerPanel(String pathOfPhoto1, String pathOfPhoto2, String[] info, String[][] content, String[] headListForRow, String[] headListForColumn){
		removeInformationPanel();
		singlePlayerPanel = new SinglePlayerPanel(pathOfPhoto1, pathOfPhoto2, info, content, headListForRow, headListForColumn);
		this.add(singlePlayerPanel, 0);
		singlePlayerPanel.updateUI();
		this.updateUI();
	}
	
	public void setSingleTeamPanel(java.io.File svgFile, String[] infoName, String[] info, String[][] content, String[] headListForRow, String[] headListForColumn){
		removeInformationPanel();
		singleTeamPanel = new SingleTeamPanel(svgFile, infoName, info, content, headListForRow, headListForColumn);
		this.add(singleTeamPanel, 0);
		this.updateUI();
	}
	
	private void removeInformationPanel(){
		if(hotPlayerPanel != null) this.remove(hotPlayerPanel);
		if(hotTeamPanel != null) this.remove(hotTeamPanel);
		if(singlePlayerPanel != null) this.remove(singlePlayerPanel);
		if(singleTeamPanel != null) this.remove(singleTeamPanel);
	}
	
}
