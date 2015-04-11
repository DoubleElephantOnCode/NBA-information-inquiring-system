package view.singlePlayerPanel;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

import view.SizeAndLocationAndFont;
import view.infomationCenter.InformationCenterPanel;

public class TestFrame {

	static int row = 82, column = 10;
	static int width = SizeAndLocationAndFont.frameWidth,
			height = SizeAndLocationAndFont.frameHeight;
	
	static Point origin = new Point();
	static JFrame f;
	static SinglePlayerPanel p;
	static String[][] content;
	static String[] headListForRow;
	static String[] headListForColumn;
	static InformationCenterPanel back;
	
	public static void main(String[] args){
		content = new String[row][column];
		headListForRow = new String[row];
		headListForColumn = new String[column];
		
		back = new InformationCenterPanel(0);
		
		for(int i = 0; i < row; i++){
			headListForRow[i] = i+"";
			for(int j = 0; j < column; j++){
				content[i][j] = i+" "+j;
			}
		}
		
		for(int i = 0; i < column; i++){
			headListForColumn[i] = i+"";
		}
		
		f = new JFrame();
		f.setBackground(Color.red);
		
		p = new SinglePlayerPanel("E:\\课件\\软件工程与计算\\大二下学期\\data\\迭代一数据\\players\\portrait\\LeBron James.png", "E:\\课件\\软件工程与计算\\大二下学期\\data\\迭代一数据\\players\\action\\LeBron James.png", null, content, headListForRow, headListForColumn);
		
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
