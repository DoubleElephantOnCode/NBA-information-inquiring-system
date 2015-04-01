package vo;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

import constant.FilePath;


/**
 * 
 * @author HalaWKS
 * @date 2015年3月9日 下午4:21:51
 *
 */
public class PlayerVO {
	
	/**
	 * 参赛场数
	 */
	private int entryNum = 0;
	
	/**
	 * 首发场数
	 */
	private int startingNum = 0;
	
	/**
	 * 球员全身照(图片路径)
	 */
	private String action = FilePath.playerActionPath;
	
	/**
	 * 球员半身照(图片路径)
	 */
	private String portrait = FilePath.playerPortaitPath;
	
	/**
	 * 所属球队
	 */
	private String teamName = "";
	
	/**
	 * 赛区（东、西部）
	 */
	private String competion = "";
	
	/**
	 * 各自赛区内分区
	 */
	private String partition = "";
	
	/**
	 * 球员姓名
	 */
	private String name = "";
	
	/**
	 * 球员号码
	 */
	private String number;
	
	/**
	 * 球员位置
	 */
	private String position = "";
	
	/**
	 * 球员身高
	 */
	private String height;
	
	/**
	 * 球员体重
	 */
	private String weight;
	
	/**
	 * 球员生日
	 */
	private String birthday;
	
	/**
	 * 球员年龄
	 */
	private String age;
	
	/**
	 * 球员球龄
	 */
	private String exp;
	
	/**
	 * 毕业学校
	 */
	private String school;
	
	/**
	 * 球员单场数据列表
	 */
	private ArrayList<PlayerDataPerMatchVO> dataPerMatchList = new ArrayList<PlayerDataPerMatchVO>();
	
	/**
	 * 两双次数(得分，篮板，助攻，抢断，盖帽中任何两项)
	 */
	private int doubleDouble = 0;
	
	/**
	 * 场均上场时间
	 */
	private MyPresentTime aveMinutes = new MyPresentTime(0, 0);
	
	/**
	 * 场均投篮命中数
	 */
	private double aveScoreNum = 0;
	
	/**
	 * 场均投篮出手数
	 */
	private double aveShootNum = 0;
	
	/**
	 * 场均三分命中数
	 */
	private double aveThreePointerScoreNum = 0;
	
	/**
	 * 场均三分出手数
	 */
	private double aveThreePointerShootNum = 0;
	
	/**
	 * 场均罚球命中数
	 */
	private double aveFreeThrowScoreNum = 0;
	
	/**
	 * 场均罚球出手数
	 */
	private double aveFreeThrowShootNum = 0;
	
	/**
	 * 场均进攻篮板数
	 */
	private double aveOffensiveReboundsNum = 0;
	
	/**
	 * 场均防守篮板数
	 */
	private double aveDefensiveReboundsNum = 0;
	
	/**
	 * 场均总篮板数
	 */
	private double aveTotalReboundsNum = 0;
	
	/**
	 * 场均助攻数
	 */
	private double aveAssistNum = 0;
	
	/**
	 * 场均抢断数
	 */
	private double aveStealNum = 0;
	
	/**
	 * 场均盖帽数
	 */
	private double aveBlockNum = 0;

	/**
	 * 场均失误数
	 */
	private double aveTurnoverNum = 0;
	
	/**
	 * 场均犯规数
	 */
	private double aveFoulNum = 0;
	
	/**
	 * 场均个人得分
	 */
	private double avePersonalPoints = 0;
	
	
	/**
	 * 赛季总上场时间
	 */
	private MyPresentTime totalMinutes = new MyPresentTime(0, 0);
	
	/**
	 * 赛季总命中数
	 */
	private double scoreNum = 0;
	
	/**
	 * 赛季总出手数
	 */
	private double shootNum = 0;
	
	/**
	 * 赛季总三分命中数
	 */
	private double threePointerScoreNum = 0;
	
	/**
	 * 赛季总三分出手数
	 */
	private double threePointerShootNum = 0;
	
	/**
	 * 赛季总罚球命中数
	 */
	private double freeThrowScoreNum = 0;
	
