package test;

import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;

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
	
	
	
	TeamHighInfo teamHighInfo = new TeamHighInfo();
	TeamHotInfo teamHotInfo = new TeamHotInfo();
	TeamNormalInfo teamNormalInfo = new TeamNormalInfo();
	
	public void analysisCommand(String[] args){
		
	}
	
	public void analysisString(String arg){
		
	}
}
