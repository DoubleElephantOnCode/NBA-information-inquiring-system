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
	public int shootingNumber;
	
	/**
	 * 投篮出手数
	 */
	public int shotNumber;
	
	/**
	 * 三分命中数
	 */
	public int threePointShootingNumber;
	
	/**
	 * 三分出手数
	 */
	public int threePointShotNumber;
	
	/**
	 * 罚球命中数
	 */
	public int freeThrowShootingNumber;
	
	/**
	 * 罚球出手数
	 */
	public int freeThrowShotNumber;
	
	/**
	 * 进攻篮板数
	 */
	public int offensiveReboundsNumber;

	
	/**
	 * 防守篮板数
	 */
	public int defensiveReboundsNumber;
	
	/**
	 * 总篮板数
	 */
	public int totalReboundsNumber;
	
	/**
	 * 助攻数
	 */
	public int assistNumber;
	
	/**
	 * 盖帽数
	 */
	public int blockNumber;
	
	/**
	 * 失误数
	 */
	public int turnoverNumber;
	
	/**
	 * 犯规数
	 */
	public int foulNumber;
	
	/**
	 * 个人得分
	 */
	public int personalScore;
}