	/**
	 * 赛季总罚球出手数
	 */
	private double freeThrowShootNum = 0;
	
	/**
	 * 赛季总进攻篮板数
	 */
	private double offensiveReboundsNum = 0;
	
	/**
	 * 赛季总防守篮板数
	 */
	private double defensiveReboundsNum = 0;
	
	/**
	 * 赛季总篮板数
	 */
	private double totalReboundsNum = 0;
	
	/**
	 * 赛季总助攻数
	 */
	private double assistNum = 0;
	
	/**
	 * 赛季总抢断数
	 */
	private double stealNum = 0;
	
	/**
	 * 赛季总盖帽数
	 */
	private double blockNum = 0;
	
	/**
	 * 赛季总失误数
	 */
	private double turnoverNum = 0;
	
	/**
	 * 赛季总犯规数
	 */
	private double foulNum = 0;
	
	/**
	 * 赛季总得分
	 */
	private double personalPoints = 0;
	
	/**
	 * 投篮命中率
	 */
	private double scoreRate = 0;
	

	/**
	 * 三分命中率
	 */
	private double threePointScoreRate = 0;
	
	/**
	 * 罚球命中率
	 */
	private double freeThrowScoreRate = 0;
	
	/**
	 * 效率：(得分+篮板+助攻+抢断+盖帽) -（出手次数-命中次数） -（罚球次数-罚球命中次数） -失误次数
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
	
	/**
	 * 近五场得分提升
	 */
	private double recentPointAdvance = 0;
	
	/**
	 * 近五场篮板提升
	 */
	private double recentReboundAdvance = 0;
	
	/**
	 * 近五场助攻提升
	 */
	private double recentAssistAdvance = 0;
	
//	球员名称y，所属球队y，参赛场数y，先发场数y，篮板数y，助攻数y，在
//	场时间，投篮命中率，三分命中率，罚球命中率，抢断数，盖
//	帽数，失误数，犯规数， 得分，效率， GmSc 效率值，真实命中率，投篮效率，
//	篮板率，进攻篮板率，防守篮板率，助攻率，抢断率，盖帽率，失误率，使用率
//	等， 并且可以依据以上数据中的任何一项对全部数据进行升降序操作
	
	/**
	 * 球队所有球员总上场时间
	 */
	private MyPresentTime timeOfAllPlayers = new MyPresentTime(0, 0);
	
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
	
	public PlayerVO() {
		// TODO Auto-generated constructor stub
	}
	
	public PlayerVO(String name, String number, String position, String height, String weight,
			String birthday, String age, String exp, String school) {
		// TODO Auto-generated constructor stub
//		dataPerMatchList = new ArrayList<PlayerDataPerMatchVO>();
		
		action = action + name;
		portrait = portrait + name;
		
		this.name = name;
		this.number = number;
		this.position = position;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;
		this.age = age;
		this.exp = exp;
		this.school = school;

		
	}

