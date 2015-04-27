package vo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.dataLogic.TeamList;

/**
 * 
 * @author ZSK
 *
 */
public class MatchVO {
	/**
	 * 比赛时间
	 */
	public Date timeOfMatch;
	
	/**
	 * 客场队伍名称 缩写
	 */
	public String awayTeam;
	
	/**
	 * 主场队伍名称 缩写
	 */
	public String homeTeam;
	
	/**
	 *  总比分
	 */
	public ScoreVO totalScore;
	
	/**
	 * 比分列表
	 */
	public ArrayList<ScoreVO> scoreVOList;
		
	/**
	 *  第一节比分
	 */
	public ScoreVO firstScore;
	
	/**
	 *  第二节比分
	 */
	public ScoreVO secondScore;
	
	/**
	 *  第三节比分
	 */
	public ScoreVO thirdScore;
	
	/**
	 *  第四节比分
	 */
	public ScoreVO fourthScore;
	
	//以下为客场数据
	/**
	 * 客场投篮命中数
	 */
	public int awayTotalScoreNum = 0;
	
	/**
	 * 客场投篮出手数
	 */
	public int awayTotalShootNum = 0;
	
	/**
	 * 客场三分命中数
	 */
	public int awayTotalThreePointScoreNum = 0;
	
	/**
	 * 客场三分出手数
	 */
	public int awayTotalThreePointShootNum = 0;
	
	/**
	 * 客场罚球命中数
	 */
	public int awayTotalFreeThrowScoreNum = 0;
	
	/**
	 * 客场罚球出手数
	 */
	public int awayTotalFreeThrowShootNum = 0;
	
	/**
	 * 客场进攻篮板数
	 */
	public int awayTotalOffensiveReboundsNum = 0;

	
	/**
	 * 客场防守篮板数
	 */
	public int awayTotalDefensiveReboundsNum = 0;
	
	/**
	 * 客场总篮板数
	 */
	public int awayTotalReboundsNum = 0;
	
	/**
	 * 客场助攻数
	 */
	public int awayTotalAssistNum = 0;
	
	/**
	 * 客场抢断数
	 */
	public int awayTotalStealNum = 0;
	
	/**
	 * 客场盖帽数
	 */
	public int awayTotalBlockNum = 0;
	
	/**
	 * 客场失误数
	 */
	public int awayTotalTurnoverNum = 0;
	
	/**
	 * 客场犯规数
	 */
	public int awayTotalFoulNum = 0;
	
	/**
	 * 客场进攻回合
	 */
	public double awayAttackRound = 0;
	
	/**
	 * 客场防守回合
	 */
	public double awayDefensiveRound = 0;
	
	/**
	 * 客场球员得分情况列表
	 */
	public ArrayList<MatchDataPerPlayerVO> awayPlayerList;
	
	//以下为主场数据
	
	/**
	 * 主场投篮命中数
	 */
	public int homeTotalScoreNum = 0;
	
	/**
	 * 主场投篮出手数
	 */
	public int homeTotalShootNum = 0;
	
	/**
	 * 主场三分命中数
	 */
	public int homeTotalThreePointScoreNum = 0;
	
	/**
	 * 主场三分出手数
	 */
	public int homeTotalThreePointShootNum = 0;
	
	/**
	 * 主场罚球命中数
	 */
	public int homeTotalFreeThrowScoreNum = 0;
	
	/**
	 * 主场罚球出手数
	 */
	public int homeTotalFreeThrowShootNum = 0;
	
	/**
	 * 主场进攻篮板数
	 */
	public int homeTotalOffensiveReboundsNum = 0;

	
	/**
	 * 主场防守篮板数
	 */
	public int homeTotalDefensiveReboundsNum = 0;
	
	/**
	 * 主场总篮板数
	 */
	public int homeTotalReboundsNum = 0;
	
	/**
	 * 主场助攻数
	 */
	public int homeTotalAssistNum = 0;
	
	/**
	 * 主场抢断数
	 */
	public int homeTotalStealNum = 0;
	
