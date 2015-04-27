package view.hotPlayerPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.SizeAndLocationAndFont;
import view.selectedPanel.SelectPanel;

public class TotalPanel extends JPanel{
	
	final static String[] item1 = {"得分", "篮板", "助攻", "盖帽", "抢断"};
	final static String[] item2 = {"场均得分", "场均篮板", "场均助攻", "场均盖帽", "场均抢断", "三分命中率", "投篮命中率", "罚球命中率"};
	final static String[] item3 = {"场均得分", "场均篮板", "场均助攻"};
	
	SelectPanel choiceHotPlayer;
	
	OneHotPlayerPanel[] hotPlayerPanel;
	
	int choiceWidth = SizeAndLocationAndFont.hotPlayerSelectPanelWidth,
			choiceHeight = SizeAndLocationAndFont.hotPlayerSelectPanelHeight;
	
	int num;
	
	public TotalPanel(String[] picHotPlayerTodayPath, String[][][] hotPlayerTodayContents, int type){
		num = hotPlayerTodayContents.length;
		
		if(type == 0){
			choiceHotPlayer = new SelectPanel(choiceWidth, choiceHeight, item1);
		}
		else if(type == 1){
			choiceHotPlayer = new SelectPanel(choiceWidth, choiceHeight, item2);
		}
		else{
			choiceHotPlayer = new SelectPanel(choiceWidth, choiceHeight, item3);
		}
		choiceHotPlayer.setLocation(SizeAndLocationAndFont.hotPlayerSelectPanelLocationX, SizeAndLocationAndFont.hotPlayerSelectPanelLocationY);
		choiceHotPlayer.box.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				choiceHotPlayer.action();
			}
			
		});
		
		this.add(choiceHotPlayer);
		
		hotPlayerPanel = new OneHotPlayerPanel[num];
		for(int i = 0; i < num; i++){
			hotPlayerPanel[i] = new OneHotPlayerPanel(picHotPlayerTodayPath[i], hotPlayerTodayContents[i]);
			hotPlayerPanel[i].setLocation(0, i*(SizeAndLocationAndFont.hotPlayerPhotoHeight+5) + SizeAndLocationAndFont.hotPlayerSelectPanelLocationY + choiceHeight + 5);
			this.add(hotPlayerPanel[i]);
		}
		
		this.setSize(SizeAndLocationAndFont.hotPlayerPhotoWidth + SizeAndLocationAndFont.hotPlayerInfoPanelWidth,
				num*(SizeAndLocationAndFont.hotPlayerPhotoHeight+5) + SizeAndLocationAndFont.hotPlayerSelectPanelLocationY + choiceHeight);
		this.setLayout(null);
		this.setOpaque(false);
	}
	
}
