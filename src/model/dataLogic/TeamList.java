package model.dataLogic;

import java.util.ArrayList;

import vo.MatchVO;
import vo.TeamVO;
/**
 * 
 * @author ZSK
 * @date 2015年3月11日 下午11:15:53
 */
public class TeamList {
	/**
	 * 记录所有队伍的列表
	 */
	public static ArrayList<TeamVO> teamVOList = new ArrayList<TeamVO>();
	
	/**
	 * 构造方法 初始化队伍列表
	 */
	public TeamList(){
	}
	
	/**
	 * 增加一个队伍信息
	 * @param teamVO
	 */
	public void addTeamVO(TeamVO teamVO){
		teamVOList.add(teamVO);
	}
	
	public void addMatchVO(MatchVO matchVO){
		for(TeamVO teamVO:teamVOList){
			if(teamVO.abbreviation.equals(matchVO.getAwayTeam())){
				teamVO.addMatchVO(matchVO);
			}else if(teamVO.abbreviation.equals(matchVO.getHomeTeam())){
				teamVO.addMatchVO(matchVO);
			}
		}
	}
}
