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
import view.SVGLabel;
import view.SizeAndLocationAndFont;
import view.infomationCenter.InformationCenterPanel;
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
	static InformationCenterPanel infomationCenterPanel;
	
	public Main(){
		
		readTeam = new ReadTeamData();
		readTeam.readTeamData();
		
		readPlayer = new ReadPlayerData();
		readPlayer.readPlayerData();
		
		readMatch = new ReadMatchData();
		readMatch.readMatchDataForTwo();
		
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
	}
	/**
	 * 重置球员统计表中的数据，只能修改行数据
	 * @param content
	 * @param player
	 */
	public static void resetPlayerCountPanel(String[][] content, String[] player){
		playerCountPanel.resetTableInfo(content, player);
	}
	
	public static void setHotPlayerTodayPanel(String[] picPath, String[][][] playerContents){
		if(infomationCenterPanel == null) infomationCenterPanel = new InformationCenterPanel(1);//当日热点球员
		infomationCenterPanel.setHotPlayerTodayPanel(picPath, playerContents);
		removeAllPanel();
		mainFrame.add(infomationCenterPanel);
		mainFrame.repaint();
	}
	
	public static void setHotPlayerThisYearPanel(String[] picPath, String[][][] playerContents){
		if(infomationCenterPanel == null) infomationCenterPanel = new InformationCenterPanel(0);//赛季热点球员
		infomationCenterPanel.setHotPlayerThisYearPanel(picPath, playerContents);
		removeAllPanel();
		mainFrame.add(infomationCenterPanel);
		mainFrame.repaint();
	}
	
	public static void setProgressGreatPlayerPanel(String[] picPath, String[][][] playerContents){
		if(infomationCenterPanel == null) infomationCenterPanel = new InformationCenterPanel(2);//进步最快球员
		infomationCenterPanel.setProgressGreatPlayerPanel(picPath, playerContents);
		removeAllPanel();
		mainFrame.add(infomationCenterPanel);
		mainFrame.repaint();
	}
	
	public static void setHotTeamPanel(java.io.File[] teamPics, String[][][] teamContents){
		if(infomationCenterPanel == null) infomationCenterPanel = new InformationCenterPanel(3);//赛季热点球队
		infomationCenterPanel.setHotTeamPanel(teamPics, teamContents);
		removeAllPanel();
		mainFrame.add(infomationCenterPanel);
		mainFrame.repaint();
	}
	
	public static void setSinglePlayerPanel(String pathOfPhoto1, String pathOfPhoto2, String[] info, String[][] content, String[] headListForRow, String[] headListForColumn){
		if(infomationCenterPanel == null) infomationCenterPanel = new InformationCenterPanel(4);//球员信息
		infomationCenterPanel.setSinglePlayerPanel(pathOfPhoto1, pathOfPhoto2, info, content, headListForRow, headListForColumn);
		removeAllPanel();
		mainFrame.add(infomationCenterPanel);
		mainFrame.repaint();
	}
	
	public void setSingleTeamPanel(java.io.File svgFile, String[] infoName, String[] info, String[][] content, String[] headListForRow, String[] headListForColumn){
		if(infomationCenterPanel == null) infomationCenterPanel = new InformationCenterPanel(5);//球队信息
		infomationCenterPanel.setSingleTeamPanel(svgFile, infoName, info, content, headListForRow, headListForColumn);
		removeAllPanel();
		mainFrame.add(infomationCenterPanel);
		mainFrame.repaint();
	}
	
	public void setMatchPanel(java.io.File team1, String[][] content1, String[] headListForRow1, String[] headListForColumn1,
			java.io.File team2, String[][] content2, String[] headListForRow2, String[] headListForColumn2){
		if(infomationCenterPanel == null) infomationCenterPanel = new InformationCenterPanel(6);//对阵信息
		infomationCenterPanel.setMatchPanel(team1, content1, headListForRow1, headListForColumn1, 
				team2, content2, headListForRow2, headListForColumn2);
		removeAllPanel();
		mainFrame.add(infomationCenterPanel);
		mainFrame.repaint();
	}
	
	private static void removeAllPanel(){
		if(playerCountPanel != null)
			mainFrame.remove(playerCountPanel);
		if(teamCountPanel != null)
			mainFrame.remove(teamCountPanel);
		if(infomationCenterPanel != null)
			mainFrame.remove(infomationCenterPanel);
	}
	
	public static void main(String[] args){
		new Main();
	}
	
}
