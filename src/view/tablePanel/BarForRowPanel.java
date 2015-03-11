package view.tablePanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class BarForRowPanel extends JPanel{
	double position;
	int pageBarX;
	
	int width, height;
	
	JLabel totalBar;
	JLabel pageBar;
	
	int totalColumn;
	int pageColumn;
	
	public BarForRowPanel(int totalColumn, int pageColumn, int width, int height){
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
				position = (double)pointerRow / totalColumn;
				pageBarX = (int) (position * width);
				pageBar.setLocation(pageBarX, 0);
				pageBar.updateUI();
				return null;
			}
			
		}.execute();
	}
}
