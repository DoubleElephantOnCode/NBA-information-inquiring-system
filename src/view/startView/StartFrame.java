package view.startView;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartFrame extends JFrame{

	int width = 1000, height = 550;
	static Point origin = new Point();//实现屏幕拖拽
	
	static String file = "E:\\课件\\软件工程与计算\\大二下学期\\图片\\";
	
	JPanel panel;
	
	
	JLabel Background;
	JLabel BackgroundDarker;
	
	
	JLabel Exit;
	JLabel ExitEnter;
	int exitWidth = 30, exitHeight = 30;
	
	JLabel Menu;
	JLabel MenuEnter;
	int menuWidth = 100, menuHeight = 50;
	
	JLabel TeamCount;
	JLabel TeamCountEnter;
	
	JLabel TeamInfo;
	JLabel TeamInfoEnter;
	
	JLabel PlayerCount;
	JLabel PlayerCountEnter;
	
	JLabel PlayerInfo;
	JLabel PlayerInfoEnter;
	
	int oriWidth = 337, oriHeight = 165;
	int enterWidth = 340, enterHeight = 175;
	
	int splitX = 10, splitY = 5;
	
	public StartFrame(){
		panel = new JPanel();
		
		Background = setJLabelWithIcon(file+"main.png", width, height);
		BackgroundDarker = setJLabelWithIcon(file+"main_dark.png", width, height);
		Background.setLocation(0, 0);
		BackgroundDarker.setLocation(0, 0);
		
		Exit = setJLabelWithIcon(file+"XX.png", exitWidth, exitHeight);
		ExitEnter = setJLabelWithIcon(file+"XX_enter.png", exitWidth, exitHeight);
		Exit.setLocation(width-exitWidth-10, 10);
		ExitEnter.setLocation(width-exitWidth-10, 10);
		
		Menu = setJLabelWithIcon(file+"menu.png", menuWidth, menuHeight);
		MenuEnter = setJLabelWithIcon(file+"menu_enter.png", menuWidth, menuHeight);
		Menu.setLocation(50, 30);
		MenuEnter.setLocation(50, 30);
		
		TeamInfo = setJLabelWithIcon(file+"teamInfo.png", oriWidth, oriHeight);
		TeamInfoEnter = setJLabelWithIcon(file+"teamInfo_enter.png", enterWidth, enterHeight);
		TeamInfo.setLocation(width/2-splitX-oriWidth, height/2-splitY-oriHeight);
		TeamInfoEnter.setLocation(width/2-2*splitX-enterWidth, height/2-2*splitY-enterHeight);
		
		TeamCount = setJLabelWithIcon(file+"teamCount.png", oriWidth, oriHeight);
		TeamCountEnter = setJLabelWithIcon(file+"teamCount_enter.png", enterWidth, enterHeight);
		TeamCount.setLocation(width/2+splitX, height/2-splitY-oriHeight);
		TeamCountEnter.setLocation(width/2+2*splitX, height/2-2*splitY-enterHeight);
		
		PlayerInfo = setJLabelWithIcon(file+"playerInfo.png", oriWidth, oriHeight);
		PlayerInfoEnter = setJLabelWithIcon(file+"playerInfo_enter.png", enterWidth, enterHeight);
		PlayerInfo.setLocation(width/2-splitX-oriWidth, height/2+splitY);
		PlayerInfoEnter.setLocation(width/2-2*splitX-enterWidth, height/2+2*splitY);
		
		PlayerCount = setJLabelWithIcon(file+"playerCount.png", oriWidth, oriHeight);
		PlayerCountEnter = setJLabelWithIcon(file+"playerCount_enter.png", enterWidth, enterHeight);
		PlayerCount.setLocation(width/2+splitX, height/2+splitY);
		PlayerCountEnter.setLocation(width/2+2*splitX, height/2+2*splitY);
		
		panel.add(BackgroundDarker);
		panel.add(Exit, 0);
		panel.add(Menu, 0);
		panel.add(TeamCount, 0);
		panel.add(TeamInfo, 0);
		panel.add(PlayerInfo, 0);
		panel.add(PlayerCount, 0);
		
		panel.add(ExitEnter, 0);
		panel.add(MenuEnter, 0);
		panel.add(TeamCountEnter, 0);
		panel.add(TeamInfoEnter, 0);
		panel.add(PlayerCountEnter, 0);
		panel.add(PlayerInfoEnter, 0);
		
		ExitEnter.setVisible(false);
		MenuEnter.setVisible(false);
		TeamCountEnter.setVisible(false);
		TeamInfoEnter.setVisible(false);
		PlayerCountEnter.setVisible(false);
		PlayerInfoEnter.setVisible(false);
		
		Exit.addMouseListener(new LabelUsualListener(Exit, ExitEnter));
		Menu.addMouseListener(new LabelUsualListener(Menu, MenuEnter));
		TeamCount.addMouseListener(new LabelUsualListener(TeamCount, TeamCountEnter));
		TeamInfo.addMouseListener(new LabelUsualListener(TeamInfo, TeamInfoEnter));
		PlayerCount.addMouseListener(new LabelUsualListener(PlayerCount, PlayerCountEnter));
		PlayerInfo.addMouseListener(new LabelUsualListener(PlayerInfo, PlayerInfoEnter));
		
		ExitEnter.addMouseListener(new LabelEnterListener(Exit, ExitEnter));
		MenuEnter.addMouseListener(new LabelEnterListener(Menu, MenuEnter));
		TeamCountEnter.addMouseListener(new LabelEnterListener(TeamCount, TeamCountEnter));
		TeamInfoEnter.addMouseListener(new LabelEnterListener(TeamInfo, TeamInfoEnter));
		PlayerCountEnter.addMouseListener(new LabelEnterListener(PlayerCount, PlayerCountEnter));
		PlayerInfoEnter.addMouseListener(new LabelEnterListener(PlayerInfo, PlayerInfoEnter));
		
		panel.setLocation(0, -5);
		panel.setSize(width, height);
		
		panel.setLayout(null);
		
		add(panel);
		setLayout(null);
		setUndecorated(true);
		setSize(width, height-5);
		setVisible(true);
		setLocationRelativeTo(null);
		
		addMouseListener(new MouseAdapter(){
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
            	repaint();
            }
         });
		
		addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                Point p = getLocation();
                setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y );
              }
            }
        );
	            
	}
	
	private JLabel setJLabelWithIcon(String IconPath, int width, int height){
		ImageIcon icon = new ImageIcon(IconPath);
		icon.setImage(icon.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
		JLabel label = new JLabel(icon);
		label.setSize(width, height);
		label.setOpaque(false);
		return label;
	}
	
	public static void main(String[] args){
		new StartFrame();
	}
	
	class LabelUsualListener implements MouseListener{

		JLabel enter;
		JLabel usual;
		public LabelUsualListener(JLabel usual, JLabel enter){
			this.enter = enter;
			this.usual = usual;
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			enter.setVisible(true);
			usual.setVisible(false);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			enter.setVisible(false);
			usual.setVisible(true);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class LabelEnterListener implements MouseListener{
		
		JLabel usual, enter;
		
		public LabelEnterListener(JLabel usual, JLabel enter){
			this.usual = usual;
			this.enter = enter;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			usual.setVisible(false);
			enter.setVisible(true);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			usual.setVisible(true);
			enter.setVisible(false);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
