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
import view.playerCount.PlayerCountPanel;
import view.startView.StartPanel;
import view.teamCount.TeamCountPanel;

public class Main {
	static ReadTeamData readTeam;
	static ReadPlayerData readPlayer;
	static ReadMatchData readMatch;

	static JFrame mainFrame = new JFrame();
	
	static int width = 1000, height = 550;
	
	static Point origin = new Point();//实现屏幕拖拽
	
	static StartPanel startPanel = new StartPanel();
	
	static TeamCountPanel teamCountPanel;
	static PlayerCountPanel playerCountPanel;
	
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
			pic[i] = new SVGLabel(teamPic[i], 80, 50);
		}
		teamCountPanel = new TeamCountPanel(content, team, headListForColumn, pic);
		startPanel.setVisible(false);
		mainFrame.add(teamCountPanel);
		
		if(playerCountPanel != null)
			mainFrame.remove(playerCountPanel);
	}
	/**
	 * 重置球队统计表格中数据，只能修改行数据
	 * @param content
	 * @param team
	 */
	public static void resetTeamCountPanel(String[][] content, String[] team, File[] teamPic){
		JLabel[] pic = new JLabel[teamPic.length];
		for(int i = 0; i < pic.length; i++){
			pic[i] = new SVGLabel(teamPic[i], 80, 50);
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
		mainFrame.add(playerCountPanel);
		
		if(teamCountPanel != null)
			mainFrame.remove(teamCountPanel);
	}
	/**
	 * 重置球员统计表中的数据，只能修改行数据
	 * @param content
	 * @param player
	 */
	public static void resetPlayerCountPanel(String[][] content, String[] player){
		playerCountPanel.resetTableInfo(content, player);
	}
	
	public static void main(String[] args){
		new Main();
	}
	
}
