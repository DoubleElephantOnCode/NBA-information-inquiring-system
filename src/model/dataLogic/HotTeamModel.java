package model.dataLogic;

import java.io.File;
import java.util.Date;

import view.singleTeamPanel.TestFrame;
import vo.TeamVO;

public class HotTeamModel {
	public void showTeam(String teamName, Date begin,Date end){
		TeamVO teamVO = TeamList.findTeamVO(teamName);
		File svgFile = new File(teamVO.getPath());
		String[] infoName = TeamList.getTeamInfoName();
		String[] info = teamVO.toStringArrayForHotTeam();
		
		String[] headListForColumn = MatchList.getHeadListForColumn();
		String[][] content = teamVO.getMatchInfo(begin,end);
		String[] headListForRow = new String[content.length];
		for(int i = 0;i<content.length;i++){
			headListForRow[i] = content[i][0];
		}
		TestFrame.teamInfoPanel(svgFile, infoName, info, content, headListForRow, headListForColumn);
	}
}
