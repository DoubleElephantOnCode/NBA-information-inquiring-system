package vo;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;
import constant.FilePath;

/**
 * 
 * @author ZSK
 *
 */
public class TeamVO {
	
	
	
	/**
	 * 球队所有比赛
	 */
	public ArrayList<MatchVO> matchList = new ArrayList<MatchVO>(); 
	
	/**
	 * 球队图片路径
	 */
	public String path;
	
	/**
	 * 球队全名
	 */
	public String name;
	
	/**
	 * 球队曾用名
	 */
	public String oldName= "";
	
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
	public double matchNum = 0.0;
	
	/**
	 * 投篮命中数
	 */
	public int totalScoreNum = 0;
	
	/**
	 * 投篮出手数
	 */
	public int totalShootNum = 0;
	
	/**
	 * 三分命中数
	 */
	public int totalThreePointScoreNum = 0;
	
	/**
	 * 三分出手数
	 */
	public int totalThreePointShootNum = 0;
	
	/**
	 * 罚球命中数
	 */
	public int totalFreeThrowScoreNum = 0;
	
	/**
	 * 罚球出手数
	 */
	public int totalFreeThrowShootNum = 0;
	
	/**
	 * 进攻篮板数
	 */
	public int totalOffensiveReboundsNum = 0;

	
	/**
	 * 对手进攻篮板数
	 */
	public int totalOpponentOffensiveReboundsNum = 0;
	
	/**
	 * 防守篮板数
	 */
	public int totalDefensiveReboundsNum = 0;
	
	/**
	 * 对手防守篮板数
	 */
	public int totalOpponentDefensiveReboundsNum = 0;
	
	/**
	 * 总篮板数
	 */
	public int totalTotalReboundsNum = 0;
	
	/**
	 * 对手总投篮数
	 */
	public int totalOpponentShootNum = 0;
	
	/**
	 * 对手总罚球数
	 */
	public int totalOpponentFreeThrowShootNum = 0;
	
	/**
	 * 对手总进球数
	 */
	public int totalOpponentScoreNum = 0;
	
	/**
	 * 对手总失误数
	 */
	public int totalOpponentTurnoverNum = 0;
	
	
	/**
	 * 助攻数
	 */
	public int totalAssistNum = 0;
	
	/**
	 * 抢断数
	 */
	public int totalStealNum = 0;
	
	/**
	 * 盖帽数
	 */
	public int totalBlockNum = 0;
	
	/**
	 * 失误数
	 */
	public int totalTurnoverNum = 0;
	
	/**
	 * 犯规数
	 */
	public int totalFoulNum = 0;
	
	/**
	 * 比赛得分
	 */
	public int totalScore = 0;
	
	/**
	 * 对手比赛得分
	 */
	public int totalOpponentScore = 0;
	
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
	 * 胜的场数
	 */
	public int winningNum = 0;
	
	/**
	 * 胜率
	 */
	public double totalWinningRate;
	
	/**
	 * 进攻回合
	 */
	public double totalAttackRound = 0;
	
	/**
	 * 防守回合
	 */
	public double totalDefensiveRound = 0;
	
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
	 * 进攻篮板效率
	 */
	public double totalAttackReboundEfficiency;
	
	/**
	 * 防守篮板效率
	 */
	public double totalDefensiveReboundEfficiency;
	
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
	 * 平均防守回合
	 */
	public double aveDefensiveRound;
	
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

	/**
	 * 构造方法
	 * @param name
	 * @param abbreviation
	 * @param location
	 * @param competion
	 * @param partition
	 * @param homeCourt
	 * @param buildTime
	 */
	public TeamVO(String name, String abbreviation, String location,
			String competion, String partition, String homeCourt,
			String buildTime) {
		super();
		
		this.name = name;
	
		this.abbreviation = abbreviation;
		if(abbreviation.equals("NOP")){
			oldName = "NOH";
		}else if(abbreviation.equals("NOH")){
			oldName = "NOP";
		}
		//球队图片路径
		this.path = FilePath.teamPath+"/"+abbreviation+".svg";
				
		this.location = location;
		this.competion = competion;
		this.partition = partition;
		this.homeCourt = homeCourt;
		this.buildTime = buildTime;
		matchVOList = new ArrayList<MatchVO>();
	}
	
