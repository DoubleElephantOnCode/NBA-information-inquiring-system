package view.tablePanel;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

public class HeadListForRow{
	JLabel[][] field;
	int rowH, columnW;
	int pageRow;
	
	long moveTime = 200;
	long sleepTime = 10;
	long stateTime = 0;
	
	int speed;
	int index;
	
	public HeadListForRow(ArrayList<String> headList, int pageRow){
		field = new JLabel[headList.size()][2];
		this.pageRow = pageRow;
		for(int i = 0; i < field.length; i++){
			field[i][0] = new JLabel(headList.get(i));
			field[i][1] = new JLabel(headList.get(i));
			field[i][0].setHorizontalAlignment(SwingConstants.CENTER);
			field[i][0].setOpaque(false);
			field[i][1].setOpaque(false);
		}
	}
	
	public HeadListForRow(String[] headList, int pageColumn){
		field = new JLabel[headList.length][2];
		this.pageRow = pageColumn;
		for(int i = 0; i < field.length; i++){
			field[i][0] = new JLabel(headList[i]);
			field[i][1] = new JLabel(headList[i]);
			field[i][0].setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
	
	public void setFieldSize(int width, int height){
		rowH = height;
		columnW = width;
		for(int i = 0; i < field.length; i++){
			field[i][0].setSize(rowH, columnW);
			field[i][1].setSize(rowH, columnW);
		}
	}
	
	public void setRowHeight(int height){
		rowH = height;
		for(int i = 0; i < field.length; i++){
			field[i][0].setSize(rowH, columnW);
			field[i][1].setSize(rowH, columnW);
		}
	}
	
	public void setColumnWidth(int width){
		columnW = width;
		for(int i = 0; i < field.length; i++){
			field[i][0].setSize(rowH, columnW);
			field[i][1].setSize(rowH, columnW);
		}
	}
	
	public void setPageRow(int pageRow){
		this.pageRow = pageRow;
	}
	
	protected void moveToIndex(int index){
		int moveLength = -field[index][0].getLocation().y;
		if(moveLength == 0) return;
		speed = (int) (moveLength / sleepTime);
		this.index = index;
		new SwingWorker<Void, Void>(){
			@Override
			protected Void doInBackground() throws Exception {
				moveHeadList();
				return null;
			}
		}.execute();
	}
	
	protected void addToPanel(JPanel p){
		for(int i = 0; i < field.length; i++){
			p.add(field[i][1], 0);
			p.add(field[i][0], 0);
			field[i][0].setBounds(0, i*rowH, columnW, rowH);
			field[i][1].setBounds(0, i*rowH, columnW, rowH);
		}
	}
	
	public void updateUI(){
		for(int i = 0; i < field.length; i++){
			field[i][0].updateUI();
			field[i][1].updateUI();
		}
	}
	
	private Void moveHeadList(){
		while(stateTime <= moveTime){
			for(int i = 0; i < field.length; i++){
				field[i][0].setLocation(0, field[i][0].getLocation().y + speed);
				field[i][1].setLocation(0, field[i][0].getLocation().y + speed);
			}
			if(field[0][0].getLocation().y > 0){
				for(int i = 0; i < field.length; i++){
					field[i][0].setLocation(0, i*rowH);
					field[i][1].setLocation(0, i*rowH);
				}
			}
			else if(field[field.length-1][0].getLocation().y < (pageRow-1)*rowH){
				field[index][0].setLocation(0, 0);
				for(int i = 0; i < field.length; i++){
					field[i][0].setLocation(0, (i-index)*rowH);
					field[i][1].setLocation(0, (i-index)*rowH);
				}
			}
			updateUI();
			try {
				Thread.sleep(sleepTime);
				stateTime += sleepTime;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(field[index][0].getLocation().y != 0){
			field[index][0].setLocation(0, 0);
			for(int i = 0; i < field.length; i++){
				field[i][0].setLocation(0, (i-index)*rowH);
				field[i][1].setLocation(0, (i-index)*rowH);
			}
			this.updateUI();
		}
		stateTime = 0;
		return null;
	}
}