	/**
	 * 主场盖帽数
	 */
	public int homeTotalBlockNum = 0;
	
	/**
	 * 主场失误数
	 */
	public int homeTotalTurnoverNum = 0;
	
	/**
	 * 主场犯规数
	 */
	public int homeTotalFoulNum = 0;
	
	/**
	 * 主场进攻回合
	 */
	public double homeAttackRound = 0;
	
	/**
	 * 主场防守回合
	 */
	public double homeDefensiveRound = 0;
	
	/**
	 * 主场球员得分情况列表
	 */
	public ArrayList<MatchDataPerPlayerVO> homePlayerList;
	
	
	
	/**
	 * 构造方法
	 * @param timeOfMatch
	 * @param awayTeam
	 * @param homeTeam
	 * @param totalScore
	 * @param firstScore
	 * @param secondScore
	 * @param thirdScore
	 * @param fourthScore
	 */
	public MatchVO(Date timeOfMatch, String awayTeam, String homeTeam,
			ScoreVO totalScore, ArrayList<ScoreVO> scoreVOList) {
		super();
		this.timeOfMatch = timeOfMatch;
		this.awayTeam = awayTeam;
		this.homeTeam = homeTeam;
		this.totalScore = totalScore;
		this.scoreVOList = scoreVOList;
		awayPlayerList = new ArrayList<MatchDataPerPlayerVO>();
		homePlayerList = new ArrayList<MatchDataPerPlayerVO>();
	}

	/**
	 * 向客场球员得分情况列表增加一条记录
	 * @param mdppVO
	 */
	public void addAwayPlayerData(MatchDataPerPlayerVO mdppVO){
		awayPlayerList.add(mdppVO);
		awayTotalScoreNum += mdppVO.getScoreNum();
		awayTotalShootNum += mdppVO.getShootNum();
		awayTotalThreePointScoreNum += mdppVO.getThreePointScoreNum();
		awayTotalThreePointShootNum += mdppVO.getThreePointShootNum();
		awayTotalFreeThrowScoreNum += mdppVO.getFreeThrowScoreNum();
		awayTotalFreeThrowShootNum += mdppVO.getFreeThrowShootNum();
		awayTotalOffensiveReboundsNum += mdppVO.getOffensiveReboundsNum();
		awayTotalDefensiveReboundsNum += mdppVO.getDefensiveReboundsNum();
		awayTotalReboundsNum += mdppVO.getTotalReboundsNum();
		awayTotalAssistNum += mdppVO.getAssistNum();
		awayTotalStealNum += mdppVO.getStealNum();
		awayTotalBlockNum += mdppVO.getBlockNum();
		awayTotalTurnoverNum += mdppVO.getTurnoverNum();
		awayTotalFoulNum += mdppVO.getFoulNum();
	}
	
	/**
	 * 向主场球员得分情况列表增加一条记录
	 * @param mdppVO
	 */
	public void addHomePlayerData(MatchDataPerPlayerVO mdppVO){
		homePlayerList.add(mdppVO);
		homeTotalScoreNum += mdppVO.getScoreNum();
		homeTotalShootNum += mdppVO.getShootNum();
		homeTotalThreePointScoreNum += mdppVO.getThreePointScoreNum();
		homeTotalThreePointShootNum += mdppVO.getThreePointShootNum();
		homeTotalFreeThrowScoreNum += mdppVO.getFreeThrowScoreNum();
		homeTotalFreeThrowShootNum += mdppVO.getFreeThrowShootNum();
		homeTotalOffensiveReboundsNum += mdppVO.getOffensiveReboundsNum();
		homeTotalDefensiveReboundsNum += mdppVO.getDefensiveReboundsNum();
		homeTotalReboundsNum += mdppVO.getTotalReboundsNum();
		homeTotalAssistNum += mdppVO.getAssistNum();
		homeTotalStealNum += mdppVO.getStealNum();
		homeTotalBlockNum += mdppVO.getBlockNum();
		homeTotalTurnoverNum += mdppVO.getTurnoverNum();
		homeTotalFoulNum += mdppVO.getFoulNum();
	}
	
