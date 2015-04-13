package test;

import java.io.PrintStream;
import java.util.ArrayList;

import model.dataLogic.TeamList;
import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;
import vo.TeamVO;

/**
 * 
 * @author ZSK
 * @date 2015年4月5日 下午4:03:22
 */
public class TeamTestCommand {
	/**
	 * Avg or Total
	 */
	boolean isAvg = true;
	
	/**
	 * all or hot field;
	 */
	boolean isAll = true;
	/**
	 * hot field    when isAll=false
	 */
	int field;
	String stringField; //暂时不确定hotInfo里的field指的是什么
	
	int normalField = 41;
	
	int highField = 19;
	
	boolean isSequence = false;
	
	int num = 30;
	
	/**
	 * normal or high
	 */
	boolean isNormal = true;
	
	
	TeamHighInfo teamHighInfo = new TeamHighInfo();
	TeamHotInfo teamHotInfo = new TeamHotInfo();
	TeamNormalInfo teamNormalInfo = new TeamNormalInfo();
	
	public void analysisCommand(PrintStream out,String[] args){
		
	
		
		for(int i = 1;i<args.length;){
			i = analysisString(args,i);
		}
		

		
		if(!isAll){//热点球队

			
			
			TeamList.sortTeam(field, isSequence);
			ArrayList<TeamVO> teamVOList = TeamList.getTeamVOList();
			for(int i = 0; i < num &&i < teamVOList.size();i++){
				teamHotInfo = teamVOList.get(i).getHotInfo(stringField, field);
				out.append(teamHotInfo.toString());
			}
		}else if(!isNormal){ //高阶数据

			
			TeamList.sortTeam(highField, isSequence);
			ArrayList<TeamVO> teamVOList = TeamList.getTeamVOList();
			for(int i = 0; i < num &&i < teamVOList.size();i++){
				teamHighInfo = teamVOList.get(i).getHighInfo();
				out.append(teamHighInfo.toString());
			}
		}else {

			
			TeamList.sortTeam(normalField, isSequence);
			ArrayList<TeamVO> teamVOList = TeamList.getTeamVOList();
			for(int i = 0; i < num &&i < teamVOList.size();i++){
				teamNormalInfo = teamVOList.get(i).getNormalInfo(isAvg);
				out.append(teamNormalInfo.toString());
			}
		}
		
	}
	
	public int analysisString(String[] args,int i){
		
		switch(args[i]){
		case "-avg": i++; return i;
		case "-total": i++; isAvg = false; return i;
		case "-all": i++; return i;
		case "-hot": i++; analysisHotString(args,i); i++; return i;
		case "-n": i++; analysisN(args,i); i++; return i;
		case "-high": i++; isNormal = false; return i;
		case "-sort": i++; analysisSortString(args,i); i++; return i;
		}
		
		return 0;
	}
	
	private int analysisSortString(String[] args, int i) {
		// TODO Auto-generated method stub
		String s[] = args[i].split(".");
		if(s[1].equals("asc")){
			isSequence = true;
		}
		switch(s[0]){
		case "point":if(isAvg) normalField = 41;else normalField = 15; return i;
		case "rebound":if(isAvg) normalField = 35;else normalField = 9; return i;
		case "assist":if(isAvg) normalField = 36;else normalField = 10; return i;
		case "blockShot":if(isAvg) normalField = 38;else normalField = 12; return i;
		case "steal":if(isAvg) normalField = 37;else normalField = 11; return i;
		case "foul":if(isAvg) normalField = 40;else normalField = 14; return i;
		case "fault":if(isAvg) normalField = 39;else normalField = 13; return i;
		case "shot":if(isAvg) normalField = 16;else normalField = 16; return i;
		case "three":if(isAvg) normalField = 17;else normalField = 17; return i;
		case "penalty":if(isAvg) normalField = 18;else normalField = 18; return i;
		case "defendRebound":if(isAvg) normalField = 34;else normalField = 8; return i;
		case "offendRebound":if(isAvg) normalField = 33;else normalField = 7; return i;
		case "winRate": highField = 19; return i;
		case "offendRound":highField = 20; return i;
		case "offendEfficient":highField = 21; return i;
		case "defendEfficient":highField = 22; return i;
		case "offendReboundEfficient":highField = 23; return i;
		case "defendReboundEfficient":highField = 24; return i;
		case "stealEfficient":highField = 25; return i;
		case "assistEfficient":highField = 26; return i;
		}
		return 0;
	}

	private void analysisN(String[] args, int i) {
		// TODO Auto-generated method stub
		num = Integer.parseInt(args[i]);
	}

	public int analysisHotString(String[] args,int i){
		stringField = args[i];
		switch(args[i]){
		case "point":if(isAvg) field = 41;else field = 15; return i;
		case "rebound":if(isAvg) field = 35;else field = 9; return i;
		case "assist":if(isAvg) field = 36;else field = 10; return i;
		case "blockShot":if(isAvg) field = 38;else field = 12; return i;
		case "steal":if(isAvg) field = 37;else field = 11; return i;
		case "foul":if(isAvg) field = 40;else field = 14; return i;
		case "fault":if(isAvg) field = 39;else field = 13; return i;
		case "shot":if(isAvg) field = 16;else field = 16; return i;
		case "three":if(isAvg) field = 17;else field = 17; return i;
		case "penalty":if(isAvg) field = 18;else field = 18; return i;
		case "defendRebound":if(isAvg) field = 34;else field = 8; return i;
		case "offendRebound":if(isAvg) field = 33;else field = 7; return i;
		}
		return 0;
	}
}