	/**
	 * 增加一条比赛记录并改变相关数据
	 * @param matchVO
	 */
	public void addMatchVO(MatchVO matchVO){
		matchList.add(matchVO);
		if(abbreviation.equals(matchVO.getAwayTeam())||matchVO.getAwayTeam().equals(oldName)){
			matchVOList.add(matchVO);
			matchNum++;
			if(matchVO.getTotalScore().former > matchVO.getTotalScore().latter){
				winningNum++;
			}
			totalScoreNum += matchVO.getAwayTotalScoreNum();
			totalShootNum += matchVO.getAwayTotalShootNum();
			totalThreePointScoreNum += matchVO.getAwayTotalThreePointScoreNum();
			totalThreePointShootNum += matchVO.getAwayTotalThreePointShootNum();
			totalFreeThrowScoreNum += matchVO.getAwayTotalFreeThrowScoreNum();
			totalFreeThrowShootNum += matchVO.getAwayTotalFreeThrowShootNum();
			totalOffensiveReboundsNum += matchVO.getAwayTotalOffensiveReboundsNum();
			totalDefensiveReboundsNum += matchVO.getAwayTotalDefensiveReboundsNum();
			totalTotalReboundsNum += matchVO.getAwayTotalReboundsNum();
			totalAssistNum += matchVO.getAwayTotalAssistNum();
			totalStealNum += matchVO.getAwayTotalStealNum();
			totalBlockNum += matchVO.getAwayTotalBlockNum();
			totalTurnoverNum += matchVO.getAwayTotalTurnoverNum();
			totalFoulNum += matchVO.getAwayTotalFoulNum();
			totalScore += matchVO.getTotalScore().former;
			
			//关于总进攻回合的计算有疑问  暂时采用第二种方法  通过总的数据来计算 而不是通过进攻回合累加
			//totalAttackRound += matchVO.getAwayAttackRound();
			//totalDefensiveRound += matchVO.getAwayDefensiveRound();
			
			totalOpponentScore += matchVO.getTotalScore().latter;
			totalOpponentOffensiveReboundsNum += matchVO.getHomeTotalOffensiveReboundsNum();
			totalOpponentDefensiveReboundsNum += matchVO.getHomeTotalDefensiveReboundsNum();
			totalOpponentShootNum += matchVO.getHomeTotalShootNum();
			totalOpponentFreeThrowShootNum += matchVO.getHomeTotalFreeThrowShootNum();
			totalOpponentScoreNum += matchVO.getHomeTotalScoreNum();
			totalOpponentTurnoverNum += matchVO.getHomeTotalTurnoverNum();
			
			
		}else if(abbreviation.equals(matchVO.getHomeTeam())||matchVO.getHomeTeam().equals(oldName)){
			matchVOList.add(matchVO);
			matchNum++;
			if(matchVO.getTotalScore().former < matchVO.getTotalScore().latter){
				winningNum++;
			}
			totalScoreNum += matchVO.getHomeTotalScoreNum();
			totalShootNum += matchVO.getHomeTotalShootNum();
			totalThreePointScoreNum += matchVO.getHomeTotalThreePointScoreNum();
			totalThreePointShootNum += matchVO.getHomeTotalThreePointShootNum();
			totalFreeThrowScoreNum += matchVO.getHomeTotalFreeThrowScoreNum();
			totalFreeThrowShootNum += matchVO.getHomeTotalFreeThrowShootNum();
			totalOffensiveReboundsNum += matchVO.getHomeTotalOffensiveReboundsNum();
			totalDefensiveReboundsNum += matchVO.getHomeTotalDefensiveReboundsNum();
			totalTotalReboundsNum += matchVO.getHomeTotalReboundsNum();
			totalAssistNum += matchVO.getHomeTotalAssistNum();
			totalStealNum += matchVO.getHomeTotalStealNum();
			totalBlockNum += matchVO.getHomeTotalBlockNum();
			totalTurnoverNum += matchVO.getHomeTotalTurnoverNum();
			totalFoulNum += matchVO.getHomeTotalFoulNum();
			totalScore += matchVO.getTotalScore().latter;
			
			//关于总进攻回合的计算有疑问  暂时采用第二种方法  通过总的数据来计算 而不是通过进攻回合累加
			//totalAttackRound += matchVO.getHomeAttackRound();
			//totalDefensiveRound += matchVO.getHomeDefensiveRound();
			
			totalOpponentScore += matchVO.getTotalScore().former;
			totalOpponentOffensiveReboundsNum += matchVO.getAwayTotalOffensiveReboundsNum();
			totalOpponentDefensiveReboundsNum += matchVO.getAwayTotalDefensiveReboundsNum();
			totalOpponentShootNum += matchVO.getAwayTotalShootNum();
			totalOpponentFreeThrowShootNum += matchVO.getAwayTotalFreeThrowShootNum();
			totalOpponentScoreNum += matchVO.getAwayTotalScoreNum();
			totalOpponentTurnoverNum += matchVO.getAwayTotalTurnoverNum();
		}else{
			System.out.println("error in TeamVO addMatchVO");
		}
	}
	
	
	/**
	 * 计算各种平均数
	 * @return
	 */
	public void calAve(){
		if(matchNum==0){
			return;
		}
		
		aveScoreNum = totalScoreNum/matchNum;
		aveShootNum = totalShootNum/matchNum;
		aveThreePointScoreNum = totalThreePointScoreNum/matchNum;
		aveThreePointShootNum = totalThreePointShootNum/matchNum;
		aveFreeThrowScoreNum = totalFreeThrowScoreNum/matchNum;
		aveFreeThrowShootNum = totalFreeThrowShootNum/matchNum;
		aveOffensiveReboundsNum = totalOffensiveReboundsNum/matchNum;
		aveDefensiveReboundsNum = totalDefensiveReboundsNum/matchNum;
		aveTotalReboundsNum = totalTotalReboundsNum/matchNum;
		aveAssistNum = totalAssistNum/matchNum;
		aveStealNum = totalStealNum/matchNum;
		aveBlockNum = totalBlockNum/matchNum;
		aveTurnoverNum = totalTurnoverNum/matchNum;
		aveFoulNum = totalFoulNum/matchNum;
		aveScore = totalScore/matchNum;
		//关于平均进攻回合的计算有疑问  暂时采用第二种方法  不计算平均进攻回合
		//aveAttackRound = totalAttackRound/matchNum;
		//aveDefensiveRound = totalDefensiveRound/matchNum;
		
	}
	/**
	 * 计算总的进攻防守回合
	 */
	public void calRound(){
		if(matchNum==0){
			return;
		}
		
		totalAttackRound =  totalShootNum + 0.4 * totalFreeThrowShootNum 
				- 1.07 *(totalOffensiveReboundsNum/(double)(totalOffensiveReboundsNum+totalOpponentDefensiveReboundsNum)*(totalShootNum - totalScoreNum))
				+ 1.07 * totalTurnoverNum;
		totalDefensiveRound =  totalOpponentShootNum + 0.4 * totalOpponentFreeThrowShootNum 
				- 1.07 *(totalOpponentOffensiveReboundsNum/(double)(totalOpponentOffensiveReboundsNum+totalDefensiveReboundsNum)*(totalOpponentShootNum - totalOpponentScoreNum))
				+ 1.07 * totalOpponentTurnoverNum;
	}
	
