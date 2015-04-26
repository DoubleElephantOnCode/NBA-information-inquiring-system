package view.matchPanel;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.File;
import view.SizeAndLocationAndFont;
import view.tablePanel.BarInColumnPanel;
import view.tablePanel.BarInRowPanel;
import view.tablePanel.HeadListForColumnPanel;
import view.tablePanel.HeadListForRowPanel;
import view.tablePanel.TablePanel;

public class OneTeamMatchStatisticsTablePanel extends JPanel{

	int width = SizeAndLocationAndFont.oneTeamStatisticsTablePanelWidth,
			height = SizeAndLocationAndFont.oneTeamStatisticsTablePanelHeight;
	
	int pointerRow = 0, pointerColumn = 0;
	
	int selectedColumn;
	boolean sort;
	
	String[] headListForColumn;
	String[] headListForRow;
	String[][] contentInTable;
	
	
	int tableWidth = SizeAndLocationAndFont.oneTeamStatisticsTableWidth,
			tableHeight = SizeAndLocationAndFont.oneTeamStatisticsTableHeight;
	int row = 30, column = 50;
	int pageRow = SizeAndLocationAndFont.oneTeamStatisticsTablePageRow,
			pageColumn = SizeAndLocationAndFont.oneTeamStatisticsTablePageColumn;
	
	int headListForRowPanelWidth = SizeAndLocationAndFont.oneTeamStatisticsTableHeadListForRowWidth;
			
	int headListForColumnPanelHeight = SizeAndLocationAndFont.oneTeamStatisticsTableHeadListForColumnHeight;
	
	int barWidth = SizeAndLocationAndFont.barWidth;
	
	int leftSide = 0;
	
	TablePanel p;
	HeadListForColumnPanel hpC;
	HeadListForRowPanel hpR;
	BarInColumnPanel bcp;
	BarInRowPanel brp;
	
	JLabel hpcBackground;
	JLabel background;
	
	JLabel[] playerName;
	
	ImageIcon grid_deep, grid_light;
	
	ImageIcon head_deep, head_light;
	
	Color fontColor = Color.black;
	
