package vo;

import java.sql.Time;

/**
 * 一场比赛里一个球员的数据
 * @author ZSK
 * @data 2015年3月9日 下午4:22:06
 */
public class MatchDataPerPlayerVO {
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
}