	public void checkData(){
		checkTime();
	}
	
	public void checkTime(){
		MatchDataPerPlayerVO tempVO = null;
		MyPresentTime totalPeoPleTime = new MyPresentTime(0, 0);
		for(MatchDataPerPlayerVO mdppVO:awayPlayerList){
			if(mdppVO.isTimeHasError()){
				tempVO = mdppVO;
			}else{
				totalPeoPleTime = totalPeoPleTime.add(mdppVO.getPresentTime());
			}
		}
		int minute = (scoreVOList.size()-4) * 5 + 48;
		MyPresentTime totalTime = new MyPresentTime(minute * 5, 0);
		if(tempVO != null){			
			tempVO.setPresentTime(totalTime.minus(totalPeoPleTime));
		}else{
			if(totalTime.equals(totalPeoPleTime)){
				
			}else{
				//System.out.println("totalTime: "+totalTime.minute+" : "+totalTime.second);
				//System.out.println("totalPeopleTime: "+totalPeoPleTime.minute+" : "+totalPeoPleTime.second);
				//System.out.println("error in MatchVO checkTime");
			}
		}
		
		tempVO = null;
		totalPeoPleTime = new MyPresentTime(0, 0);
		for(MatchDataPerPlayerVO mdppVO:homePlayerList){
			if(mdppVO.isTimeHasError()){
				tempVO = mdppVO;
			}else{
				totalPeoPleTime = totalPeoPleTime.add(mdppVO.getPresentTime());
			}
		}
		if(tempVO != null){
			tempVO.setPresentTime(totalTime.minus(totalPeoPleTime));
		}else{
			if(totalTime.equals(totalPeoPleTime)){
				
			}else{		
				//System.out.println("totalTime: "+totalTime.minute+" : "+totalTime.second);
				//System.out.println("totalPeopleTime: "+totalPeoPleTime.minute+" : "+totalPeoPleTime.second);
				//System.out.println("error in MatchVO checkTime");
			}
		}
		
	}
	
	/**
	 * 计算主客场进攻防守回合
	 * 进攻回合：本队回合=投篮数+0.4*球队罚球数-1.07*（本队进攻篮板/（本队进攻篮板+对手防守篮板）*投失球数）
	 * +1.07*失误数 
	 */
	public void calRound(){
		awayAttackRound =  awayTotalShootNum + 0.4 * awayTotalFreeThrowShootNum 
				- 1.07 *(awayTotalOffensiveReboundsNum/(double)(awayTotalOffensiveReboundsNum+homeTotalDefensiveReboundsNum)*(awayTotalShootNum - awayTotalScoreNum))
				+ 1.07 * awayTotalTurnoverNum;
		homeAttackRound =  homeTotalShootNum + 0.4 * homeTotalFreeThrowShootNum 
				- 1.07 *(homeTotalOffensiveReboundsNum/(double)(homeTotalOffensiveReboundsNum+awayTotalDefensiveReboundsNum)*(homeTotalShootNum - homeTotalScoreNum))
				+ 1.07 * homeTotalTurnoverNum;
		awayDefensiveRound = homeAttackRound;
		homeDefensiveRound = awayAttackRound;
	}
	
	/**
	 * 计算数据
	 */
	public void calData(){
		calRound();
	}

