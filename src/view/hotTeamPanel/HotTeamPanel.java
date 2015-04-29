package view.hotTeamPanel;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

import view.SizeAndLocationAndFont;

public class HotTeamPanel extends JPanel{
	
	TotalPanel total;
	
	int pointerH;
	
	public HotTeamPanel(java.io.File[] teamPics, String[][][] teamContents, String[] teamNames){
		
		total = new TotalPanel(teamPics, teamContents, teamNames);
		total.setLocation(0, 0);
		
		pointerH = 0;
		
		this.add(total);
		
		this.setLayout(null);
		this.setSize(SizeAndLocationAndFont.hotTeamPanelWidth, SizeAndLocationAndFont.hotTeamPanelHeight);
		this.setLocation(SizeAndLocationAndFont.hotTeamPanelLocationX, SizeAndLocationAndFont.hotTeamPanelLocationY);
		this.setOpaque(false);
		this.addMouseWheelListener(new MouseWheelListener(){

			@Override
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				if(arg0.getWheelRotation() > 0){
					pointerH -= 30;
					if(pointerH < SizeAndLocationAndFont.hotTeamPanelHeight-total.getHeight()){
						pointerH = SizeAndLocationAndFont.hotTeamPanelHeight-total.getHeight();
					}
					total.setLocation(0, pointerH);
				}
				else if(arg0.getWheelRotation() < 0){
					pointerH += 30;
					if(pointerH > 0){
						pointerH = 0;
					}
					total.setLocation(0, pointerH);
				}
			}
			
		});
	}
	
	public int getFormerIndex(){
		return total.formerIndex;
	}
	
}
