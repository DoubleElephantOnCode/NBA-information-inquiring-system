package view.tablePanel;

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
	}
	
	protected void moveToIndex(int index){
		list.moveToIndex(index);
	}
}
