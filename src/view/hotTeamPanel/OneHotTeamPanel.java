package view.hotTeamPanel;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;
import view.SVGLabel;
import view.SizeAndLocationAndFont;
import view.TimeSetting;
import view.singleTeamPanel.SingleTeamPanel;
import view.tablePanel.TablePanel;
import control.ShowTeamController;

public class OneHotTeamPanel extends JPanel{
	
	static ImageIcon table_cell_light, table_cell_dark;
	
	JLabel pic;
	JLabel listening;
	
	TablePanel infoPanel;
	
	String name;
	
	int picWidth = SizeAndLocationAndFont.hotTeamPhotoWidth,
			picHeight = SizeAndLocationAndFont.hotTeamPhotoHeight;
	
	int tableWidth = SizeAndLocationAndFont.hotTeamInfoPanelWidth,
			tableHeight = SizeAndLocationAndFont.hotTeamInfoPanelHeight;
	
	int row, column;
	
	public OneHotTeamPanel(java.io.File teamPic, String[][] content, String teamName){
		name = teamName;
		
		row = content.length;
		column = content[0].length;
		
		pic = new SVGLabel(teamPic, picWidth, picHeight);
		listening = new JLabel();
		listening.setSize(picWidth, picHeight);
		listening.setOpaque(false);
		
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
		listening.setLocation(0, 0);
		infoPanel.setLocation(picWidth, 0);
		
		listening.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SingleTeamPanel.initialTime();
				new ShowTeamController().showTeamFrame(name, TimeSetting.begin, TimeSetting.end);
			}
		});
		
		this.add(pic);
		this.add(listening, 0);
		this.add(infoPanel);
		
		this.setLayout(null);
		this.setSize(picWidth+tableWidth, picHeight);
		this.setOpaque(false);
	}
	
}
