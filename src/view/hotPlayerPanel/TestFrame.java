package view.hotPlayerPanel;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

import view.SizeAndLocationAndFont;
import view.infomationCenter.InformationCenterPanel;

public class TestFrame {

	static int row = 2, column = 5;
	static int width = SizeAndLocationAndFont.frameWidth,
			height = SizeAndLocationAndFont.frameHeight;
	
	static Point origin = new Point();
	static JFrame f;
	static HotPlayerPanel p;
	static String[][][] content;
	static InformationCenterPanel back;
	
	static String png = "E:\\课件\\软件工程与计算\\大二下学期\\data\\迭代一数据\\players\\portrait\\LeBron James.png";
	
	public static void main(String[] args){
		content = new String[5][row][column];
		
		back = new InformationCenterPanel(0);
		
		for(int k = 0; k < 5; k++){
			for(int i = 0; i < row; i++){
				for(int j = 0; j < column; j++){
					content[k][i][j] = i+" "+j;
				}
			}
		}
		
		f = new JFrame();
		f.setBackground(Color.red);
		
		String[] arrpng = new String[5];
		for(int i = 0; i < 5; i++){
			arrpng[i] = png;
		}
		p = new HotPlayerPanel(arrpng, content);
		
		back.add(p, 0);
		
		f.add(back);
		f.setLayout(null);
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
	
}