	/**
	 * 统计该球员赛季单场数据(向数据列表中添加一条数据)
	 */
	public void addDataPerMatchList(MatchDataPerPlayerVO matchData) {
		//TODO
		PlayerDataPerMatchVO pvo = new PlayerDataPerMatchVO(matchData);
		dataPerMatchList.add(pvo);
		
		//所属球队
		teamName = matchData.getTeamName();
		//东、西赛区
		competion = matchData.getCompetion();
		//赛区内分区
		partition = matchData.getPartition();
		//两双次数
		if(pvo.isDoubleDouble()){
			doubleDouble++;
		}
		//首发次数
		if(pvo.isStarting()){
			startingNum++;
		}
		//总上场时间
		totalMinutes = totalMinutes.add(pvo.getPlayTime());
		//总投篮命中数
		scoreNum = scoreNum + pvo.getScoreNum();
		//总出手数
		shootNum = shootNum + pvo.getShootNum();
		//总三分命中数
		threePointerScoreNum = threePointerScoreNum + pvo.getThreePointerScoreNum();
		//总三分出手数
		threePointerShootNum = threePointerShootNum + pvo.getThreePointerShootNum();
		//总罚球命中数
		freeThrowScoreNum = freeThrowScoreNum + pvo.getFreeThrowScoreNum();
		//总罚球出手数
		freeThrowShootNum = freeThrowShootNum + pvo.getFreeThrowShootNum();
		//总进攻篮板数
		offensiveReboundsNum = offensiveReboundsNum + pvo.getOffensiveReboundsNum();
		//总防守篮板数
		defensiveReboundsNum = defensiveReboundsNum + pvo.getDefensiveReboundsNum();
		//总篮板数
		totalReboundsNum = totalReboundsNum + pvo.getTotalReboundsNum();
		//总助攻数
		assistNum = assistNum + pvo.getAssistNum();
		//总抢断数
		stealNum = stealNum + pvo.getStealNum();
		//总盖帽数
		blockNum = blockNum + pvo.getBlockNum();
		//总犯规数
		turnoverNum = turnoverNum + pvo.getTurnoverNum();
		//总失误数
		foulNum = foulNum + pvo.getFoulNum();
		//个人总得分
		personalPoints = personalPoints + pvo.getPersonalPoints();
		
		timeOfAllPlayers = timeOfAllPlayers.add(pvo.getTimeOfAllPlayers());
		allScoreNum += pvo.getAllScoreNum();
		allReboundNum += pvo.getAllReboundNum();
		allOffReboundNum += pvo.getAllOffReboundNum();
		allDefReboundNum += pvo.getAllDefReboundNum();
		allOpponentRebondNum += pvo.getAllOpponentRebondNum();
		allOppOffReboundNum += pvo.getAllOppOffReboundNum();
		allOppDefReboundNum += pvo.getAllOppDefReboundNum();
		opponentAttackRound += pvo.getOpponentAttackRound();
		oppTwoPointShootNum += pvo.getOppTwoPointShootNum();
		allShootNum += pvo.getAllShootNum();
		allFreeThrowShootNum += pvo.getAllFreeThrowShootNum();
		allTurnoverNum = pvo.getAllTurnoverNum();
		
		//计算参赛场数
		calEntryNum();
		calAveData();
		calAllRate();
		calRecentAdvance();
	}

