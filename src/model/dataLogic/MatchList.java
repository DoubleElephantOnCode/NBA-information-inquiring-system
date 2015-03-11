package model.dataLogic;

import java.util.ArrayList;

import vo.MatchVO;

/**
 * 比赛列表类
 * @author ZSK
 * @date 2015年3月10日 下午9:47:22
 */
public class MatchList {
	/**
	 * 比赛列表
	 */
	public static ArrayList<MatchVO> matchVOList = new ArrayList<MatchVO>();
	
	/**
	 * 构造方法
	 */
	public MatchList(){
	}
	
	public void addMatchVO(MatchVO matchVO){
		matchVOList.add(matchVO);
	}
}
