package vo;

import sun.jdbc.odbc.OdbcDef;

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
	 * 球员所属球队
	 */
	private String teamName;
	
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
	private double scoreNum;
	
	/**
	 * 投篮出手数
	 */
	private double shootNum;
	
	/**
	 * 三分命中数
	 */
	private double threePointerScoreNum;
	
	/**
	 * 三分出手数
	 */
	private double threePointerShootNum;
	
	/**
	 * 罚球命中数
	 */
	private double freeThrowScoreNum;
	
	/**
	 * 罚球出手数
	 */
	private double freeThrowShootNum;
	
	/**
	 * 进攻篮板数
	 */
	private double offensiveReboundsNum;
	
	/**
	 * 防守篮板数
	 */
	private double defensiveReboundsNum;
	
	/**
	 * 总篮板数
	 */
	private double totalReboundsNum;
	
	/**
	 * 助攻数
	 */
	private double assistNum;
	
	/**
	 * 抢断数
	 */
	private double stealNum;
	
	/**
	 * 盖帽数
	 */
	private double blockNum;

	/**
	 * 失误数
	 */
	private double turnoverNum;
	
	/**
	 * 犯规数
	 */
	private double foulNum;
	
	/**
	 * 个人得分
	 */
	private double personalPoints;
	
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
	 * 单场效率：(得分+篮板+助攻+抢断+盖帽) -（出手次数-命中次数） -（罚球次数-罚球命中次数） -失误次数
	 */
	private double efficiency = 0;
	
	/**
	 * GmSc 效率值： 得分 + 0.4×投篮命中数 - 0.7×投篮出手数-0.4×(罚球出手数-罚球命中数) +
	 *  0.7×前场篮板数 + 0.3×后场篮板数 + 抢断数 + 0.7×助攻数 + 0.7× 盖帽数 - 0.4×犯规数 - 失误数
	 */
	private double GmSc = 0;
	
	/**
	 * 真实命中率: 得分÷(2×(投篮出手数+0.44×罚球出手数))
	 */
	private double trueShootingPercentage = 0;
	
	/**
	 * 投篮效率： (投篮命中数+0.5×三分命中数)÷投篮出手数
	 */
	private double shootingEfficiency = 0;
	
	/**
	 * 篮板率：球员篮板数×(球队所有球员上场时间÷5)÷球员上场时间÷(球队总篮板+对手总篮板)
	 */
	private double reboundRate = 0;
	
	/**
	 * 进攻篮板率：球员进攻篮板数×(球队所有球员上场时间÷5)÷球员上场时间÷(球队总进攻篮板+对手总进攻篮板)
	 */
	private double offensiveReboundRate = 0;
	
	/**
	 * 防守篮板率：球员防守篮板数×(球队所有球员上场时间÷5)÷球员上场时间÷(球队总防守篮板+对手总防守篮板)
	 */
	private double defensiveReboundRate = 0;
	
	/**
	 * 助攻率：球员助攻数÷(球员上场时间÷(球队所有球员上场时间÷5)×球队总进球数-球员进球数)
	 */
	private double assistRate = 0;
	
	/**
	 * 抢断率：球员抢断数×(球队所有球员上场时间÷5)÷球员上场时间÷对手进攻次数)
	 */
	private double stealRate = 0;
	
	/**
	 * 盖帽率：球员盖帽数×(球队所有球员上场时间÷5)÷球员上场时间÷对手两分球出手次数
	 */
	private double blockRate = 0;
	
	/**
	 * 失误率：球员失误数÷(球员两分球出手次数+0.44×球员罚球次数+球员失误数)
	 */
	private double turnoverRate = 0;
	
	/**
	 * 使用率：(球员出手次数+0.44×球员罚球次数+球员失误次数)×(球队所有球员上场时间÷5)÷
	 *      球员上场时间÷(球队所有总球员出手次数+0.44×球队所有球员罚球次数+球队所有球员失误次数)
	 */
	private double useRate = 0;
