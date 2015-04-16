package view.hotTeamPanel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;
import view.SVGLabel;
import view.SizeAndLocationAndFont;
import view.tablePanel.TablePanel;

public class OneHotTeamPanel extends JPanel{
	
	static ImageIcon table_cell_light, table_cell_dark;
	
	JLabel pic;
	
	TablePanel infoPanel;
	
	int picWidth = SizeAndLocationAndFont.hotTeamPhotoWidth,
			picHeight = SizeAndLocationAndFont.hotTeamPhotoHeight;
	
	int tableWidth = SizeAndLocationAndFont.hotTeamInfoPanelWidth,
			tableHeight = SizeAndLocationAndFont.hotTeamInfoPanelHeight;
	
	int row, column;
	
	public OneHotTeamPanel(java.io.File teamPic, String[][] content){
		row = content.length;
		column = content[0].length;
		
		pic = new SVGLabel(teamPic, picWidth, picHeight);
		
		infoPanel = new TablePanel(row, column, row, column, tableWidth, tableHeight);
		infoPanel.setContent(content);
		
		table_cell_light = new ImageIcon(File.file + File.table_cell2_light + File.PNG);
		table_cell_light.setImage(table_cell_light.getImage().getScaledInstance(tableWidth/column, tableHeight/row, Image.SCALE_DEFAULT));
		table_cell_dark = new ImageIcon(File.file + File.table_cell2_deep + File.PNG);
		table_cell_dark.setImage(table_cell_dark.getImage().getScaledInstance(tableWidth/column, tableHeight/row, Image.SCALE_DEFAULT));
		
		for(int i = 0; i < row; i++){
			if(i%2 == 0){
				infoPanel.setRowBackground(table_cell_dark, i);
			}
			else{
				infoPanel.setRowBackground(table_cell_light, i);
			}
		}
		
		pic.setLocation(0, 0);
		infoPanel.setLocation(picWidth, 0);
		
		this.add(pic);
		this.add(infoPanel);
		
		this.setLayout(null);
		this.setSize(picWidth+tableWidth, picHeight);
		this.setOpaque(false);
	}
	
}
