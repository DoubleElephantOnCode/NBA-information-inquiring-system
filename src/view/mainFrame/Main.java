package view.mainFrame;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.startView.StartPanel;

public class Main {

	static JFrame mainFrame = new JFrame();
	
	static int width = 1000, height = 550;
	
	static Point origin = new Point();//实现屏幕拖拽
	
	static StartPanel startPanel = new StartPanel();
	
	public Main(){
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
	
	public static void main(String[] args){
		new Main();
	}
	
}
