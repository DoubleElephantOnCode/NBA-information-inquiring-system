package view.infomationCenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;
import view.SizeAndLocationAndFont;
import view.TimeSetting;
import view.hotPlayerPanel.HotPlayerPanel;
import view.hotTeamPanel.HotTeamPanel;
import view.mainFrame.ExitLabel;
import view.mainFrame.LabelEnterListener;
import view.mainFrame.Main;
import view.mainFrame.MenuLabel;
import view.mainFrame.GoForwardOrBackward.GoForwardOrBackwardPanel;
import view.matchPanel.MatchPanel;
import view.searchPanel.SearchPanel;
import view.selectedPanel.SelectPanel;
import view.singlePlayerPanel.SinglePlayerCamera;
import view.singleTeamPanel.SingleTeamCamera;
import view.singleTeamPanel.SingleTeamPanel;
import view.startView.StartPanel;
import control.ShowPlayerController;
import control.ShowTeamController;

public class InformationCenterPanel extends JPanel{
	
	static String[] items = {"赛季热点球员", "当日热点球员", "进步最快球员", "赛季热点球队", "球员信息", "球队信息", "对阵信息"};
	
	int width = SizeAndLocationAndFont.frameWidth,
			height = SizeAndLocationAndFont.frameHeight;
	
	static JLabel background;
	static ExitLabel exit = StartPanel.exit;
	static MenuLabel menu = StartPanel.menu;
	static GoForwardOrBackwardPanel goForwardOrBackward = StartPanel.goForwardOrBackward;
	
	static SearchPanel searchPlayer;
	
	static TeamLogoChosenPane teamChosen;
	
	static SelectPanel panelBox;
	
	static int index = 0;
	
	public static HotPlayerPanel hotPlayerPanel;
	public static HotTeamPanel hotTeamPanel;
	public static SinglePlayerCamera singlePlayerPanel;
	public static SingleTeamCamera singleTeamPanel;
	public static MatchPanel matchPanel;
	
	public static int formerPanel = 0;
	
