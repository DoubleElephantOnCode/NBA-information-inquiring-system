package model.dataLogic;

import java.io.File;
import java.util.Date;

import model.readData.ReadMatchData;
import view.mainFrame.Main;
import vo.TeamVO;

public class SingleTeamModel implements ShowView{
	public String teamName;
	public Date begin;
	public Date end;
	
	public void showTeam(String teamName, Date begin,Date end){
		
		this.teamName = teamName;
		this.begin = begin;
		this.end = end;
		
		ReadMatchData.readMatch.setCurrentView(this);
		
		TeamVO teamVO = TeamList.findTeamVO(teamName);
		File svgFile = new File(teamVO.getPath());
		String[] infoName = TeamList.getTeamInfoName();
		String[] info = teamVO.toStringArrayForSingleTeam();
		
		String[] headListForColumn = MatchList.getHeadListForColumn();
		String[][] content = teamVO.getMatchInfo(begin,end);
		String[][] realContent = new String[content.length][3];//去掉第一项时间
		for(int i = 0 ;i<content.length;i++){
			for(int j = 0;j<3;j++){
				realContent[i][j] = content[i][j+1];
			}
		}
		
		double[] ability = teamVO.getAbilityArray();
		
		String[] headListForRow = new String[content.length];
		for(int i = 0;i<content.length;i++){
			headListForRow[i] = content[i][0];
		}
		Main.setSingleTeamPanel(svgFile, infoName, info, realContent, headListForRow, headListForColumn,teamName,ability);
	}

	@Override
	public void changeData() {
		// TODO Auto-generated method stub
		TeamVO teamVO = TeamList.findTeamVO(teamName);
		File svgFile = new File(teamVO.getPath());
		String[] infoName = TeamList.getTeamInfoName();
		String[] info = teamVO.toStringArrayForSingleTeam();
		
		String[] headListForColumn = MatchList.getHeadListForColumn();
		String[][] content = teamVO.getMatchInfo(begin,end);
		String[][] realContent = new String[content.length][3];//去掉第一项时间
		for(int i = 0 ;i<content.length;i++){
			for(int j = 0;j<3;j++){
				realContent[i][j] = content[i][j+1];
			}
		}
		
		double[] ability = teamVO.getAbilityArray();
		
		String[] headListForRow = new String[content.length];
		for(int i = 0;i<content.length;i++){
			headListForRow[i] = content[i][0];
		}
		Main.setSingleTeamPanel(svgFile, infoName, info, realContent, headListForRow, headListForColumn,teamName,ability);
	}
}
