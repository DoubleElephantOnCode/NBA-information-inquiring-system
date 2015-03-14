package view.teamCount;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;
import view.tablePanel.BarInColumnPanel;
import view.tablePanel.BarInRowPanel;
import view.tablePanel.HeadListForColumnPanel;
import view.tablePanel.HeadListForRowPanel;
import view.tablePanel.TablePanel;

public class TeamCountTablePanel extends JPanel{
	
	int width = 1000, height = 410;
	
	int pointerRow = 0, pointerColumn = 0;
	
	int selectedColumn;
	
	String[] headListForColumn;
	String[] headListForRow;
	String[][] contentInTable;
	
	
	int tableWidth = 700, tableHeight = 300;
	int row = 30, column = 50;
	int pageRow = 10, pageColumn = 5;
	
	int headListForRowPanelWidth = 160;
			
	int headListForColumnPanelHeight = 45;
	
	int barWidth = 10;
	
	int leftSide = 80, rightSide = 20, downSide = 20;
	
	TablePanel p;
	HeadListForColumnPanel hpC;
	HeadListForRowPanel hpR;
	BarInColumnPanel bcp;
	BarInRowPanel brp;
	
	JLabel hpcBackground;
	JLabel background;
	
	ImageIcon grid_deep, grid_light;
	
	ImageIcon head_deep, head_light;
	
	ImageIcon selected;//TODO 要调整图片，上下指向各一张
	
	Color fontColor = new Color(170, 170, 170);
	
	public TeamCountTablePanel(String[][] content, String[] headListForRow, String[] headListForColumn){

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
		
		bcp = new BarInColumnPanel(row, pageRow, barWidth, tableHeight);
		bcp.setLocation(leftSide + headListForRowPanelWidth + tableWidth, headListForColumnPanelHeight);
		bcp.setPosition(pointerRow);
		
		brp = new BarInRowPanel(column, pageColumn, tableWidth, barWidth);
		brp.setLocation(leftSide + headListForRowPanelWidth, headListForColumnPanelHeight + tableHeight);
		brp.setPosition(pointerColumn);
		
		hpcBackground = setJLabelWithIcon(File.file + File.backgroundForHeadListForColumn + File.PNG, tableWidth, headListForColumnPanelHeight);
		hpC.setBackground(hpcBackground);
		
		grid_deep = new ImageIcon(File.file + File.grid_deep + File.PNG);
		grid_deep.setImage(grid_deep.getImage().getScaledInstance(tableWidth / pageColumn, tableHeight / pageRow,Image.SCALE_DEFAULT));
		
		grid_light = new ImageIcon(File.file + File.grid_light + File.PNG);
		grid_light.setImage(grid_light.getImage().getScaledInstance(tableWidth / pageColumn, tableHeight / pageRow,Image.SCALE_DEFAULT));
		
		head_deep = new ImageIcon(File.file + File.grid_deep + File.PNG);
		head_deep.setImage(head_deep.getImage().getScaledInstance(headListForRowPanelWidth, tableHeight / pageRow,Image.SCALE_DEFAULT));
		
		head_light = new ImageIcon(File.file + File.grid_light + File.PNG);
		head_light.setImage(head_light.getImage().getScaledInstance(headListForRowPanelWidth, tableHeight / pageRow,Image.SCALE_DEFAULT));
		
		selected = new ImageIcon(File.file + File.selectedColumnHeadList + File.PNG);
		selected.setImage(selected.getImage().getScaledInstance(tableWidth / pageColumn, headListForColumnPanelHeight, Image.SCALE_DEFAULT));
		
		for(int i = 0; i < row;){
			hpR.setIconInRow(head_light, i++);
			hpR.setIconInRow(head_deep, i++);
		}
		
		setTablePanelRowIcon();
		
		p.setFontColor(fontColor);
		hpC.setFontColor(fontColor);
		hpR.setFontColor(fontColor);
		
		this.setLayout(null);
		this.add(p);
		this.add(bcp);
		this.add(brp);
		this.add(hpC);
		this.add(hpR);
		this.setSize(width, height);
		this.setLocation(0, 140);
		this.setOpaque(false);
		//给列表头添加Listener，点击按此列数据进行排序
		for(int i = 0; i < hpC.list.field.length; i++){
			hpC.list.field[i][0].addMouseListener(new HeadListLabelListener(hpC.list.field, i));
		}
		
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
	
	class HeadListLabelListener implements MouseListener{

		JLabel[][] labelList;
		int index;
		
		public HeadListLabelListener(JLabel[][] labelList, int index){
			this.labelList = labelList;
			this.index = index;
		}
		
		public void mouseClicked(MouseEvent arg0) {
			for(int i = 0; i < labelList.length; i++){
				if(i != index && labelList[i][1].getIcon() != null){
					labelList[i][1].setIcon(null);
				}
			}
			labelList[index][1].setIcon(selected);
			//TODO 点击后调整排序方式，以此列排序，需要reset整个表格的行数据，发送给control，由model执行
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
}
