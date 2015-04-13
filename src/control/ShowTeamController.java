package control;

import java.util.Date;

import model.dataLogic.HotTeamModel;
import model.dataLogic.ShowTeamDataModel;

public class ShowTeamController {
	ShowTeamDataModel showTeamModel;
	HotTeamModel hotTeamModel;
	public ShowTeamController(){
		showTeamModel = new ShowTeamDataModel();
		hotTeamModel = new HotTeamModel();
	}
	
	public void showTeamTable(){
		showTeamModel.showTeamTable();
	}
	
	public void sortTeam(int i,boolean isPositiveSequence){
		showTeamModel.sortTeamTable(i, isPositiveSequence);
	}
	
	public void showTeamFrame(String teamName, Date begin,Date end){
		hotTeamModel.showTeam(teamName,begin,end);
	}
}
