package view.tablePanel;

import javax.swing.JPanel;

public class TablePanel extends JPanel{
	String[] headList;
	
	TableField table;
	
	int totalRow, totalColumn;
	int pageRow, pageColumn;
	
	String[][] totalContent;
	String[][] pageContent;
	
	int pointerRow = 0, pointerColumn = 0;//指向目前显示在table上面的最左上角的行和列，指向的列同时是headList的列
	
	public TablePanel(int totalrow, int totalcolumn, int pagerow, int pagecolumn, String[] head, int width, int height){
		totalRow = totalrow;
		totalColumn = totalcolumn;
		pageRow = pagerow;
		pageColumn = pagecolumn;
		headList = new String[head.length];
		for(int i = 0; i < head.length; i++){
			headList[i] = head[i];
		}
		
		table = new TableField(pagerow, pagecolumn);
		table.addToPanel(this);
		
		totalContent = new String[totalRow][totalColumn];
		pageContent = new String[pageRow][pageColumn];
		
		for(int i = 0; i < totalRow; i++){
			for(int j = 0; j < totalColumn; j++){
				totalContent[i][j] = new String();
			}
		}
		for(int i = 0; i < pageRow; i++){
			for(int j = 0; j < pageColumn; j++){
				pageContent[i][j] = new String();
			}
		}
		
		this.setTableContent();
		this.setSize(width, height);
		this.setTableSize(width, height);
		this.setTableLocation(0, 0);
		
		this.setLayout(null);
	}
	
	public void setContent(String[][] content){
		for(int i = 0; i < content.length && i < totalRow; i++){
			for(int j = 0; j < content[0].length && j < totalColumn; j++){
				totalContent[i][j] = content[i][j];
			}
		}
	}
	
	protected void setTableContent(){
		for(int i = 0; i < pageRow; i++){
			for(int j = 0; j < pageColumn; j++){
				pageContent[i][j] = totalContent[i+pointerRow][j+pointerColumn];
			}
		}
		table.setFieldContent(pageContent);
		table.updateUI();
	}
	
	private void setTableSize(int width, int height){
		table.setSize(width, height);
	}
	
	private void setTableLocation(int x, int y){
		table.setLocation(x, y);
	}
	
	protected void changeColumn(int change){
		pointerColumn += change;
		if(pointerColumn < 0){
			pointerColumn = 0;
		}
		else if(pointerColumn > totalColumn-pageColumn){
			pointerColumn = totalColumn-pageColumn;
		}
		this.setTableContent();
	}
	
	protected void changeRow(int change){
		pointerRow += change;
		if(pointerRow < 0){
			pointerRow = 0;
		}
		else if(pointerRow > totalRow-pageRow){
			pointerRow = totalRow-pageRow;
		}
		this.setTableContent();
	}
	
	protected void setTablePointer(int pointerR, int pointerC){
		pointerRow = pointerR;
		pointerColumn = pointerC;
		if(pointerColumn < 0){
			pointerColumn = 0;
		}
		else if(pointerColumn > totalColumn-pageColumn){
			pointerColumn = totalColumn-pageColumn;
		}
		if(pointerRow < 0){
			pointerRow = 0;
		}
		else if(pointerRow > totalRow-pageRow){
			pointerRow = totalRow-pageRow;
		}
		this.setTableContent();
	}
	
}
