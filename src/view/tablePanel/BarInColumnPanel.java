package view.tablePanel;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class BarInColumnPanel extends JPanel{
	String file = "E:\\课件\\软件工程与计算\\大二下学期\\图片\\";
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
		
		totalBar = setJLabelWithIcon(file+"totalBar_c.png", width, height);
		pageBar = setJLabelWithIcon(file+"pageBar_c.png", width, (int) (((double)pageRow / totalRow) * height));
		
//		totalBar.setSize(width, height);
//		pageBar.setSize(width, (int) (((double)pageRow / totalRow) * height));
		
		totalBar.setBackground(Color.black);
		pageBar.setBackground(Color.white);
		
		totalBar.setOpaque(false);//TODO 换透明，贴图
		pageBar.setOpaque(false);
		
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
	
	private static JLabel setJLabelWithIcon(String IconPath, int width, int height){
		ImageIcon icon = new ImageIcon(IconPath);
		icon.setImage(icon.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
		JLabel label = new JLabel(icon);
		label.setSize(width, height);
		label.setOpaque(false);
		return label;
	}
}
