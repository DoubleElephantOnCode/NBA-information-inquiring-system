package view.startView;

import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;
import view.SizeAndLocationAndFont;
import view.mainFrame.ExitLabel;
import view.mainFrame.LabelEnterListener;
import view.mainFrame.LabelUsualListener;
import view.mainFrame.Main;
import view.mainFrame.MenuLabel;
import control.ShowPlayerController;
import control.ShowTeamController;

public class StartPanel extends JPanel{
	int width = SizeAndLocationAndFont.frameWidth, height = SizeAndLocationAndFont.frameHeight;
	
	public static JPanel self;
	
	public static JLabel Background;
	public static JLabel BackgroundDarker;
	public static Icon background;
	
	public static ExitLabel exit;
	public static MenuLabel menu;
	
	public static JLabel Quit;
	public static JLabel QuitEnter;
	
	public static JLabel TeamCount;
	public static JLabel TeamCountEnter;
	
	public static JLabel TeamInfo;
	public static JLabel TeamInfoEnter;
	
	public static JLabel PlayerCount;
	public static JLabel PlayerCountEnter;
	
	public static JLabel PlayerInfo;
	public static JLabel PlayerInfoEnter;
	
	int oriWidth = SizeAndLocationAndFont.startPanelOriWidth,
			oriHeight = SizeAndLocationAndFont.startPanelOriHeight;
	
	int enterWidth = SizeAndLocationAndFont.startPanelEnterWidth,
			enterHeight = SizeAndLocationAndFont.startPanelEnterHeight;
	
	int splitX = SizeAndLocationAndFont.startPanelSplitX,
			splitY = SizeAndLocationAndFont.startPanelSplitY;
	
	int quitWidth = SizeAndLocationAndFont.startPanelQuitWidth,
			quitHeight = SizeAndLocationAndFont.startPanelQuitHeight;
	
