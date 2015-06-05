package vo;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * 
 * @author HalaWKS
 * 球员单场数据
 */
public class PlayerDataPerMatchVO {
	
//	球员名y ; 位置y; 在场时间y; 投篮命中数y; 投篮出手数y; 三分命中数y; 三分出手数y; 罚球命中数y; 罚
//	球出手数y; 进攻（ 前场）篮板数y; 防守（ 后场）篮板数y; 总篮板数y; 助攻数y; 盖帽数y; 失误数y; 犯规 数y;
//	个人得分y;
	
	
	/**
	 * 球员姓名
	 */
	private String playerName;
	
	/**
	 * 对阵双方
	 */
	private String twoSides;
	
	/**
	 * 所属赛季
	 */
	private String season;
	
	/**
	 * 是否是季后赛
	 */
	private boolean isPlayoff;
	
	/**
	 * 对手球队名
	 */
	private String rivalTeam;
	
	/**
	 * 球员所属球队
	 */
	private String teamName;
	
	/**
	 * 比赛日期
	 */
	private String matchDate;
	
	/**
	 * 上场位置
	 */
	private String position;
	
	/**
	 * 上场时间
	 */
	private MyPresentTime playTime;
	
	/**
	 * 投篮命中数
	 */
	private double scoreNum = 0;
	
	/**
	 * 投篮出手数
	 */
	private double shootNum = 0;
	
	/**
	 * 三分命中数
	 */
	private double threePointerScoreNum = 0;
	
	/**
	 * 三分出手数
	 */
	private double threePointerShootNum = 0;
	
	/**
	 * 罚球命中数
	 */
	private double freeThrowScoreNum = 0;
	
	/**
	 * 罚球出手数
	 */
	private double freeThrowShootNum = 0;
	
	/**
	 * 进攻篮板数
	 */
	private double offensiveReboundsNum = 0;
	
	/**
	 * 防守篮板数
	 */
	private double defensiveReboundsNum = 0;
	
	/**
	 * 总篮板数
	 */
	private double totalReboundsNum = 0;
	
	/**
	 * 助攻数
	 */
	private double assistNum = 0;
	
	/**
	 * 抢断数
	 */
	private double stealNum = 0;
	
	/**
	 * 盖帽数
	 */
	private double blockNum = 0;

	/**
	 * 失误数
	 */
	private double turnoverNum = 0;
	
	/**
	 * 犯规数
	 */
	private double foulNum = 0;
	
	/**
	 * 个人得分
	 */
	private double personalPoints = 0;
	
	/**
	 * 是否两双
	 */
	private boolean isDoubleDouble = false;
	
	/**
	 * 是否首发
	 */
	private boolean isStarting = false;
	
	/**
	 * 单场投篮命中率
	 */
	private double scoreRate = 0;
	
	/**
	 * 单场三分命中率
	 */
	private double threePointScoreRate = 0;
	
	/**
	 * 单场罚球命中率
	 */
	private double freeThrowScoreRate = 0;
	

	
	/**
	 * 该场球队所有球员总上场时间
	 */
	private MyPresentTime timeOfAllPlayers;
	
	/**
	 * 球队总进球数
	 */
	private double allScoreNum = 0;
	
	/**
	 * 球队总篮板数
	 */
	private double allReboundNum = 0;
	
	/**
	 * 球队总进攻篮板数
	 */
	private double allOffReboundNum = 0;
	
	/**
	 * 球队总防守篮板数
	 */
	private double allDefReboundNum = 0;
	
	/**
	 * 对手总篮板数
	 */
	private double allOpponentRebondNum = 0;
	
	/**
	 * 对手总进攻篮板数
	 */
	private double allOppOffReboundNum = 0;
	
	/**
	 * 对手总防守篮板数
	 */
	private double allOppDefReboundNum = 0;

	/**
	 * 对手进攻回合
	 */
	private double opponentAttackRound = 0;
	
	/**
	 * 对手两分球出手次数
	 */
	private double oppTwoPointShootNum = 0;
	
	/**
	 * 球队所有球员总出手数
	 */
	private double allShootNum = 0;

	/**
	 * 球队所有球员罚球出手数
	 */
	private double allFreeThrowShootNum = 0;

	/**
	 * 球队所有球员失误数
	 */
	private double allTurnoverNum = 0;
	
	public PlayerDataPerMatchVO() {
		// TODO Auto-generated constructor stub
	}
	
