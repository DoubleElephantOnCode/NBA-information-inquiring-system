package view.tablePanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class BarForColumnPanel extends JPanel{
	
	double position;
	int pageBarY;
	
	int width, height;
	
	JLabel totalBar;
	JLabel pageBar;
	
	int totalRow;
	int pageRow;
	
	public BarForColumnPanel(int totalRow, int pageRow, int width, int height){
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
}
