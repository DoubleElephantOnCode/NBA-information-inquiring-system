package model.sqlLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import model.dataLogic.MatchList;
import model.dataLogic.PlayerList;
import model.dataLogic.TeamList;
import vo.MatchDataPerPlayerVO;
import vo.MatchVO;
import vo.ScoreVO;

public class MatchSQL {
	/**
	 * 驱动程序名
	 */
	private static String driver = "com.mysql.jdbc.Driver";

	/**
	 * URL指向要访问的数据库名scutcs
	 */
	private static String url = "jdbc:mysql://127.0.0.1:3306/school";

	/**
	 * MySQL配置时的用户名
	 */
	private static String user = "root";

	/**
	 * MySQL配置时的密码
	 */
	private static String password = "123456";

	/**
	 * 链接数据库
	 */
	private Connection conn;
	
	public MatchSQL(){
		try {
			// 加载驱动程序
			Class.forName(driver);

			// 连续数据库
			conn = DriverManager.getConnection(url, user, password);

			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");

			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从数据库中读取比赛信息
	 */
	public void readAllMatch(){
		String matchSql = "select * from school.match";
		String playerInfoSql = "select * from school.playerinfo";
		try{
			Statement statement= conn.createStatement();
			Statement statement2 = conn.createStatement();
			ResultSet rs = statement.executeQuery(matchSql);
			String season = "";
			String isPayoffStr = "";
			boolean isPayoff = false;
			String timeOfMatchStr = "";
			Date timeOfMatch = null;
			String team = "";
			String awayTeam = "";
			String homeTeam = "";
			String totalScoreStr = "";
			ScoreVO totalScore = null;
			String scoreVOListStr = "";
			ArrayList<ScoreVO> scoreVOList = null;
			
			while (rs.next()){
				//TODO 
				timeOfMatchStr = rs.getString(2);
				String[] date = timeOfMatchStr.split("-");
				timeOfMatch = new Date(Integer.parseInt(date[0])-1900, Integer.parseInt(date[1])-1, Integer.parseInt(date[2]));
				team = rs.getString(3);
				awayTeam = team.split("-")[0];
				homeTeam = team.split("-")[1];
				totalScoreStr = rs.getString(4);
				totalScore = new ScoreVO(totalScoreStr);
				season = rs.getString(5);
				isPayoffStr = rs.getString(6);
				if(isPayoffStr.equals("0")){
					isPayoff = false;
				}else{
					isPayoff = true;
				}
				scoreVOListStr = rs.getString(7);
				String[] splitScore = scoreVOListStr.split(";");
				scoreVOList = new ArrayList<ScoreVO>(splitScore.length);
				for(int i=0;i<splitScore.length;i++){
					scoreVOList.add(new ScoreVO(splitScore[i]));
				}
				
				
				MatchVO matchVO = new MatchVO(season,isPayoff,timeOfMatch, awayTeam, homeTeam, totalScore, scoreVOList);
			
				String selectSql = " WHERE matchDate = '" + timeOfMatchStr + "' AND team ='" + team+ "';";
				String sql = playerInfoSql + selectSql;
				ResultSet rst = statement2.executeQuery(sql);
				while (rst.next()){
					MatchDataPerPlayerVO mdppVO = null;
					if(rst.getString(3).equals("1")){
						mdppVO = new MatchDataPerPlayerVO(homeTeam,awayTeam+"-"+homeTeam, rst.getString(4),  rst.getString(5),  rst.getString(6),  rst.getString(7),  rst.getString(8),  rst.getString(9),rst.getString(10),  rst.getString(11),rst.getString(12),  rst.getString(13),rst.getString(14),  rst.getString(15),rst.getString(16),  rst.getString(17),rst.getString(18),  rst.getString(19),rst.getString(20),  rst.getString(21)) ;
						matchVO.addHomePlayerData(mdppVO);
					}else{
						mdppVO = new MatchDataPerPlayerVO(homeTeam,awayTeam+"-"+homeTeam, rst.getString(4),  rst.getString(5),  rst.getString(6),  rst.getString(7),  rst.getString(8),  rst.getString(9),rst.getString(10),  rst.getString(11),rst.getString(12),  rst.getString(13),rst.getString(14),  rst.getString(15),rst.getString(16),  rst.getString(17),rst.getString(18),  rst.getString(19),rst.getString(20),  rst.getString(21)) ;						matchVO.addAwayPlayerData(mdppVO);
					}		
					
				}
				rst.close();
				
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
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public void readMatches(){
		File matchFile = new File("D:/data/matches");
		 File[] matches = matchFile.listFiles();		 
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
			 readAMatch(fileList.get(i),i);
		 }
	}
	
	public void readAMatch(File file,int num){
		System.out.println(file.getAbsolutePath());
		InputStreamReader insReader =null;
		BufferedReader reader = null;
		try{
			
			insReader =  new InputStreamReader(new FileInputStream(file) ,"UTF-8");
			reader = new BufferedReader(insReader);

			String tempString = null;
			tempString = reader.readLine();
			String[] strings = tempString.split(";");
			
			
			String awayTeam = strings[1].split("-")[0];
			String homeTeam = strings[1].split("-")[1];
			
			int month = Integer.parseInt(strings[0].split("-")[0]);
			int day = Integer.parseInt(strings[0].split("-")[1]);
			
			int startYear = Integer.parseInt(strings[3].split("-")[0]); //得到12 13 14 .。。。
			int year = 0;
			if(month > 6){
				year = startYear + 2000;
			}else{
				year = startYear + 2000 + 1;
			}
			String matchDate = year+"-"+month+"-"+day;
			String team = strings[1];
			String totalScore = strings[2];
			String season = strings[3];
			String isPayoff = strings[4];
			
					
			tempString = reader.readLine();
			String scoreList = tempString;
			
			try{
				String sql = "INSERT INTO `school`.`match` (`number`, `matchDate`, `team`, `totalScore`, `season`, `isPayoff`, `scoreList`) VALUES " +
						"('" +num + "', '" + matchDate + "', '" + team + "', '" + totalScore + "', '" + season +
						"', '" + isPayoff + "', '" + scoreList +"')";
				Statement statement= conn.createStatement();	
				 statement.executeUpdate(sql);
			}catch(Exception e){
				e.printStackTrace();
			}
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

				String sql = "INSERT INTO `school`.`playerInfo` (  `matchDate` ,`team`,  `isHomeTeam` ,  `playerName`,  `position`, `playTime` ,  `scoreNum` ,  `shootNum`,  `threeScoreNum`,  `threeShootNum` ,  `freeScoreNum` ,  `freeShootNum` ,  `oppReboundNum`,  `defReboundNum`,  `totalReboundNum`,  `assistNum` ,  `stealNum`,  `blockNum` ,  `turnoverNum`,  `foulNum`,  `personalPoints`) VALUES ";
				String playerInfo;
				strings[0] = dealWithString(strings[0]);
				if(isHome){										
					 playerInfo = "('" + matchDate + "', '" +team+ "', '"+ "1"  + "', '" + strings[0] + "', '" + strings[1] +
							"', '" + strings[2] + "', '" + strings[3] + "', '" + strings[4]+ "', '" + strings[5] + "', '" + strings[6] + "', '" + strings[7]+ "', '" + strings[8] + "', '" + strings[9] + "', '" + strings[10]+ "', '" + strings[11] +"', '" +strings[12] + "', '" + strings[13]+ "', '" + strings[14] +"', '" +strings[15] + "', '" + strings[16]+ "', '" + strings[17]+"')";

				}else{
					playerInfo = "('" + matchDate + "', '"  + team+ "', '" + "0" + "', '" + strings[0] + "', '" + strings[1] +
							"', '" + strings[2] + "', '" + strings[3] + "', '" + strings[4]+ "', '" + strings[5] + "', '" + strings[6] + "', '" + strings[7]+ "', '" + strings[8] + "', '" + strings[9] + "', '" + strings[10]+ "', '" + strings[11] +"', '" +strings[12] + "', '" + strings[13]+ "', '" + strings[14] +"', '" +strings[15] + "', '" + strings[16]+ "', '" + strings[17]+"')";
				}	
				
				try{
					String sql1 = sql + playerInfo;
					Statement statement= conn.createStatement();	
					 statement.executeUpdate(sql1);
				}catch(Exception e){
					e.printStackTrace();
				}
				
				
				tempString = reader.readLine();
			}
			
			
		}catch(IOException exception){
			
		}
	}
	
	

	public void createMatchTable(){
		try {
			String sql = "CREATE TABLE `school`.`match` (`number` INT NOT NULL,`matchDate` VARCHAR(10) NOT NULL,`team` VARCHAR(45) NOT NULL,`totalScore` VARCHAR(10) NULL,`season` VARCHAR(8) NULL,`isPayoff` VARCHAR(3) NULL,`scoreList` VARCHAR(90) NULL,PRIMARY KEY (`number`))";
			Statement statement= conn.createStatement();
		
			 statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createPlayerInfoTable(){
		try {
			String sql = "CREATE TABLE `school`.`playerinfo` (  `matchDate` VARCHAR(45) NOT NULL,  `team` VARCHAR(10) NOT NULL, `isHomeTeam` VARCHAR(45) NOT NULL,  `playerName` VARCHAR(100) NOT NULL,  `position` VARCHAR(45) NOT NULL, `playTime` VARCHAR(45) NOT NULL,  `scoreNum` VARCHAR(45) NOT NULL,  `shootNum` VARCHAR(45) NOT NULL,  `threeScoreNum` VARCHAR(45) NOT NULL,  `threeShootNum` VARCHAR(45) NOT NULL,  `freeScoreNum` VARCHAR(45) NOT NULL,  `freeShootNum` VARCHAR(45) NOT NULL,  `oppReboundNum` VARCHAR(45) NOT NULL,  `defReboundNum` VARCHAR(45) NOT NULL,  `totalReboundNum` VARCHAR(45) NOT NULL,  `assistNum` VARCHAR(45) NOT NULL,  `stealNum` VARCHAR(45) NOT NULL,  `blockNum` VARCHAR(45) NOT NULL,  `turnoverNum` VARCHAR(45) NOT NULL,  `foulNum` VARCHAR(45) NOT NULL,  `personalPoints` VARCHAR(45) NOT NULL)";
			Statement statement= conn.createStatement();
		
			 statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteAll(){
		String sqlCommand = "truncate table school.match";
		String sqlCommand2 = "truncate table school.playerinfo";
		Statement statement;
		try {
			statement = conn.createStatement();	
			statement.executeUpdate(sqlCommand);
			statement.executeUpdate(sqlCommand2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String dealWithString(String s){
		String[] temp = s.split("'");
		if(temp.length > 1){
			String s1 = temp[0] + "\\'" + temp[1];
			return s1;
		}
		return s;
	}
}
