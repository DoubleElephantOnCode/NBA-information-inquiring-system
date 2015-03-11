package vo;

import java.util.ArrayList;

/**
 * 
 * @author HalaWKS
 *
 */
public class TeamVO {
	
	/**
	 * 球队全名
	 */
	public String name;
	
	/**
	 * 球队名称缩写
	 */
	public String abbreviation;
	
	/**
	 * 所在地
	 */
	public String location;
	
	/**
	 * 赛区
	 */
	public String competion;
	
	/**
	 * 分区
	 */
	public String partition;
	
	/**
	 * 主场
	 */
	public String homeCourt;
	
	/**
	 * 建立时间
	 */
	public String buildTime;
	
	/**
	 * 比赛场数
	 */
	public int matchNum = 0;
	
	/**
	 * 投篮命中数
	 */
	public int totalScoreNum = 0;
	
	/**
	 * 投篮出手数
	 */
	public int totalShootNum = 0;
	
	/**
	 * 三分命中数
	 */
	public int totalThreePointScoreNum = 0;
	
	/**
	 * 三分出手数
	 */
	public int totalThreePointShootNum = 0;
	
	/**
	 * 罚球命中数
	 */
	public int totalFreeThrowScoreNum = 0;
	
	/**
	 * 罚球出手数
	 */
	public int totalFreeThrowShootNum = 0;
	
	/**
	 * 进攻篮板数
	 */
	public int totalOffensiveReboundsNum = 0;

	
	/**
	 * 防守篮板数
	 */
	public int totalDefensiveReboundsNum = 0;
	
	/**
	 * 总篮板数
	 */
	public int totalTotalReboundsNum = 0;
	
	/**
	 * 助攻数
	 */
	public int totalAssistNum = 0;
	
	/**
	 * 抢断数
	 */
	public int totalStealNum = 0;
	
	/**
	 * 盖帽数
	 */
	public int totalBlockNum = 0;
	
	/**
	 * 失误数
	 */
	public int totalTurnoverNum = 0;
	
	/**
	 * 犯规数
	 */
	public int totalFoulNum = 0;
	
	/**
	 * 比赛得分
	 */
	public int totalScore = 0;
	
	/**
	 * 投篮命中率
	 */
	public double totalScoreRate;
	
	/**
	 * 三分命中率
	 */
	public double totalThreePointRate;
	
	/**
	 * 罚球命中率
	 */
	public double totalFreeThrowRate;
	
	/**
	 * 胜率
	 */
	public double totalWinningRate;
	
	/**
	 * 进攻回合
	 */
	public double totalAttackRound;
	
	/**
	 * 进攻效率
	 */
	public double totalAttackEfficiency;
	
	/**
	 * 防守效率
	 */
	public double totalDefendEfficiency;
	
	/**
	 * 篮板效率
	 */
	public double totalReboundEfficiency;
	
	/**
	 * 抢断效率
	 */
	public double totalStealEfficiency;
	
	/**
	 * 助攻率
	 */
	public double totalAssistRate;
	
	
	
	//以下为平均数据
	/**
	 * 平均投篮命中数
	 */
	public double aveScoreNum;
	
	/**
	 * 平均投篮出手数
	 */
	public double aveShootNum;
	
	/**
	 * 平均三分命中数
	 */
	public double aveThreePointScoreNum;
	
	/**
	 * 平均三分出手数
	 */
	public double aveThreePointShootNum;
	
	/**
	 * 平均罚球命中数
	 */
	public double aveFreeThrowScoreNum;
	
	/**
	 * 平均罚球出手数
	 */
	public double aveFreeThrowShootNum;
	
	/**
	 * 平均进攻篮板数
	 */
	public double aveOffensiveReboundsNum;

	
	/**
	 * 平均防守篮板数
	 */
	public double aveDefensiveReboundsNum;
	
	/**
	 * 平均总篮板数
	 */
	public double aveTotalReboundsNum;
	
