package control;

import java.util.Date;

import view.mainFrame.GoForwardOrBackward.HistoryList;
import model.dataLogic.ShowHotTeamModel;
import model.dataLogic.ShowTeamDataModel;
import model.dataLogic.SingleTeamModel;

public class ShowTeamController {
	ShowTeamDataModel showTeamModel;
	SingleTeamModel singleTeamModel;
	ShowHotTeamModel showHotTeamModel;
	
	
	public ShowTeamController(boolean inWay){
		showTeamModel = new ShowTeamDataModel();
		singleTeamModel = new SingleTeamModel();
		showHotTeamModel = new ShowHotTeamModel();
		HistoryList.inWay = inWay;
	}
	
	public void showTeamTable(){
		showTeamModel.showTeamTable();
	}
	
	public void sortTeam(int i,boolean isPositiveSequence){
		showTeamModel.sortTeamTable(i, isPositiveSequence);
	}
	
	public void showTeamFrame(String teamName, Date begin,Date end, String chartItem){
		singleTeamModel.showTeam(teamName,begin,end,chartItem);
	}
	
	public void showHotTeamTable(int i){
		showHotTeamModel.showTeamTable(i);
	}
	
	public void chooseSeasonAndIsPlayOff(String season,int isPlayoff){
		showTeamModel.chooseSeasonAndPlayoff(season, isPlayoff);
	}
}
