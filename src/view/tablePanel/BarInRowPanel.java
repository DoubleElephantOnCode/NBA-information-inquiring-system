package view.tablePanel;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class BarInRowPanel extends JPanel{
	public double position;
	int pageBarX;
	
	int width, height;
	
	JLabel totalBar;
	JLabel pageBar;
	
	int totalColumn;
	int pageColumn;
	
	Point origin = new Point();
	
	public BarInRowPanel(int totalColumn, int pageColumn, int width, int height){
		this.totalColumn = totalColumn;
		this.pageColumn = pageColumn;
		this.width = width;
		this.height = height;
		
		totalBar = new JLabel();
		pageBar = new JLabel();
		
		totalBar.setSize(width, height);
		pageBar.setSize((int) (((double)pageColumn / totalColumn) * width), height);
		
		totalBar.setBackground(Color.black);
		pageBar.setBackground(Color.white);
		
		totalBar.setOpaque(true);//TODO ��͸������ͼ
		pageBar.setOpaque(true);
		
		totalBar.setLocation(0, 0);
		pageBar.setLocation(0, 0);
		
		this.setLayout(null);
		
		this.add(pageBar, 0);
		this.add(totalBar, 1);
		
		this.setSize(width, height);
		
		pageBar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
    			origin.x = e.getX();
            }
            public void mouseClicked(MouseEvent e) {
            	
            }
            public void mouseReleased(MouseEvent e) {
            	super.mouseReleased(e);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	pageBar.repaint();
            }
		});
	}
	
	public void setPosition(final int pointerColumn){
		new SwingWorker<Void, Void>(){
			@Override
			protected Void doInBackground() throws Exception {
				position = (double)pointerColumn / totalColumn;
				pageBarX = (int) (position * width);
				pageBar.setLocation(pageBarX, 0);
				pageBar.updateUI();
				return null;
			}
			
		}.execute();
	}
	
	public void dragBarMethod(MouseEvent e){
		Point p = pageBar.getLocation();
        if(p.x + e.getX() - origin.x < 0){
        	pageBar.setLocation(0, 0);
        }
        else if(p.x + e.getX() - origin.x > totalBar.getWidth() - pageBar.getWidth()){
        	pageBar.setLocation(totalBar.getWidth() - pageBar.getWidth(), 0);
        }
        else{
        	pageBar.setLocation(p.x + e.getX() - origin.x, 0);
        }
        position = (double)pageBar.getLocation().x / totalBar.getWidth();
	}
	
	public void addDragBarListener(MouseMotionListener l){
		pageBar.addMouseMotionListener(l);
	}
}
