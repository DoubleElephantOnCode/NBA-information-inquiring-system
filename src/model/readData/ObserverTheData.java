package model.readData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import constant.FilePath;
import vo.MatchDataPerPlayerVO;
import vo.MatchVO;
import vo.ScoreVO;
import model.dataLogic.MatchList;
import model.dataLogic.PlayerList;
import model.dataLogic.ShowView;
import model.dataLogic.TeamList;

public class ObserverTheData extends Thread{
	
	private final int datePadding = 1900;
	ShowView showView = null;
	public int readMatchNum = 0;
	
	public void setCurrentView(ShowView showView){
		this.showView = showView;
	}
	
	public void run(){
		
		while(true){
			File matchFile = new File(FilePath.matchPath);
			 File[] matches = matchFile.listFiles();
			 if(matches.length> readMatchNum){
				 for(int i = readMatchNum;i<matches.length;i++){
					 readMatchFile(matches[i],2012);
				 }
				 readMatchNum = matches.length;
				 
				 TeamList.finishRead();
				 
				 if(showView!=null){
					 showView.changeData();
				 }
			 }
			 try {
				this.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * 读取一个match文件的数据
	 */
	public void readMatchFile(File file,int yearOfStart){
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
				year = yearOfStart - datePadding;
			}else{
				year = yearOfStart + 1 - datePadding;
			}
			Date timeOfMatch = new Date(year,month - 1,day);
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
