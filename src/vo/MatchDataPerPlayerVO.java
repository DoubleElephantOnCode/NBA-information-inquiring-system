package vo;


/**
 * 一场比赛里一个球员的数据
 * @author ZSK
 * @data 2015年3月9日 下午4:22:06
 */
public class MatchDataPerPlayerVO {
	/**
	 * 比赛双方
	 */
	public String teamName;
	
	/**
	 * 球员名称
	 */
	public String playerName;
	
	/**
	 * 位置
	 */
	public String position;
	
	/**
	 * 在场时间
	 */
	public MyPresentTime presentTime;
	
	/**
	 * 投篮命中数
	 */
	public int scoreNum;
	
	/**
	 * 投篮出手数
	 */
	public int shootNum;
	
	/**
	 * 三分命中数
	 */
	public int threePointScoreNum;
	
	/**
	 * 三分出手数
	 */
	public int threePointShootNum;
	
	/**
	 * 罚球命中数
	 */
	public int freeThrowScoreNum;
	
	/**
	 * 罚球出手数
	 */
	public int freeThrowShootNum;
	
	/**
	 * 进攻篮板数
	 */
	public int offensiveReboundsNum;

	
	/**
	 * 防守篮板数
	 */
	public int defensiveReboundsNum;
	
	/**
	 * 总篮板数
	 */
	public int totalReboundsNum;
	
	/**
	 * 助攻数
	 */
	public int assistNum;
	
	/**
	 * 盖帽数
	 */
	public int blockNum;
	
	/**
	 * 失误数
	 */
	public int turnoverNum;
	
	/**
	 * 犯规数
	 */
	public int foulNum;
	
	/**
	 * 个人得分
	 */
	public int personalScore;

	public MatchDataPerPlayerVO(String teamName,String playerName, String position,
			MyPresentTime presentTime, int scoreNum, int shootNum,
			int threePointScoreNum, int threePointShootNum,
			int freeThrowScoreNum, int freeThrowShootNum,
			int offensiveReboundsNum, int defensiveReboundsNum,
			int totalReboundsNum, int assistNum, int blockNum, int turnoverNum,
			int foulNum, int personalScore) {
		super();
		this.teamName = teamName;
		this.playerName = playerName;
		this.position = position;
		this.presentTime = presentTime;
		this.scoreNum = scoreNum;
		this.shootNum = shootNum;
		this.threePointScoreNum = threePointScoreNum;
		this.threePointShootNum = threePointShootNum;
		this.freeThrowScoreNum = freeThrowScoreNum;
		this.freeThrowShootNum = freeThrowShootNum;
		this.offensiveReboundsNum = offensiveReboundsNum;
		this.defensiveReboundsNum = defensiveReboundsNum;
		this.totalReboundsNum = totalReboundsNum;
		this.assistNum = assistNum;
		this.blockNum = blockNum;
		this.turnoverNum = turnoverNum;
		this.foulNum = foulNum;
		this.personalScore = personalScore;
	}
	
	
}