	public InformationCenterPanel(int index){
		this.index = index;
		
		background = Main.setJLabelWithIcon(File.file + File.infomationFrame + File.PNG, width, height);
		
		this.add(background);
		
		if(exit == null) exit = new ExitLabel();
		exit.addToPanel(this);
		if(menu == null) menu = new MenuLabel();
		menu.addToPanel(this);
		if(goForwardOrBackward == null) goForwardOrBackward = new GoForwardOrBackwardPanel();
		goForwardOrBackward.addToPanel(this);
		
		searchPlayer = new SearchPanel(SizeAndLocationAndFont.searchPlayerPanelWidth, SizeAndLocationAndFont.searchPlayerPanelHeight);
		searchPlayer.setLocation(SizeAndLocationAndFont.searchPlayerPanelLocationX, SizeAndLocationAndFont.searchPlayerPanelLocationY);
		searchPlayer.area.setFont(SizeAndLocationAndFont.searchPlayerPanelFont);
		searchPlayer.area.setForeground(SizeAndLocationAndFont.tableLabelColor);
		searchPlayer.area.setCaretColor(SizeAndLocationAndFont.tableLabelColor);
		
		searchPlayer.searchEnter.addMouseListener(new LabelEnterListener(searchPlayer.search, searchPlayer.searchEnter){
			public void mouseClicked(MouseEvent e) {
				//TODO 查找事项
				String temp = searchPlayer.getInputText();
				new ShowPlayerController(true).showSinglePlayerInfo(temp, TimeSetting.startDate, TimeSetting.endDate);
				panelBox.setSelectedIndex(4);
			}
		});
		
		teamChosen = new TeamLogoChosenPane();
		
		panelBox = new SelectPanel(SizeAndLocationAndFont.panelBoxWidth, SizeAndLocationAndFont.panelBoxHeight, items);
		panelBox.setLocation(SizeAndLocationAndFont.panelBoxLocationX, SizeAndLocationAndFont.panelBoxLocationY);
		panelBox.setSelectedIndex(index);
		panelBox.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 界面切换
				panelBox.action();
				if(formerPanel == panelBox.getSelectedIndex()) return;
				
				switch(panelBox.getSelectedIndex()){
				case 0:new ShowPlayerController(true).showHotPlayerInfo(true, 5, 0); break;//赛季热点球员
				case 1:new ShowPlayerController(true).showHotPlayerInfo(false, 5, 0); break;//当日热点球员
				case 2:new ShowPlayerController(true).showProgressPlayerInfo(0, 5); break;//进步最快球员
				case 3:new ShowTeamController(true).showHotTeamTable(0); break;//赛季热点球队
				case 4:panelBox.setSelectedIndex(formerPanel);break;//球员信息
				case 5:panelBox.setSelectedIndex(formerPanel);break;//球队信息
				case 6:panelBox.setSelectedIndex(formerPanel);break;//对阵信息
				default:break;
				}
				formerPanel = panelBox.getSelectedIndex();
			}
		});
		
		this.add(teamChosen, 0);
		this.add(searchPlayer, 0);
		this.add(panelBox, 0);
		this.setLayout(null);
		this.setSize(width, height);
		this.setLocation(0, 0);
	}
	
	public void setHotPlayerTodayPanel(String[] picPath, String[][][] playerContents, String[] playerNames){
		removeInformationPanel();
		hotPlayerPanel = new HotPlayerPanel(picPath, playerContents, playerNames, 0);//当日
		this.add(hotPlayerPanel, 0);
		panelBox.setSelectedIndex(1);
		this.updateUI();
	}
	
	public void setHotPlayerThisYearPanel(String[] picPath, String[][][] playerContents, String[] playerNames){
		removeInformationPanel();
		hotPlayerPanel = new HotPlayerPanel(picPath, playerContents, playerNames, 1);//赛季
		this.add(hotPlayerPanel, 0);
		panelBox.setSelectedIndex(0);
		this.updateUI();
	}
	
	public void setProgressGreatPlayerPanel(String[] picPath, String[][][] playerContents, String[] playerNames){
		removeInformationPanel();
		hotPlayerPanel = new HotPlayerPanel(picPath, playerContents, playerNames, 2);//进步最快
		this.add(hotPlayerPanel, 0);
		panelBox.setSelectedIndex(2);
		this.updateUI();
	}
	
	public void setHotTeamPanel(java.io.File[] teamPics, String[][][] teamContents, String[] teamNames){
		removeInformationPanel();
		hotTeamPanel = new HotTeamPanel(teamPics, teamContents, teamNames);
		this.add(hotTeamPanel, 0);
		panelBox.setSelectedIndex(3);
		this.updateUI();
	}
	
	public void setSinglePlayerPanel(String pathOfPhoto1, String pathOfPhoto2, String[][] info, String[][] content, String[] headListForRow, String[] headListForColumn, String playerName, double[] ability){
		removeInformationPanel();
		singlePlayerPanel = new SinglePlayerCamera(pathOfPhoto1, pathOfPhoto2, info, content, headListForRow, headListForColumn, playerName, ability);
		this.add(singlePlayerPanel, 0);
		panelBox.setSelectedIndex(4);
		singlePlayerPanel.updateUI();
		this.updateUI();
	}
	
	public void setSingleTeamPanel(java.io.File svgFile, String[] infoName, String[] info, String[][] content, String[] headListForRow, String[] headListForColumn, String teamName){
		removeInformationPanel();
		singleTeamPanel = new SingleTeamCamera(svgFile, infoName, info, content, headListForRow, headListForColumn, teamName);
		this.add(singleTeamPanel, 0);
		panelBox.setSelectedIndex(5);
		this.updateUI();
	}
	
	public void setMatchPanel(java.io.File team1, String[][] content1, String[] headListForRow1, String[] headListForColumn1, String teamName1, 
			java.io.File team2, String[][] content2, String[] headListForRow2, String[] headListForColumn2, String teamName2){
		removeInformationPanel();
		matchPanel = new MatchPanel(team1, content1, headListForRow1, headListForColumn1, teamName1, team2, content2, headListForRow2, headListForColumn2, teamName2);
		this.add(matchPanel, 0);
		panelBox.setSelectedIndex(6);
		this.updateUI();
	}
	
	public void setFailedToFindPlayer(){
		searchPlayer.area.setText("输入球员名错误");
	}
	
	public void addMenuAndExit(){
		if(exit == null) exit = new ExitLabel();
		exit.addToPanel(this);
		if(menu == null) menu = new MenuLabel();
		menu.addToPanel(this);
		if(goForwardOrBackward == null) goForwardOrBackward = new GoForwardOrBackwardPanel();
		goForwardOrBackward.addToPanel(this);
	}
	
	private void removeInformationPanel(){
//		if(hotPlayerPanel != null) this.remove(hotPlayerPanel);
//		if(hotTeamPanel != null) this.remove(hotTeamPanel);
//		if(singlePlayerPanel != null) this.remove(singlePlayerPanel);
//		if(singleTeamPanel != null) this.remove(singleTeamPanel);
//		if(matchPanel != null) this.remove(matchPanel);
		this.removeAll();
		this.add(background);
		if(exit == null) exit = new ExitLabel();
		exit.addToPanel(this);
		if(menu == null) menu = new MenuLabel();
		menu.addToPanel(this);
		if(goForwardOrBackward == null) goForwardOrBackward = new GoForwardOrBackwardPanel();
		goForwardOrBackward.addToPanel(this);
		this.add(teamChosen, 0);
		this.add(searchPlayer, 0);
		this.add(panelBox, 0);
	}
	
}
