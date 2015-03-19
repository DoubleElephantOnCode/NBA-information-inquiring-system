package projectTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import constant.FilePath;
import vo.MatchDataPerPlayerVO;
import vo.MatchVO;
import vo.ScoreVO;

public class MatchTest {
	@Test
	public void testAddPlayer(){
		MatchVO matchVO = null;
		File file = new File(FilePath.matchPath+"/13-14_01-01_CHA-LAC");
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			tempString = reader.readLine();
			String[] strings = tempString.split(";");
			int month = Integer.parseInt(strings[0].split("-")[0]);
			int day = Integer.parseInt(strings[0].split("-")[1]);
			int year = 0;
			if(month > 6){
				year = 2013;
			}else{
				year = 2014;
			}
			Date timeOfMatch = new Date(year,month,day);
			String awayTeam = strings[1].split("-")[0];
			String homeTeam = strings[1].split("-")[1];
			ScoreVO totalScore = new ScoreVO(strings[2]);
			
			tempString = reader.readLine();
			ArrayList<ScoreVO> scoreVOList = new ArrayList<ScoreVO>();
			strings = tempString.split(";");
			for(int i = 0;i < strings.length;i++){
				ScoreVO scoreVO = new ScoreVO(strings[i]);
				scoreVOList.add(scoreVO);
			}
			matchVO = new MatchVO(timeOfMatch, awayTeam, homeTeam, totalScore, scoreVOList);
			
		}catch(IOException exception){
			
		}
		
		
	}
}
