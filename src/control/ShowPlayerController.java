package control;

import model.dataLogic.ShowPlayerDataModel;

/**
 * 
 * @author HalaWKS
 * @date 2015年3月14日 下午7:05:28
 *
 */
public class ShowPlayerController {

	ShowPlayerDataModel showPlayerModel;
	
	public ShowPlayerController() {
		// TODO Auto-generated constructor stub
		showPlayerModel = new ShowPlayerDataModel();
	}
	
	public void showPlayerInfo(){
		showPlayerModel.showPlayerInfo();
	}
	
	public void sortPlayer(int i, boolean isPositiveSequence){
		showPlayerModel.sortByPlayerInfo(i, isPositiveSequence);
	}
	
	
}