	/**
	 * 计算各种效率
	 * @return
	 */
	public void calEfficiency(){
		if(matchNum==0){
			return;
		}
		totalAttackEfficiency = totalScore/totalAttackRound*100;
		totalDefendEfficiency = totalOpponentScore/totalDefensiveRound*100;
		totalAttackReboundEfficiency = totalOffensiveReboundsNum/(double)(totalOffensiveReboundsNum + totalOpponentDefensiveReboundsNum);
		totalDefensiveReboundEfficiency = totalDefensiveReboundsNum/(double)(totalDefensiveReboundsNum + totalOpponentOffensiveReboundsNum);
		totalStealEfficiency = totalStealNum/totalDefensiveRound;
		totalAssistRate = totalAssistNum/totalAttackRound;
	}
	
	/**
	 * 计算各种率
	 * @return
	 */
	public void calRate(){
		if(matchNum==0){
			return;
		}
		totalScoreRate = totalScoreNum/(double)totalShootNum;
		totalThreePointRate = totalThreePointScoreNum/(double)totalThreePointShootNum;
		totalFreeThrowRate = totalFreeThrowScoreNum/(double)totalFreeThrowShootNum;
		totalWinningRate = winningNum/matchNum;
	}
	
	public void calData(){
		calRound();
		calAve();
		calEfficiency();
		calRate();
		
	}

	
	/**
	 * 总：
	 *  比赛场数，投篮命中数，投篮出手次数，三分命中数，
		三分出手数，罚球命中数，罚球出手数，进攻篮板数，防守篮板数，篮板数，
		助攻数，抢断数，盖帽数，失误数，犯规数，
		比赛得分，投篮命中率，三分命中率，
		罚球命中率，胜率，进攻回合，进攻效率
		，防守效率，进攻篮板效率，防守篮板效率，抢断效率，助攻率   
		平均：
		投篮命中数，投篮出手次数，三分命中数，
		三分出手数，罚球命中数，罚球出手数，进攻篮板数，防守篮板数，篮板数，
		助攻数，抢断数，盖帽数，失误数，犯规数，比赛得分，
	 * @return
	 */
	public String[] toStringArray(){
		DecimalFormat df = new DecimalFormat("#.00");
		String[] s= new String[]{
			(int)matchNum+"",totalScoreNum+"",totalShootNum+"",totalThreePointScoreNum+"",
			totalThreePointShootNum+"",totalFreeThrowScoreNum+"",totalFreeThrowShootNum+"",totalOffensiveReboundsNum+"",totalDefensiveReboundsNum+"",totalTotalReboundsNum+"",
			totalAssistNum+"",totalStealNum+"",totalBlockNum+"",totalTurnoverNum+"",totalFoulNum+"",
			totalScore+"",changeFormat(totalScoreRate*100),changeFormat(totalThreePointRate*100),
			changeFormat(totalFreeThrowRate*100),changeFormat(totalWinningRate*100),changeFormat(totalAttackRound),changeFormat(totalAttackEfficiency),
			changeFormat(totalDefendEfficiency),changeFormat(totalAttackReboundEfficiency),changeFormat(totalDefensiveReboundEfficiency),changeFormat(totalStealEfficiency),changeFormat(totalAssistRate),
			changeFormat(aveScoreNum),changeFormat(aveShootNum),changeFormat(aveThreePointScoreNum),
			changeFormat(aveThreePointShootNum),changeFormat(aveFreeThrowScoreNum),changeFormat(aveFreeThrowShootNum),changeFormat(aveOffensiveReboundsNum),changeFormat(aveDefensiveReboundsNum),changeFormat(aveTotalReboundsNum),
			changeFormat(aveAssistNum),changeFormat(aveStealNum),changeFormat(aveBlockNum),changeFormat(aveTurnoverNum),changeFormat(aveFoulNum),
		    changeFormat(aveScore)
		};
		return s;
	}
	
