package view.teamCompare;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

import view.SizeAndLocationAndFont;

public class TeamCompareCamera extends JPanel{
	public static TeamComparePanel pcp = new TeamComparePanel();
	int locationY = 0;
	public TeamCompareCamera(){
		pcp = new TeamComparePanel();
		pcp.setLocation(0, locationY);
		this.addMouseWheelListener(new MouseWheelListener(){

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int r = e.getWheelRotation();
				if(r > 0){
					locationY -= 30;
					if(locationY < getHeight()-pcp.getHeight()){
						locationY = getHeight()-pcp.getHeight();
					}
					pcp.setLocation(0, locationY);
				}
				else if(r < 0){
					locationY += 30;
					if(locationY > 0){
						locationY = 0;
					}
					pcp.setLocation(0, locationY);
				}
			}
			
		});
		this.add(pcp);
		this.setLayout(null);
		this.setOpaque(false);
		this.setSize(SizeAndLocationAndFont.playerCompareCameraWidth, SizeAndLocationAndFont.playerCompareCameraHeight);
		this.setLocation(SizeAndLocationAndFont.playerCompareCameraLocationX, SizeAndLocationAndFont.playerCompareCameraLocationY);
	}
}