	public PlayerDataPerMatchVO(MatchDataPerPlayerVO matchData) {
		// TODO Auto-generated constructor stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.season = matchData.getSeason();
		this.playerName = matchData.getPlayerName();
		this.teamName = matchData.getTeamName();
		this.matchDate = sdf.format(matchData.getTimeOfMatch());
		this.twoSides = matchData.getTwoSides();
		this.season = matchData.getSeason();
		this.isPlayoff = matchData.isPlayoff();
		this.position = matchData.getPosition();
		this.playTime = matchData.getPresentTime();
		this.scoreNum = matchData.getScoreNum();
		this.shootNum = matchData.getShootNum();
		this.threePointerScoreNum = matchData.getThreePointScoreNum();
		this.threePointerShootNum = matchData.getThreePointShootNum();
		this.freeThrowScoreNum = matchData.getFreeThrowScoreNum();
		this.freeThrowShootNum = matchData.getFreeThrowShootNum();
		this.offensiveReboundsNum = matchData.getOffensiveReboundsNum();
		this.defensiveReboundsNum = matchData.getDefensiveReboundsNum();
		this.totalReboundsNum = matchData.getTotalReboundsNum();
		this.assistNum = matchData.getAssistNum();
		this.stealNum = matchData.getStealNum();
		this.blockNum = matchData.getBlockNum();
		this.turnoverNum = matchData.getTurnoverNum();
		this.foulNum = matchData.getFoulNum();
		this.personalPoints = matchData.getPersonalScore();
		this.timeOfAllPlayers = matchData.getTimeOfAllPlayers();
		this.allReboundNum = matchData.getAllReboundNum();
		this.allOpponentRebondNum = matchData.getAllOpponentRebondNum();
		this.allScoreNum = matchData.getAllScoreNum();
		this.allOffReboundNum = matchData.getAllOffReboundNum();
		this.allDefReboundNum = matchData.getAllDefReboundNum();
		this.allOppOffReboundNum = matchData.getAllOppOffReboundNum();
		this.allOppDefReboundNum = matchData.getAllOppDefReboundNum();
		this.opponentAttackRound = matchData.getOpponentAttackRound();
		this.oppTwoPointShootNum = matchData.getOppTwoPointShootNum();
		this.allShootNum = matchData.getAllShootNum();
		this.allFreeThrowShootNum = matchData.getAllFreeThrowShootNum();
		this.allTurnoverNum = matchData.getAllTurnoverNum();
		
		String[] bothTeam = this.twoSides.split("-");
		if(bothTeam[0].equalsIgnoreCase(this.teamName)){
			rivalTeam = bothTeam[1];
		} else {
			rivalTeam = bothTeam[0];
		}
		
		judgeDoubleDouble();
		judgeStarting();
		calAllRate();
	}

	/**
	 * 判断该场比赛是否两双
	 * 两双： 特指得分，篮板，助攻，抢断，盖帽中任何两项
	 */
	private void judgeDoubleDouble(){
		int i = 0;
		if(personalPoints >= 10){
			i++;
		}
		if(totalReboundsNum >= 10){
			i++;
		}
		if(assistNum >= 10){
			i++;
		}
		if(stealNum >= 10){
			i++;
		}
		if(blockNum >= 10){
			i++;
		}
		if(i >= 2){
			isDoubleDouble = true;
		}
	}
	
	/**
	 * 判断该场比赛是否先发
	 */
	private void judgeStarting(){
		//TODO : 是否首发
		if(!position.equals("")){
			isStarting = true;
		}
	}
	
	/**
	 * 计算各种率
	 */
	private void calAllRate(){
		//TODO
		//单场投篮命中率
		if(shootNum != 0.0){
			scoreRate = scoreNum / shootNum;
		}
		//单场三分命中率
		if(threePointerShootNum != 0.0){
			threePointScoreRate = threePointerScoreNum / threePointerShootNum;
		}	
		//罚球命中率
		if(freeThrowShootNum != 0.0){
			freeThrowScoreRate = freeThrowScoreNum / freeThrowShootNum;
		}

	}
	
	/**
	 * 获得单场比赛的信息
	 * 对阵球队, 是否首发, 得分, 助攻, 篮板, 盖帽, 抢断, 失误, 犯规,
	 * 三分命中数, 三分命中率, 罚球命中数, 罚球命中率, 投篮命中率
	 * @return
	 */
	public String[] getMatchInfo(){
		
		//TODO 获得单场比赛的信息
		String[] s = new String[]{
				this.matchDate, this.rivalTeam, isInStartingLineup(this.isStarting),
				(int)personalPoints + "", (int)assistNum + "", (int)totalReboundsNum + "",
				(int)blockNum + "", (int)stealNum + "", (int)turnoverNum + "", (int)foulNum + "",
				(int)threePointerScoreNum + "", toString(this.threePointScoreRate * 100),
				(int)freeThrowScoreNum + "", toString(this.freeThrowScoreRate * 100),
				toString(this.scoreRate * 100)
		};
		return s;
	}
	