	public StartPanel(){
		
		self = this;
		
		Background = Main.setJLabelWithIcon(File.file + File.startBackground + File.GIF, width, height);
		BackgroundDarker = Main.setJLabelWithIcon(File.file + File.startBackground_dark + File.PNG, width, height);
		Background.setLocation(0, 0);
		BackgroundDarker.setLocation(0, 0);
		
		exit = new ExitLabel();
		menu = new MenuLabel();
		
		Quit = Main.setJLabelWithIcon(File.file + File.quit + File.PNG, quitWidth, quitHeight);
		QuitEnter = Main.setJLabelWithIcon(File.file + File.quit + File.enter + File.PNG, quitWidth, quitHeight);
		Quit.setLocation(width-50-quitWidth, height-30-quitHeight);
		QuitEnter.setLocation(width-50-quitWidth, height-30-quitHeight);
		
		TeamInfo = Main.setJLabelWithIcon(File.file + File.teamInfo+ File.PNG, oriWidth, oriHeight);
		TeamInfoEnter = Main.setJLabelWithIcon(File.file + File.teamInfo + File.enter + File.PNG, enterWidth, enterHeight);
		TeamInfo.setLocation(width/2-splitX-oriWidth, height/2-splitY-oriHeight);
		TeamInfoEnter.setLocation(width/2-2*splitX-enterWidth, height/2-2*splitY-enterHeight);
		
		TeamCount = Main.setJLabelWithIcon(File.file + File.teamCount + File.PNG, oriWidth, oriHeight);
		TeamCountEnter = Main.setJLabelWithIcon(File.file + File.teamCount + File.enter + File.PNG, enterWidth, enterHeight);
		TeamCount.setLocation(width/2+splitX, height/2-splitY-oriHeight);
		TeamCountEnter.setLocation(width/2+2*splitX, height/2-2*splitY-enterHeight);
		
		PlayerInfo = Main.setJLabelWithIcon(File.file + File.playerInfo + File.PNG, oriWidth, oriHeight);
		PlayerInfoEnter = Main.setJLabelWithIcon(File.file + File.playerInfo + File.enter + File.PNG, enterWidth, enterHeight);
		PlayerInfo.setLocation(width/2-splitX-oriWidth, height/2+splitY);
		PlayerInfoEnter.setLocation(width/2-2*splitX-enterWidth, height/2+2*splitY);
		
		PlayerCount = Main.setJLabelWithIcon(File.file + File.playerCount + File.PNG, oriWidth, oriHeight);
		PlayerCountEnter = Main.setJLabelWithIcon(File.file + File.playerCount + File.enter + File.PNG, enterWidth, enterHeight);
		PlayerCount.setLocation(width/2+splitX, height/2+splitY);
		PlayerCountEnter.setLocation(width/2+2*splitX, height/2+2*splitY);
		
		TeamCount.setVisible(false);
		TeamInfo.setVisible(false);
		PlayerCount.setVisible(false);
		PlayerInfo.setVisible(false);
		
		add(Background);
		add(TeamCount, 0);
		add(TeamInfo, 0);
		add(PlayerInfo, 0);
		add(PlayerCount, 0);
		add(TeamCountEnter, 0);
		add(TeamInfoEnter, 0);
		add(PlayerInfoEnter, 0);
		add(PlayerCountEnter, 0);
		exit.addToPanel(this);
		menu.addToPanel(this);
		
		QuitEnter.setVisible(false);
		TeamCountEnter.setVisible(false);
		TeamInfoEnter.setVisible(false);
		PlayerCountEnter.setVisible(false);
		PlayerInfoEnter.setVisible(false);
		
		Quit.addMouseListener(new LabelUsualListener(Quit, QuitEnter));
		TeamCount.addMouseListener(new LabelUsualListener(TeamCount, TeamCountEnter));
		TeamInfo.addMouseListener(new LabelUsualListener(TeamInfo, TeamInfoEnter));
		PlayerCount.addMouseListener(new LabelUsualListener(PlayerCount, PlayerCountEnter));
		PlayerInfo.addMouseListener(new LabelUsualListener(PlayerInfo, PlayerInfoEnter));
		
		
		
		QuitEnter.addMouseListener(new LabelEnterListener(Quit, QuitEnter){
			@Override
			public void mouseClicked(MouseEvent e) {
				Background.setIcon(background);
				Background.updateUI();
				
				menu.addToPanel(self);
				
				TeamCount.setVisible(false);
				TeamInfo.setVisible(false);
				PlayerCount.setVisible(false);
				PlayerInfo.setVisible(false);
				
				TeamCountEnter.setVisible(false);
				TeamInfoEnter.setVisible(false);
				PlayerCountEnter.setVisible(false);
				PlayerInfoEnter.setVisible(false);
				
				remove(Quit);
				remove(QuitEnter);
			}
		});
		TeamCountEnter.addMouseListener(new LabelEnterListener(TeamCount, TeamCountEnter){
			public void mouseClicked(MouseEvent e) {
				new ShowTeamController().showTeamTable();
			}
		});
		TeamInfoEnter.addMouseListener(new LabelEnterListener(TeamInfo, TeamInfoEnter){
			public void mouseClicked(MouseEvent e) {
				//TODO
			}
		});
		PlayerCountEnter.addMouseListener(new LabelEnterListener(PlayerCount, PlayerCountEnter){
			public void mouseClicked(MouseEvent e) {
				new ShowPlayerController().showPlayerInfo("-ALL", "-ALL");
			}
		});
		PlayerInfoEnter.addMouseListener(new LabelEnterListener(PlayerInfo, PlayerInfoEnter){
			public void mouseClicked(MouseEvent e) {
				new ShowPlayerController().showHotPlayerInfo(true, "", 5, 0);
			}
		});
		
		setLocation(0, -5);
		setSize(width, height);
		setLayout(null);
	}
	
	
}
