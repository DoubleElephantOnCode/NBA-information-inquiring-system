package view.singleTeamPanel;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

import org.jfree.data.time.TimeSeries;

import view.SizeAndLocationAndFont;

public class SingleTeamCamera extends JPanel{

	public SingleTeamPanel stp;
	int locationY = 0;
	public SingleTeamCamera(java.io.File svgFile, String[] infoName, String[] info, String[][] content, String[] headListForRow, String[] headListForColumn, String teamName, double[] ability, TimeSeries series){
		stp = new SingleTeamPanel(svgFile, infoName, info, content, headListForRow, headListForColumn, teamName, ability, series);
		stp.setLocation(0, 0);
		this.addMouseWheelListener(new MouseWheelListener(){

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int r = e.getWheelRotation();
				if(r > 0){
					locationY -= 30;
					if(locationY < getHeight()-stp.getHeight()){
						locationY = getHeight()-stp.getHeight();
					}
					stp.setLocation(0, locationY);
				}
				else if(r < 0){
					locationY += 30;
					if(locationY > 0){
						locationY = 0;
					}
					stp.setLocation(0, locationY);
				}
			}
			
		});
		this.add(stp);
		this.setLayout(null);
		this.setOpaque(false);
		this.setSize(SizeAndLocationAndFont.singleTeamCameraWidth, SizeAndLocationAndFont.singleTeamCameraHeight);
		this.setLocation(SizeAndLocationAndFont.singleTeamCameraLocationX, SizeAndLocationAndFont.singleTeamCameraLocationY);
	}
	
}