	/**
	 * 平均助攻数
	 */
	public double aveAssistNum;
	
	/**
	 * 平均抢断数
	 */
	public double aveStealNum;
	
	/**
	 * 平均盖帽数
	 */
	public double aveBlockNum;
	
	/**
	 * 平均失误数
	 */
	public double aveTurnoverNum;
	
	/**
	 * 平均犯规数
	 */
	public double aveFoulNum;
	
	/**
	 * 平均比赛得分
	 */
	public double aveScore;
	
	/*
	 * 平均投篮命中率
	 
	public double aveScoreRate;
	*/
	/*
	 * 平均三分命中率
	 
	public double aveThreePointRate;
	*/
	/*
	 * 平均罚球命中率
	 
	public double aveFreeThrowRate;
	*/
	/*
	 * 平均胜率
	 
	public double aveWinningRate;
	*/
	/**
	 * 平均进攻回合
	 */
	public double aveAttackRound;
	
	/**
	 * 平均进攻效率
	 */
	public double aveAttackEfficiency;
	
	/**
	 * 平均防守效率
	 */
	public double aveDefendEfficiency;
	
	/**
	 * 平均篮板效率
	 */
	public double aveReboundEfficiency;
	
	/**
	 * 平均抢断效率
	 */
	public double aveStealEfficiency;
	
	/**
	 * 平均助攻率
	 */
	public double aveAssistRate;
	
	//以上为平均数据
	
	/**
	 * 球队比赛列表
	 */
	public ArrayList<MatchVO> matchVOList;

