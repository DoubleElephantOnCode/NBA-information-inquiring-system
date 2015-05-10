package test;

import java.io.PrintStream;

import constant.FilePath;
import model.readData.ReadMatchData;
import model.readData.ReadPlayerData;
import model.readData.ReadTeamData;

/**
 * 
 * @author HalaWKS
 * @date 2015年4月2日 下午7:00:47
 * 
 */
public class Console {

	/**
	 * 
	 * @param out
	 * @param args
	 */
	public void execute(PrintStream out, String[] args) {
		if(args[0].equals("--datasource")){
			FilePath.changePath(args[1]);
			return;
		}
		
		ReadTeamData readTeam;
		ReadPlayerData readPlayer;
		ReadMatchData readMatch;

		readTeam = new ReadTeamData();
		readTeam.readTeamData();

		readPlayer = new ReadPlayerData();
		readPlayer.readPlayerData();

		readMatch = new ReadMatchData();
		readMatch.readMatchData();
		if(args[0].equals("-team")){
			TeamTestCommand t = new TeamTestCommand();
			t.analysisCommand(out, args);
		}else if(args[0].equals("-player")){
			PlayerTestCommand t = new PlayerTestCommand();
			t.analysisCommand(out, args);
		}
		
		

	}

}
