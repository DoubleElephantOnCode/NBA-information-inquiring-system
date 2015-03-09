package vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author HalaWKS
 *
 */
public class MatchVO {
	/**
	 * 比赛时间
	 */
	public Date timeOfMatch;
	
	/**
	 * 客场队伍名称
	 */
	public String awayTeam;
	
	/**
	 * 主场队伍名称
	 */
	public String homeTeam;
	
	/**
	 *  总比分
	 */
	public String totalScore;
	
	/**
	 *  第一节比分
	 */
	public String firstScore;
	
	/**
	 *  第二节比分
	 */
	public String secondScore;
	
	/**
	 *  第三节比分
	 */
	public String thirdScore;
	
	/**
	 *  第四节比分
	 */
	public String fourthScore;
	
	/**
	 * 客场球员得分情况列表
	 */
	public ArrayList<MatchDataPerPlayerVO> awayPlayerList;
	
	/**
	 * 主场球员得分情况列表
	 */
	public ArrayList<MatchDataPerPlayerVO> homePlayerList;
}
