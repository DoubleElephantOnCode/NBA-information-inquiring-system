package model.dataLogic;

import java.util.ArrayList;

import vo.PlayerDataPerMatchVO;

/**
 * 筛选比赛场次
 * @author HalaWKS
 * @date 2015年4月19日 下午11:49:20
 *
 */
public class SelectMatch {

	public SelectMatch() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 根据日期筛选比赛信息
	 * @param matchList 比赛列表
	 * @param startDate 起始日期
	 * @param endDate 终止日期
	 * @return
	 */
	public static ArrayList<PlayerDataPerMatchVO> selectMatchByDate(
			ArrayList<PlayerDataPerMatchVO> matchList, String startDate, String endDate){
		
		ArrayList<PlayerDataPerMatchVO> newMatchList = new ArrayList<PlayerDataPerMatchVO>();
		PlayerDataPerMatchVO matchData = new PlayerDataPerMatchVO();

		
		for (int i = matchList.size() - 1; i >= 0; i--) {
			matchData = matchList.get(i);
			if(matchData.getMatchDate().compareTo(startDate) >= 0 &&
					matchData.getMatchDate().compareTo(endDate) <= 0){
				newMatchList.add(matchData);
			}
		}
		
		return newMatchList;
	}
	
}
