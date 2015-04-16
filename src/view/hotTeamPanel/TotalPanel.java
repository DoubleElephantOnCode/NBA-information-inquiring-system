package view.hotTeamPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.SizeAndLocationAndFont;
import view.selectedPanel.SelectPanel;

public class TotalPanel extends JPanel{
	
	static String[] item = {"场均得分", "场均篮板", "场均助攻", "场均盖帽", "场均抢断", "三分命中率", "投篮命中率", "罚球命中率"};
	
	SelectPanel choiceHotPlayerToday, choiceHotPlayerThisYear;
	
	OneHotTeamPanel[] hotPlayerTodayPanel;
	
	int choiceWidth = SizeAndLocationAndFont.hotTeamSelectPanelWidth,
			choiceHeight = SizeAndLocationAndFont.hotTeamSelectPanelHeight;
	
	int num;
	
	public TotalPanel(java.io.File[] teamPics, String[][][] hotPlayerTodayContents){
		num = hotPlayerTodayContents.length;
		
		choiceHotPlayerToday = new SelectPanel(choiceWidth, choiceHeight, item);
		choiceHotPlayerToday.setLocation(SizeAndLocationAndFont.hotTeamSelectPanelLocationX, SizeAndLocationAndFont.hotTeamSelectPanelLocationY);
		choiceHotPlayerToday.box.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				choiceHotPlayerToday.action();
			}
			
		});
		
		this.add(choiceHotPlayerToday);
		
		hotPlayerTodayPanel = new OneHotTeamPanel[num];
		for(int i = 0; i < num; i++){
			hotPlayerTodayPanel[i] = new OneHotTeamPanel(teamPics[i], hotPlayerTodayContents[i]);
			hotPlayerTodayPanel[i].setLocation(0, i*(SizeAndLocationAndFont.hotTeamPhotoHeight+5) + SizeAndLocationAndFont.hotTeamSelectPanelLocationY + choiceHeight + 5);
			this.add(hotPlayerTodayPanel[i]);
		}
		
		this.setSize(SizeAndLocationAndFont.hotTeamPhotoWidth + SizeAndLocationAndFont.hotTeamInfoPanelWidth,
				num*(SizeAndLocationAndFont.hotTeamPhotoHeight+5) + SizeAndLocationAndFont.hotTeamSelectPanelLocationY + choiceHeight);
		this.setLayout(null);
		this.setOpaque(false);
	}
	
}
