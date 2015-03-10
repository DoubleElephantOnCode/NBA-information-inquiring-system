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
	 * 客场队伍名称 缩写
	 */
	public String awayTeam;
	
	/**
	 * 主场队伍名称 缩写
	 */
	public String homeTeam;
	
	/**
	 *  总比分
	 */
	public ScoreVO totalScore;
	
	/**
	 * 比分列表
	 */
	public ArrayList<ScoreVO> scoreVOList;
		
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
	
	//以下为客场数据
	/**
	 * 客场投篮命中数
	 */
	public int awayTotalScoreNum = 0;
	
	/**
	 * 客场投篮出手数
	 */
	public int awayTotalShootNum = 0;
	
	/**
	 * 客场三分命中数
	 */
	public int awayTotalThreePointScoreNum = 0;
	
	/**
	 * 客场三分出手数
	 */
	public int awayTotalThreePointShootNum = 0;
	
	/**
	 * 客场罚球命中数
	 */
	public int awayTotalFreeThrowScoreNum = 0;
	
	/**
	 * 客场罚球出手数
	 */
	public int awayTotalFreeThrowShootNum = 0;
	
	/**
	 * 客场进攻篮板数
	 */
	public int awayTotalOffensiveReboundsNum = 0;

	
	/**
	 * 客场防守篮板数
	 */
	public int awayTotalDefensiveReboundsNum = 0;
	
	/**
	 * 客场总篮板数
	 */
	public int awayTotalReboundsNum = 0;
	
	/**
	 * 客场助攻数
	 */
	public int awayTotalAssistNum = 0;
	
	/**
	 * 客场抢断数
	 */
	public int awayTotalStealNum = 0;
	
	/**
	 * 客场盖帽数
	 */
	public int awayTotalBlockNum = 0;
	
	/**
	 * 客场失误数
	 */
	public int awayTotalTurnoverNum = 0;
	
	/**
	 * 客场犯规数
	 */
	public int awayTotalFoulNum = 0;
	
	/**
	 * 客场球员得分情况列表
	 */
	public ArrayList<MatchDataPerPlayerVO> awayPlayerList;
	
	//以下为主场数据
	
	/**
	 * 主场投篮命中数
	 */
	public int homeTotalScoreNum = 0;
	
	/**
	 * 主场投篮出手数
	 */
	public int homeTotalShootNum = 0;
	
	/**
	 * 主场三分命中数
	 */
	public int homeTotalThreePointScoreNum = 0;
	
	/**
	 * 主场三分出手数
	 */
	public int homeTotalThreePointShootNum = 0;
	
	/**
	 * 主场罚球命中数
	 */
	public int homeTotalFreeThrowScoreNum = 0;
	
	/**
	 * 主场罚球出手数
	 */
	public int homeTotalFreeThrowShootNum = 0;
	
	/**
	 * 主场进攻篮板数
	 */
	public int homeTotalOffensiveReboundsNum = 0;

	
	/**
	 * 主场防守篮板数
	 */
	public int homeTotalDefensiveReboundsNum = 0;
	
	/**
	 * 主场总篮板数
	 */
	public int homeTotalReboundsNum = 0;
	
	/**
	 * 主场助攻数
	 */
	public int homeTotalAssistNum = 0;
	
	/**
	 * 主场抢断数
	 */
	public int homeTotalStealNum = 0;
	
	/**
	 * 主场盖帽数
	 */
	public int homeTotalBlockNum = 0;
	
	/**
	 * 主场失误数
	 */
	public int homeTotalTurnoverNum = 0;
	
	/**
	 * 主场犯规数
	 */
	public int homeTotalFoulNum = 0;
	
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
			ScoreVO totalScore, ArrayList<ScoreVO> scoreVOList) {
		super();
		this.timeOfMatch = timeOfMatch;
		this.awayTeam = awayTeam;
		this.homeTeam = homeTeam;
		this.totalScore = totalScore;
		this.scoreVOList = scoreVOList;
		awayPlayerList = new ArrayList<MatchDataPerPlayerVO>();
		homePlayerList = new ArrayList<MatchDataPerPlayerVO>();
	}

	/**
	 * 向客场球员得分情况列表增加一条记录
	 * @param mdppVO
	 */
	public void addAwayPlayerData(MatchDataPerPlayerVO mdppVO){
		awayPlayerList.add(mdppVO);
		awayTotalScoreNum += mdppVO.getScoreNum();
		awayTotalShootNum += mdppVO.getShootNum();
		awayTotalThreePointScoreNum += mdppVO.getThreePointScoreNum();
		awayTotalThreePointShootNum += mdppVO.getThreePointShootNum();
		awayTotalFreeThrowScoreNum += mdppVO.getFreeThrowScoreNum();
		awayTotalFreeThrowShootNum += mdppVO.getFreeThrowShootNum();
		awayTotalOffensiveReboundsNum += mdppVO.getOffensiveReboundsNum();
		awayTotalDefensiveReboundsNum += mdppVO.getDefensiveReboundsNum();
		awayTotalReboundsNum += mdppVO.getTotalReboundsNum();
		awayTotalAssistNum += mdppVO.getAssistNum();
		awayTotalStealNum += mdppVO.getStealNum();
		awayTotalBlockNum += mdppVO.getBlockNum();
		awayTotalTurnoverNum += mdppVO.getTurnoverNum();
		awayTotalFoulNum += mdppVO.getFoulNum();
	}
	
	/**
	 * 向主场球员得分情况列表增加一条记录
	 * @param mdppVO
	 */
	public void addHomePlayerData(MatchDataPerPlayerVO mdppVO){
		homePlayerList.add(mdppVO);
		homeTotalScoreNum += mdppVO.getScoreNum();
		homeTotalShootNum += mdppVO.getShootNum();
		homeTotalThreePointScoreNum += mdppVO.getThreePointScoreNum();
		homeTotalThreePointShootNum += mdppVO.getThreePointShootNum();
		homeTotalFreeThrowScoreNum += mdppVO.getFreeThrowScoreNum();
		homeTotalFreeThrowShootNum += mdppVO.getFreeThrowShootNum();
		homeTotalOffensiveReboundsNum += mdppVO.getOffensiveReboundsNum();
		homeTotalDefensiveReboundsNum += mdppVO.getDefensiveReboundsNum();
		homeTotalReboundsNum += mdppVO.getTotalReboundsNum();
		homeTotalAssistNum += mdppVO.getAssistNum();
		homeTotalStealNum += mdppVO.getStealNum();
		homeTotalBlockNum += mdppVO.getBlockNum();
		homeTotalTurnoverNum += mdppVO.getTurnoverNum();
		homeTotalFoulNum += mdppVO.getFoulNum();
	}

	public Date getTimeOfMatch() {
		return timeOfMatch;
	}

	public void setTimeOfMatch(Date timeOfMatch) {
		this.timeOfMatch = timeOfMatch;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public ScoreVO getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(ScoreVO totalScore) {
		this.totalScore = totalScore;
	}

	public ArrayList<ScoreVO> getScoreVOList() {
		return scoreVOList;
	}

	public void setScoreVOList(ArrayList<ScoreVO> scoreVOList) {
		this.scoreVOList = scoreVOList;
	}

	public ScoreVO getFirstScore() {
		return firstScore;
	}

	public void setFirstScore(ScoreVO firstScore) {
		this.firstScore = firstScore;
	}

	public ScoreVO getSecondScore() {
		return secondScore;
	}

	public void setSecondScore(ScoreVO secondScore) {
		this.secondScore = secondScore;
	}

	public ScoreVO getThirdScore() {
		return thirdScore;
	}

	public void setThirdScore(ScoreVO thirdScore) {
		this.thirdScore = thirdScore;
	}

	public ScoreVO getFourthScore() {
		return fourthScore;
	}

	public void setFourthScore(ScoreVO fourthScore) {
		this.fourthScore = fourthScore;
	}

	public int getAwayTotalScoreNum() {
		return awayTotalScoreNum;
	}

	public void setAwayTotalScoreNum(int awayTotalScoreNum) {
		this.awayTotalScoreNum = awayTotalScoreNum;
	}

	public int getAwayTotalShootNum() {
		return awayTotalShootNum;
	}

	public void setAwayTotalShootNum(int awayTotalShootNum) {
		this.awayTotalShootNum = awayTotalShootNum;
	}

	public int getAwayTotalThreePointScoreNum() {
		return awayTotalThreePointScoreNum;
	}

	public void setAwayTotalThreePointScoreNum(int awayTotalThreePointScoreNum) {
		this.awayTotalThreePointScoreNum = awayTotalThreePointScoreNum;
	}

	public int getAwayTotalThreePointShootNum() {
		return awayTotalThreePointShootNum;
	}

	public void setAwayTotalThreePointShootNum(int awayTotalThreePointShootNum) {
		this.awayTotalThreePointShootNum = awayTotalThreePointShootNum;
	}

	public int getAwayTotalFreeThrowScoreNum() {
		return awayTotalFreeThrowScoreNum;
	}

	public void setAwayTotalFreeThrowScoreNum(int awayTotalFreeThrowScoreNum) {
		this.awayTotalFreeThrowScoreNum = awayTotalFreeThrowScoreNum;
	}

	public int getAwayTotalFreeThrowShootNum() {
		return awayTotalFreeThrowShootNum;
	}

	public void setAwayTotalFreeThrowShootNum(int awayTotalFreeThrowShootNum) {
		this.awayTotalFreeThrowShootNum = awayTotalFreeThrowShootNum;
	}

	public int getAwayTotalOffensiveReboundsNum() {
		return awayTotalOffensiveReboundsNum;
	}

	public void setAwayTotalOffensiveReboundsNum(int awayTotalOffensiveReboundsNum) {
		this.awayTotalOffensiveReboundsNum = awayTotalOffensiveReboundsNum;
	}

	public int getAwayTotalDefensiveReboundsNum() {
		return awayTotalDefensiveReboundsNum;
	}

	public void setAwayTotalDefensiveReboundsNum(int awayTotalDefensiveReboundsNum) {
		this.awayTotalDefensiveReboundsNum = awayTotalDefensiveReboundsNum;
	}

	public int getAwayTotalReboundsNum() {
		return awayTotalReboundsNum;
	}

	public void setAwayTotalReboundsNum(int awayTotalReboundsNum) {
		this.awayTotalReboundsNum = awayTotalReboundsNum;
	}

	public int getAwayTotalAssistNum() {
		return awayTotalAssistNum;
	}

	public void setAwayTotalAssistNum(int awayTotalAssistNum) {
		this.awayTotalAssistNum = awayTotalAssistNum;
	}

	public int getAwayTotalStealNum() {
		return awayTotalStealNum;
	}

	public void setAwayTotalStealNum(int awayTotalStealNum) {
		this.awayTotalStealNum = awayTotalStealNum;
	}

	public int getAwayTotalBlockNum() {
		return awayTotalBlockNum;
	}

	public void setAwayTotalBlockNum(int awayTotalBlockNum) {
		this.awayTotalBlockNum = awayTotalBlockNum;
	}

	public int getAwayTotalTurnoverNum() {
		return awayTotalTurnoverNum;
	}

	public void setAwayTotalTurnoverNum(int awayTotalTurnoverNum) {
		this.awayTotalTurnoverNum = awayTotalTurnoverNum;
	}

	public int getAwayTotalFoulNum() {
		return awayTotalFoulNum;
	}

	public void setAwayTotalFoulNum(int awayTotalFoulNum) {
		this.awayTotalFoulNum = awayTotalFoulNum;
	}

	public ArrayList<MatchDataPerPlayerVO> getAwayPlayerList() {
		return awayPlayerList;
	}

	public void setAwayPlayerList(ArrayList<MatchDataPerPlayerVO> awayPlayerList) {
		this.awayPlayerList = awayPlayerList;
	}

	public int getHomeTotalScoreNum() {
		return homeTotalScoreNum;
	}

	public void setHomeTotalScoreNum(int homeTotalScoreNum) {
		this.homeTotalScoreNum = homeTotalScoreNum;
	}

	public int getHomeTotalShootNum() {
		return homeTotalShootNum;
	}

	public void setHomeTotalShootNum(int homeTotalShootNum) {
		this.homeTotalShootNum = homeTotalShootNum;
	}

	public int getHomeTotalThreePointScoreNum() {
		return homeTotalThreePointScoreNum;
	}

	public void setHomeTotalThreePointScoreNum(int homeTotalThreePointScoreNum) {
		this.homeTotalThreePointScoreNum = homeTotalThreePointScoreNum;
	}

	public int getHomeTotalThreePointShootNum() {
		return homeTotalThreePointShootNum;
	}

	public void setHomeTotalThreePointShootNum(int homeTotalThreePointShootNum) {
		this.homeTotalThreePointShootNum = homeTotalThreePointShootNum;
	}

	public int getHomeTotalFreeThrowScoreNum() {
		return homeTotalFreeThrowScoreNum;
	}

	public void setHomeTotalFreeThrowScoreNum(int homeTotalFreeThrowScoreNum) {
		this.homeTotalFreeThrowScoreNum = homeTotalFreeThrowScoreNum;
	}

	public int getHomeTotalFreeThrowShootNum() {
		return homeTotalFreeThrowShootNum;
	}

	public void setHomeTotalFreeThrowShootNum(int homeTotalFreeThrowShootNum) {
		this.homeTotalFreeThrowShootNum = homeTotalFreeThrowShootNum;
	}

	public int getHomeTotalOffensiveReboundsNum() {
		return homeTotalOffensiveReboundsNum;
	}

	public void setHomeTotalOffensiveReboundsNum(int homeTotalOffensiveReboundsNum) {
		this.homeTotalOffensiveReboundsNum = homeTotalOffensiveReboundsNum;
	}

	public int getHomeTotalDefensiveReboundsNum() {
		return homeTotalDefensiveReboundsNum;
	}

	public void setHomeTotalDefensiveReboundsNum(int homeTotalDefensiveReboundsNum) {
		this.homeTotalDefensiveReboundsNum = homeTotalDefensiveReboundsNum;
	}

	public int getHomeTotalReboundsNum() {
		return homeTotalReboundsNum;
	}

	public void setHomeTotalReboundsNum(int homeTotalReboundsNum) {
		this.homeTotalReboundsNum = homeTotalReboundsNum;
	}

	public int getHomeTotalAssistNum() {
		return homeTotalAssistNum;
	}

	public void setHomeTotalAssistNum(int homeTotalAssistNum) {
		this.homeTotalAssistNum = homeTotalAssistNum;
	}

	public int getHomeTotalStealNum() {
		return homeTotalStealNum;
	}

	public void setHomeTotalStealNum(int homeTotalStealNum) {
		this.homeTotalStealNum = homeTotalStealNum;
	}

	public int getHomeTotalBlockNum() {
		return homeTotalBlockNum;
	}

	public void setHomeTotalBlockNum(int homeTotalBlockNum) {
		this.homeTotalBlockNum = homeTotalBlockNum;
	}

	public int getHomeTotalTurnoverNum() {
		return homeTotalTurnoverNum;
	}

	public void setHomeTotalTurnoverNum(int homeTotalTurnoverNum) {
		this.homeTotalTurnoverNum = homeTotalTurnoverNum;
	}

	public int getHomeTotalFoulNum() {
		return homeTotalFoulNum;
	}

	public void setHomeTotalFoulNum(int homeTotalFoulNum) {
		this.homeTotalFoulNum = homeTotalFoulNum;
	}

	public ArrayList<MatchDataPerPlayerVO> getHomePlayerList() {
		return homePlayerList;
	}

	public void setHomePlayerList(ArrayList<MatchDataPerPlayerVO> homePlayerList) {
		this.homePlayerList = homePlayerList;
	}

	
	
	
}
