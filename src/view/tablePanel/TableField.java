package view.tablePanel;

import java.awt.Color;

import javax.swing.Icon;
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
	
	JLabel[][][] field;//table由多个JLabel组成
	int row, column;
	int rowH, columnW;
	
	int x = 0, y = 0;
	
	public TableField(int row, int column){
		field = new JLabel[row][column][2];
		this.row = row;
		this.column = column;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				field[i][j][0] = new JLabel();
				field[i][j][1] = new JLabel();
				field[i][j][0].setHorizontalAlignment(SwingConstants.CENTER);
				field[i][j][0].setOpaque(false);
				field[i][j][1].setOpaque(false);
			}
		}
	}
	
	public void setFieldContent(String[][] content){
		for(int i = 0; i < content.length && i < row; i++){
			for(int j = 0; j < content[0].length && j < column; j++){
				field[i][j][0].setText(content[i][j]);
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
				field[i][j][0].updateUI();
				field[i][j][1].updateUI();
			}
		}
	}
	
	protected void addToPanel(JPanel p){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				p.add(field[i][j][1], 0);
				p.add(field[i][j][0], 0);
			}
		}
	}
	
	protected void setFontColor(Color c){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				field[i][j][0].setForeground(c);
			}
		}
	}
	
	protected void setFontColorColumn(Color c, int column){
		if(column >= this.column || column < 0) return;
		for(int i = 0; i < row; i++){
			field[i][column][0].setForeground(c);
		}
	}
	
	protected void setFontColorRow(Color c, int row){
		if(row >= this.row || row < 0) return;
		for(int j = 0; j < column; j++){
			field[row][j][0].setForeground(c);
		}
	}
	
	protected void setRowBackground(Icon icon, int row){
		if(row >= this.row || row < 0) return;
		for(int j = 0; j < column; j++){
			field[row][j][1].setIcon(icon);
		}
	}
	
	protected void setColumnBackground(Icon icon, int column){
		if(column >= this.column || column < 0) return;
		for(int i = 0; i < row; i++){
			field[i][column][1].setIcon(icon);
		}
	}
	
	private void resetFieldBounds(){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				field[i][j][0].setBounds(x+j*columnW, y+i*rowH, columnW, rowH);
				field[i][j][1].setBounds(x+j*columnW, y+i*rowH, columnW, rowH);
			}
		}
	}
}
