package model.sqlLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import model.dataLogic.TeamList;
import vo.TeamVO;
import constant.FilePath;

public class TestSql {
	public static void main(String[] args){
		TeamSQL teamSql = new TeamSQL();
		MatchSQL matchSql = new MatchSQL();
//		File teamFile = new File(FilePath.teamPath+"/teams");
//		InputStreamReader insReader =null;
//		BufferedReader reader = null;
//		String tempString=null;
//		try{
//			insReader =  new InputStreamReader(new FileInputStream(teamFile) ,"UTF-8");
//			reader = new BufferedReader(insReader);
//			int i =0;
//			while((tempString = reader.readLine())!=null){
//				if(tempString.charAt(2)=='═'){
//					continue;
//				}
//				tempString = tempString.substring(1, tempString.length()-1);
//				//tempString.replace("║", "");
//				String[] strings = tempString.split("│");
//				teamSql.addTeam(strings[0].trim(), strings[1].trim(), strings[2].trim(), strings[3].trim(), strings[4].trim(), strings[5].trim(), strings[6].trim());
//				
//			}
//		}catch(IOException exception){
//
//		}
		matchSql.readMatches();
	
		
	//	teamSql.readTeamInfoToSql();


	}
}
