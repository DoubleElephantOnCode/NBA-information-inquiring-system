package control;

import view.mainFrame.GoForwardOrBackward.HistoryList;
import model.dataLogic.ShowPlayerDataModel;

/**
 * 
 * @author HalaWKS
 * @date 2015年3月14日 下午7:05:28
 *
 */
public class ShowPlayerController {

	ShowPlayerDataModel showPlayerModel;
	
	
	public ShowPlayerController(boolean inWay) {
		// TODO Auto-generated constructor stub
		showPlayerModel = new ShowPlayerDataModel();
		HistoryList.inWay = inWay;
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
	 * 筛选前50名球员
	 * @param i
	 */
	public void sortAndSelectPlayer(String position, String area, int i){
		showPlayerModel.selectByPlayerInfo(position, area, i);
	}
	
	/**
	 * 根据分区、位置筛选球员
	 * @param position
	 * @param area
	 */
	public void selectByAreaOrPosition(String position, String area){
		showPlayerModel.selectByAreaOrPosition(position, area);
	}
	
	/**
	 * 显示单独的球员信息
	 * @param name
	 */
	public void showSinglePlayerInfo(String name, String startDate, String endDate){
		showPlayerModel.showSinglePlayerInfo(name, startDate, endDate);
	}
	
	/**
	 * 显示热点球员
	 * @param isSeason 是否显示赛季热点
	 * @param presentDate 当前日期
	 * @param selectNum 筛选数目
	 * @param selectItem 筛选依据项
	 */
	public void showHotPlayerInfo(boolean isSeason, int selectNum, int selectItem){
		showPlayerModel.selectHotPlayer(isSeason, selectNum, selectItem);
	}
	
	/**
	 * 显示进步最快球员
	 * @param selectItem 筛选依据项
	 * @param selectNum 筛选数目
	 */
	public void showProgressPlayerInfo(int selectItem, int selectNum){
		showPlayerModel.selectProgressPlayer(selectItem, selectNum);
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
