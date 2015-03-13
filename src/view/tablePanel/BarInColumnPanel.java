package view.tablePanel;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class BarInColumnPanel extends JPanel{
	
	public double position = 0;
	int pageBarY;
	
	int width, height;
	
	JLabel totalBar;
	JLabel pageBar;
	
	int totalRow;
	int pageRow;
	
	Point origin = new Point();
	
	public BarInColumnPanel(int totalRow, int pageRow, int width, int height){
		this.totalRow = totalRow;
		this.pageRow = pageRow;
		this.width = width;
		this.height = height;
		
		totalBar = new JLabel();
		pageBar = new JLabel();
		
		totalBar.setSize(width, height);
		pageBar.setSize(width, (int) (((double)pageRow / totalRow) * height));
		
		totalBar.setBackground(Color.black);
		pageBar.setBackground(Color.white);
		
		totalBar.setOpaque(true);//TODO »»Í¸Ã÷£¬ÌùÍ¼
		pageBar.setOpaque(true);
		
		totalBar.setLocation(0, 0);
		pageBar.setLocation(0, 0);
		
		this.setLayout(null);
		
		this.add(pageBar, 0);
		this.add(totalBar, 1);
		
		this.setSize(width, height);
		
		pageBar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
    			origin.y = e.getY();
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
	
	public void setPosition(final int pointerRow){
		new SwingWorker<Void, Void>(){
			@Override
			protected Void doInBackground() throws Exception {
				position = (double)pointerRow / totalRow;
				pageBarY = (int) (position * height);
				pageBar.setLocation(0, pageBarY);
				pageBar.updateUI();
				return null;
			}
			
		}.execute();
	}
	
	public void dragBarMethod(MouseEvent e){
		Point p = pageBar.getLocation();
        if(p.y + e.getY() - origin.y < 0){
        	pageBar.setLocation(0, 0);
        }
        else if(p.y + e.getY() - origin.y > totalBar.getHeight() - pageBar.getHeight()){
        	pageBar.setLocation(0, totalBar.getHeight() - pageBar.getHeight());
        }
        else{
        	pageBar.setLocation(0, p.y + e.getY() - origin.y);
        }
        position = (double)pageBar.getLocation().y / totalBar.getHeight();
	}
	
	public void addDragBarListener(MouseMotionListener l){
		pageBar.addMouseMotionListener(l);
	}
}
