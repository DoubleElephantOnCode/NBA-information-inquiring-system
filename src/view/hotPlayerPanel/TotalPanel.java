package view.hotPlayerPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.SizeAndLocationAndFont;
import view.selectedPanel.SelectPanel;

public class TotalPanel extends JPanel{
	
	static String[] item1 = {"得分", "篮板", "助攻", "盖帽", "抢断"};
	static String[] item2 = {"场均得分", "场均篮板", "场均助攻", "场均盖帽", "场均抢断", "三分命中率", "投篮命中率", "罚球命中率"};
	
	SelectPanel choiceHotPlayerToday, choiceHotPlayerThisYear;
	
	OneHotPlayerPanel[] hotPlayerTodayPanel;
	
	int choiceWidth = SizeAndLocationAndFont.hotPlayerSelectPanelWidth,
			choiceHeight = SizeAndLocationAndFont.hotPlayerSelectPanelHeight;
	
	int num;
	
	public TotalPanel(String[] picHotPlayerTodayPath, String[][][] hotPlayerTodayContents, int type){
		num = hotPlayerTodayContents.length;
		
		if(type == 1){
			choiceHotPlayerToday = new SelectPanel(choiceWidth, choiceHeight, item1);
		}
		else{
			choiceHotPlayerToday = new SelectPanel(choiceWidth, choiceHeight, item2);
		}
		choiceHotPlayerToday.setLocation(SizeAndLocationAndFont.hotPlayerSelectPanelLocationX, SizeAndLocationAndFont.hotPlayerSelectPanelLocationY);
		choiceHotPlayerToday.box.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				choiceHotPlayerToday.action();
			}
			
		});
		
		this.add(choiceHotPlayerToday);
		
		hotPlayerTodayPanel = new OneHotPlayerPanel[num];
		for(int i = 0; i < num; i++){
			hotPlayerTodayPanel[i] = new OneHotPlayerPanel(picHotPlayerTodayPath[i], hotPlayerTodayContents[i]);
			hotPlayerTodayPanel[i].setLocation(0, i*(SizeAndLocationAndFont.hotPlayerPhotoHeight+5) + SizeAndLocationAndFont.hotPlayerSelectPanelLocationY + choiceHeight + 5);
			this.add(hotPlayerTodayPanel[i]);
		}
		
		this.setSize(SizeAndLocationAndFont.hotPlayerPhotoWidth + SizeAndLocationAndFont.hotPlayerInfoPanelWidth,
				num*(SizeAndLocationAndFont.hotPlayerPhotoHeight+5) + SizeAndLocationAndFont.hotPlayerSelectPanelLocationY + choiceHeight);
		this.setLayout(null);
		this.setOpaque(false);
	}
	
}
