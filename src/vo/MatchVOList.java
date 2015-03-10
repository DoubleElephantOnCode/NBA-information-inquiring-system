package vo;

import java.util.ArrayList;

/**
 * 比赛列表类
 * @author ZSK
 * @date 2015年3月10日 下午9:47:22
 */
public class MatchVOList {
	/**
	 * 比赛列表
	 */
	ArrayList<MatchVO> matchVOList;
	
	/**
	 * 构造方法
	 */
	public MatchVOList(){
		matchVOList = new ArrayList<MatchVO>();
	}
	
	public void addMatchVO(MatchVO matchVO){
		matchVOList.add(matchVO);
	}
}
