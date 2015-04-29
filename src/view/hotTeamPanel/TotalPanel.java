package view.hotTeamPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.SizeAndLocationAndFont;
import view.selectedPanel.SelectPanel;
import control.ShowTeamController;

public class TotalPanel extends JPanel{
	
	static String[] item = {"场均得分", "场均篮板", "场均助攻", "场均盖帽", "场均抢断", "三分命中率", "投篮命中率", "罚球命中率"};
	static int formerIndex = 0;
	SelectPanel choiceHotTeam;
	
	OneHotTeamPanel[] hotTeamPanel;
	
	int choiceWidth = SizeAndLocationAndFont.hotTeamSelectPanelWidth,
			choiceHeight = SizeAndLocationAndFont.hotTeamSelectPanelHeight;
	
	int num;
	
	public TotalPanel(java.io.File[] teamPics, String[][][] hotTeamContents, String[] teamNames){
		num = hotTeamContents.length;
		
		choiceHotTeam = new SelectPanel(choiceWidth, choiceHeight, item);
		choiceHotTeam.setLocation(SizeAndLocationAndFont.hotTeamSelectPanelLocationX, SizeAndLocationAndFont.hotTeamSelectPanelLocationY);
		choiceHotTeam.box.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				choiceHotTeam.action();
				int t = choiceHotTeam.getSelectedIndex();
				if(t == formerIndex) return;
				formerIndex = t;
				new ShowTeamController().showHotTeamTable(t);
			}
			
		});
		choiceHotTeam.setSelectedIndex(formerIndex);
		
		this.add(choiceHotTeam);
		
		hotTeamPanel = new OneHotTeamPanel[num];
		for(int i = 0; i < num; i++){
			hotTeamPanel[i] = new OneHotTeamPanel(teamPics[i], hotTeamContents[i], teamNames[i]);
			hotTeamPanel[i].setLocation(0, i*(SizeAndLocationAndFont.hotTeamPhotoHeight+5) + SizeAndLocationAndFont.hotTeamSelectPanelLocationY + choiceHeight + 5);
			this.add(hotTeamPanel[i]);
		}
		
		this.setSize(SizeAndLocationAndFont.hotTeamPhotoWidth + SizeAndLocationAndFont.hotTeamInfoPanelWidth,
				num*(SizeAndLocationAndFont.hotTeamPhotoHeight+5) + SizeAndLocationAndFont.hotTeamSelectPanelLocationY + choiceHeight);
		this.setLayout(null);
		this.setOpaque(false);
	}
	
}