	/**
	 * 根据日期和对手球队找比赛  不能找NOP和NOH的
	 * @param date
	 * @param awayTeam
	 * @return
	 */
	public MatchVO findMatchVO(String date,String awayTeam){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		for(int i = 0;i<matchList.size();i++){
			MatchVO matchVO = matchList.get(i);
			if(sdf.format(matchVO.getTimeOfMatch()).equals(date)&&
					(matchVO.getAwayTeam().equals(awayTeam)||matchVO.getHomeTeam().equals(awayTeam))){
				return matchVO;
			}
		}
		
		System.out.println("error in TeamVO findMatchVO  can't find any match");
		return null;
	}
	
	
	
	
	/**
	 * 单个球队显示属性 
	 * 球队名称  所在地 赛区 分区 主场 建立时间  场均得分 场均篮板 场均助攻 场均盖帽 场均抢断
	 * 三分命中率 投篮命中率 罚球命中率
	 * @return
	 */
	public String[] toStringArrayForSingleTeam(){
		String[] s = new String[]{
				name,location,competion,partition,homeCourt,buildTime,
				changeFormat(aveScore),changeFormat(aveTotalReboundsNum),changeFormat(aveAssistNum),
				changeFormat(aveBlockNum),changeFormat(aveStealNum),changeFormat(totalThreePointRate),
				changeFormat(totalScoreRate),changeFormat(totalFreeThrowRate)
		};
		return s;
	}
	
	
	public String[][] toStringArrayForHotTeam(){
		String[][] s = new String[][]{
			{name,location,competion,homeCourt,buildTime,"","",""},
			{"场均得分","场均篮板 ","场均助攻","场均盖帽 ","场均抢断","三分命中率 ","投篮命中率","罚球命中率"	},
			{changeFormat(aveScore),changeFormat(aveTotalReboundsNum),changeFormat(aveAssistNum),
				changeFormat(aveBlockNum),changeFormat(aveStealNum),changeFormat(totalThreePointRate),
				changeFormat(totalScoreRate),changeFormat(totalFreeThrowRate)}
		};
		return s;
	}
	
