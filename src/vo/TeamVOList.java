package vo;

import java.util.ArrayList;

public class TeamVOList {
	/**
	 * 记录所有队伍的列表
	 */
	public ArrayList<TeamVO> teamVOList;
	
	/**
	 * 构造方法 初始化队伍列表
	 */
	public TeamVOList(){
		teamVOList = new ArrayList<TeamVO>();
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
