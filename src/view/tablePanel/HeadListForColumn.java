package view.tablePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

public class HeadListForColumn {
	public JLabel[][] field;
	int rowH, columnW;
	int pageColumn;
	
	long moveTime = 200;
	long sleepTime = 10;
	long stateTime = 0;
	
	int speed;
	int index;
	
	Timer timer = new Timer();
	
	public HeadListForColumn(ArrayList<String> headList, int pageColumn){
		field = new JLabel[headList.size()][2];
		this.pageColumn = pageColumn;
		for(int i = 0; i < field.length; i++){
			field[i][0] = new JLabel(headList.get(i));
			field[i][1] = new JLabel();
			field[i][0].setHorizontalAlignment(SwingConstants.CENTER);
			field[i][0].setOpaque(false);
			field[i][1].setOpaque(false);
		}
	}
	
	public HeadListForColumn(String[] headList, int pageColumn){
		field = new JLabel[headList.length][2];
		this.pageColumn = pageColumn;
		for(int i = 0; i < field.length; i++){
			field[i][0] = new JLabel(headList[i]);
			field[i][1] = new JLabel();
			field[i][0].setHorizontalAlignment(SwingConstants.CENTER);
			field[i][0].setOpaque(false);
			field[i][1].setOpaque(false);
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
	
	public void setPageColumn(int pageColumn){
		this.pageColumn = pageColumn;
	}
	
	protected void moveToIndex(int index){
		int moveLength = -field[index][0].getLocation().x;
		if(moveLength == 0) return;
		speed = (int) (moveLength / sleepTime) / 2;
		this.index = index;
		new SwingWorker<Void, Void>(){
			@Override
			protected Void doInBackground() throws Exception {
				publish();
				return null;
			}

			@Override
			protected void process(List<Void> chunks) {
				timer.cancel();
				stateTime = 0;
				timer = new Timer();
				TimerTask task = new TimerTask(){

					@Override
					public void run() {
						moveHeadList(this);
					}
					
				};
				timer.schedule(task, 0, sleepTime);
			}
		}.execute();
	}
	
	protected void addToPanel(JPanel p){
		for(int i = 0; i < field.length; i++){
			p.add(field[i][0], 0);
			p.add(field[i][1], 1);
			field[i][0].setBounds(i*columnW, 0, columnW, rowH);
			field[i][1].setBounds(i*columnW, 0, columnW, rowH);
		}
	}
	
	public void updateUI(){
		for(int i = 0; i < field.length; i++){
			field[i][0].updateUI();
			field[i][1].updateUI();
		}
	}

	private Void moveHeadList(TimerTask task) {
		if(stateTime <= moveTime){
			for(int i = 0; i < field.length; i++){
				field[i][0].setLocation(field[i][0].getLocation().x + speed, 0);
				field[i][1].setLocation(field[i][1].getLocation().x + speed, 0);
			}
			if(field[0][0].getLocation().x > 0){
				for(int i = 0; i < field.length; i++){
					field[i][0].setLocation(i*columnW, 0);
					field[i][1].setLocation(i*columnW, 0);
				}
			}
			else if(field[field.length-1][0].getLocation().x < (pageColumn-1)*columnW){
				field[index][0].setLocation(0, 0);
				field[index][1].setLocation(0, 0);
				for(int i = 0; i < field.length; i++){
					field[i][0].setLocation((i-index)*columnW, 0);
					field[i][1].setLocation((i-index)*columnW, 0);
				}
			}
			updateUI();
			stateTime += sleepTime;
		}
		else{
			if(field[index][0].getLocation().x != 0){
				field[index][0].setLocation(0, 0);
				field[index][1].setLocation(0, 0);
				for(int i = 0; i < field.length; i++){
					field[i][0].setLocation((i-index)*columnW, 0);
					field[i][1].setLocation((i-index)*columnW, 0);
				}
				this.updateUI();
			}
			stateTime = 0;
			task.cancel();
		}
		return null;
	}
	
}