	/**
	 * 构造方法
	 * @param name
	 * @param abbreviation
	 * @param location
	 * @param competion
	 * @param partition
	 * @param homeCourt
	 * @param buildTime
	 */
	public TeamVO(String name, String abbreviation, String location,
			String competion, String partition, String homeCourt,
			String buildTime) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.location = location;
		this.competion = competion;
		this.partition = partition;
		this.homeCourt = homeCourt;
		this.buildTime = buildTime;
		matchVOList = new ArrayList<MatchVO>();
	}
	
	/**
	 * 增加一条比赛记录并改变相关数据
	 * @param matchVO
	 */
	public void addMatchVO(MatchVO matchVO){
		if(abbreviation.equals(matchVO.getAwayTeam())){
			matchVOList.add(matchVO);
			matchNum++;
			totalScoreNum += matchVO.getAwayTotalScoreNum();
			totalShootNum += matchVO.getAwayTotalShootNum();
			totalThreePointScoreNum += matchVO.getAwayTotalThreePointScoreNum();
			totalThreePointShootNum += matchVO.getAwayTotalThreePointShootNum();
			totalFreeThrowScoreNum += matchVO.getAwayTotalFreeThrowScoreNum();
			totalFreeThrowShootNum += matchVO.getAwayTotalFreeThrowShootNum();
			totalOffensiveReboundsNum += matchVO.getAwayTotalOffensiveReboundsNum();
			totalDefensiveReboundsNum += matchVO.getAwayTotalDefensiveReboundsNum();
			totalTotalReboundsNum += matchVO.getAwayTotalReboundsNum();
			totalAssistNum += matchVO.getAwayTotalAssistNum();
			totalStealNum += matchVO.getAwayTotalStealNum();
			totalBlockNum += matchVO.getAwayTotalBlockNum();
			totalTurnoverNum += matchVO.getAwayTotalTurnoverNum();
			totalFoulNum += matchVO.getAwayTotalFoulNum();
			totalScore += matchVO.getTotalScore().former;
			
		}else if(abbreviation.equals(matchVO.getHomeTeam())){
			matchVOList.add(matchVO);
			matchNum++;
			totalScoreNum += matchVO.getHomeTotalScoreNum();
			totalShootNum += matchVO.getHomeTotalShootNum();
			totalThreePointScoreNum += matchVO.getHomeTotalThreePointScoreNum();
			totalThreePointShootNum += matchVO.getHomeTotalThreePointShootNum();
			totalFreeThrowScoreNum += matchVO.getHomeTotalFreeThrowScoreNum();
			totalFreeThrowShootNum += matchVO.getHomeTotalFreeThrowShootNum();
			totalOffensiveReboundsNum += matchVO.getHomeTotalOffensiveReboundsNum();
			totalDefensiveReboundsNum += matchVO.getHomeTotalDefensiveReboundsNum();
			totalTotalReboundsNum += matchVO.getHomeTotalReboundsNum();
			totalAssistNum += matchVO.getHomeTotalAssistNum();
			totalStealNum += matchVO.getHomeTotalStealNum();
			totalBlockNum += matchVO.getHomeTotalBlockNum();
			totalTurnoverNum += matchVO.getHomeTotalTurnoverNum();
			totalFoulNum += matchVO.getHomeTotalFoulNum();
			totalScore += matchVO.getTotalScore().latter;
		}else{
			System.out.println("error in TeamVO addMatchVO");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompetion() {
		return competion;
	}

	public void setCompetion(String competion) {
		this.competion = competion;
	}

	public String getPartition() {
		return partition;
	}

	public void setPartition(String partition) {
		this.partition = partition;
	}

	public String getHomeCourt() {
		return homeCourt;
	}

	public void setHomeCourt(String homeCourt) {
		this.homeCourt = homeCourt;
	}

	public String getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}

	public int getMatchNum() {
		return matchNum;
	}

	public void setMatchNum(int matchNum) {
		this.matchNum = matchNum;
	}

	public int getTotalScoreNum() {
		return totalScoreNum;
	}

	public void setTotalScoreNum(int totalScoreNum) {
		this.totalScoreNum = totalScoreNum;
	}

	public int getTotalShootNum() {
		return totalShootNum;
	}

	public void setTotalShootNum(int totalShootNum) {
		this.totalShootNum = totalShootNum;
	}

	public int getTotalThreePointScoreNum() {
		return totalThreePointScoreNum;
	}

	public void setTotalThreePointScoreNum(int totalThreePointScoreNum) {
		this.totalThreePointScoreNum = totalThreePointScoreNum;
	}

	public int getTotalThreePointShootNum() {
		return totalThreePointShootNum;
	}

	public void setTotalThreePointShootNum(int totalThreePointShootNum) {
		this.totalThreePointShootNum = totalThreePointShootNum;
	}

	public int getTotalFreeThrowScoreNum() {
		return totalFreeThrowScoreNum;
	}

	public void setTotalFreeThrowScoreNum(int totalFreeThrowScoreNum) {
		this.totalFreeThrowScoreNum = totalFreeThrowScoreNum;
	}

	public int getTotalFreeThrowShootNum() {
		return totalFreeThrowShootNum;
	}

	public void setTotalFreeThrowShootNum(int totalFreeThrowShootNum) {
		this.totalFreeThrowShootNum = totalFreeThrowShootNum;
	}

	public int getTotalOffensiveReboundsNum() {
		return totalOffensiveReboundsNum;
	}

	public void setTotalOffensiveReboundsNum(int totalOffensiveReboundsNum) {
		this.totalOffensiveReboundsNum = totalOffensiveReboundsNum;
	}

	public int getTotalDefensiveReboundsNum() {
		return totalDefensiveReboundsNum;
	}

	public void setTotalDefensiveReboundsNum(int totalDefensiveReboundsNum) {
		this.totalDefensiveReboundsNum = totalDefensiveReboundsNum;
	}

	public int getTotalTotalReboundsNum() {
		return totalTotalReboundsNum;
	}

	public void setTotalTotalReboundsNum(int totalTotalReboundsNum) {
		this.totalTotalReboundsNum = totalTotalReboundsNum;
	}

	public int getTotalAssistNum() {
		return totalAssistNum;
	}

	public void setTotalAssistNum(int totalAssistNum) {
		this.totalAssistNum = totalAssistNum;
	}

	public int getTotalStealNum() {
		return totalStealNum;
	}

	public void setTotalStealNum(int totalStealNum) {
		this.totalStealNum = totalStealNum;
	}

	public int getTotalBlockNum() {
		return totalBlockNum;
	}

	public void setTotalBlockNum(int totalBlockNum) {
		this.totalBlockNum = totalBlockNum;
	}

	public int getTotalTurnoverNum() {
		return totalTurnoverNum;
	}

	public void setTotalTurnoverNum(int totalTurnoverNum) {
		this.totalTurnoverNum = totalTurnoverNum;
	}

	public int getTotalFoulNum() {
		return totalFoulNum;
	}

	public void setTotalFoulNum(int totalFoulNum) {
		this.totalFoulNum = totalFoulNum;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public double getTotalScoreRate() {
		return totalScoreRate;
	}

	public void setTotalScoreRate(double totalScoreRate) {
		this.totalScoreRate = totalScoreRate;
	}

	public double getTotalThreePointRate() {
		return totalThreePointRate;
	}

	public void setTotalThreePointRate(double totalThreePointRate) {
		this.totalThreePointRate = totalThreePointRate;
	}

	public double getTotalFreeThrowRate() {
		return totalFreeThrowRate;
	}

	public void setTotalFreeThrowRate(double totalFreeThrowRate) {
		this.totalFreeThrowRate = totalFreeThrowRate;
	}

	public double getTotalWinningRate() {
		return totalWinningRate;
	}

	public void setTotalWinningRate(double totalWinningRate) {
		this.totalWinningRate = totalWinningRate;
	}

	public double getTotalAttackRound() {
		return totalAttackRound;
	}

	public void setTotalAttackRound(double totalAttackRound) {
		this.totalAttackRound = totalAttackRound;
	}

	public double getTotalAttackEfficiency() {
		return totalAttackEfficiency;
	}

	public void setTotalAttackEfficiency(double totalAttackEfficiency) {
		this.totalAttackEfficiency = totalAttackEfficiency;
	}

	public double getTotalDefendEfficiency() {
		return totalDefendEfficiency;
	}

	public void setTotalDefendEfficiency(double totalDefendEfficiency) {
		this.totalDefendEfficiency = totalDefendEfficiency;
	}

	public double getTotalReboundEfficiency() {
		return totalReboundEfficiency;
	}

	public void setTotalReboundEfficiency(double totalReboundEfficiency) {
		this.totalReboundEfficiency = totalReboundEfficiency;
	}

	public double getTotalStealEfficiency() {
		return totalStealEfficiency;
	}

	public void setTotalStealEfficiency(double totalStealEfficiency) {
		this.totalStealEfficiency = totalStealEfficiency;
	}

	public double getTotalAssistRate() {
		return totalAssistRate;
	}

	public void setTotalAssistRate(double totalAssistRate) {
		this.totalAssistRate = totalAssistRate;
	}

	public double getAveScoreNum() {
		return aveScoreNum;
	}

	public void setAveScoreNum(double aveScoreNum) {
		this.aveScoreNum = aveScoreNum;
	}

	public double getAveShootNum() {
		return aveShootNum;
	}

	public void setAveShootNum(double aveShootNum) {
		this.aveShootNum = aveShootNum;
	}

	public double getAveThreePointScoreNum() {
		return aveThreePointScoreNum;
	}

	public void setAveThreePointScoreNum(double aveThreePointScoreNum) {
		this.aveThreePointScoreNum = aveThreePointScoreNum;
	}

	public double getAveThreePointShootNum() {
		return aveThreePointShootNum;
	}

	public void setAveThreePointShootNum(double aveThreePointShootNum) {
		this.aveThreePointShootNum = aveThreePointShootNum;
	}

	public double getAveFreeThrowScoreNum() {
		return aveFreeThrowScoreNum;
	}

	public void setAveFreeThrowScoreNum(double aveFreeThrowScoreNum) {
		this.aveFreeThrowScoreNum = aveFreeThrowScoreNum;
	}

	public double getAveFreeThrowShootNum() {
		return aveFreeThrowShootNum;
	}

	public void setAveFreeThrowShootNum(double aveFreeThrowShootNum) {
		this.aveFreeThrowShootNum = aveFreeThrowShootNum;
	}

	public double getAveOffensiveReboundsNum() {
		return aveOffensiveReboundsNum;
	}

	public void setAveOffensiveReboundsNum(double aveOffensiveReboundsNum) {
		this.aveOffensiveReboundsNum = aveOffensiveReboundsNum;
	}

	public double getAveDefensiveReboundsNum() {
		return aveDefensiveReboundsNum;
	}

	public void setAveDefensiveReboundsNum(double aveDefensiveReboundsNum) {
		this.aveDefensiveReboundsNum = aveDefensiveReboundsNum;
	}

	public double getAveTotalReboundsNum() {
		return aveTotalReboundsNum;
	}

	public void setAveTotalReboundsNum(double aveTotalReboundsNum) {
		this.aveTotalReboundsNum = aveTotalReboundsNum;
	}

	public double getAveAssistNum() {
		return aveAssistNum;
	}

	public void setAveAssistNum(double aveAssistNum) {
		this.aveAssistNum = aveAssistNum;
	}

	public double getAveStealNum() {
		return aveStealNum;
	}

	public void setAveStealNum(double aveStealNum) {
		this.aveStealNum = aveStealNum;
	}

	public double getAveBlockNum() {
		return aveBlockNum;
	}

	public void setAveBlockNum(double aveBlockNum) {
		this.aveBlockNum = aveBlockNum;
	}

	public double getAveTurnoverNum() {
		return aveTurnoverNum;
	}

	public void setAveTurnoverNum(double aveTurnoverNum) {
		this.aveTurnoverNum = aveTurnoverNum;
	}

	public double getAveFoulNum() {
		return aveFoulNum;
	}

	public void setAveFoulNum(double aveFoulNum) {
		this.aveFoulNum = aveFoulNum;
	}

	public double getAveScore() {
		return aveScore;
	}

	public void setAveScore(double aveScore) {
		this.aveScore = aveScore;
	}

	public double getAveAttackRound() {
		return aveAttackRound;
	}

	public void setAveAttackRound(double aveAttackRound) {
		this.aveAttackRound = aveAttackRound;
	}

	public double getAveAttackEfficiency() {
		return aveAttackEfficiency;
	}

	public void setAveAttackEfficiency(double aveAttackEfficiency) {
		this.aveAttackEfficiency = aveAttackEfficiency;
	}

	public double getAveDefendEfficiency() {
		return aveDefendEfficiency;
	}

	public void setAveDefendEfficiency(double aveDefendEfficiency) {
		this.aveDefendEfficiency = aveDefendEfficiency;
	}

	public double getAveReboundEfficiency() {
		return aveReboundEfficiency;
	}

	public void setAveReboundEfficiency(double aveReboundEfficiency) {
		this.aveReboundEfficiency = aveReboundEfficiency;
	}

	public double getAveStealEfficiency() {
		return aveStealEfficiency;
	}

	public void setAveStealEfficiency(double aveStealEfficiency) {
		this.aveStealEfficiency = aveStealEfficiency;
	}

	public double getAveAssistRate() {
		return aveAssistRate;
	}

	public void setAveAssistRate(double aveAssistRate) {
		this.aveAssistRate = aveAssistRate;
	}

	public ArrayList<MatchVO> getMatchVOList() {
		return matchVOList;
	}

	public void setMatchVOList(ArrayList<MatchVO> matchVOList) {
		this.matchVOList = matchVOList;
	}
	
	
}