	/**
	 * 计算各种率(所有场次)
	 */
	public void calAllRate(){
		//TODO 计算各种率

		//赛季投篮命中率
		scoreRate = scoreNum / shootNum;
		//赛季三分命中率
		if(threePointerShootNum != 0.0){
			threePointScoreRate = threePointerScoreNum / threePointerShootNum;
		}
		//赛季罚球命中率
		if(freeThrowShootNum != 0.0){
			freeThrowScoreRate = freeThrowScoreNum / freeThrowShootNum;
		}
		//赛季效率：(得分+篮板+助攻+抢断+盖帽) -（出手次数-命中次数） -（罚球次数-罚球命中次数） -失误次数
		efficiency = (avePersonalPoints + aveTotalReboundsNum + aveAssistNum + aveStealNum +
				aveBlockNum) - (aveShootNum - aveScoreNum) - aveTurnoverNum;
		//GmSc 效率值： 得分 + 0.4×投篮命中数 - 0.7×投篮出手数-0.4×(罚球出手数-罚球命中数) + 0.7×前场篮板数 +
		//0.3×后场篮板数 + 抢断数 + 0.7×助攻数 + 0.7× 盖帽数 - 0.4×犯规数 - 失误数
		GmSc = avePersonalPoints + 0.4 * aveScoreNum - 0.7 * aveShootNum -
				0.4 * (aveFreeThrowShootNum - aveFreeThrowScoreNum) +
				0.7 * aveOffensiveReboundsNum + 0.3 * aveDefensiveReboundsNum +
				aveStealNum + 0.7 * aveAssistNum + 0.7 * aveBlockNum - aveTurnoverNum;
		//真实命中率: 得分÷(2×(投篮出手数+0.44×罚球出手数))
		trueShootingPercentage = avePersonalPoints / (2 * (aveShootNum + 
				0.44 * aveFreeThrowShootNum));
		//投篮效率： (投篮命中数+0.5×三分命中数)÷投篮出手数
		shootingEfficiency = (aveScoreNum + 0.5 * aveThreePointerScoreNum) / aveShootNum;
		//篮板率：球员篮板数×(球队所有球员上场时间÷5)÷球员上场时间÷(球队总篮板+对手总篮板)
		reboundRate = totalReboundsNum *
				(timeOfAllPlayers.getTimeByMinute() / 5) / totalMinutes.getTimeByMinute() / 
				(allReboundNum + allOpponentRebondNum);
		//进攻篮板率：球员进攻篮板数×(球队所有球员上场时间÷5)÷球员上场时间÷(球队总进攻篮板+对手总进攻篮板)
		offensiveReboundRate = offensiveReboundsNum * 
				(timeOfAllPlayers.getTimeByMinute() / 5) / totalMinutes.getTimeByMinute() / 
				(allOffReboundNum + allOppOffReboundNum);
		//防守篮板率：球员防守篮板数×(球队所有球员上场时间÷5)÷球员上场时间÷(球队总防守篮板+对手总防守篮板)
		defensiveReboundRate = defensiveReboundsNum * 
				(timeOfAllPlayers.getTimeByMinute() / 5) / totalMinutes.getTimeByMinute() /
				(allDefReboundNum + allOppDefReboundNum);
		//助攻率：球员助攻数÷(球员上场时间÷(球队所有球员上场时间÷5)×球队总进球数-球员进球数)
		assistRate = assistNum / (totalMinutes.getTimeByMinute() /
				(timeOfAllPlayers.getTimeByMinute() / 5) * allScoreNum - scoreNum);
		//抢断率：球员抢断数×(球队所有球员上场时间÷5)÷球员上场时间÷对手进攻次数
		stealRate = stealNum * (timeOfAllPlayers.getTimeByMinute() / 5) / 
				totalMinutes.getTimeByMinute() / opponentAttackRound;
		//盖帽率：球员盖帽数×(球队所有球员上场时间÷5)÷球员上场时间÷对手两分球出手次数
		blockRate = blockNum * (timeOfAllPlayers.getTimeByMinute() / 5) / 
				totalMinutes.getTimeByMinute() / oppTwoPointShootNum;
		//失误率：球员失误数÷(球员两分球出手次数+0.44×球员罚球次数+球员失误数)
		turnoverRate = turnoverNum / ((shootNum - threePointerShootNum)
				+ 0.44 * freeThrowShootNum + turnoverNum);
		//使用率：(球员出手次数+0.44×球员罚球次数+球员失误次数)×(球队所有球员上场时间÷5)÷
		//球员上场时间÷(球队所有总球员出手次数+0.44×球队所有球员罚球次数+球队所有球员失误次数)
		useRate = (shootNum + 0.44 * freeThrowShootNum + turnoverNum) *
				(timeOfAllPlayers.getTimeByMinute() / 5) / totalMinutes.getTimeByMinute() / 
				(allShootNum + 0.44 * allFreeThrowShootNum + allTurnoverNum);
		
	}
	
	/**
	 * 计算场均数据
	 */
	public void calAveData(){
		double matchNum = dataPerMatchList.size();
		
		aveMinutes = MyPresentTime.toTimeFormat(totalMinutes.getTimeByMinute() / matchNum);
		aveScoreNum = scoreNum / matchNum;
		aveShootNum = shootNum / matchNum;
		aveThreePointerScoreNum = threePointerScoreNum / matchNum;
		aveThreePointerShootNum = threePointerShootNum / matchNum;
		aveFreeThrowScoreNum = freeThrowScoreNum / matchNum;
		aveFreeThrowShootNum = freeThrowShootNum / matchNum;
		aveOffensiveReboundsNum = offensiveReboundsNum / matchNum;
		aveDefensiveReboundsNum = defensiveReboundsNum / matchNum;
		aveTotalReboundsNum = totalReboundsNum / matchNum;
		aveAssistNum = assistNum / matchNum;
		aveStealNum = stealNum / matchNum;
		aveBlockNum = blockNum / matchNum;
		aveTurnoverNum = turnoverNum / matchNum;
		aveFoulNum = foulNum / matchNum;
		avePersonalPoints = personalPoints / matchNum;
	}
	
