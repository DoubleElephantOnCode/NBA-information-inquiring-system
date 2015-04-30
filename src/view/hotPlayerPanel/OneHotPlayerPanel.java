package view.hotPlayerPanel;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;
import view.SizeAndLocationAndFont;
import view.TimeSetting;
import view.singlePlayerPanel.SinglePlayerPanel;
import view.tablePanel.TablePanel;
import control.ShowPlayerController;

public class OneHotPlayerPanel extends JPanel{
	String name;
	
	static ImageIcon table_cell_light, table_cell_dark;
	
	JLabel photo_fg, photo_bg;
	
	ImageIcon photoFG, photoBG;
	
	TablePanel infoPanel;
	
	int photoWidth = SizeAndLocationAndFont.hotPlayerPhotoWidth,
			photoHeight = SizeAndLocationAndFont.hotPlayerPhotoHeight;
	
	int tableWidth = SizeAndLocationAndFont.hotPlayerInfoPanelWidth,
			tableHeight = SizeAndLocationAndFont.hotPlayerInfoPanelHeight;
	
	int row, column;
	
	public OneHotPlayerPanel(String playerPicPath, String[][] content, String playerName){
		name = playerName;
		
		row = content.length;
		column = content[0].length;
		
		photoFG = new ImageIcon(playerPicPath);
		photoFG.setImage(photoFG.getImage().getScaledInstance(photoWidth, photoHeight, Image.SCALE_DEFAULT));
		
		photoBG = new ImageIcon(File.file + File.table_cell2_light + File.PNG);
		photoBG.setImage(photoBG.getImage().getScaledInstance(photoWidth, photoHeight, Image.SCALE_DEFAULT));
		
		photo_fg = new JLabel();
		photo_fg.setSize(photoWidth, photoHeight);
		photo_fg.setOpaque(false);
		photo_fg.setIcon(photoFG);
		
		photo_bg = new JLabel();
		photo_bg.setSize(photoWidth, photoHeight);
		photo_bg.setOpaque(false);
		photo_bg.setIcon(photoBG);
		
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
		
		photo_fg.setLocation(0, 0);
		photo_bg.setLocation(0, 0);
		infoPanel.setLocation(photoWidth, 0);
		
		photo_fg.addMouseListener(new MouseListener() {
			
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
				SinglePlayerPanel.initialTime();
				new ShowPlayerController(true).showSinglePlayerInfo(name, TimeSetting.startDate, TimeSetting.endDate);
			}
		});
		
		this.add(photo_bg);
		this.add(photo_fg, 0);
		this.add(infoPanel);
		
		this.setLayout(null);
		this.setSize(photoWidth+tableWidth, photoHeight);
		this.setOpaque(false);
	}
	
}
