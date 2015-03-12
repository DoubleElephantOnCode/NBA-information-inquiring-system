package model.readData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import model.dataLogic.MatchList;
import model.dataLogic.TeamList;
import vo.MatchDataPerPlayerVO;
import vo.MatchVO;
import vo.PlayerDataPerMatchVO;
import vo.ScoreVO;
import constant.FilePath;

public class ReadMatchData {
	public void readMatchData(){
		File matchFile = new File(FilePath.matchPath);
		 File[] matches = matchFile.listFiles();
		 
		 //直接遍历时间顺序不对
		// for(File file:matches){
		//	 readMatchFile(file);
		// }
		 int i = 0;
		 for(i = 0;i < matches.length;i++){
			 String path = matches[i].getPath();
			 String fileName = path.substring(FilePath.matchPath.length()+1);
			 int month = Integer.parseInt(fileName.substring(6, 8));
			 if(month > 6){
				 break;
			 }
		 }
		 for(int j = i;j<matches.length;j++){
			 readMatchFile(matches[j]);
		 }
		 for(int j = 0;j < i;j++){
			 readMatchFile(matches[j]);
		 }
	}
	
	
	
	/**
	 * 读取一个match文件的数据
	 */
	public void readMatchFile(File file){
		System.out.println(file.getPath());
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
			MatchVO matchVO = new MatchVO(timeOfMatch, awayTeam, homeTeam, totalScore, scoreVOList);
			
			tempString = reader.readLine();
			boolean isHome = false;
			while(tempString != null){
				System.out.println(tempString);
				if(tempString.equals(awayTeam)){
					tempString = reader.readLine();
					continue;
				}
				if(tempString.equals(homeTeam)){
					tempString = reader.readLine();
					isHome = true;
					continue;
				}
				strings = tempString.split(";");
				MatchDataPerPlayerVO mdppVO = null;
				if(isHome){
					mdppVO = new MatchDataPerPlayerVO(homeTeam,awayTeam+"-"+homeTeam, strings[0],  strings[1],  strings[2],  strings[3],  strings[4],  strings[5],  strings[6],  strings[7],  strings[8],  strings[9],  strings[10],  strings[11],  strings[12],  strings[13],  strings[14],  strings[15],  strings[16],  strings[17]) ;
					matchVO.addHomePlayerData(mdppVO);
				}else{
					mdppVO = new MatchDataPerPlayerVO(awayTeam,awayTeam+"-"+homeTeam, strings[0],  strings[1],  strings[2],  strings[3],  strings[4],  strings[5],  strings[6],  strings[7],  strings[8],  strings[9],  strings[10],  strings[11],  strings[12],  strings[13],  strings[14],  strings[15],  strings[16],  strings[17]) ;
					matchVO.addAwayPlayerData(mdppVO);
				}		
				
				PlayerDataPerMatchVO pdpmVO = new PlayerDataPerMatchVO(mdppVO);
				
				
				tempString = reader.readLine();
			}
			matchVO.calData();
			MatchList.addMatchVO(matchVO);
			TeamList.addMatchVO(matchVO);
			
			
			
		}catch(IOException exception){
			
		}
	}
}
