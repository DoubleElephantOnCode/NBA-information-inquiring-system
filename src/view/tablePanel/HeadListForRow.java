package view.tablePanel;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HeadListForRow implements Runnable{
	JLabel[] field;
	int rowH, columnW;
	int pageColumn;
	
	long moveTime = 200;
	long sleepTime = 10;
	long stateTime = 0;
	
	int speed;
	int index;
	
	public HeadListForRow(ArrayList<String> headList, int pageColumn){
		field = new JLabel[headList.size()];
		this.pageColumn = pageColumn;
		for(int i = 0; i < field.length; i++){
			field[i] = new JLabel(headList.get(i));
			field[i].setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
	
	public HeadListForRow(String[] headList, int pageColumn){
		field = new JLabel[headList.length];
		this.pageColumn = pageColumn;
		for(int i = 0; i < field.length; i++){
			field[i] = new JLabel(headList[i]);
			field[i].setHorizontalAlignment(SwingConstants.CENTER);
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
	
	public void setPageColumn(int pageColumn){
		this.pageColumn = pageColumn;
	}
	
	protected void setHeadToPanel(JPanel p, int index){
		for(int i = 0; i < field.length; i++){
			field[i].setVisible(false);
			field[i].setBounds(0, (i-index)*rowH, columnW, rowH);
		}
		for(int i = 0; i < pageColumn; i++){
			field[(i+index)%field.length].setVisible(true);
		}
	}
	
	protected void moveToIndex(int index){
		int moveLength = -field[index].getLocation().y;
		if(moveLength == 0) return;
		speed = (int) (moveLength / sleepTime);
		this.index = index;
		Thread t = new Thread(this);
		t.start();
	}
	
	protected void addToPanel(JPanel p){
		for(int i = 0; i < field.length; i++){
			p.add(field[i]);
			field[i].setBounds(0, i*rowH, columnW, rowH);
		}
	}
	
	public void updateUI(){
		for(int i = 0; i < field.length; i++){
			field[i].updateUI();
		}
	}

	@Override
	public void run() {
		while(stateTime <= moveTime){
			for(int i = 0; i < field.length; i++){
				field[i].setLocation(0, field[i].getLocation().y + speed);
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
		if(field[index].getLocation().y != 0){
			field[index].setLocation(0, 0);
			for(int i = 0; i < field.length; i++){
				field[i].setLocation(0, (i-index)*rowH);
			}
			this.updateUI();
		}
		stateTime = 0;
	}
}