	public OneTeamMatchStatisticsTablePanel(String[][] content, String[] headListForRow, String[] headListForColumn){

		contentInTable = content;
		this.headListForColumn = headListForColumn;
		this.headListForRow = headListForRow;
		
		row = content.length;
		column = content[0].length;
		
		p = new TablePanel(row, column, pageRow, pageColumn, tableWidth, tableHeight);
		p.setContent(contentInTable);
		p.setLocation(leftSide + headListForRowPanelWidth, headListForColumnPanelHeight);
		
		hpC = new HeadListForColumnPanel(headListForColumn, pageColumn, tableWidth, headListForColumnPanelHeight);
		hpC.setLocation(leftSide + headListForRowPanelWidth, 0);
		
		hpR = new HeadListForRowPanel(headListForRow, pageRow, headListForRowPanelWidth, tableHeight);
		hpR.setLocation(leftSide, headListForColumnPanelHeight);
		
		playerName = new JLabel[2];
		playerName[0] = new JLabel("球  员");
		playerName[0].setForeground(fontColor);
		playerName[0].setHorizontalAlignment(SwingConstants.CENTER);
		playerName[1] = setJLabelWithIcon(File.file + File.table_cell2_light + File.PNG, headListForRowPanelWidth, headListForColumnPanelHeight);
		for(int i = 0; i < 2; i++){
			playerName[i].setSize(headListForRowPanelWidth, headListForColumnPanelHeight);
			playerName[i].setLocation(leftSide, 0);
		}
		
		bcp = new BarInColumnPanel(row, pageRow, barWidth, tableHeight);
		bcp.setLocation(leftSide + headListForRowPanelWidth + tableWidth, headListForColumnPanelHeight);
		bcp.setPosition(pointerRow);
		
		brp = new BarInRowPanel(column, pageColumn, tableWidth, barWidth);
		brp.setLocation(leftSide + headListForRowPanelWidth, headListForColumnPanelHeight + tableHeight);
		brp.setPosition(pointerColumn);
		
		hpcBackground = setJLabelWithIcon(File.file + File.table_cell2_light + File.PNG, tableWidth, headListForColumnPanelHeight);
		hpC.setBackground(hpcBackground);
		
		grid_deep = new ImageIcon(File.file + File.table_cell2_deep + File.PNG);
		grid_deep.setImage(grid_deep.getImage().getScaledInstance(tableWidth / pageColumn, tableHeight / pageRow,Image.SCALE_DEFAULT));
		
		grid_light = new ImageIcon(File.file + File.table_cell2_light + File.PNG);
		grid_light.setImage(grid_light.getImage().getScaledInstance(tableWidth / pageColumn, tableHeight / pageRow,Image.SCALE_DEFAULT));
		
		head_deep = new ImageIcon(File.file + File.table_cell2_deep + File.PNG);
		head_deep.setImage(head_deep.getImage().getScaledInstance(headListForRowPanelWidth, tableHeight / pageRow,Image.SCALE_DEFAULT));
		
		head_light = new ImageIcon(File.file + File.table_cell2_light + File.PNG);
		head_light.setImage(head_light.getImage().getScaledInstance(headListForRowPanelWidth, tableHeight / pageRow,Image.SCALE_DEFAULT));
		
//		sortUP = new ImageIcon(File.file + File.sort_up + File.PNG);
//		sortUP.setImage(sortUP.getImage().getScaledInstance(tableWidth / pageColumn, headListForColumnPanelHeight, Image.SCALE_DEFAULT));
//		
//		sortDOWN = new ImageIcon(File.file + File.sort_down + File.PNG);
//		sortDOWN.setImage(sortDOWN.getImage().getScaledInstance(tableWidth / pageColumn, headListForColumnPanelHeight, Image.SCALE_DEFAULT));
//		
//		sortOUT = new ImageIcon(File.file + File.sort_out + File.PNG);
//		sortOUT.setImage(sortOUT.getImage().getScaledInstance(tableWidth / pageColumn, headListForColumnPanelHeight, Image.SCALE_DEFAULT));
		
		
		for(int i = 0; i < row;){
			hpR.setIconInRow(head_light, i++);
			if(i >= row) break;
			hpR.setIconInRow(head_deep, i++);
		}
		
		setTablePanelRowIcon();
		
		p.setFontColor(fontColor);
		hpC.setFontColor(fontColor);
		hpR.setFontColor(fontColor);
		
		this.setLayout(null);
		this.add(playerName[0]);
		this.add(playerName[1]);
		this.add(p);
		this.add(bcp);
		this.add(brp);
		this.add(hpC);
		this.add(hpR);
		this.setSize(width, height);
		this.setLocation(SizeAndLocationAndFont.oneTeamStatisticsTablePanelLocationX, SizeAndLocationAndFont.oneTeamStatisticsTablePanelLocationY);
		this.setOpaque(false);
		
		p.addMouseWheelListener(new MouseWheelListener(){
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				int r = arg0.getWheelRotation();
				if(r > 0){
					p.changeRow(1);
				}
				else if(r < 0){
					p.changeRow(-1);
				}
				hpR.moveToIndex(p.pointerRow);
				bcp.setPosition(p.pointerRow);
				setTablePanelRowIcon();
			}
						
		});
		
		bcp.addMouseWheelListener(new MouseWheelListener(){

			public void mouseWheelMoved(MouseWheelEvent arg0) {
				int r = arg0.getWheelRotation();
				if(r > 0){
					p.changeRow(1);
				}
				else if(r < 0){
					p.changeRow(-1);
				}
				hpR.moveToIndex(p.pointerRow);
				bcp.setPosition(p.pointerRow);
				setTablePanelRowIcon();
			}
			
		});
		
