package control;

import model.dataLogic.ShowPlayerDataModel;

/**
 * 
 * @author HalaWKS
 * @date 2015年6月12日 下午4:47:56
 *
 */
public class PlayerStatisticController {
	
	ShowPlayerDataModel showPlayerDataModel;
	
	public PlayerStatisticController() {
		// TODO Auto-generated constructor stub
		showPlayerDataModel = new ShowPlayerDataModel();
	}
	
	public void showPlayer(String playerName, int index){
		showPlayerDataModel.showPlayer(playerName, index);
	}
	
	public void showPlayerAbility(String name1, String name2, String season){
		showPlayerDataModel.showPlayerAbility(name1, name2, season);
	}
	
	public void playerStatistic(String name1, String name2, String season,
			int after, int index, int type){
		showPlayerDataModel.playerStatistic(name1, name2, season, after, index, type);
	}
}
