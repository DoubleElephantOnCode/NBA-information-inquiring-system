package model.readData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import model.dataLogic.MatchList;
import model.dataLogic.PlayerList;
import model.dataLogic.TeamList;
import model.sqlLogic.MatchSQL;
import vo.MatchDataPerPlayerVO;
import vo.MatchVO;
import vo.ScoreVO;
import constant.FilePath;

public class ReadMatchData {
	
	private final int datePadding = 1900;
	
	public static ObserverTheData readMatch= null;
	
	private static boolean isIteratorOne = false;
	
	private static String currentDate;
	
	public void readMatchData(){
		
		ObserverTheData t = new ObserverTheData();
		 readMatch = t;
		
		
		isIteratorOne = true;
		
		File matchFile = new File(FilePath.matchPath);
		 File[] matches = matchFile.listFiles();
		 
		 //直接遍历时间顺序不对
		// for(File file:matches){
		//	 readMatchFile(file);
		// }
		 
		 
		 
		 
		 
//		 int i = 0;
//		 for(i = 0;i < matches.length;i++){
//			 String path = matches[i].getPath();
//			 String fileName = path.substring(FilePath.matchPath.length()+1);
//			 int month = Integer.parseInt(fileName.substring(6, 8));
//			 if(month > 6){
//				 break;
//			 }
//		 }
//		 for(int j = i;j<matches.length;j++){
//			 readMatchFile(matches[j],2012);
//		 }
//		 for(int j = 0;j < i;j++){
//			 readMatchFile(matches[j],2012);
//		 }
		 ArrayList<File> fileList = new ArrayList<File>();
		 
		 for(int i=0;i<matches.length;i++){
			 fileList.add(matches[i]);
		}
		 class Com implements Comparator{

			@Override
			public int compare(Object arg0, Object arg1) {
				// TODO Auto-generated method stub
				File f1=(File)arg0;
				String season1 = f1.getName().split("_")[0];
				String date1 = f1.getName().split("_")[1];
				int year1 = Integer.parseInt(season1.split("-")[0]);
				int month1 = Integer.parseInt(date1.split("-")[0]);
				if(month1<8){
					year1++;
				}
				int day1 = Integer.parseInt(date1.split("-")[1]);
				
				File f2=(File)arg1;
				String season2 = f2.getName().split("_")[0];
				String date2 = f2.getName().split("_")[1];
				int year2 = Integer.parseInt(season2.split("-")[0]);
				int month2 = Integer.parseInt(date2.split("-")[0]);
				if(month2 < 8 ){
					year2++;
				}
				int day2 = Integer.parseInt(date1.split("-")[1]);
				
				
				if(year1==year2&&month1==month2&&day1==day2){
					return 0;
				}
				if(year1>year2||year1==year2&&month1>month2||year1==year2&&month1==month2&&day1>day2){
					return 1;
				}else{
					return -1;
				}
			}
			 
		 }
		 
		 Collections.sort(fileList, new Com());
		 for(int i=0;i<fileList.size();i++){
			 readMatchFile(fileList.get(i));
		 }
		 
		 
		 
		 
		 
		 TeamList.finishRead();
	}
	
	/**
	 * 迭代二的读取比赛数据
	 */
	public void readMatchDataForTwo(){
		ObserverTheData t = new ObserverTheData();
		 readMatch = t;
		t.start();
	}
	
	/**
	 * 当前日期
	 * @return
	 */
	public static String getCurrentDate(){
		return "2015-04-08";
		/**
		if(isIteratorOne){
			return currentDate;
		}
		return readMatch.latestDate; 
		**/
	}
	
	
	public void readMatchDataBySQL(){
		ObserverTheData t = new ObserverTheData();
		 readMatch = t;
		
		
		MatchSQL matchSQL = new MatchSQL();
		matchSQL.readAllMatch();
	}
	
	
	/**
	 * 读取一个match文件的数据
	 */
	public void readMatchFile(File file){
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			tempString = reader.readLine();
			String[] strings = tempString.split(";");
			int month = Integer.parseInt(strings[0].split("-")[0]);
			int day = Integer.parseInt(strings[0].split("-")[1]);
			int year = 0;
			int startYear = Integer.parseInt(strings[3].split("-")[0]); //得到12 13 14 .。。。
			if(month > 6){
				year = startYear + 2000 - datePadding;
			}else{
				year = startYear + 2000 + 1 - datePadding;
			}
			currentDate = year+"-"+month+"-"+day;
			Date timeOfMatch = new Date(year,month - 1,day);
			String awayTeam = strings[1].split("-")[0];
			String homeTeam = strings[1].split("-")[1];
			ScoreVO totalScore = new ScoreVO(strings[2]);
			String season = strings[3];
			boolean isPlayoff;
			if(strings[4].equals("0")){
				isPlayoff = false;
			}else{
				isPlayoff = true;
			}
			
			
			tempString = reader.readLine();
			ArrayList<ScoreVO> scoreVOList = new ArrayList<ScoreVO>();
			strings = tempString.split(";");
			for(int i = 0;i < strings.length;i++){
				ScoreVO scoreVO = new ScoreVO(strings[i]);
				scoreVOList.add(scoreVO);
			}
			MatchVO matchVO = new MatchVO(season,isPlayoff,timeOfMatch, awayTeam, homeTeam, totalScore, scoreVOList);
			
			tempString = reader.readLine();
			boolean isHome = false;
			while(tempString != null){
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
				
				
				
				tempString = reader.readLine();
			}
			matchVO.checkData();
			matchVO.calData();
			matchVO.setBasicData();
			for(MatchDataPerPlayerVO homePlayerData : matchVO.homePlayerList){
				PlayerList.addAMatch(homePlayerData);
			}
			for(MatchDataPerPlayerVO awayPlayerData : matchVO.awayPlayerList){
				PlayerList.addAMatch(awayPlayerData);
			}
			
			MatchList.addMatchVO(matchVO);
			TeamList.addMatchVO(matchVO);
			
			
			
			
			
		}catch(IOException exception){
			
		}
	}
}
