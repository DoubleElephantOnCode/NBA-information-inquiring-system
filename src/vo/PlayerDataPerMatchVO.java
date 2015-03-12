package vo;

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
	private MyPresentTime minutes;
	
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
	
	public PlayerDataPerMatchVO() {
		// TODO Auto-generated constructor stub
	}
	
	public PlayerDataPerMatchVO(MatchDataPerPlayerVO matchData) {
		// TODO Auto-generated constructor stub
		this.playerName = matchData.getPlayerName();
		this.teamName = matchData.getTeamName();
		this.position = matchData.getPosition();
		this.minutes = matchData.getPresentTime();
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
	
	public double getStealNum() {
		return stealNum;
	}

	public String getTwoSides() {
		return twoSides;
	}

	public String getTeamName() {
		return teamName;
	}

	public MyPresentTime getMinutes() {
		return minutes;
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

	
	
}
