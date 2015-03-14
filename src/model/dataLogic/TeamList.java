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
	public static void addTeamVO(TeamVO teamVO){
		teamVOList.add(teamVO);
	}
	
	public static void addMatchVO(MatchVO matchVO){
		for(TeamVO teamVO:teamVOList){
			if(teamVO.abbreviation.equals(matchVO.getAwayTeam())){
				teamVO.addMatchVO(matchVO);
			}else if(teamVO.abbreviation.equals(matchVO.getHomeTeam())){
				teamVO.addMatchVO(matchVO);
			}
		}
	}
	
	public static void finishRead(){
		for(TeamVO teamVO:teamVOList){
			teamVO.calData();
		}
	}
	
	public static ArrayList<TeamVO> getTeamVOList(){
		return teamVOList;
	}
	
	public static String[] getHeadListForColumn(){
		String[] s= new String[]{
				"总比赛场数","总投篮命中数","总投篮出手次数","总三分命中数",
				"总三分出手数","总罚球命中数","总罚球出手数","总进攻篮板数","总防守篮板数","总篮板数",
				"总助攻数","总抢断数","总盖帽数","总失误数","总犯规数",
				"总比赛得分","投篮命中率","三分命中率",
				"罚球命中率","胜率","进攻回合","进攻效率"
				,"防守效率","进攻篮板效率","防守篮板效率","抢断效率","助攻率",   
				"平均投篮命中数","平均投篮出手次数","平均三分命中数",
				"平均三分出手数","平均罚球命中数","平均罚球出手数","平均进攻篮板数","平均防守篮板数","平均总篮板数",
				"平均助攻数","平均抢断数","平均盖帽数","平均失误数","平均犯规数","平均比赛得分",
		};
		return s;
	}

	public static String[] getHeadListForRow(){
		String[] s = new String[teamVOList.size()];
		for(int i=0;i<teamVOList.size();i++){
			s[i]=teamVOList.get(i).getAbbreviation();
		}
		return s;
	}

}
