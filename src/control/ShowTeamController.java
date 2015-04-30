package control;

import java.util.Date;

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
	}
	
	public void showTeamTable(){
		showTeamModel.showTeamTable();
	}
	
	public void sortTeam(int i,boolean isPositiveSequence){
		showTeamModel.sortTeamTable(i, isPositiveSequence);
	}
	
	public void showTeamFrame(String teamName, Date begin,Date end){
		singleTeamModel.showTeam(teamName,begin,end);
	}
	
	public void showHotTeamTable(int i){
		showHotTeamModel.showTeamTable(i);
	}
}
