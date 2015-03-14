package model.dataLogic;

import java.util.ArrayList;

import view.mainFrame.Main;
import vo.TeamVO;

public class ShowTeamDataModel {
	public void showTeamTable(){
		ArrayList<TeamVO> teamVOList = TeamList.getTeamVOList();
		TeamVO t = teamVOList.get(0);
		String[][] content = new String[teamVOList.size()][t.toString().length()];
		for(int i = 0;i<teamVOList.size();i++){
			t=teamVOList.get(i);
			String[] s = t.toStringArray();
			for(int j=0;j<s.length;j++){
				content[i][j] = s[j];
			}
		}
		
		String[] column = TeamList.getHeadListForColumn();
		String[] row = TeamList.getHeadListForRow();
		Main.newTeamCountPanel(content,row,column);
		
	}
}
