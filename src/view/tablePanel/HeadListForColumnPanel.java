package view.tablePanel;

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
	}
	
	protected void moveToIndex(int index){
		list.moveToIndex(index);
	}
}