	/**
	 * 向每一条该场比赛的球员数据内添加一些基础数据（总上场时间之类）
	 */
	public void setBasicData(){
		//TODO 尚未完成
		//主队
		for(MatchDataPerPlayerVO homePlayerData : homePlayerList){
			homePlayerData.setTimeOfMatch(timeOfMatch);
			homePlayerData.setTimeOfAllPlayers(new MyPresentTime(
					((scoreVOList.size() - 4) * 5 +48) * 5, 0));
			homePlayerData.setAllReboundNum(homeTotalReboundsNum);
			homePlayerData.setAllOpponentRebondNum(awayTotalReboundsNum);
			homePlayerData.setAllScoreNum(homeTotalScoreNum);
			homePlayerData.setAllOffReboundNum(homeTotalOffensiveReboundsNum);
			homePlayerData.setAllDefReboundNum(homeTotalDefensiveReboundsNum);
			homePlayerData.setAllOppOffReboundNum(awayTotalOffensiveReboundsNum);
			homePlayerData.setAllOppDefReboundNum(awayTotalDefensiveReboundsNum);
			homePlayerData.setOpponentAttackRound(awayAttackRound);
			homePlayerData.setOppTwoPointShootNum(awayTotalShootNum - awayTotalThreePointShootNum);
			homePlayerData.setAllShootNum(homeTotalShootNum);
			homePlayerData.setAllFreeThrowShootNum(homeTotalFreeThrowShootNum);
			homePlayerData.setAllTurnoverNum(homeTotalTurnoverNum);
			TeamVO teamVO = TeamList.findTeamVO(homeTeam);
			homePlayerData.setCompetion(teamVO.competion);
			homePlayerData.setPartition(teamVO.partition);
		}
		//客队
		for(MatchDataPerPlayerVO awayPlayerData : awayPlayerList){
			awayPlayerData.setTimeOfMatch(timeOfMatch);
			awayPlayerData.setTimeOfAllPlayers(new MyPresentTime(
					((scoreVOList.size() - 4) * 5 +48) * 5, 0));
			awayPlayerData.setAllReboundNum(awayTotalReboundsNum);;
			awayPlayerData.setAllOpponentRebondNum(homeTotalReboundsNum);
			awayPlayerData.setAllScoreNum(awayTotalScoreNum);
			awayPlayerData.setAllOffReboundNum(awayTotalOffensiveReboundsNum);
			awayPlayerData.setAllDefReboundNum(awayTotalDefensiveReboundsNum);
			awayPlayerData.setAllOppOffReboundNum(homeTotalOffensiveReboundsNum);
			awayPlayerData.setAllOppDefReboundNum(homeTotalDefensiveReboundsNum);
			awayPlayerData.setOpponentAttackRound(homeAttackRound);
			awayPlayerData.setOppTwoPointShootNum(homeTotalShootNum - homeTotalThreePointShootNum);
			awayPlayerData.setAllShootNum(awayTotalShootNum);
			awayPlayerData.setAllFreeThrowShootNum(awayTotalFreeThrowShootNum);
			awayPlayerData.setAllTurnoverNum(awayTotalTurnoverNum);
			
			TeamVO teamVO = TeamList.findTeamVO(awayTeam);
			awayPlayerData.setCompetion(teamVO.competion);
			awayPlayerData.setPartition(teamVO.partition);
		}
	}
	
	/**
	 * 比赛时间 主场 客场 比分
	 */
	public String[] toStringArrayForRecentMatch(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String[] s = new String[]{
			  
			sdf.format(timeOfMatch),homeTeam,awayTeam,totalScore.getString()
		};
		return s;
	}
	
	/**
	 * 主场球队图片
	 * @return
	 */
	public File getHomeTeamPicture(){
		TeamVO teamVO = TeamList.findTeamVO(homeTeam);
		return new File(teamVO.getPath());
	}
	
	/**
	 * 主场球队名称列表
	 * @return
	 */
	public String[] getHomeTeamInfoForRow(){
		String[] row = new String[homePlayerList.size()] ;
		for(int i = 0;i< homePlayerList.size();i++){
			MatchDataPerPlayerVO mdppVO = homePlayerList.get(i);
			row[i] = mdppVO.playerName;
		}
		return row;
	}
	
