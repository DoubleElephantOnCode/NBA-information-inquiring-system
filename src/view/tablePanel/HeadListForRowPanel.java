package view.tablePanel;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeadListForRowPanel extends JPanel{
	int width, height;
	HeadListForRow list;
	
	int pageRow;

	public HeadListForRowPanel(String[] headList, int pageRow, int width, int height){
		this.height = height;
		this.width = width;
		this.pageRow = pageRow;
		list = new HeadListForRow(headList, pageRow);
		list.setRowHeight(height / pageRow);
		list.setColumnWidth(width);
		list.addToPanel(this);
		this.setSize(width, height);
		this.setLayout(null);
		this.setOpaque(false);
	}
	
	public void moveToIndex(int index){
		list.moveToIndex(index);
	}
	
//	public void setIcon(Icon icon){
//		for(int i = 0; i < list.field.length; i++){
//			list.field[i].setIcon(icon);
//		}
//	}
	
	public void setFontColor(Color c){
		for(int i = 0; i < list.field.length; i++){
			list.field[i][0].setForeground(c);
		}
	}
	
	public void setBackground(JLabel back){
		back.setLocation(0, 0);
		this.add(back, list.field.length);
	}
	
	public void setIconInRow(Icon icon, int row){
		list.field[row][1].setIcon(icon);
	}
	
//	public void setBackground(Icon icon){
//		this.setIcon(icon);
//	}
}
