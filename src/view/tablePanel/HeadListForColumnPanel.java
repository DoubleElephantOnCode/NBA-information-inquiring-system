package view.tablePanel;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeadListForColumnPanel extends JPanel{
	int width, height;
	HeadListForColumn list;
	
	int pageColumn;

	public HeadListForColumnPanel(String[] headList, int pageColumn, int width, int height){
		this.height = height;
		this.width = width;
		this.pageColumn = pageColumn;
		list = new HeadListForColumn(headList, pageColumn);
		list.setRowHeight(height);
		list.setColumnWidth(width / pageColumn);
		list.addToPanel(this);
		this.setSize(width, height);
		this.setLayout(null);
		this.setOpaque(false);
	}
	
	public void moveToIndex(int index){
		list.moveToIndex(index);
	}
	
	public void setFontColor(Color c){
		for(int i = 0; i < list.field.length; i++){
			list.field[i].setForeground(c);
		}
	}
	
	public void setBackground(JLabel back){
		back.setLocation(0, 0);
		this.add(back, list.field.length);
	}
}
