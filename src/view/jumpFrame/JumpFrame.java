package view.jumpFrame;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.File;
import view.tablePanel.BarInColumnPanel;
import view.tablePanel.HeadListForRowPanel;

public class JumpFrame extends JFrame{
	
	ImageIcon cell_deep;
	ImageIcon cell_light;
	
	HeadListForRowPanel hpR;
	
	BarInColumnPanel bpC;
	
	int pointerRow = 0;
	
	Point origin = new Point();
	
	static int width = 100, height = 60;
	
	static int pageRow = 2;
	
	static int barWidth = 12;
	
	public JumpFrame(String[] items){
		
		hpR = new HeadListForRowPanel(items, pageRow, width-barWidth, height);
		hpR.setLocation(0, 0);
		
		bpC = new BarInColumnPanel(items.length, pageRow, barWidth, height);
		bpC.setLocation(width-barWidth, 0);
		
		cell_deep = new ImageIcon(File.file + File.grid_deep + File.PNG);
		cell_deep.setImage(cell_deep.getImage().getScaledInstance(width-barWidth, height / pageRow,Image.SCALE_DEFAULT));
		
		cell_light = new ImageIcon(File.file + File.grid_deep + File.PNG);
		cell_light.setImage(cell_light.getImage().getScaledInstance(width-barWidth, height / pageRow,Image.SCALE_DEFAULT));
		
		for(int i = 0; i < hpR.getTotalRow(); i++){
			if(i%2 == 0){
				hpR.setIconInRow(cell_deep, i);
			}
			else{
				hpR.setIconInRow(cell_light, i);
			}
		}
		
		bpC.addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				int r = arg0.getWheelRotation();
				if(r > 0){
					pointerRow++;
				}
				else if(r < 0){
					pointerRow--;
				}
				if(pointerRow+pageRow > hpR.getTotalRow()){
					pointerRow = hpR.getTotalRow()-pageRow;
				}
				if(pointerRow < 0){
					pointerRow = 0;
				}
				hpR.moveToIndex(pointerRow);
				bpC.setPosition(pointerRow);
			}
		});
		
		hpR.addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				int r = arg0.getWheelRotation();
				if(r > 0){
					pointerRow++;
				}
				else if(r < 0){
					pointerRow--;
				}
				if(pointerRow+pageRow > hpR.getTotalRow()){
					pointerRow = hpR.getTotalRow()-pageRow;
				}
				if(pointerRow < 0){
					pointerRow = 0;
				}
				hpR.moveToIndex(pointerRow);
				bpC.setPosition(pointerRow);
			}
		});
		
		bpC.addDragBarListener(new MouseMotionAdapter(){			
			@Override
			public void mouseDragged(MouseEvent e) {
				bpC.dragBarMethod(e);
				int t = (int) (hpR.getTotalRow()*bpC.position);
				hpR.moveToIndex(t);
			}
		});
		
		addMouseListener(
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
		            	repaint();
		            }
		         });
		addMouseMotionListener(
	            new MouseMotionAdapter(){
		              public void mouseDragged(MouseEvent e){
		                Point p = getLocation();
		                setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y );
		              }
		            }
		        );
		
		add(hpR, 0);
		add(bpC, 0);
		
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
		setSize(width, height);
		setLocationRelativeTo(null);
	}
	
	private static JLabel setJLabelWithIcon(String IconPath, int width, int height){
		ImageIcon icon = new ImageIcon(IconPath);
		icon.setImage(icon.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
		JLabel label = new JLabel(icon);
		label.setSize(width, height);
		label.setOpaque(false);
		return label;
	}
	
	public static void main(String[] args){
		String[] items = {"1", "2", "3"};
		new JumpFrame(items);
	}
	
}
