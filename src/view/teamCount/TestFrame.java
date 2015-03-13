package view.teamCount;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestFrame {
	
	static int width = 1000;
	static int height = 550;
	
	static Point origin = new Point();
	static JFrame f;
	static JPanel p;
	static JLabel background;
	
	public static void main(String[] args){
		f = new JFrame();
		p = new JPanel();
		
		background = setJLabelWithIcon("E:\\课件\\软件工程与计算\\大二下学期\\图片\\team_count_frame.gif", width, height);
		
		TeamCountTablePanel tctp = new TeamCountTablePanel();
		
		p.add(background);
		p.add(tctp, 0);
		
		p.setLayout(null);
		p.setSize(width, height);
		p.setLocation(0, 0);
		
		f.setContentPane(p);
		f.setUndecorated(true);
		f.setSize(width, height);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		f.addMouseListener(
		    	new MouseAdapter(){
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
		            	f.repaint();
		            }
		         });
		f.addMouseMotionListener(
	            new MouseMotionAdapter(){
		              public void mouseDragged(MouseEvent e){
		                Point p =    f.getLocation();
		                f.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y );
		              }
		            }
		        );
	}
	
	private static JLabel setJLabelWithIcon(String IconPath, int width, int height){
		ImageIcon icon = new ImageIcon(IconPath);
		icon.setImage(icon.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
		JLabel label = new JLabel(icon);
		label.setSize(width, height);
		label.setOpaque(false);
		return label;
	}
	
}