	/**
	 * 近期比赛数据
	 * @param begin
	 * @param end
	 * @return
	 */
	public String[][] getMatchInfo(Date begin,Date end){
		ArrayList<String[]> info = new ArrayList<String[]>();
		if(begin==null){
			for(int i = matchList.size()-1;i>=0;i--){
				MatchVO matchVO = matchList.get(i);				
				info.add(matchVO.toStringArrayForRecentMatch());			
			}
		}else{
			for(int i = matchList.size()-1;i>=0;i--){
				MatchVO matchVO = matchList.get(i);
				if(matchVO.timeOfMatch.after(begin)&&matchVO.timeOfMatch.before(end)){
					info.add(matchVO.toStringArrayForRecentMatch());
				}
			}
		}
		int length = 4; //比赛时间 主场  客场 比分 
		String[][] content = new String[info.size()][length];
		for(int i = 0;i<info.size();i++){
			for(int j = 0;j<length;j++){
				content[i][j] = info.get(i)[j];
			}
		}
		return content;
	}
	
	
	public String changeFormat(double d){
		DecimalFormat df = new DecimalFormat("#.00");
		String s = df.format(d);
		Double m = new Double(s);
		return m.toString();
	}

	public TeamNormalInfo getNormalInfo(boolean isAvg){
		TeamNormalInfo normalInfo = new TeamNormalInfo();
		if(isAvg){
			normalInfo.setAssist(aveAssistNum);
			normalInfo.setBlockShot(aveBlockNum);
			normalInfo.setDefendRebound(aveDefensiveReboundsNum);
			normalInfo.setFault(aveTurnoverNum);
			normalInfo.setFoul(aveFoulNum);
			normalInfo.setNumOfGame((int)matchNum);
			normalInfo.setOffendRebound(aveOffensiveReboundsNum);
			normalInfo.setPenalty(totalFreeThrowRate);
			normalInfo.setPoint(aveScore);
			normalInfo.setRebound(aveTotalReboundsNum);
			normalInfo.setShot(totalScoreRate);
			normalInfo.setSteal(aveStealNum);
			normalInfo.setTeamName(abbreviation);
			normalInfo.setThree(totalThreePointRate);
		}else{
			normalInfo.setAssist(totalAssistNum);
			normalInfo.setBlockShot(totalBlockNum);
			normalInfo.setDefendRebound(totalDefensiveReboundsNum);
			normalInfo.setFault(totalTurnoverNum);
			normalInfo.setFoul(totalFoulNum);
			normalInfo.setNumOfGame((int)matchNum);
			normalInfo.setOffendRebound(totalOffensiveReboundsNum);
			normalInfo.setPenalty(totalFreeThrowRate);
			normalInfo.setPoint(totalScore);
			normalInfo.setRebound(totalTotalReboundsNum);
			normalInfo.setShot(totalScoreRate);
			normalInfo.setSteal(totalStealNum);
			normalInfo.setTeamName(abbreviation);
			normalInfo.setThree(totalThreePointRate);
		}
		return normalInfo;
	}
	
	public TeamHighInfo getHighInfo(){
		TeamHighInfo highInfo = new TeamHighInfo();
		highInfo.setAssistEfficient(totalAssistRate);
		highInfo.setDefendEfficient(totalDefendEfficiency);
		highInfo.setDefendReboundEfficient(totalDefensiveReboundEfficiency);
		highInfo.setOffendEfficient(totalAttackEfficiency);
		highInfo.setOffendReboundEfficient(totalAttackReboundEfficiency);
		highInfo.setOffendRound(totalAttackRound);
		highInfo.setStealEfficient(totalStealEfficiency);
		highInfo.setTeamName(abbreviation);
		highInfo.setWinRate(totalWinningRate);
		return highInfo;
	}
	
	
	public TeamHotInfo getHotInfo(String stringField,int field){
		TeamHotInfo hotInfo = new TeamHotInfo();
		hotInfo.setField(stringField);
		hotInfo.setLeague(competion);
		hotInfo.setTeamName(abbreviation);
		hotInfo.setValue(analysisField(field));
		return hotInfo;
	}
	
	public double analysisField(int field){
		double d= 0.0;
		switch(field){
		case 41:  d = aveScore; return d;
		case 35:  d = aveTotalReboundsNum;return d;
		case 36: d = aveAssistNum;return d;
		case 38: d = aveBlockNum;return d;
		case 37: d = aveStealNum;return d;
		case 40: d = aveFoulNum;return d;
		case 39: d = aveTurnoverNum;return d;
		case 16: d = totalScoreRate;return d;
		case 17: d = totalThreePointRate;return d;
		case 18: d = totalFreeThrowRate;return d;
		case 34: d = aveDefensiveReboundsNum;return d;
		case 33: d = aveOffensiveReboundsNum;return d;
		}
		return d;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getHomeCourt() {
		return homeCourt;
	}

	public void setHomeCourt(String homeCourt) {
		this.homeCourt = homeCourt;
	}

	public String getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}

