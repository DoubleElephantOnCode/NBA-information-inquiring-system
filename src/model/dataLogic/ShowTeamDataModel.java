package model.dataLogic;

import java.util.ArrayList;

import view.mainFrame.Main;
import view.mainFrame.Waiting;
import vo.TeamVO;

public class ShowTeamDataModel {
	
	public void showTeamTable(){
		
	
		Waiting w = new Waiting();
		ArrayList<TeamVO> teamVOList = TeamList.getTeamVOList();
		TeamVO t = teamVOList.get(0);
		String[][] content = new String[teamVOList.size()][TeamList.getHeadListForColumn().length];
		for(int i = 0;i<teamVOList.size();i++){
			t=teamVOList.get(i);
			String[] s = t.toStringArray();
			for(int j=0;j<s.length;j++){
				content[i][j] = s[j];
			}
		}
		
		String[] column = TeamList.getHeadListForColumn();
		String[] row = TeamList.getHeadListForRow();
		
		w.cancel();
		Main.newTeamCountPanel(content,row,column);
		
	}
	
	public void sortTeamTable(int i,boolean isPositiveSequence){
		Waiting w = new Waiting();
		
		TeamList.sortTeam(i, isPositiveSequence);
		ArrayList<TeamVO> teamVOList = TeamList.getTeamVOList();
		TeamVO t = teamVOList.get(0);
		String[][] content = new String[teamVOList.size()][TeamList.getHeadListForColumn().length];
		for(int h = 0;h<teamVOList.size();h++){
			t=teamVOList.get(h);
			String[] s = t.toStringArray();
			for(int j=0;j<s.length;j++){
				content[h][j] = s[j];
			}
		}
		String[] row = TeamList.getHeadListForRow();
		
		w.cancel();
		Main.resetTeamCountPanel(content, row);
	}
}
