package view.hotPlayerPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.SizeAndLocationAndFont;
import view.selectedPanel.SelectPanel;
import control.ShowPlayerController;

public class TotalPanel extends JPanel{
	
	final static String[] item1 = {"得分", "篮板", "助攻", "盖帽", "抢断"};
	final static String[] item2 = {"场均得分", "场均篮板", "场均助攻", "场均盖帽", "场均抢断", "投篮命中率", "三分命中率", "罚球命中率"};
	final static String[] item3 = {"场均得分", "场均篮板", "场均助攻"};
	static int formerIndex = 0;
	static int formerType = -1;
	SelectPanel choiceHotPlayer;
	
	OneHotPlayerPanel[] hotPlayerPanel;
	
	int choiceWidth = SizeAndLocationAndFont.hotPlayerSelectPanelWidth,
			choiceHeight = SizeAndLocationAndFont.hotPlayerSelectPanelHeight;
	
	int num;
	
	public TotalPanel(String[] picHotPlayerTodayPath, String[][][] hotPlayerTodayContents, String[] playerNames, int type){
		num = hotPlayerTodayContents.length;
		
		if(type == 0){
			choiceHotPlayer = new SelectPanel(choiceWidth, choiceHeight, item1);
		}
		else if(type == 1){
			choiceHotPlayer = new SelectPanel(choiceWidth, choiceHeight, item2);
		}
		else if(type == 2){
			choiceHotPlayer = new SelectPanel(choiceWidth, choiceHeight, item3);
		}
		choiceHotPlayer.setLocation(SizeAndLocationAndFont.hotPlayerSelectPanelLocationX, SizeAndLocationAndFont.hotPlayerSelectPanelLocationY);
		if(formerType == type) choiceHotPlayer.setSelectedIndex(formerIndex);//与之前显示类型相同，设置为之前选择的项目
		else {
			formerIndex = 0;
			formerType = type;
		}
		choiceHotPlayer.box.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				choiceHotPlayer.action();
				int t = choiceHotPlayer.getSelectedIndex();
				if(t == formerIndex) return;
				//TODO 改变选项
				formerIndex = t;
				if(formerType == 0) new ShowPlayerController().showHotPlayerInfo(false, 5, t);
				else if(formerType == 1) new ShowPlayerController().showHotPlayerInfo(true, 5, t);
				else if(formerType == 2) new ShowPlayerController().showProgressPlayerInfo(t, 5);
			}
		});
		
		this.add(choiceHotPlayer);
		
		hotPlayerPanel = new OneHotPlayerPanel[num];
		for(int i = 0; i < num; i++){
			hotPlayerPanel[i] = new OneHotPlayerPanel(picHotPlayerTodayPath[i], hotPlayerTodayContents[i], playerNames[i]);
			hotPlayerPanel[i].setLocation(0, i*(SizeAndLocationAndFont.hotPlayerPhotoHeight+5) + SizeAndLocationAndFont.hotPlayerSelectPanelLocationY + choiceHeight + 5);
			this.add(hotPlayerPanel[i]);
		}
		
		this.setSize(SizeAndLocationAndFont.hotPlayerPhotoWidth + SizeAndLocationAndFont.hotPlayerInfoPanelWidth,
				num*(SizeAndLocationAndFont.hotPlayerPhotoHeight+5) + SizeAndLocationAndFont.hotPlayerSelectPanelLocationY + choiceHeight);
		this.setLayout(null);
		this.setOpaque(false);
	}
	
}
