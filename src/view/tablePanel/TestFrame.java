package view.tablePanel;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TestFrame {
	
	static String[] headC = {"0", "1", "2", "3", "4", "5", "6"};
	static String[] headR = {"0", "1", "2", "3", "4", "5", "6", "7"};
	static int width = 500, height = 250;
	
	static TablePanel p;
	static HeadListForColumnPanel hpC;
	static HeadListForRowPanel hpR;
	static Point origin = new Point();
	static JFrame f;
	static JTextArea field;
	
	public static void main(String[] args){
		String[][] s = new String[8][7];
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 7; j++){
				s[i][j] = new String(i + "  " + j);
			}
		}
		f = new JFrame();
		JPanel panel = new JPanel();
		p = new TablePanel(8,7,4,5,headC, width, height);
		p.setContent(s);
		p.setTableContent();
		p.setLocation(100, 50);
		
		hpC = new HeadListForColumnPanel(headC, 5, width, height/4);
		hpC.setLocation(100, 0);
		
		hpR = new HeadListForRowPanel(headR, 4, width/5, height);
		hpR.setLocation(0, 50);
		
		JButton left = new JButton("left");
		left.setSize(100, 30);
		left.setLocation(0, 300);
		JButton right = new JButton("right");
		right.setSize(100, 30);
		right.setLocation(200, 300);
		JButton up = new JButton("up");
		up.setSize(100, 30);
		up.setLocation(600, 100);
		JButton down = new JButton("down");
		down.setSize(100, 30);
		down.setLocation(600, 200);
		JButton close = new JButton("close");
		close.setSize(100, 30);
		close.setLocation(700, 400);
		left.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				p.changeColumn(-1);
				hpC.moveToIndex(p.pointerColumn);
			}
			
		});
		
		right.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				p.changeColumn(1);
				hpC.moveToIndex(p.pointerColumn);
			}
			
		});
		up.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				p.changeRow(-1);
				hpR.moveToIndex(p.pointerRow);
			}
			
		});
		down.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				p.changeRow(1);
				hpR.moveToIndex(p.pointerRow);
			}
			
		});
		close.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		
		p.addMouseWheelListener(new MouseWheelListener(){
			@Override
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				int r = arg0.getWheelRotation();
				if(r > 0){
					p.changeRow(1);
				}
				else if(r < 0){
					p.changeRow(-1);
				}
				hpR.moveToIndex(p.pointerRow);
			}
						
		});
		
		field = new JTextArea();
		field.setOpaque(false);
		field.setSize(200, 20);
		field.setLocation(800, 450);
//		field.setForeground(new Color(1, 1, 0, 0.0f));
		panel.setLayout(null);
		panel.add(p);
		panel.add(hpC);
		panel.add(hpR);
		panel.add(left);
		panel.add(right);
		panel.add(up);
		panel.add(down);
		panel.add(close);
		panel.add(field);
		
		f.setContentPane(panel);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setUndecorated(true);
		f.setSize(2*width, 2*height);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		
		f.addMouseListener(
		    	new MouseAdapter(){
		    		public void mousePressed(MouseEvent e){
		    			origin.x = e.getX();
		                origin.y = e.getY();
		            }
		            //设置关闭程序所用，关闭按钮设置
		            public void mouseClicked(MouseEvent e) {
		            	//TODO
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
