package view.singlePlayerPanel;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

import view.SizeAndLocationAndFont;

public class SinglePlayerCamera extends JPanel{
	public SinglePlayerPanel spp;
	int locationY = 0;
	public SinglePlayerCamera(String pathOfPhoto1, String pathOfPhoto2, String[][] info, String[][] content, String[] headListForRow, String[] headListForColumn, String playerName){
		spp = new SinglePlayerPanel(pathOfPhoto1, pathOfPhoto2, info, content, headListForRow, headListForColumn, playerName);
		spp.setLocation(0, locationY);
		this.addMouseWheelListener(new MouseWheelListener(){

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int r = e.getWheelRotation();
				if(r > 0){
					locationY -= 30;
					if(locationY < getHeight()-spp.getHeight()){
						locationY = getHeight()-spp.getHeight();
					}
					spp.setLocation(0, locationY);
				}
				else if(r < 0){
					locationY += 30;
					if(locationY > 0){
						locationY = 0;
					}
					spp.setLocation(0, locationY);
				}
			}
			
		});
		this.add(spp);
		this.setLayout(null);
		this.setOpaque(false);
		this.setSize(SizeAndLocationAndFont.singlePlayerCameraWidth, SizeAndLocationAndFont.singlePlayerCameraHeight);
		this.setLocation(SizeAndLocationAndFont.singlePlayerCameraLocationX, SizeAndLocationAndFont.singlePlayerCameraLocationY);
	}
	
}