	/**
	 * 位置;在场时间;投篮命中数;投篮出手数;
	 * 三分命中数;三分出手数;罚球命中数;罚 球出手数;
	 * 进攻（前场）篮板数;防守（后场）篮板数;
	 * 总篮板数;助攻数;抢断数;盖帽数;失误 数;犯规数;个人得分; 
	 * @return
	 */
	public String[] getInfoForColumn(){
		String[] column = new String[]{
			"位置","在场时间","投篮命中数","投篮出手数",
			"三分命中数","三分出手数","罚球命中数","罚 球出手数",
			"进攻篮板数","防守篮板数",
			"总篮板数","助攻数","抢断数","盖帽数","失误 数","犯规数","个人得分" 
		};
		return column;
	}
	
	/**
	 * 主场球员信息
	 * @return
	 */
	public String[][] getHomeTeamContent(){
		String[][] content = new String[homePlayerList.size()][17];
		for(int i = 0;i<homePlayerList.size();i++){
			String[] info = homePlayerList.get(i).getInfo();
			for(int j=0;j<17;j++){
				content[i][j] = info[j];
			}
		}
		return content;
	}
	
	/**
	 * 客场球队图片
	 * @return
	 */
	public File getAwayTeamPicture(){
		TeamVO teamVO = TeamList.findTeamVO(awayTeam);
		return new File(teamVO.getPath());
	}
	
	/**
	 * 客场球队名称列表
	 * @return
	 */
	public String[] getAwayTeamInfoForRow(){
		String[] row = new String[awayPlayerList.size()] ;
		for(int i = 0;i< awayPlayerList.size();i++){
			MatchDataPerPlayerVO mdppVO = awayPlayerList.get(i);
			row[i] = mdppVO.playerName;
		}
		return row;
	}
	
	/**
	 * 客场球员信息
	 * @return
	 */
	public String[][] getAwayTeamContent(){
		String[][] content = new String[awayPlayerList.size()][17];
		for(int i = 0;i<awayPlayerList.size();i++){
			String[] info = awayPlayerList.get(i).getInfo();
			for(int j=0;j<17;j++){
				content[i][j] = info[j];
			}
		}
		return content;
	}
	
	public Date getTimeOfMatch() {
		return timeOfMatch;
	}

