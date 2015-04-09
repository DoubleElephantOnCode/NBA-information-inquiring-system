package test;

import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;

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
	
	
	
	int num = 30;
	
	/**
	 * normal or high
	 */
	boolean isNormal = true;
	
	boolean isPositiveSequence = true;
	
	TeamHighInfo teamHighInfo = new TeamHighInfo();
	TeamHotInfo teamHotInfo = new TeamHotInfo();
	TeamNormalInfo teamNormalInfo = new TeamNormalInfo();
	
	public void analysisCommand(String[] args){
		for(int i = 0;i<args.length;){
			i = analysisString(args,i);
		}
	}
	
	public int analysisString(String[] args,int i){
		switch(args[i]){
		case "-avg": i++; return i;
		case "-total": i++; isAvg = false; return i;
		case "-all": i++; return i;
		
		}
		return 0;
	}
}