//	球员名称y，所属球队y，参赛场数y，先发场数y，篮板数y，助攻数y，在
//	场时间，投篮命中率y，三分命中率y，罚球命中率y，效率y， GmSc 效率值y，真实命中率y，投篮效率y，
//	篮板率y，进攻篮板率，防守篮板率，助攻率，抢断率，盖帽率，失误率，使用率
//	等， 并且可以依据以上数据中的任何一项对全部数据进行升降序操作
	
	/**
	 * 该场球队所有球员总上场时间
	 */
	private MyPresentTime timeOfAllPlayers;
	
	/**
	 * 球队总进球数
	 */
	private double allScoreNum;
	
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
		this.playerName = matchData.getPlayerName();
		this.teamName = matchData.getTeamName();
		this.twoSides = matchData.getTwoSides();
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
		
		judgeDoubleDouble();
		judgeStarting();
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
		if(position != ""){
			isStarting = true;
		}
	}
	
	/**
	 * 计算各种率
	 */
	private void calAllRate(){
		//TODO
		//单场投篮命中率
		scoreRate = scoreNum / shootNum;
		//单场三分命中率
		threePointScoreRate = threePointerScoreNum / threePointerShootNum;
		//罚球命中率
		freeThrowScoreRate = freeThrowScoreNum / freeThrowShootNum;
		//效率
		efficiency = (personalPoints + totalReboundsNum + assistNum + stealNum + blockNum) - 
				(shootNum - scoreNum) - (freeThrowShootNum - freeThrowScoreNum) - turnoverNum;
		//GmSc
		GmSc = personalPoints + 0.4 * scoreNum - 0.7 * shootNum -
				0.4 * (freeThrowShootNum - freeThrowScoreNum) + 0.7 * offensiveReboundsNum + 
				0.3 * defensiveReboundsNum + stealNum + 0.7 * assistNum + 0.7 * blockNum - 
				0.4 * foulNum - turnoverNum;
		//真实投篮命中率 = 得分÷(2×(投篮出手数+0.44×罚球出手数))
		trueShootingPercentage = personalPoints / (2 * (shootNum + 0.44 * freeThrowShootNum));
		//投篮效率 = (投篮命中数+0.5×三分命中数)÷投篮出手数
		shootingEfficiency = (scoreNum + 0.5 * threePointerScoreNum) / shootNum;
		//篮板率 = 球员篮板数×(球队所有球员上场时间÷5)÷球员上场时间÷(球队总篮板+对手总篮板)
		reboundRate = totalReboundsNum * (timeOfAllPlayers.getTimeByMinute() / 5) / 
				playTime.getTimeByMinute() / (allReboundNum + allOpponentRebondNum);
		//进攻篮板率 = 球员进攻篮板数×(球队所有球员上场时间÷5)÷球员上场时间÷(球队总进攻篮板+对手总进攻篮板)
		offensiveReboundRate = offensiveReboundsNum * (timeOfAllPlayers.getTimeByMinute() / 5) / 
				playTime.getTimeByMinute() / (allOffReboundNum + allOppOffReboundNum);
		//防守篮板率 = 球员防守篮板数×(球队所有球员上场时间÷5)÷球员上场时间÷(球队总防守篮板+对手总防守篮板)
		defensiveReboundRate = defensiveReboundsNum * (timeOfAllPlayers.getTimeByMinute() / 5) / 
				playTime.getTimeByMinute() / (allDefReboundNum + allOppDefReboundNum);
		//助攻率 = 球员助攻数÷(球员上场时间÷(球队所有球员上场时间÷5)×球队总进球数-球员进球数)
		assistRate = assistNum / (playTime.getTimeByMinute() /
				(timeOfAllPlayers.getTimeByMinute() / 5) * allScoreNum - scoreNum);
		//抢断率 = 球员抢断数×(球队所有球员上场时间÷5)÷球员上场时间÷对手进攻次数
		stealRate = stealNum * (timeOfAllPlayers.getTimeByMinute() / 5) / 
				playTime.getTimeByMinute() / opponentAttackRound;
		//盖帽率 = 球员盖帽数×(球队所有球员上场时间÷5)÷球员上场时间÷对手两分球出手次数
		blockRate = blockNum * (timeOfAllPlayers.getTimeByMinute() / 5) / 
				playTime.getTimeByMinute() / oppTwoPointShootNum;
		//失误率 = 球员失误数÷(球员两分球出手次数+0.44×球员罚球次数+球员失误数)
		turnoverRate = turnoverNum / (shootNum - threePointerShootNum +
				0.44 * freeThrowShootNum + turnoverNum);
		//使用率 = (球员出手次数+0.44×球员罚球次数+球员失误次数)×(球队所有球员上场时间÷5)÷
		//        球员上场时间÷(球队所有总球员出手次数+0.44×球队所有球员罚球次数+球队所有球员失误次数)
		useRate = (shootNum / 0.44 * freeThrowShootNum + turnoverNum) *
				(timeOfAllPlayers.getTimeByMinute() / 5) / playTime.getTimeByMinute() / 
				(allShootNum + 0.44 * allFreeThrowShootNum + allTurnoverNum );
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

	public double getEfficiency() {
		return efficiency;
	}

	public double getGmSc() {
		return GmSc;
	}

	public double getTrueShootingPercentage() {
		return trueShootingPercentage;
	}

	public double getShootingEfficiency() {
		return shootingEfficiency;
	}

	public double getReboundRate() {
		return reboundRate;
	}

	public double getOffensiveReboundRate() {
		return offensiveReboundRate;
	}

	public double getDefensiveReboundRate() {
		return defensiveReboundRate;
	}

	public double getAssistRate() {
		return assistRate;
	}

	public double getStealRate() {
		return stealRate;
	}

	public double getBlockRate() {
		return blockRate;
	}

	public double getTurnoverRate() {
		return turnoverRate;
	}

	public double getUseRate() {
		return useRate;
	}

	
	
}