		brp.addMouseWheelListener(new MouseWheelListener(){
			
			public void mouseWheelMoved(MouseWheelEvent e) {
				int r = e.getWheelRotation();
				if(r > 0){
					p.changeColumn(1);
				}
				else if(r < 0){
					p.changeColumn(-1);
				}
				hpC.moveToIndex(p.pointerColumn);
				brp.setPosition(p.pointerColumn);
			}
			
		});
		
		bcp.addDragBarListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				bcp.dragBarMethod(e);
				int t = (int) (row * bcp.position);
				p.changeRow(t-p.pointerRow);
				hpR.moveToIndex(p.pointerRow);
				setTablePanelRowIcon();
			}
		});
		
		brp.addDragBarListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				brp.dragBarMethod(e);
				int t = (int) (column * brp.position);
				p.changeColumn(t-p.pointerColumn);
				hpC.moveToIndex(p.pointerColumn);
			}
		});
	}
	
	private JLabel setJLabelWithIcon(String IconPath, int width, int height){
		ImageIcon icon = new ImageIcon(IconPath);
		icon.setImage(icon.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
		JLabel label = new JLabel(icon);
		label.setSize(width, height);
		label.setOpaque(false);
		return label;
	}
	
	private void setTablePanelRowIcon(){
		if(p.pointerRow % 2 == 0){
			for(int i = 0; i < pageRow;){
				p.setRowBackground(grid_light, i++);
				p.setRowBackground(grid_deep, i++);
			}
		}
		else{
			for(int i = 0; i < pageRow;){
				p.setRowBackground(grid_deep, i++);
				p.setRowBackground(grid_light, i++);
			}
		}
		
	}
	
	protected void resetTableInfoAndSize(String[][] content, String[] time){
		remove(p);
		remove(hpR);
		remove(bcp);
		
		int formerColumn = p.pointerColumn;
		
		contentInTable = content;
		row = content.length;
		p = new TablePanel(row, column, pageRow, pageColumn, tableWidth, tableHeight);
		p.setContent(contentInTable);
		p.setLocation(leftSide + headListForRowPanelWidth, headListForColumnPanelHeight);
		setTablePanelRowIcon();
		
		headListForRow = time;
		hpR = new HeadListForRowPanel(headListForRow, pageRow, headListForRowPanelWidth, tableHeight);
		hpR.setLocation(leftSide, headListForColumnPanelHeight);
		
		for(int i = 0; i < row;){
			hpR.setIconInRow(head_light, i++);
			if(i >= row) break;
			hpR.setIconInRow(head_deep, i++);
		}
		
		bcp = new BarInColumnPanel(row, pageRow, barWidth, tableHeight);
		bcp.setLocation(leftSide + headListForRowPanelWidth + tableWidth, headListForColumnPanelHeight);
		bcp.setPosition(pointerRow);
		
		p.addMouseWheelListener(new MouseWheelListener(){
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				int r = arg0.getWheelRotation();
				if(r > 0){
					p.changeRow(1);
				}
				else if(r < 0){
					p.changeRow(-1);
				}
				hpR.moveToIndex(p.pointerRow);
				bcp.setPosition(p.pointerRow);
				setTablePanelRowIcon();
			}
						
		});
		
		bcp.addMouseWheelListener(new MouseWheelListener(){

			public void mouseWheelMoved(MouseWheelEvent arg0) {
				int r = arg0.getWheelRotation();
				if(r > 0){
					p.changeRow(1);
				}
				else if(r < 0){
					p.changeRow(-1);
				}
				hpR.moveToIndex(p.pointerRow);
				bcp.setPosition(p.pointerRow);
				setTablePanelRowIcon();
			}
			
		});
		
		bcp.addDragBarListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				bcp.dragBarMethod(e);
				int t = (int) (row * bcp.position);
				p.changeRow(t-p.pointerRow);
				hpR.moveToIndex(p.pointerRow);
			}
		});
		
		p.setFontColor(fontColor);
		hpR.setFontColor(fontColor);
		
		p.changeColumn(formerColumn);
		
		add(p, 0);
		add(hpR, 0);
		add(bcp, 0);
		p.updateUI();
		hpR.updateUI();
		bcp.updateUI();
	}
	
}
