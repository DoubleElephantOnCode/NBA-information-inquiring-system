package control;

import view.mainFrame.GoForwardOrBackward.HistoryList;
import model.dataLogic.ShowMatchDataModel;

/**
 * 
 * @author ZSK
 * @date 2015年4月27日 下午3:26:40
 */
public class ShowMatchController {
	ShowMatchDataModel showMatchDataModel;
	
	
	public ShowMatchController(boolean inWay){
		showMatchDataModel = new ShowMatchDataModel();
		HistoryList.inWay = inWay;
	}
	
	
	public void showMatchTable(String date,String homeTeam,String awayTeam){
		showMatchDataModel.showMatchTable(date,homeTeam,awayTeam);
	}
}