	public void setTimeOfMatch(Date timeOfMatch) {
		this.timeOfMatch = timeOfMatch;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public ScoreVO getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(ScoreVO totalScore) {
		this.totalScore = totalScore;
	}

	public ArrayList<ScoreVO> getScoreVOList() {
		return scoreVOList;
	}

	public void setScoreVOList(ArrayList<ScoreVO> scoreVOList) {
		this.scoreVOList = scoreVOList;
	}

	public ScoreVO getFirstScore() {
		return firstScore;
	}

	public void setFirstScore(ScoreVO firstScore) {
		this.firstScore = firstScore;
	}

	public ScoreVO getSecondScore() {
		return secondScore;
	}

	public void setSecondScore(ScoreVO secondScore) {
		this.secondScore = secondScore;
	}

	public ScoreVO getThirdScore() {
		return thirdScore;
	}

	public void setThirdScore(ScoreVO thirdScore) {
		this.thirdScore = thirdScore;
	}

	public ScoreVO getFourthScore() {
		return fourthScore;
	}

	public void setFourthScore(ScoreVO fourthScore) {
		this.fourthScore = fourthScore;
	}

	public int getAwayTotalScoreNum() {
		return awayTotalScoreNum;
	}

	public void setAwayTotalScoreNum(int awayTotalScoreNum) {
		this.awayTotalScoreNum = awayTotalScoreNum;
	}

	public int getAwayTotalShootNum() {
		return awayTotalShootNum;
	}

	public void setAwayTotalShootNum(int awayTotalShootNum) {
		this.awayTotalShootNum = awayTotalShootNum;
	}

	public int getAwayTotalThreePointScoreNum() {
		return awayTotalThreePointScoreNum;
	}

	public void setAwayTotalThreePointScoreNum(int awayTotalThreePointScoreNum) {
		this.awayTotalThreePointScoreNum = awayTotalThreePointScoreNum;
	}

	public int getAwayTotalThreePointShootNum() {
		return awayTotalThreePointShootNum;
	}

	public void setAwayTotalThreePointShootNum(int awayTotalThreePointShootNum) {
		this.awayTotalThreePointShootNum = awayTotalThreePointShootNum;
	}

	public int getAwayTotalFreeThrowScoreNum() {
		return awayTotalFreeThrowScoreNum;
	}

	public void setAwayTotalFreeThrowScoreNum(int awayTotalFreeThrowScoreNum) {
		this.awayTotalFreeThrowScoreNum = awayTotalFreeThrowScoreNum;
	}

	public int getAwayTotalFreeThrowShootNum() {
		return awayTotalFreeThrowShootNum;
	}

	public void setAwayTotalFreeThrowShootNum(int awayTotalFreeThrowShootNum) {
		this.awayTotalFreeThrowShootNum = awayTotalFreeThrowShootNum;
	}

	public int getAwayTotalOffensiveReboundsNum() {
		return awayTotalOffensiveReboundsNum;
	}

	public void setAwayTotalOffensiveReboundsNum(int awayTotalOffensiveReboundsNum) {
		this.awayTotalOffensiveReboundsNum = awayTotalOffensiveReboundsNum;
	}

	public int getAwayTotalDefensiveReboundsNum() {
		return awayTotalDefensiveReboundsNum;
	}

	public void setAwayTotalDefensiveReboundsNum(int awayTotalDefensiveReboundsNum) {
		this.awayTotalDefensiveReboundsNum = awayTotalDefensiveReboundsNum;
	}

	public int getAwayTotalReboundsNum() {
		return awayTotalReboundsNum;
	}

	public void setAwayTotalReboundsNum(int awayTotalReboundsNum) {
		this.awayTotalReboundsNum = awayTotalReboundsNum;
	}

	public int getAwayTotalAssistNum() {
		return awayTotalAssistNum;
	}

	public void setAwayTotalAssistNum(int awayTotalAssistNum) {
		this.awayTotalAssistNum = awayTotalAssistNum;
	}

	public int getAwayTotalStealNum() {
		return awayTotalStealNum;
	}

	public void setAwayTotalStealNum(int awayTotalStealNum) {
		this.awayTotalStealNum = awayTotalStealNum;
	}

	public int getAwayTotalBlockNum() {
		return awayTotalBlockNum;
	}

	public void setAwayTotalBlockNum(int awayTotalBlockNum) {
		this.awayTotalBlockNum = awayTotalBlockNum;
	}

	public int getAwayTotalTurnoverNum() {
		return awayTotalTurnoverNum;
	}

	public void setAwayTotalTurnoverNum(int awayTotalTurnoverNum) {
		this.awayTotalTurnoverNum = awayTotalTurnoverNum;
	}

	public int getAwayTotalFoulNum() {
		return awayTotalFoulNum;
	}

	public void setAwayTotalFoulNum(int awayTotalFoulNum) {
		this.awayTotalFoulNum = awayTotalFoulNum;
	}

	public ArrayList<MatchDataPerPlayerVO> getAwayPlayerList() {
		return awayPlayerList;
	}

	public void setAwayPlayerList(ArrayList<MatchDataPerPlayerVO> awayPlayerList) {
		this.awayPlayerList = awayPlayerList;
	}

	public int getHomeTotalScoreNum() {
		return homeTotalScoreNum;
	}

	public void setHomeTotalScoreNum(int homeTotalScoreNum) {
		this.homeTotalScoreNum = homeTotalScoreNum;
	}

	public int getHomeTotalShootNum() {
		return homeTotalShootNum;
	}

	public void setHomeTotalShootNum(int homeTotalShootNum) {
		this.homeTotalShootNum = homeTotalShootNum;
	}

	public int getHomeTotalThreePointScoreNum() {
		return homeTotalThreePointScoreNum;
	}

	public void setHomeTotalThreePointScoreNum(int homeTotalThreePointScoreNum) {
		this.homeTotalThreePointScoreNum = homeTotalThreePointScoreNum;
	}

	public int getHomeTotalThreePointShootNum() {
		return homeTotalThreePointShootNum;
	}

	public void setHomeTotalThreePointShootNum(int homeTotalThreePointShootNum) {
		this.homeTotalThreePointShootNum = homeTotalThreePointShootNum;
	}

	public int getHomeTotalFreeThrowScoreNum() {
		return homeTotalFreeThrowScoreNum;
	}

	public void setHomeTotalFreeThrowScoreNum(int homeTotalFreeThrowScoreNum) {
		this.homeTotalFreeThrowScoreNum = homeTotalFreeThrowScoreNum;
	}

	public int getHomeTotalFreeThrowShootNum() {
		return homeTotalFreeThrowShootNum;
	}

	public void setHomeTotalFreeThrowShootNum(int homeTotalFreeThrowShootNum) {
		this.homeTotalFreeThrowShootNum = homeTotalFreeThrowShootNum;
	}

	public int getHomeTotalOffensiveReboundsNum() {
		return homeTotalOffensiveReboundsNum;
	}

	public void setHomeTotalOffensiveReboundsNum(int homeTotalOffensiveReboundsNum) {
		this.homeTotalOffensiveReboundsNum = homeTotalOffensiveReboundsNum;
	}

	public int getHomeTotalDefensiveReboundsNum() {
		return homeTotalDefensiveReboundsNum;
	}

	public void setHomeTotalDefensiveReboundsNum(int homeTotalDefensiveReboundsNum) {
		this.homeTotalDefensiveReboundsNum = homeTotalDefensiveReboundsNum;
	}

	public int getHomeTotalReboundsNum() {
		return homeTotalReboundsNum;
	}

	public void setHomeTotalReboundsNum(int homeTotalReboundsNum) {
		this.homeTotalReboundsNum = homeTotalReboundsNum;
	}

	public int getHomeTotalAssistNum() {
		return homeTotalAssistNum;
	}

	public void setHomeTotalAssistNum(int homeTotalAssistNum) {
		this.homeTotalAssistNum = homeTotalAssistNum;
	}

	public int getHomeTotalStealNum() {
		return homeTotalStealNum;
	}

	public void setHomeTotalStealNum(int homeTotalStealNum) {
		this.homeTotalStealNum = homeTotalStealNum;
	}

	public int getHomeTotalBlockNum() {
		return homeTotalBlockNum;
	}

	public void setHomeTotalBlockNum(int homeTotalBlockNum) {
		this.homeTotalBlockNum = homeTotalBlockNum;
	}

	public int getHomeTotalTurnoverNum() {
		return homeTotalTurnoverNum;
	}

	public void setHomeTotalTurnoverNum(int homeTotalTurnoverNum) {
		this.homeTotalTurnoverNum = homeTotalTurnoverNum;
	}

	public int getHomeTotalFoulNum() {
		return homeTotalFoulNum;
	}

	public void setHomeTotalFoulNum(int homeTotalFoulNum) {
		this.homeTotalFoulNum = homeTotalFoulNum;
	}

	public ArrayList<MatchDataPerPlayerVO> getHomePlayerList() {
		return homePlayerList;
	}

	public void setHomePlayerList(ArrayList<MatchDataPerPlayerVO> homePlayerList) {
		this.homePlayerList = homePlayerList;
	}

	public double getAwayAttackRound() {
		return awayAttackRound;
	}

	public void setAwayAttackRound(double awayAttackRound) {
		this.awayAttackRound = awayAttackRound;
	}

	public double getAwayDefensiveRound() {
		return awayDefensiveRound;
	}

	public void setAwayDefensiveRound(double awayDefensiveRound) {
		this.awayDefensiveRound = awayDefensiveRound;
	}

	public double getHomeAttackRound() {
		return homeAttackRound;
	}

	public void setHomeAttackRound(double homeAttackRound) {
		this.homeAttackRound = homeAttackRound;
	}

	public double getHomeDefensiveRound() {
		return homeDefensiveRound;
	}

	public void setHomeDefensiveRound(double homeDefensiveRound) {
		this.homeDefensiveRound = homeDefensiveRound;
	}

	
	
	
}
