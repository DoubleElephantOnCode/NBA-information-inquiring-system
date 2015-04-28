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
	public int NUM = 0;
	
	int greatestIndex = 0;
	public String latestDate = "2013-10-29";
	
	ArrayList<String> latestMatches = new ArrayList<String>();  //0位置的是同日期中字典序排最后的比赛
	
	
	public void setCurrentView(ShowView showView){
		this.showView = showView;
	}
	
	public void run(){
		
		
		while(true){
			 
			 File matchFile = new File(FilePath.matchPath);
//			 File matchFile = new File("D://test");
			 File[] matches = matchFile.listFiles();
//			 System.out.println("nums is "+matches.length);
			 
			 if(matches.length> readMatchNum){
				 
                 //初始读入
				 if(readMatchNum==0){
				     
					 int separator = 0;
					 
					 for(int i = 0;i<matches.length;i++){
						 
						 String[] mInfo = matches[i].getName().split("_");
						 String[] date = mInfo[1].split("-");
						 
						 if(Integer.parseInt(date[0])<9){
							 separator++;
						 }
						 else{
							 break;
						 }
					 }
					 
					 for(int i = separator;i<matches.length;i++){
					      readMatchFile(matches[i],2012);
//						  System.out.println(matches[i].getName()+" "+(++NUM));
				     }	
					 
				     for(int i = 0;i<separator;i++){
				    	 readMatchFile(matches[i], 2012);
				     }
					 
					 greatestIndex = matches.length-1;
					 
					 for(int i=0; i<matches.length; i++){
						 
						 if(this.matchFilesCompare(matches[i], matches[greatestIndex])>=0){
							 
							 greatestIndex = i;
						 }
						 else{
							  break;
						 }
					 }
				     
				 }
				 
				 //持续加入
				 else{
					 
					 int move = this.numOfGreatestIndexMove(matches);
					 
					 greatestIndex+=move;
					 
//					 System.out.println(move);
					 
					 //说明前面没有新增的
					// if(move==0){
						 
						 for(int i = greatestIndex+1; i<matches.length ; i++){
						  	
							 if(this.matchFilesCompare(matches[i], matches[greatestIndex])>=0){
						  		 
						  		 readMatchFile(matches[i],2012);
//								 System.out.println(matches[i].getName()+" "+(++NUM));
						  		 greatestIndex = i;
						  	 }
						  	 
						  	 else{
						  		 break;
						  	 }
						 }
					// }
					 
					 //说明前面有新增的 
					 if(move!=0){
						 
//						 //读取与最大下标同日期且新加入的比赛
//						 for(int i = greatestIndex-1; i>=0; i--){
//							 
//							 if(this.matchFilesCompare(matches[greatestIndex], matches[i])==0){
//								 
//								 if(!latestMatches.contains(matches[i].getName())){
////									 readMatchFile(matches[i],2012); 	
//									 System.out.println(matches[i].getName()+" "+(++NUM));
//									 move--;
//								 }
//							 }
//							 else{
//								 break;
//							 }
//						 }
						 
						 //读取加入在头部的比赛
						 for(int i = 0; i < move; i++){
							 readMatchFile(matches[i],2012);
//							 System.out.println(matches[i].getName()+" "+(++NUM));
						 }
						 greatestIndex = move-1;
						 
//						 //读取加入在尾部的比赛
//						 for(int i = readMatchNum+move; i<matches.length; i++){
////							 readMatchFile(matches[i],2012); 
//							 System.out.println(matches[i].getName()+" "+(++NUM));
//						 }
//						 
					 }
				 }
				 
				 latestDate = this.fetchLatestDate(matches[greatestIndex].getName());
				 
				 latestMatches.clear();
				 latestMatches.add(matches[greatestIndex].getName());   //最大下标在0位置
				 
				 for(int i = greatestIndex-1; i>=0; i--){
					 
					 if(this.matchFilesCompare(matches[greatestIndex], matches[i])==0){
						 latestMatches.add(matches[i].getName());
					 }
					 else{
						 break;
					 }
				 }
				 
				 
				 readMatchNum = matches.length;
				 TeamList.finishRead();
				 
				 if(showView!=null){
					 showView.changeData();
				 }
                 
//				 System.out.println("greatest index is "+greatestIndex);
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
	 * 判断比赛发生的前后
	 */
	public int matchFilesCompare(File match1, File match2){
		
		String[] m1 = match1.getName().split("_");
		String[] m2 = match2.getName().split("_");
		
		String[] season1 = m1[0].split("-");
		String[] season2 = m2[0].split("-");
		
		String[] date1 = m1[1].split("-");
		String[] date2 = m2[1].split("-");
		
		int month1 = Integer.parseInt(date1[0]);
		int day1 = Integer.parseInt(date1[1]);
		int month2 = Integer.parseInt(date2[0]);
		int day2 = Integer.parseInt(date2[1]);
		
		if(month1<=9)
			month1+=12;
		if(month2<=9)
			month2+=12;
		
		boolean seasonBigger = Integer.parseInt(season1[0])>=Integer.parseInt(season2[0]);
		boolean dateBigger = (month1>month2)||(month1==month2&&day1>day2);
		
		boolean seasonEqual = Integer.parseInt(season1[0])==Integer.parseInt(season2[0]);
		boolean dateEqual = (month1==month2&&day1==day2);
		
		if(seasonBigger&&dateBigger)
			return 1;
		else if(seasonEqual&&dateEqual)
			return 0;
		else
		    return -1;
	}
	
	
	/**
	 *  动态添加后最大下标（前一次）的移动量
	 */
	public int numOfGreatestIndexMove(File[] matches){
		
		int num = 0;
		
		for( ; ; num++){

			if(matches[greatestIndex+num].getName().equals(latestMatches.get(0))){
				break;
			}
		}
				
		return num;
	}
	
	/**
	 *  读取最近日期
	 */
	public String fetchLatestDate(String fileName){
		
		String result = null;
		
		String[] m = fileName.split("_");
		
		String[] year = m[0].split("-");
		
		String[] date = m[1].split("-");
		
		if(Integer.parseInt(date[0])<=9){
			
			result = "20"+year[1]+"-"+m[1];
		}
		else{
			
			result = "20"+year[0]+"-"+m[1];
		}
		
		return result;
	}
	
	
	/**
	 * 读取一个match文件的数据
	 */
	public void readMatchFile(File file,int yearOfStart){
		
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
	
	public static void main(String[] args){
	
	
	}
}