	public double getMatchNum() {
		return matchNum;
	}

	public void setMatchNum(double matchNum) {
		this.matchNum = matchNum;
	}

	public int getTotalScoreNum() {
		return totalScoreNum;
	}

	public void setTotalScoreNum(int totalScoreNum) {
		this.totalScoreNum = totalScoreNum;
	}

	public int getTotalShootNum() {
		return totalShootNum;
	}

	public void setTotalShootNum(int totalShootNum) {
		this.totalShootNum = totalShootNum;
	}

	public int getTotalThreePointScoreNum() {
		return totalThreePointScoreNum;
	}

	public void setTotalThreePointScoreNum(int totalThreePointScoreNum) {
		this.totalThreePointScoreNum = totalThreePointScoreNum;
	}

	public int getTotalThreePointShootNum() {
		return totalThreePointShootNum;
	}

	public void setTotalThreePointShootNum(int totalThreePointShootNum) {
		this.totalThreePointShootNum = totalThreePointShootNum;
	}

	public int getTotalFreeThrowScoreNum() {
		return totalFreeThrowScoreNum;
	}

	public void setTotalFreeThrowScoreNum(int totalFreeThrowScoreNum) {
		this.totalFreeThrowScoreNum = totalFreeThrowScoreNum;
	}

	public int getTotalFreeThrowShootNum() {
		return totalFreeThrowShootNum;
	}

	public void setTotalFreeThrowShootNum(int totalFreeThrowShootNum) {
		this.totalFreeThrowShootNum = totalFreeThrowShootNum;
	}

	public int getTotalOffensiveReboundsNum() {
		return totalOffensiveReboundsNum;
	}

	public void setTotalOffensiveReboundsNum(int totalOffensiveReboundsNum) {
		this.totalOffensiveReboundsNum = totalOffensiveReboundsNum;
	}

	public int getTotalDefensiveReboundsNum() {
		return totalDefensiveReboundsNum;
	}

	public void setTotalDefensiveReboundsNum(int totalDefensiveReboundsNum) {
		this.totalDefensiveReboundsNum = totalDefensiveReboundsNum;
	}

	public int getTotalTotalReboundsNum() {
		return totalTotalReboundsNum;
	}

	public void setTotalTotalReboundsNum(int totalTotalReboundsNum) {
		this.totalTotalReboundsNum = totalTotalReboundsNum;
	}

	public int getTotalAssistNum() {
		return totalAssistNum;
	}

	public void setTotalAssistNum(int totalAssistNum) {
		this.totalAssistNum = totalAssistNum;
	}

	public int getTotalStealNum() {
		return totalStealNum;
	}

	public void setTotalStealNum(int totalStealNum) {
		this.totalStealNum = totalStealNum;
	}

	public int getTotalBlockNum() {
		return totalBlockNum;
	}

	public void setTotalBlockNum(int totalBlockNum) {
		this.totalBlockNum = totalBlockNum;
	}

	public int getTotalTurnoverNum() {
		return totalTurnoverNum;
	}

	public void setTotalTurnoverNum(int totalTurnoverNum) {
		this.totalTurnoverNum = totalTurnoverNum;
	}

	public int getTotalFoulNum() {
		return totalFoulNum;
	}

