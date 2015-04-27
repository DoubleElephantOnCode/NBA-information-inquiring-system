package vo;

import java.util.Date;


/**
 * 一场比赛里一个球员的数据
 * @author ZSK
 * @data 2015年3月9日 下午4:22:06
 */
public class MatchDataPerPlayerVO {
	/**
	 * 比赛时间
	 */
	public Date timeOfMatch;
	/**
	 * 所属队伍缩写
	 */
	public String teamName;
	
	/**
	 * 比赛双方
	 */
	public String twoSides;
	
	/**
	 * 球员名称
	 */
	public String playerName;
	
	/**
	 * 赛区
	 */
	public String competion;
	
	/**
	 * 分区
	 */
	public String partition;
	
	/**
	 * 位置
	 */
	public String position;
	
	/**
	 * 在场时间
	 */
	public MyPresentTime presentTime;
	
	/**
	 * 在场时间有误
	 */
	public boolean timeHasError = false;
	
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
	 * 抢断数
	 */
	public int stealNum;
	
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

	/**
	 * 该场球队所有球员总上场时间
	 */
	private MyPresentTime timeOfAllPlayers;
	
	/**
	 * 球队总篮板数
	 */
	private double allReboundNum = 0;
	
	/**
	 * 对手总篮板数
	 */
	private double allOpponentRebondNum = 0;
	
	/**
	 * 所属球队总进球数
	 */
	private double allScoreNum;
	
	/**
	 * 球队总进攻篮板数
	 */
	private double allOffReboundNum = 0;
	
	/**
	 * 球队总防守篮板数
	 */
	private double allDefReboundNum = 0;
	
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
	
	public MatchDataPerPlayerVO(String teamName,String twoSides,String playerName, String position,
			MyPresentTime presentTime, int scoreNum, int shootNum,
			int threePointScoreNum, int threePointShootNum,
			int freeThrowScoreNum, int freeThrowShootNum,
			int offensiveReboundsNum, int defensiveReboundsNum,
			int totalReboundsNum, int assistNum, int stealNum,int blockNum, int turnoverNum,
			int foulNum, int personalScore) {
		super();
		this.teamName = teamName;
		this.twoSides = twoSides;
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
		this.stealNum = stealNum;
		this.blockNum = blockNum;
		this.turnoverNum = turnoverNum;
		this.foulNum = foulNum;
		this.personalScore = personalScore;
	}
	
	public MatchDataPerPlayerVO(String teamName,String twoSides,String playerName, String position,
			String presentTime, String scoreNum, String shootNum,
			String threePointScoreNum, String threePointShootNum,
			String freeThrowScoreNum, String freeThrowShootNum,
			String offensiveReboundsNum, String defensiveReboundsNum,
			String totalReboundsNum, String assistNum, String stealNum,String blockNum, String turnoverNum,
			String foulNum, String personalScore) {
		super();
		this.teamName = teamName;
		this.twoSides = twoSides;
		this.playerName = playerName;
		this.position = position;
		//为了处理脏数据
		if(presentTime.equals("null")||presentTime.equals("None")){
		//	System.out.println("time has error 啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
			timeHasError = true;
		}else{
			this.presentTime = new MyPresentTime(presentTime);
		}
				
		this.scoreNum = Integer.parseInt(scoreNum);
		this.shootNum = Integer.parseInt(shootNum);
		this.threePointScoreNum = Integer.parseInt(threePointScoreNum);
		this.threePointShootNum = Integer.parseInt(threePointShootNum);
		this.freeThrowScoreNum = Integer.parseInt(freeThrowScoreNum);
		this.freeThrowShootNum = Integer.parseInt(freeThrowShootNum);
		this.offensiveReboundsNum = Integer.parseInt(offensiveReboundsNum);
		this.defensiveReboundsNum = Integer.parseInt(defensiveReboundsNum);
		this.totalReboundsNum = Integer.parseInt(totalReboundsNum);
		this.assistNum = Integer.parseInt(assistNum);
		this.stealNum = Integer.parseInt(stealNum);
		this.blockNum = Integer.parseInt(blockNum);
		this.turnoverNum = Integer.parseInt(turnoverNum);
		this.foulNum = Integer.parseInt(foulNum);
		//this.personalScore = Integer.parseInt(personalScore);
		this.personalScore = this.threePointScoreNum * 3 + this.freeThrowScoreNum * 1 + (this.scoreNum - this.threePointScoreNum) * 2;
		
		//以下为寻找脏数据  最后要删除 
		if(this.personalScore!=toInt(personalScore)){
		//	System.out.println("error in MatchDataPerPlayer个人得分有问题啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
		}
	}
	