	/**
	 * 计算近五场提升
	 * 该球员五场前的平均得分是 A，最近五场的评均得分是 B，近五场的提升为： (B-A)/A
	 */
	private void calRecentAdvance(){
		//TODO: 计算近五场提升
		double[] preAveList = null;
		double[] nowAveList = null;
		double preAvePoint = 0;
		double preAveRebound = 0;
		double preAveAssist = 0;
		double nowAvePoint = 0;
		double nowAveRebound = 0;
		double nowAveAssist = 0;
		//赛季比赛场数
		double matchNum = dataPerMatchList.size();
		if(matchNum > 5){
			preAveList = aveData(0, dataPerMatchList.size() - 5);
			nowAveList = aveData(dataPerMatchList.size() - 5, dataPerMatchList.size());
			preAvePoint = preAveList[0];
			preAveRebound = preAveList[1];
			preAveAssist = preAveList[2];
			nowAvePoint = nowAveList[0];
			nowAveRebound = nowAveList[1];
			nowAveAssist = nowAveList[2];
			
			recentPointAdvance = (nowAvePoint - preAvePoint) / preAvePoint;
			recentReboundAdvance = (nowAveRebound - preAveRebound) / preAveRebound;
			recentAssistAdvance = (nowAveAssist - preAveAssist) / preAveAssist;
		}

	}
	
	private double[] aveData(int low, int high){
		double[] aveList = new double[3];
		double avePoint = 0;
		double aveRebound = 0;
		double aveAssist = 0;
		for (int i = low; i < high; i++) {
			avePoint += dataPerMatchList.get(i).getPersonalPoints();
			aveRebound += dataPerMatchList.get(i).getTotalReboundsNum();
			aveAssist += dataPerMatchList.get(i).getAssistNum();
		}
		avePoint = avePoint / (high - low);
		aveRebound = aveRebound / (high - low);
		aveAssist = aveAssist / (high - low);
		aveList[0] = avePoint;
		aveList[1] = aveRebound;
		aveList[2] = aveAssist;
		return aveList;
	}
	
	/**
	 * 获取球员全身照
	 * @return
	 */
	public File getPlayerAction(){
		File actionFile = new File(action);
		return actionFile;
	}
	
	/**
	 * 获取球员半身照
	 * @return
	 */
	public File getPlayerPortrait(){
		File portraitFile = new File(portrait);
		return portraitFile;
	}

