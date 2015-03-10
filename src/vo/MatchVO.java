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
	public ScoreVO totalScore;
	
	/**
	 *  第一节比分
	 */
	public ScoreVO firstScore;
	
	/**
	 *  第二节比分
	 */
	public ScoreVO secondScore;
	
	/**
	 *  第三节比分
	 */
	public ScoreVO thirdScore;
	
	/**
	 *  第四节比分
	 */
	public ScoreVO fourthScore;
	
	/**
	 * 客场球员得分情况列表
	 */
	public ArrayList<MatchDataPerPlayerVO> awayPlayerList;
	
	/**
	 * 主场球员得分情况列表
	 */
	public ArrayList<MatchDataPerPlayerVO> homePlayerList;
	
	
	
	/**
	 * 构造方法
	 * @param timeOfMatch
	 * @param awayTeam
	 * @param homeTeam
	 * @param totalScore
	 * @param firstScore
	 * @param secondScore
	 * @param thirdScore
	 * @param fourthScore
	 */
	public MatchVO(Date timeOfMatch, String awayTeam, String homeTeam,
			ScoreVO totalScore, ScoreVO firstScore, ScoreVO secondScore,
			ScoreVO thirdScore, ScoreVO fourthScore) {
		super();
		this.timeOfMatch = timeOfMatch;
		this.awayTeam = awayTeam;
		this.homeTeam = homeTeam;
		this.totalScore = totalScore;
		this.firstScore = firstScore;
		this.secondScore = secondScore;
		this.thirdScore = thirdScore;
		this.fourthScore = fourthScore;
		awayPlayerList = new ArrayList<MatchDataPerPlayerVO>();
		homePlayerList = new ArrayList<MatchDataPerPlayerVO>();
	}

	/**
	 * 向客场球员得分情况列表增加一条记录
	 * @param mdppVO
	 */
	public void addAwayPlayerData(MatchDataPerPlayerVO mdppVO){
		awayPlayerList.add(mdppVO);
	}
	
	/**
	 * 向主场球员得分情况列表增加一条记录
	 * @param mdppVO
	 */
	public void addHomePlayerData(MatchDataPerPlayerVO mdppVO){
		homePlayerList.add(mdppVO);
	}
}
