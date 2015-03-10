package view.tablePanel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 
 * @author WHJ
 *	Table为静态的，只是静态的显示内容，要使其可以翻页或者换列需要Table的相关类对其进行操作
 *	只是单纯的表格，不含表头
 */
public class TableField {
	
	JLabel[][] field;//table由多个JLabel组成
	int row, column;
	int rowH, columnW;
	
	int x = 0, y = 0;
	
	public TableField(int row, int column){
		field = new JLabel[row][column];
		this.row = row;
		this.column = column;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				field[i][j] = new JLabel();
				field[i][j].setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
	}
	
	public void setFieldContent(String[][] content){
		for(int i = 0; i < content.length && i < row; i++){
			for(int j = 0; j < content[0].length && j < column; j++){
				field[i][j].setText(content[i][j]);
			}
		}
	}
	
	public void setRowHeight(int Rheight){
		rowH = Rheight;
		this.resetFieldBounds();
	}
	
	public void setColumnWidth(int Cwidth){
		columnW = Cwidth;
		this.resetFieldBounds();
	}
	
	public void setSize(int width, int height){
		rowH = height / row;
		columnW = width / column;
		this.resetFieldBounds();
	}
	
	public void setLocation(int x, int y){
		this.x = x;
		this.y = y;
		this.resetFieldBounds();
	}
	
	public void updateUI(){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				field[i][j].updateUI();
			}
		}
	}
	
	protected void addToPanel(JPanel p){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				p.add(field[i][j]);
			}
		}
	}
	
	private void resetFieldBounds(){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				field[i][j].setBounds(x+j*columnW, y+i*rowH, columnW, rowH);
			}
		}
	}
}