	public int toInt(String s){
		if(s.equals("null")){
			return 0;
		}else{
			return Integer.parseInt(s);
		}
	}

	public String getTwoSides() {
		return twoSides;
	}

	public void setTwoSides(String twoSides) {
		this.twoSides = twoSides;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public MyPresentTime getPresentTime() {
		return presentTime;
	}

	public void setPresentTime(MyPresentTime presentTime) {
		this.presentTime = presentTime;
	}

	public int getScoreNum() {
		return scoreNum;
	}

	public void setScoreNum(int scoreNum) {
		this.scoreNum = scoreNum;
	}

	public int getShootNum() {
		return shootNum;
	}

	public void setShootNum(int shootNum) {
		this.shootNum = shootNum;
	}

	public int getThreePointScoreNum() {
		return threePointScoreNum;
	}

	public void setThreePointScoreNum(int threePointScoreNum) {
		this.threePointScoreNum = threePointScoreNum;
	}

	public int getThreePointShootNum() {
		return threePointShootNum;
	}

	public void setThreePointShootNum(int threePointShootNum) {
		this.threePointShootNum = threePointShootNum;
	}

	public int getFreeThrowScoreNum() {
		return freeThrowScoreNum;
	}

	public void setFreeThrowScoreNum(int freeThrowScoreNum) {
		this.freeThrowScoreNum = freeThrowScoreNum;
	}

	public int getFreeThrowShootNum() {
		return freeThrowShootNum;
	}

	public void setFreeThrowShootNum(int freeThrowShootNum) {
		this.freeThrowShootNum = freeThrowShootNum;
	}

	public int getOffensiveReboundsNum() {
		return offensiveReboundsNum;
	}

	public void setOffensiveReboundsNum(int offensiveReboundsNum) {
		this.offensiveReboundsNum = offensiveReboundsNum;
	}

	public int getDefensiveReboundsNum() {
		return defensiveReboundsNum;
	}

	public void setDefensiveReboundsNum(int defensiveReboundsNum) {
		this.defensiveReboundsNum = defensiveReboundsNum;
	}

	public int getTotalReboundsNum() {
		return totalReboundsNum;
	}

	public void setTotalReboundsNum(int totalReboundsNum) {
		this.totalReboundsNum = totalReboundsNum;
	}

	public int getAssistNum() {
		return assistNum;
	}

	public void setAssistNum(int assistNum) {
		this.assistNum = assistNum;
	}

	public int getStealNum() {
		return stealNum;
	}

	public void setStealNum(int stealNum) {
		this.stealNum = stealNum;
	}
	
	public int getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(int blockNum) {
		this.blockNum = blockNum;
	}

	public int getTurnoverNum() {
		return turnoverNum;
	}

	public void setTurnoverNum(int turnoverNum) {
		this.turnoverNum = turnoverNum;
	}

	public int getFoulNum() {
		return foulNum;
	}

	public void setFoulNum(int foulNum) {
		this.foulNum = foulNum;
	}

	public int getPersonalScore() {
		return personalScore;
	}

	public void setPersonalScore(int personalScore) {
		this.personalScore = personalScore;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public boolean isTimeHasError() {
		return timeHasError;
	}

	public void setTimeHasError(boolean timeHasError) {
		this.timeHasError = timeHasError;
	}

	public MyPresentTime getTimeOfAllPlayers() {
		return timeOfAllPlayers;
	}

	public void setTimeOfAllPlayers(MyPresentTime timeOfAllPlayers) {
		this.timeOfAllPlayers = timeOfAllPlayers;
	}

	public double getAllReboundNum() {
		return allReboundNum;
	}

	public void setAllReboundNum(double allReboundNum) {
		this.allReboundNum = allReboundNum;
	}

	public double getAllOpponentRebondNum() {
		return allOpponentRebondNum;
	}

	public void setAllOpponentRebondNum(double allOpponentRebondNum) {
		this.allOpponentRebondNum = allOpponentRebondNum;
	}

	public double getAllScoreNum() {
		return allScoreNum;
	}

	public void setAllScoreNum(double allScoreNum) {
		this.allScoreNum = allScoreNum;
	}

	public double getAllOffReboundNum() {
		return allOffReboundNum;
	}

	public void setAllOffReboundNum(double allOffReboundNum) {
		this.allOffReboundNum = allOffReboundNum;
	}

	public double getAllDefReboundNum() {
		return allDefReboundNum;
	}

	public void setAllDefReboundNum(double allDefReboundNum) {
		this.allDefReboundNum = allDefReboundNum;
	}

	public double getAllOppOffReboundNum() {
		return allOppOffReboundNum;
	}

	public void setAllOppOffReboundNum(double allOppOffReboundNum) {
		this.allOppOffReboundNum = allOppOffReboundNum;
	}

	public double getAllOppDefReboundNum() {
		return allOppDefReboundNum;
	}

	public void setAllOppDefReboundNum(double allOppDefReboundNum) {
		this.allOppDefReboundNum = allOppDefReboundNum;
	}

	public double getOpponentAttackRound() {
		return opponentAttackRound;
	}

	public void setOpponentAttackRound(double opponentAttackRound) {
		this.opponentAttackRound = opponentAttackRound;
	}

	public double getOppTwoPointShootNum() {
		return oppTwoPointShootNum;
	}

	public void setOppTwoPointShootNum(double oppTwoPointShootNum) {
		this.oppTwoPointShootNum = oppTwoPointShootNum;
	}

	public double getAllShootNum() {
		return allShootNum;
	}

	public void setAllShootNum(double allShootNum) {
		this.allShootNum = allShootNum;
	}

	public double getAllFreeThrowShootNum() {
		return allFreeThrowShootNum;
	}

	public void setAllFreeThrowShootNum(double allFreeThrowShootNum) {
		this.allFreeThrowShootNum = allFreeThrowShootNum;
	}

	public double getAllTurnoverNum() {
		return allTurnoverNum;
	}

	public void setAllTurnoverNum(double allTurnoverNum) {
		this.allTurnoverNum = allTurnoverNum;
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

	public Date getTimeOfMatch() {
		return timeOfMatch;
	}

	public void setTimeOfMatch(Date timeOfMatch) {
		this.timeOfMatch = timeOfMatch;
	}

	
	/**
	 "位置","在场时间","投篮命中数","投篮出手数",
			"三分命中数","三分出手数","罚球命中数","罚 球出手数",
			"进攻篮板数","防守篮板数",
			"总篮板数","助攻数","抢断数","盖帽数","失误 数","犯规数","个人得分" 
	 * @return
	 */
	public String[] getInfo() {
		String[] s = new String[]{
			position,presentTime.minute+":"+presentTime.second,scoreNum+"",shootNum+"",
			threePointScoreNum+"",threePointShootNum+"",freeThrowScoreNum+"",freeThrowShootNum+"",
			offensiveReboundsNum+"",defensiveReboundsNum+"",
			totalReboundsNum+"",assistNum+"",stealNum+"",blockNum+"",turnoverNum+"",foulNum+"",personalScore+""
		};
		return s;
	}
	
	
}
