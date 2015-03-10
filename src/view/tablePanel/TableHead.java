package view.tablePanel;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TableHead implements Runnable{
	JLabel[] field;
	int rowH, columnW;
	int pageColumn;
	int x, y;
	
	long moveTime = 1000;
	long sleepTime = 25;
	long stateTime = 0;
	
	int speed;
	
	public TableHead(ArrayList<String> headList, int pageColumn){
		field = new JLabel[headList.size()];
		this.pageColumn = pageColumn;
		for(int i = 0; i < field.length; i++){
			field[i] = new JLabel(headList.get(i));
			field[i]. setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
	
	public TableHead(String[] headList, int pageColumn){
		field = new JLabel[headList.length];
		this.pageColumn = pageColumn;
		for(int i = 0; i < field.length; i++){
			field[i] = new JLabel(headList[i]);
		}
	}
	
	public void setFieldSize(int width, int height){
		rowH = height;
		columnW = width;
		for(int i = 0; i < field.length; i++){
			field[i].setSize(rowH, columnW);
		}
	}
	
	public void setRowHeight(int height){
		rowH = height;
		for(int i = 0; i < field.length; i++){
			field[i].setSize(rowH, columnW);
		}
	}
	
	public void setColumnWidth(int width){
		columnW = width;
		for(int i = 0; i < field.length; i++){
			field[i].setSize(rowH, columnW);
		}
	}
	
	public void setLocation(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setPageColumn(int pageColumn){
		this.pageColumn = pageColumn;
	}
	
	protected void setHeadToPanel(JPanel p, int index){
		for(int i = 0; i < field.length; i++){
			field[i].setVisible(false);
			field[i].setBounds((i-index)*columnW+x, y, columnW, rowH);
		}
		for(int i = 0; i < pageColumn; i++){
			field[(i+index)%field.length].setVisible(true);
		}
	}
	
	protected void moveToIndex(final int index){
//		int moveLength = x - field[index].getLocation().x;
//		if(moveLength == 0) return;
//		speed = (int) (moveLength / sleepTime);
		Thread t = new Thread(this);
		t.start();
		stateTime = 0;
	}
	
	protected void addToPanel(JPanel p){
		for(int i = 0; i < field.length; i++){
			p.add(field[i]);
			field[i].setBounds(i*columnW+x, y, columnW, rowH);
		}
	}
	
	public void updateUI(){
		for(int i = 0; i < field.length; i++){
			field[i].updateUI();
		}
	}

	@Override
	public void run() {
		while(stateTime < moveTime){
			for(int i = 0; i < field.length; i++){
				field[i].setLocation(field[i].getLocation().x + 1, y);
			}
			updateUI();
			try {
				Thread.sleep(sleepTime);
				stateTime += sleepTime;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
