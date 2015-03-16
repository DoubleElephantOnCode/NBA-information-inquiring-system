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
	public void showPlayerInfo(final String position, final String area){
		showPlayerModel.showPlayerInfo(position, area);
	}
	
	/**
	 * 球员排序
	 * @param i
	 * @param isPositiveSequence
	 */
	public void sortPlayer(String position, String area, int i, boolean isPositiveSequence){
		showPlayerModel.sortByPlayerInfo(position, area, i, isPositiveSequence);
	}
	
	/**
	 * 筛选球员
	 * @param i
	 */
	public void selectPlayer(int i){
//		showPlayerModel.selectByPlayerInfo(i);
	}
	
	/**
	 * 获取球员位置筛选依据
	 * @return
	 */
	public static String[] getPositionList(){
		String[] s = new String[]{
				"-ALL",
				"前锋-F", "中锋-C", "后卫-G"
		};
		return s;
	}
	
	/**
	 * 获取球员分区筛选依据
	 * @return
	 */
	public static String[] getAreaList(){
		String[] s = new String[]{
				"-ALL",
				"东部联盟-E",
				"大西洋分区-Atlantic", "中部分区-Central", "东南分区-Southeast",
				"西部联盟-W",
				"西南分区-Southwest", "西北分区-Northwest", "太平洋分区-Pacific"
		};
		return s;
	}
	
}
