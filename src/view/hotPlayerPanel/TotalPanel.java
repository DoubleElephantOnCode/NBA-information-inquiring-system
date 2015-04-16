package view.hotPlayerPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.SizeAndLocationAndFont;
import view.selectedPanel.SelectPanel;

public class TotalPanel extends JPanel{
	
	static String[] item = {"得分", "篮板", "助攻", "盖帽", "抢断"};
	
	SelectPanel choice;
	
	OneHotPlayerPanel[] playerPanel;
	
	int choiceWidth = SizeAndLocationAndFont.hotPlayerSelectPanelWidth,
			choiceHeight = SizeAndLocationAndFont.hotPlayerSelectPanelHeight;
	
	int num;
	
	public TotalPanel(String[] picPath, String[][][] playerContents){
		num = playerContents.length;
		
		choice = new SelectPanel(choiceWidth, choiceHeight, item);
		choice.setLocation(SizeAndLocationAndFont.hotPlayerSelectPanelLocationX, SizeAndLocationAndFont.hotPlayerSelectPanelLocationY);
		choice.box.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				choice.action();
			}
			
		});
		
		this.add(choice);
		
		playerPanel = new OneHotPlayerPanel[num];
		for(int i = 0; i < num; i++){
			playerPanel[i] = new OneHotPlayerPanel(picPath[i], playerContents[i]);
			playerPanel[i].setLocation(0, i*(SizeAndLocationAndFont.hotPlayerPhotoHeight+5) + SizeAndLocationAndFont.hotPlayerSelectPanelLocationY + choiceHeight + 5);
			this.add(playerPanel[i]);
		}
		
		this.setSize(SizeAndLocationAndFont.hotPlayerPhotoWidth + SizeAndLocationAndFont.hotPlayerInfoPanelWidth,
				num*(SizeAndLocationAndFont.hotPlayerPhotoHeight+5) + SizeAndLocationAndFont.hotPlayerSelectPanelLocationY + choiceHeight);
		this.setLayout(null);
		this.setOpaque(false);
	}
	
}
