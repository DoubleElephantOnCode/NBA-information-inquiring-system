package model.readData;

import model.dataLogic.MatchList;
import model.dataLogic.TeamList;

public class Test {
	public static void main(String[] args){
		new ReadTeamData().readTeamData();
		new ReadMatchData().readMatchData();
		System.out.println(TeamList.teamVOList.size());
		for(int i=0;i<TeamList.teamVOList.size();i++){
			System.out.println("第"+i+"个   "+TeamList.teamVOList.get(i).abbreviation);
		}
	}
}
