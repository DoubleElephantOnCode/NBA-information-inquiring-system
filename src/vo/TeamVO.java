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
	public String matchNum;
	
	/**
	 * 投篮命中数
	 */
	public int totalScoreNum;
	
	/**
	 * 投篮出手数
	 */
	public int totalShootNum;
	
	/**
	 * 三分命中数
	 */
	public int totalThreePointScoreNum;
	
	/**
	 * 三分出手数
	 */
	public int totalThreePointShootNum;
	
	/**
	 * 罚球命中数
	 */
	public int totalFreeThrowScoreNum;
	
	/**
	 * 罚球出手数
	 */
	public int totalFreeThrowShootNum;
	
	/**
	 * 进攻篮板数
	 */
	public int totalOffensiveReboundsNum;

	
	/**
	 * 防守篮板数
	 */
	public int totalDefensiveReboundsNum;
	
	/**
	 * 总篮板数
	 */
	public int totalTotalReboundsNum;
	
	/**
	 * 助攻数
	 */
	public int totalAssistNum;
	
	/**
	 * 抢断数
	 */
	public int totalStealNum;
	
	/**
	 * 盖帽数
	 */
	public int totalBlockNum;
	
	/**
	 * 失误数
	 */
	public int totalTurnoverNum;
	
	/**
	 * 犯规数
	 */
	public int totalFoulNum;
	
	/**
	 * 比赛得分
	 */
	public int totalScore;
	
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
	
	public void addMatchVO(MatchVO matchVO){
		matchVOList.add(matchVO);
	}
}
