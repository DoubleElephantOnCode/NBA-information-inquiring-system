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
	
	/**
	 * 显示球员信息
	 */
	public void showPlayerInfo(){
		showPlayerModel.showPlayerInfo();
	}
	
	/**
	 * 球员排序
	 * @param i
	 * @param isPositiveSequence
	 */
	public void sortPlayer(int i, boolean isPositiveSequence){
		showPlayerModel.sortByPlayerInfo(i, isPositiveSequence);
	}
	
	/**
	 * 筛选球员
	 * @param i
	 */
	public void selectPlayer(int i){
		showPlayerModel.selectByPlayerInfo(i);
	}
}
