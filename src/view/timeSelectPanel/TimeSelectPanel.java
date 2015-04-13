package view.timeSelectPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JPanel;

import view.selectedPanel.SelectPanel;

public class TimeSelectPanel extends JPanel{
	
	int begin, end;
	int swidth, sheight;
	
	SelectPanel year, month, day;
	
	final static String[] MONTH = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	
	public TimeSelectPanel(int width, int height, int beginYear, int endYear){
		swidth = width / 3;
		sheight = height;
		
		begin = beginYear;
		end = endYear;
		
		year = new SelectPanel(swidth, sheight);
		for(int i = begin; i <= end; i++){
			year.addItems(Integer.toString(i));
		}
		year.action();
		
		month = new SelectPanel(swidth-5, sheight, MONTH);
		
		day = new SelectPanel(swidth-5, sheight);
		setDayItem();
		
		year.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				year.action();
				setDayItem();
			}
		});
		
		month.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				month.action();
				setDayItem();
			}
		});
		
		day.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				day.action();
			}
		});
		
		year.setLocation(0, 0);
		month.setLocation(swidth+5, 0);
		day.setLocation(swidth * 2+5, 0);
		
		this.add(year);
		this.add(month);
		this.add(day);
		
		this.setSize(width, height);
		this.setLayout(null);
		this.setOpaque(false);
		this.setVisible(true);
	}
	
	public Date getDate(){
		int y = Integer.parseInt(year.getSelectedItem());
		int m = Integer.parseInt(month.getSelectedItem());
		int d = Integer.parseInt(day.getSelectedItem());
		return new Date(y-1900, m-1, d);
	}
	
	private void setDayItem(){
		int y = Integer.parseInt(year.getSelectedItem());
		int m = Integer.parseInt(month.getSelectedItem());
		day.removeAllItems();
		if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12){
			for(int i = 1; i <= 31; i++){
				day.addItems(Integer.toString(i));
			}
		}
		else if(m == 2){
			if(y % 400 == 0 || (y % 4 == 0 && y % 25 != 0)){
				for(int i = 1; i <= 29; i++){
					day.addItems(Integer.toString(i));
				}
			}
			else{
				for(int i = 1; i <= 28; i++){
					day.addItems(Integer.toString(i));
				}
			}
		}
		else{
			for(int i = 1; i <= 30; i++){
				day.addItems(Integer.toString(i));
			}
		}
		day.action();
	}
	
}
