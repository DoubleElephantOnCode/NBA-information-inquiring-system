package view.tablePanel;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

public class HeadListForColumn {
	JLabel[] field;
	int rowH, columnW;
	int pageColumn;
	
	long moveTime = 200;
	long sleepTime = 10;
	long stateTime = 0;
	
	int speed;
	int index;
	
	public HeadListForColumn(ArrayList<String> headList, int pageColumn){
		field = new JLabel[headList.size()];
		this.pageColumn = pageColumn;
		for(int i = 0; i < field.length; i++){
			field[i] = new JLabel(headList.get(i));
			field[i].setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
	
	public HeadListForColumn(String[] headList, int pageColumn){
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
			field[i].setBounds((i-index)*columnW, 0, columnW, rowH);
		}
		for(int i = 0; i < pageColumn; i++){
			field[(i+index)%field.length].setVisible(true);
		}
	}
	
	protected void moveToIndex(int index){
		int moveLength = -field[index].getLocation().x;
		if(moveLength == 0) return;
		speed = (int) (moveLength / sleepTime);
		this.index = index;
		new SwingWorker<Void, Void>(){
			@Override
			protected Void doInBackground() throws Exception {
				return moveHeadList();
			}
		}.execute();
	}
	
	protected void addToPanel(JPanel p){
		for(int i = 0; i < field.length; i++){
			p.add(field[i]);
			field[i].setBounds(i*columnW, 0, columnW, rowH);
		}
	}
	
	public void updateUI(){
		for(int i = 0; i < field.length; i++){
			field[i].updateUI();
		}
	}

	private Void moveHeadList() {
		while(stateTime <= moveTime){
			for(int i = 0; i < field.length; i++){
				field[i].setLocation(field[i].getLocation().x + speed, 0);
			}
			updateUI();
			try {
				Thread.sleep(sleepTime);
				stateTime += sleepTime;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(field[index].getLocation().x != 0){
			field[index].setLocation(0, 0);
			for(int i = 0; i < field.length; i++){
				field[i].setLocation((i-index)*columnW, 0);
			}
			this.updateUI();
		}
		stateTime = 0;
		return null;
	}
	
}