	/**
	 * 是否首发
	 * @param isStarting
	 * @return
	 */
	private String isInStartingLineup(boolean isStarting){
		if(isStarting){
			return "是";
		} else {
			return "否";
		}
	}
	
	/**
	 * double数据转String
	 * @param d
	 * @return
	 */
	private String toString(double d){
		DecimalFormat df = new DecimalFormat("#.00");
		String s = df.format(d);
		Double dd = new Double(s);
		return dd.toString();
	}
	
	public double getStealNum() {
		return stealNum;
	}

	public String getTwoSides() {
		return twoSides;
	}

	public String getTeamName() {
		return teamName;
	}

	public MyPresentTime getPlayTime() {
		return playTime;
	}

	public double getScoreNum() {
		return scoreNum;
	}

	public double getShootNum() {
		return shootNum;
	}

	public double getThreePointerScoreNum() {
		return threePointerScoreNum;
	}

	public double getThreePointerShootNum() {
		return threePointerShootNum;
	}

	public double getFreeThrowScoreNum() {
		return freeThrowScoreNum;
	}

	public double getFreeThrowShootNum() {
		return freeThrowShootNum;
	}

	public double getOffensiveReboundsNum() {
		return offensiveReboundsNum;
	}

	public double getDefensiveReboundsNum() {
		return defensiveReboundsNum;
	}

	public double getTotalReboundsNum() {
		return totalReboundsNum;
	}

	public double getAssistNum() {
		return assistNum;
	}

	public double getBlockNum() {
		return blockNum;
	}

	public double getTurnoverNum() {
		return turnoverNum;
	}

	public double getFoulNum() {
		return foulNum;
	}

	public double getPersonalPoints() {
		return personalPoints;
	}

	public boolean isDoubleDouble() {
		return isDoubleDouble;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getPosition() {
		return position;
	}

	public boolean isStarting() {
		return isStarting;
	}

	public double getScoreRate() {
		return scoreRate;
	}

	public double getThreePointScoreRate() {
		return threePointScoreRate;
	}

	public double getFreeThrowScoreRate() {
		return freeThrowScoreRate;
	}

//	public double getEfficiency() {
//		return efficiency;
//	}
//
//	public double getGmSc() {
//		return GmSc;
//	}
//
//	public double getTrueShootingPercentage() {
//		return trueShootingPercentage;
//	}
//
//	public double getShootingEfficiency() {
//		return shootingEfficiency;
//	}
//
//	public double getReboundRate() {
//		return reboundRate;
//	}
//
//	public double getOffensiveReboundRate() {
//		return offensiveReboundRate;
//	}
//
//	public double getDefensiveReboundRate() {
//		return defensiveReboundRate;
//	}
//
//	public double getAssistRate() {
//		return assistRate;
//	}
//
//	public double getStealRate() {
//		return stealRate;
//	}
//
//	public double getBlockRate() {
//		return blockRate;
//	}
//
//	public double getTurnoverRate() {
//		return turnoverRate;
//	}
//
//	public double getUseRate() {
//		return useRate;
//	}

	public MyPresentTime getTimeOfAllPlayers() {
		return timeOfAllPlayers;
	}

	public double getAllScoreNum() {
		return allScoreNum;
	}

	public double getAllReboundNum() {
		return allReboundNum;
	}

	public double getAllOffReboundNum() {
		return allOffReboundNum;
	}

	public double getAllDefReboundNum() {
		return allDefReboundNum;
	}

	public double getAllOpponentRebondNum() {
		return allOpponentRebondNum;
	}

	public double getAllOppOffReboundNum() {
		return allOppOffReboundNum;
	}

	public double getAllOppDefReboundNum() {
		return allOppDefReboundNum;
	}

	public double getOpponentAttackRound() {
		return opponentAttackRound;
	}

	public double getOppTwoPointShootNum() {
		return oppTwoPointShootNum;
	}

	public double getAllShootNum() {
		return allShootNum;
	}

	public double getAllFreeThrowShootNum() {
		return allFreeThrowShootNum;
	}

	public double getAllTurnoverNum() {
		return allTurnoverNum;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public String getSeason() {
		return season;
	}

	public boolean isPlayoff() {
		return isPlayoff;
	}

	public String getRivalTeam() {
		return rivalTeam;
	}

	
	
}
