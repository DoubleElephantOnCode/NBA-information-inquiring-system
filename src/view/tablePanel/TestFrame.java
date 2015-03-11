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
	
	static String[] headC;
	static String[] headR;
	static int width = 500, height = 250;
	static int column = 50;
	static int row = 150;
	
	static int prow = 12;
	static int pcolumn = 10;
	
	static TablePanel p;
	static HeadListForColumnPanel hpC;
	static HeadListForRowPanel hpR;
	static BarForColumnPanel bcp;
	static BarForRowPanel brp;
	static Point origin = new Point();
	static JFrame f;
	static JTextArea field;
	
	public static void main(String[] args){
		headC = new String[column];
		headR = new String[row];
		for(int i = 0; i < row; i++){
			headR[i] = i+"";
		}
		for(int i = 0; i < column; i++){
			headC[i] = i+"";
		}
		String[][] s = new String[row][column];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				s[i][j] = new String(i + "  " + j);
			}
		}
		f = new JFrame();
		JPanel panel = new JPanel();
		p = new TablePanel(row,column,prow,pcolumn,headC, width, height);
		p.setContent(s);
		p.setTableContent();
		p.setLocation(100, 50);
		
		hpC = new HeadListForColumnPanel(headC, pcolumn, width, height/prow);
		hpC.setLocation(100, 0);
		
		hpR = new HeadListForRowPanel(headR, prow, width/pcolumn, height);
		hpR.setLocation(50, 50);
		
		bcp = new BarForColumnPanel(row, prow, 20, height);
		bcp.setLocation(600, 50);
		bcp.setPosition(p.pointerRow);
		
		brp = new BarForRowPanel(column, pcolumn, width, 20);
		brp.setLocation(50, 300);
		brp.setPosition(p.pointerColumn);
		
		JButton left = new JButton("left");
		left.setSize(100, 30);
		left.setLocation(0, 400);
		JButton right = new JButton("right");
		right.setSize(100, 30);
		right.setLocation(200, 400);
		JButton up = new JButton("up");
		up.setSize(100, 30);
		up.setLocation(700, 100);
		JButton down = new JButton("down");
		down.setSize(100, 30);
		down.setLocation(700, 200);
		JButton close = new JButton("close");
		close.setSize(100, 30);
		close.setLocation(700, 400);
		left.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				p.changeColumn(-1);
				hpC.moveToIndex(p.pointerColumn);
				brp.setPosition(p.pointerColumn);
			}
			
		});
		
		right.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				p.changeColumn(1);
				hpC.moveToIndex(p.pointerColumn);
				brp.setPosition(p.pointerColumn);
			}
			
		});
		up.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				p.changeRow(-1);
				hpR.moveToIndex(p.pointerRow);
				bcp.setPosition(p.pointerRow);
			}
			
		});
		down.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				p.changeRow(1);
				hpR.moveToIndex(p.pointerRow);
				bcp.setPosition(p.pointerRow);
			}
			
		});
		close.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		
		p.addMouseWheelListener(new MouseWheelListener(){
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				int r = arg0.getWheelRotation();
				if(r > 0){
					p.changeRow(1);
				}
				else if(r < 0){
					p.changeRow(-1);
				}
				hpR.moveToIndex(p.pointerRow);
				bcp.setPosition(p.pointerRow);
			}
						
		});
		
		bcp.addMouseWheelListener(new MouseWheelListener(){

			public void mouseWheelMoved(MouseWheelEvent arg0) {
				int r = arg0.getWheelRotation();
				if(r > 0){
					p.changeRow(1);
				}
				else if(r < 0){
					p.changeRow(-1);
				}
				hpR.moveToIndex(p.pointerRow);
				bcp.setPosition(p.pointerRow);
			}
			
		});
		
		brp.addMouseWheelListener(new MouseWheelListener(){
			
			public void mouseWheelMoved(MouseWheelEvent e) {
				int r = e.getWheelRotation();
				if(r > 0){
					p.changeColumn(1);
				}
				else if(r < 0){
					p.changeColumn(-1);
				}
				hpC.moveToIndex(p.pointerColumn);
				brp.setPosition(p.pointerColumn);
			}
			
		});
		
		field = new JTextArea();
		field.setOpaque(false);
		field.setSize(100, 20);
		field.setLocation(800, 450);
//		field.setForeground(new Color(1, 1, 0, 0.0f));
		panel.setLayout(null);
		panel.add(p);
		panel.add(hpC);
		panel.add(hpR);
		panel.add(bcp);
		panel.add(brp);
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
