package vo;

/**
 * 
 * @author HalaWKS
 * 球员单场数据
 */
public class PlayerDataPerMatchVO {
	
//	球员名 ; 位置; 在场时间; 投篮命中数; 投篮出手数; 三分命中数; 三分出手数; 罚球命中数; 罚
//	球出手数; 进攻（ 前场）篮板数; 防守（ 后场）篮板数; 总篮板数; 助攻数; 盖帽数; 失误数; 犯规 数;
//	个人得分;
	
	/**
	 * 对阵双方
	 */
	String teamName;
	
	/**
	 * 上场时间
	 */
	String minutes;
	
	/**
	 * 投篮命中数
	 */
	double scoreNum;
	
	/**
	 * 投篮出手数
	 */
	double shootNum;
	
	/**
	 * 三分命中数
	 */
	double threePointerScoreNum;
	
	/**
	 * 三分出手数
	 */
	double threePointerShootNum;
	
	/**
	 * 罚球命中数
	 */
	double freeThrowScoreNum;
	
	/**
	 * 罚球出手数
	 */
	double freeThrowShootNum;
	
	/**
	 * 进攻篮板数
	 */
	double offensiveReboundsNum;
	
	/**
	 * 防守篮板数
	 */
	double defensiveReboundsNum;
	
	/**
	 * 总篮板数
	 */
	double totalReboundsNum;
	
	/**
	 * 助攻数
	 */
	double assistNum;
	
	/**
	 * 盖帽数
	 */
	double blockNum;

	/**
	 * 失误数
	 */
	double faultNum;
	
	/**
	 * 犯规数
	 */
	double foulNum;
	
	/**
	 * 个人得分
	 */
	double personalPoints;
	
	/**
	 * 是否两双
	 */
	boolean isDoubleDouble;
	
	public PlayerDataPerMatchVO(MatchDataPerPlayerVO matchData) {
		// TODO Auto-generated constructor stub
	}

	public PlayerDataPerMatchVO(String teamName, String minutes,
			double scoreNum, double shootNum, double threePointerScoreNum,
			double threePointerShootNum, double freeThrowScoreNum,
			double freeThrowShootNum, double offensiveReboundsNum,
			double defensiveReboundsNum, double totalReboundsNum,
			double assistNum, double blockNum, double faultNum, double foulNum,
			double personalPoints, boolean isDoubleDouble) {
		super();
		this.teamName = teamName;
		this.minutes = minutes;
		this.scoreNum = scoreNum;
		this.shootNum = shootNum;
		this.threePointerScoreNum = threePointerScoreNum;
		this.threePointerShootNum = threePointerShootNum;
		this.freeThrowScoreNum = freeThrowScoreNum;
		this.freeThrowShootNum = freeThrowShootNum;
		this.offensiveReboundsNum = offensiveReboundsNum;
		this.defensiveReboundsNum = defensiveReboundsNum;
		this.totalReboundsNum = totalReboundsNum;
		this.assistNum = assistNum;
		this.blockNum = blockNum;
		this.faultNum = faultNum;
		this.foulNum = foulNum;
		this.personalPoints = personalPoints;
		this.isDoubleDouble = isDoubleDouble;
	}
	
}
