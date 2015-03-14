package control;

import model.dataLogic.ShowTeamDataModel;

public class ShowTeamController {
	ShowTeamDataModel showTeamModel;
	public ShowTeamController(){
		showTeamModel = new ShowTeamDataModel();
	}
	
	public void showTeamTable(){
		showTeamModel.showTeamTable();
	}
}