	public void setTotalFoulNum(int totalFoulNum) {
		this.totalFoulNum = totalFoulNum;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public double getTotalScoreRate() {
		return totalScoreRate;
	}

	public void setTotalScoreRate(double totalScoreRate) {
		this.totalScoreRate = totalScoreRate;
	}

	public double getTotalThreePointRate() {
		return totalThreePointRate;
	}

	public void setTotalThreePointRate(double totalThreePointRate) {
		this.totalThreePointRate = totalThreePointRate;
	}

	public double getTotalFreeThrowRate() {
		return totalFreeThrowRate;
	}

	public void setTotalFreeThrowRate(double totalFreeThrowRate) {
		this.totalFreeThrowRate = totalFreeThrowRate;
	}

	public double getTotalWinningRate() {
		return totalWinningRate;
	}

	public void setTotalWinningRate(double totalWinningRate) {
		this.totalWinningRate = totalWinningRate;
	}

	public double getTotalAttackRound() {
		return totalAttackRound;
	}

	public void setTotalAttackRound(double totalAttackRound) {
		this.totalAttackRound = totalAttackRound;
	}

	public int getWinningNum() {
		return winningNum;
	}

	public void setWinningNum(int winningNum) {
		this.winningNum = winningNum;
	}

	public double getTotalAttackEfficiency() {
		return totalAttackEfficiency;
	}

	public void setTotalAttackEfficiency(double totalAttackEfficiency) {
		this.totalAttackEfficiency = totalAttackEfficiency;
	}

	public double getTotalDefendEfficiency() {
		return totalDefendEfficiency;
	}

	public void setTotalDefendEfficiency(double totalDefendEfficiency) {
		this.totalDefendEfficiency = totalDefendEfficiency;
	}

	public double getTotalReboundEfficiency() {
		return totalReboundEfficiency;
	}

	public void setTotalReboundEfficiency(double totalReboundEfficiency) {
		this.totalReboundEfficiency = totalReboundEfficiency;
	}

	public double getTotalStealEfficiency() {
		return totalStealEfficiency;
	}

	public void setTotalStealEfficiency(double totalStealEfficiency) {
		this.totalStealEfficiency = totalStealEfficiency;
	}

	public double getTotalAssistRate() {
		return totalAssistRate;
	}

	public void setTotalAssistRate(double totalAssistRate) {
		this.totalAssistRate = totalAssistRate;
	}

	public double getAveScoreNum() {
		return aveScoreNum;
	}

	public void setAveScoreNum(double aveScoreNum) {
		this.aveScoreNum = aveScoreNum;
	}

	public double getAveShootNum() {
		return aveShootNum;
	}

	public void setAveShootNum(double aveShootNum) {
		this.aveShootNum = aveShootNum;
	}

	public double getAveThreePointScoreNum() {
		return aveThreePointScoreNum;
	}

	public void setAveThreePointScoreNum(double aveThreePointScoreNum) {
		this.aveThreePointScoreNum = aveThreePointScoreNum;
	}

	public double getAveThreePointShootNum() {
		return aveThreePointShootNum;
	}

	public void setAveThreePointShootNum(double aveThreePointShootNum) {
		this.aveThreePointShootNum = aveThreePointShootNum;
	}

	public double getAveFreeThrowScoreNum() {
		return aveFreeThrowScoreNum;
	}

	public void setAveFreeThrowScoreNum(double aveFreeThrowScoreNum) {
		this.aveFreeThrowScoreNum = aveFreeThrowScoreNum;
	}

	public double getAveFreeThrowShootNum() {
		return aveFreeThrowShootNum;
	}

	public void setAveFreeThrowShootNum(double aveFreeThrowShootNum) {
		this.aveFreeThrowShootNum = aveFreeThrowShootNum;
	}

	public double getAveOffensiveReboundsNum() {
		return aveOffensiveReboundsNum;
	}

	public void setAveOffensiveReboundsNum(double aveOffensiveReboundsNum) {
		this.aveOffensiveReboundsNum = aveOffensiveReboundsNum;
	}

	public double getAveDefensiveReboundsNum() {
		return aveDefensiveReboundsNum;
	}

	public void setAveDefensiveReboundsNum(double aveDefensiveReboundsNum) {
		this.aveDefensiveReboundsNum = aveDefensiveReboundsNum;
	}

	public double getAveTotalReboundsNum() {
		return aveTotalReboundsNum;
	}

	public void setAveTotalReboundsNum(double aveTotalReboundsNum) {
		this.aveTotalReboundsNum = aveTotalReboundsNum;
	}

	public double getAveAssistNum() {
		return aveAssistNum;
	}

	public void setAveAssistNum(double aveAssistNum) {
		this.aveAssistNum = aveAssistNum;
	}

	public double getAveStealNum() {
		return aveStealNum;
	}

	public void setAveStealNum(double aveStealNum) {
		this.aveStealNum = aveStealNum;
	}

	public double getAveBlockNum() {
		return aveBlockNum;
	}

	public void setAveBlockNum(double aveBlockNum) {
		this.aveBlockNum = aveBlockNum;
	}

	public double getAveTurnoverNum() {
		return aveTurnoverNum;
	}

	public void setAveTurnoverNum(double aveTurnoverNum) {
		this.aveTurnoverNum = aveTurnoverNum;
	}

	public double getAveFoulNum() {
		return aveFoulNum;
	}

	public void setAveFoulNum(double aveFoulNum) {
		this.aveFoulNum = aveFoulNum;
	}

	public double getAveScore() {
		return aveScore;
	}

	public void setAveScore(double aveScore) {
		this.aveScore = aveScore;
	}

	public double getAveAttackRound() {
		return aveAttackRound;
	}

	public void setAveAttackRound(double aveAttackRound) {
		this.aveAttackRound = aveAttackRound;
	}

	public double getAveAttackEfficiency() {
		return aveAttackEfficiency;
	}

	public void setAveAttackEfficiency(double aveAttackEfficiency) {
		this.aveAttackEfficiency = aveAttackEfficiency;
	}

	public double getAveDefendEfficiency() {
		return aveDefendEfficiency;
	}

	public void setAveDefendEfficiency(double aveDefendEfficiency) {
		this.aveDefendEfficiency = aveDefendEfficiency;
	}

	public double getAveReboundEfficiency() {
		return aveReboundEfficiency;
	}

	public void setAveReboundEfficiency(double aveReboundEfficiency) {
		this.aveReboundEfficiency = aveReboundEfficiency;
	}

	public double getAveStealEfficiency() {
		return aveStealEfficiency;
	}

	public void setAveStealEfficiency(double aveStealEfficiency) {
		this.aveStealEfficiency = aveStealEfficiency;
	}

	public double getAveAssistRate() {
		return aveAssistRate;
	}

	public void setAveAssistRate(double aveAssistRate) {
		this.aveAssistRate = aveAssistRate;
	}

	public ArrayList<MatchVO> getMatchVOList() {
		return matchVOList;
	}

	public void setMatchVOList(ArrayList<MatchVO> matchVOList) {
		this.matchVOList = matchVOList;
	}

	public double getTotalDefensiveRound() {
		return totalDefensiveRound;
	}

	public void setTotalDefensiveRound(double totalDefensiveRound) {
		this.totalDefensiveRound = totalDefensiveRound;
	}

	public double getAveDefensiveRound() {
		return aveDefensiveRound;
	}

	public void setAveDefensiveRound(double aveDefensiveRound) {
		this.aveDefensiveRound = aveDefensiveRound;
	}

	public int getTotalOpponentOffensiveReboundsNum() {
		return totalOpponentOffensiveReboundsNum;
	}

	public void setTotalOpponentOffensiveReboundsNum(
			int totalOpponentOffensiveReboundsNum) {
		this.totalOpponentOffensiveReboundsNum = totalOpponentOffensiveReboundsNum;
	}

	public int getTotalOpponentDefensiveReboundsNum() {
		return totalOpponentDefensiveReboundsNum;
	}

	public void setTotalOpponentDefensiveReboundsNum(
			int totalOpponentDefensiveReboundsNum) {
		this.totalOpponentDefensiveReboundsNum = totalOpponentDefensiveReboundsNum;
	}

	public int getTotalOpponentScore() {
		return totalOpponentScore;
	}

	public void setTotalOpponentScore(int totalOpponentScore) {
		this.totalOpponentScore = totalOpponentScore;
	}

	public double getTotalAttackReboundEfficiency() {
		return totalAttackReboundEfficiency;
	}

	public void setTotalAttackReboundEfficiency(double totalAttackReboundEfficiency) {
		this.totalAttackReboundEfficiency = totalAttackReboundEfficiency;
	}

	public double getTotalDefensiveReboundEfficiency() {
		return totalDefensiveReboundEfficiency;
	}

	public void setTotalDefensiveReboundEfficiency(
			double totalDefensiveReboundEfficiency) {
		this.totalDefensiveReboundEfficiency = totalDefensiveReboundEfficiency;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getTotalOpponentShootNum() {
		return totalOpponentShootNum;
	}

	public void setTotalOpponentShootNum(int totalOpponentShootNum) {
		this.totalOpponentShootNum = totalOpponentShootNum;
	}

	public int getTotalOpponentFreeThrowShootNum() {
		return totalOpponentFreeThrowShootNum;
	}

	public void setTotalOpponentFreeThrowShootNum(int totalOpponentFreeThrowShootNum) {
		this.totalOpponentFreeThrowShootNum = totalOpponentFreeThrowShootNum;
	}

	public int getTotalOpponentScoreNum() {
		return totalOpponentScoreNum;
	}

	public void setTotalOpponentScoreNum(int totalOpponentScoreNum) {
		this.totalOpponentScoreNum = totalOpponentScoreNum;
	}

	public int getTotalOpponentTurnoverNum() {
		return totalOpponentTurnoverNum;
	}

	public void setTotalOpponentTurnoverNum(int totalOpponentTurnoverNum) {
		this.totalOpponentTurnoverNum = totalOpponentTurnoverNum;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	
	
}
