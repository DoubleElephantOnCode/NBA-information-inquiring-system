package view.mainFrame;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.readData.ReadMatchData;
import model.readData.ReadPlayerData;
import model.readData.ReadTeamData;

import org.jfree.data.time.TimeSeries;

import view.SVGLabel;
import view.SizeAndLocationAndFont;
import view.TimeSetting;
import view.Type;
import view.infomationCenter.InformationCenterPanel;
import view.mainFrame.GoForwardOrBackward.GoForwardOrBackwardPanel;
import view.mainFrame.GoForwardOrBackward.InformationForHistory;
import view.playerCount.PlayerCountPanel;
import view.startView.StartPanel;
import view.teamCount.TeamCountPanel;
/**
 * 创建启动的frame
 * @author WHJ
 *
 */
public class Main {
	static ReadTeamData readTeam;
	static ReadPlayerData readPlayer;
	static ReadMatchData readMatch;

	static JFrame mainFrame = new JFrame();
	
	static int width = SizeAndLocationAndFont.frameWidth, height = SizeAndLocationAndFont.frameHeight;
	static int teamLabelWidth = SizeAndLocationAndFont.teamPicLabelWidth, teamLabelHeight = SizeAndLocationAndFont.teamPicLabelHeight;
	
	static Point origin = new Point();//实现屏幕拖拽
	
	static StartPanel startPanel = new StartPanel();
	
	static TeamCountPanel teamCountPanel;
	static PlayerCountPanel playerCountPanel;
	static InformationCenterPanel informationCenterPanel;
	
