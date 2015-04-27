package control;

import java.util.Date;

import model.dataLogic.SingleTeamModel;
import model.dataLogic.ShowTeamDataModel;

public class ShowTeamController {
	ShowTeamDataModel showTeamModel;
	SingleTeamModel singleTeamModel;
	public ShowTeamController(){
		showTeamModel = new ShowTeamDataModel();
		singleTeamModel = new SingleTeamModel();
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
		
	}
}