	/**
	 * 计算参赛场数
	 */
	private void calEntryNum(){
		entryNum = dataPerMatchList.size();
	}

	
	/**
	 * 获得String类型的球员信息
	 * 	"姓名","所属球队", "位置", "参赛场数", "先发场数", "两双次数", "总上场时间", "场均上场时间",
	 * "总篮板", "场均篮板", "总进攻篮板", "场均进攻篮板", "总防守篮板", "场均防守篮板", "总助攻", "场均助攻",
	 * "投篮命中率", "三分命中率", "罚球命中率", "赛季总抢断", "场均抢断", "赛季总盖帽", "场均盖帽",
	 * "赛季总失误数", "场均失误数", "赛季总犯规数", "场均犯规数", "赛季总得分", "场均得分",
	 * "效率", "GmSc效率值", "真实命中率", "投篮效率", "篮板率", "进攻篮板率", "防守篮板率",
	 * "助攻率", "抢断率", "盖帽率", "失误率", "使用率"
	 * @return
	 */
	public String[] getPlayerInfo(){
		
//		System.out.println("totalMinutes = " + this.totalMinutes.getTimeByMinute());
//		System.out.println("matchNum = " + this.entryNum);
//		System.out.println("aveMinutes = " + this.aveMinutes.getTimeByMinute());
//		System.out.println("assistRate = " + this.assistRate);
//		System.out.println("stealRate = " + this.stealRate);
//		System.out.println("对手两分球出手  = " + this.oppTwoPointShootNum);
//		System.out.println("blockRate = " + this.blockRate);
//		System.out.println("name:" + this.name);
//		System.out.println("三分命中率 = " + this.threePointScoreRate);
//		System.out.println("罚球命中率 = " + this.freeThrowScoreRate);
//		System.out.println("赛区 = " + this.competion);
//		System.out.println("分区 = " + this.partition);
		
		String[] s = new String[]{
				name, teamName, position, entryNum + "", startingNum + "", doubleDouble + "",
				toString(totalMinutes.getTimeByMinute()), toString(aveMinutes.getTimeByMinute()),
				"" + (int)totalReboundsNum, toString(aveTotalReboundsNum),
				"" + (int)offensiveReboundsNum, toString(aveOffensiveReboundsNum),
				"" + (int)defensiveReboundsNum, toString(aveDefensiveReboundsNum),
				"" + (int)assistNum, toString(aveAssistNum), toString(scoreRate * 100),
				toString(threePointScoreRate * 100), toString(freeThrowScoreRate * 100),
				"" + (int)stealNum, toString(aveStealNum), "" + (int)blockNum, toString(aveBlockNum),
				"" + (int)turnoverNum, toString(aveTurnoverNum), "" + (int)foulNum, toString(aveFoulNum),
				"" + (int)personalPoints, toString(avePersonalPoints), toString(efficiency),
				toString(GmSc), toString(trueShootingPercentage), toString(shootingEfficiency),
				toString(reboundRate), toString(offensiveReboundRate), toString(defensiveReboundRate),
				toString(assistRate), toString(stealRate), toString(blockRate),
				toString(turnoverRate), toString(useRate)
				
		};

		return s;
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
	
	public String getAction() {
		return action;
	}

	public String getPortrait() {
		return portrait;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public String getPosition() {
		return position;
	}

	public String getHeight() {
		return height;
	}

	public String getWeight() {
		return weight;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getAge() {
		return age;
	}

	public String getExp() {
		return exp;
	}

	public String getSchool() {
		return school;
	}

	public ArrayList<PlayerDataPerMatchVO> getDataPerMatchList() {
		return dataPerMatchList;
	}

	public int getDoubleDouble() {
		return doubleDouble;
	}

	public MyPresentTime getAveMinutes() {
		return aveMinutes;
	}

	public double getAveScoreNum() {
		return aveScoreNum;
	}

	public double getAveShootNum() {
		return aveShootNum;
	}

	public double getAveThreePointerScoreNum() {
		return aveThreePointerScoreNum;
	}

	public double getAveThreePointerShootNum() {
		return aveThreePointerShootNum;
	}

	public double getAveFreeThrowScoreNum() {
		return aveFreeThrowScoreNum;
	}

	public double getAveFreeThrowShootNum() {
		return aveFreeThrowShootNum;
	}

	public double getAveOffensiveReboundsNum() {
		return aveOffensiveReboundsNum;
	}

	public double getAveDefensiveReboundsNum() {
		return aveDefensiveReboundsNum;
	}

	public double getAveTotalReboundsNum() {
		return aveTotalReboundsNum;
	}

	public double getAveAssistNum() {
		return aveAssistNum;
	}

	public double getAveBlockNum() {
		return aveBlockNum;
	}

	public double getAveTurnoverNum() {
		return aveTurnoverNum;
	}


	public double getAveFoulNum() {
		return aveFoulNum;
	}

	public double getAvePersonalPoints() {
		return avePersonalPoints;
	}

	public double getAveStealNum() {
		return aveStealNum;
	}

	public int getEntryNum() {
		return entryNum;
	}

	public int getStartingNum() {
		return startingNum;
	}

	public String getTeamName() {
		return teamName;
	}

	public MyPresentTime getTotalMinutes() {
		return totalMinutes;
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

	public double getStealNum() {
		return stealNum;
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

	public double getRecentPointAdvance() {
		return recentPointAdvance;
	}

	public double getRecentReboundAdvance() {
		return recentReboundAdvance;
	}

	public double getRecentAssistAdvance() {
		return recentAssistAdvance;
	}

	public String getCompetion() {
		return competion;
	}

	public String getPartition() {
		return partition;
	}

	
	
}