	public Main(){
		
		readTeam = new ReadTeamData();
		readTeam.readTeamData();
		
		readPlayer = new ReadPlayerData();
		readPlayer.readPlayerData();
		
		readMatch = new ReadMatchData();
		readMatch.readMatchData();
		
		mainFrame.setLayout(null);
		mainFrame.setUndecorated(true);
		mainFrame.setSize(width, height-5);
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		
		mainFrame.add(startPanel);
		
		mainFrame.addMouseListener(new MouseAdapter(){
    		public void mousePressed(MouseEvent e){
    			origin.x = e.getX();
                origin.y = e.getY();
            }
            public void mouseClicked(MouseEvent e) {
            	
            }
            public void mouseReleased(MouseEvent e) {
            	super.mouseReleased(e);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	mainFrame.repaint();
            }
         });
		
		mainFrame.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                Point p = mainFrame.getLocation();
                mainFrame.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y );
              }
            }
        );
	}
	
	public static JLabel setJLabelWithIcon(String IconPath, int width, int height){
		ImageIcon icon = new ImageIcon(IconPath);
		icon.setImage(icon.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
		JLabel label = new JLabel(icon);
		label.setSize(width, height);
		label.setOpaque(false);
		return label;
	}
	/**
	 * 打开查看球队统计信息的界面
	 * @param content
	 * @param team
	 * @param headListForColumn
	 */
	public static void newTeamCountPanel(String[][] content, String[] team, String[] headListForColumn, File[] teamPic){
		JLabel[] pic = new JLabel[teamPic.length];
		for(int i = 0; i < pic.length; i++){
			pic[i] = new SVGLabel(teamPic[i], teamLabelWidth, teamLabelHeight);
		}
		teamCountPanel = new TeamCountPanel(content, team, headListForColumn, pic);
		startPanel.setVisible(false);
		removeAllPanel();
		mainFrame.add(teamCountPanel);
		mainFrame.repaint();
		InformationForHistory info = new InformationForHistory(Type.teamCount);
		info.setTeamCount();
		GoForwardOrBackwardPanel.history.add(info);
	}
	/**
	 * 重置球队统计表格中数据，只能修改行数据
	 * @param content
	 * @param team
	 */
	public static void resetTeamCountPanel(String[][] content, String[] team, File[] teamPic){
		JLabel[] pic = new JLabel[teamPic.length];
		for(int i = 0; i < pic.length; i++){
			pic[i] = new SVGLabel(teamPic[i], teamLabelWidth, teamLabelHeight);
		}
		teamCountPanel.resetTableInfo(content, team, pic);
	}
	/**
	 * 打开查看球员统计数据界面
	 * @param content
	 * @param player
	 * @param headListForColumn
	 */
	public static void newPlayerCountPanel(String[][] content, String[] player, String[] headListForColumn){
		playerCountPanel = new PlayerCountPanel(content, player, headListForColumn);
		startPanel.setVisible(false);
		removeAllPanel();
		mainFrame.add(playerCountPanel);
		mainFrame.repaint();
		InformationForHistory info = new InformationForHistory(Type.playerCount);
		info.setPlayerCount();
		GoForwardOrBackwardPanel.history.add(info);
	}
	/**
	 * 重置球员统计表中的数据，只能修改行数据
	 * @param content
	 * @param player
	 */
	public static void resetPlayerCountPanel(String[][] content, String[] player){
		playerCountPanel.resetTableInfo(content, player);
	}
	
	public static void setHotPlayerTodayPanel(String[] picPath, String[][][] playerContents, String[] playerNames){
		if(informationCenterPanel == null) informationCenterPanel = new InformationCenterPanel(1);//当日热点球员
		informationCenterPanel.addMenuAndExit();
		InformationCenterPanel.formerPanel = 1;
		informationCenterPanel.setHotPlayerTodayPanel(picPath, playerContents, playerNames);
		startPanel.setVisible(false);
		removeAllPanel();
		mainFrame.add(informationCenterPanel);
		mainFrame.repaint();
		InformationForHistory info = new InformationForHistory(Type.hotPlayerToday);
		info.setHotPlayerToday(informationCenterPanel.hotPlayerPanel.getFormerIndex());
		GoForwardOrBackwardPanel.history.add(info);
	}
	
	public static void setHotPlayerThisYearPanel(String[] picPath, String[][][] playerContents, String[] playerNames){
		if(informationCenterPanel == null) informationCenterPanel = new InformationCenterPanel(0);//赛季热点球员
		informationCenterPanel.addMenuAndExit();
		InformationCenterPanel.formerPanel = 0;
		informationCenterPanel.setHotPlayerThisYearPanel(picPath, playerContents, playerNames);
		startPanel.setVisible(false);
		removeAllPanel();
		mainFrame.add(informationCenterPanel);
		mainFrame.repaint();
		InformationForHistory info = new InformationForHistory(Type.hotPlayerThisYear);
		info.setHotPlayerThisYear(informationCenterPanel.hotPlayerPanel.getFormerIndex());
		GoForwardOrBackwardPanel.history.add(info);
	}
	
	public static void setProgressGreatPlayerPanel(String[] picPath, String[][][] playerContents, String[] playerNames){
		if(informationCenterPanel == null) informationCenterPanel = new InformationCenterPanel(2);//进步最快球员
		informationCenterPanel.addMenuAndExit();
		InformationCenterPanel.formerPanel = 2;
		informationCenterPanel.setProgressGreatPlayerPanel(picPath, playerContents, playerNames);
		startPanel.setVisible(false);
		removeAllPanel();
		mainFrame.add(informationCenterPanel);
		mainFrame.repaint();
		InformationForHistory info = new InformationForHistory(Type.progressGreatPlayer);
		info.setProgressGreatPlayer(informationCenterPanel.hotPlayerPanel.getFormerIndex());
		GoForwardOrBackwardPanel.history.add(info);
	}
	
	public static void setHotTeamPanel(java.io.File[] teamPics, String[][][] teamContents, String[] teamNames){
		if(informationCenterPanel == null) informationCenterPanel = new InformationCenterPanel(3);//赛季热点球队
		informationCenterPanel.addMenuAndExit();
		InformationCenterPanel.formerPanel = 3;
		informationCenterPanel.setHotTeamPanel(teamPics, teamContents, teamNames);
		startPanel.setVisible(false);
		removeAllPanel();
		mainFrame.add(informationCenterPanel);
		mainFrame.repaint();
		InformationForHistory info = new InformationForHistory(Type.hotTeam);
		info.setHotTeam(informationCenterPanel.hotTeamPanel.getFormerIndex());
		GoForwardOrBackwardPanel.history.add(info);
	}
	
	public static void setSinglePlayerPanel(String pathOfPhoto1, String pathOfPhoto2, String[][] info, String[][] content, String[] headListForRow, String[] headListForColumn, String playerName, double[] ability){
		if(informationCenterPanel == null) informationCenterPanel = new InformationCenterPanel(4);//球员信息
		informationCenterPanel.addMenuAndExit();
		InformationCenterPanel.formerPanel = 4;
		informationCenterPanel.setSinglePlayerPanel(pathOfPhoto1, pathOfPhoto2, info, content, headListForRow, headListForColumn, playerName, ability);
		startPanel.setVisible(false);
		removeAllPanel();
		mainFrame.add(informationCenterPanel);
		mainFrame.repaint();
		InformationForHistory in = new InformationForHistory(Type.singlePlayer);
		in.setSinglePlayer(playerName, TimeSetting.sdf.format(informationCenterPanel.singlePlayerPanel.spp.Begin), TimeSetting.sdf.format(informationCenterPanel.singlePlayerPanel.spp.End));
		GoForwardOrBackwardPanel.history.add(in);
	}
	
	public static void setSingleTeamPanel(java.io.File svgFile, String[] infoName, String[] info, String[][] content, String[] headListForRow, String[] headListForColumn, String teamName, double[] ability, TimeSeries series){
		if(informationCenterPanel == null) informationCenterPanel = new InformationCenterPanel(5);//球队信息
		informationCenterPanel.addMenuAndExit();
		InformationCenterPanel.formerPanel = 5;
		informationCenterPanel.setSingleTeamPanel(svgFile, infoName, info, content, headListForRow, headListForColumn, teamName, ability, series);
		startPanel.setVisible(false);
		removeAllPanel();
		mainFrame.add(informationCenterPanel);
		mainFrame.repaint();
		InformationForHistory in = new InformationForHistory(Type.singleTeam);
		in.setSingleTeam(teamName, informationCenterPanel.singleTeamPanel.stp.Begin, informationCenterPanel.singleTeamPanel.stp.End);
		GoForwardOrBackwardPanel.history.add(in);
	}
	
	public static void setMatchPanel(java.io.File team1, String[][] content1, String[] headListForRow1, String[] headListForColumn1, String teamName1, 
			java.io.File team2, String[][] content2, String[] headListForRow2, String[] headListForColumn2, String teamName2, String date){
		if(informationCenterPanel == null) informationCenterPanel = new InformationCenterPanel(6);//对阵信息
		informationCenterPanel.addMenuAndExit();
		InformationCenterPanel.formerPanel = 6;
		informationCenterPanel.setMatchPanel(team1, content1, headListForRow1, headListForColumn1, teamName1, 
				team2, content2, headListForRow2, headListForColumn2, teamName2);
		startPanel.setVisible(false);
		removeAllPanel();
		mainFrame.add(informationCenterPanel);
		mainFrame.repaint();
		InformationForHistory info = new InformationForHistory(Type.match);
		info.setMatch(date, teamName1, teamName2);
		GoForwardOrBackwardPanel.history.add(info);
	}
	
	public static void failedToFindPlayer(){//查找失败
		if(informationCenterPanel != null){
			informationCenterPanel.setFailedToFindPlayer();
		}
	}
	
	private static void removeAllPanel(){
		if(playerCountPanel != null)
			mainFrame.remove(playerCountPanel);
		if(teamCountPanel != null)
			mainFrame.remove(teamCountPanel);
		if(informationCenterPanel != null)
			mainFrame.remove(informationCenterPanel);
	}
	
	public static void main(String[] args){
		new Main();
	}
	
}
