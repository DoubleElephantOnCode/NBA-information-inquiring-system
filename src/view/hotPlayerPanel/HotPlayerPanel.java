package view.hotPlayerPanel;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

import view.SizeAndLocationAndFont;

public class HotPlayerPanel extends JPanel{
	
	TotalPanel total;
	
	int pointerH;
	
	public HotPlayerPanel(String[] picPath, String[][][] playerContents){
		
		total = new TotalPanel(picPath, playerContents);
		total.setLocation(0, 0);
		
		pointerH = 0;
		
		this.add(total);
		
		this.setLayout(null);
		this.setSize(SizeAndLocationAndFont.hotPlayerPanelWidth, SizeAndLocationAndFont.hotPlayerPanelHeight);
		this.setLocation(SizeAndLocationAndFont.hotPlayerPanelLocationX, SizeAndLocationAndFont.hotPlayerPanelLocationY);
		this.setOpaque(false);
		this.addMouseWheelListener(new MouseWheelListener(){

			@Override
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				if(arg0.getWheelRotation() > 0){
					pointerH -= 30;
					if(pointerH < SizeAndLocationAndFont.hotPlayerPanelHeight-total.getHeight()){
						pointerH = SizeAndLocationAndFont.hotPlayerPanelHeight-total.getHeight();
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
	
}
