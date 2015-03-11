package model.readData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.dataLogic.TeamList;
import vo.TeamVO;
import constant.FilePath;

public class ReadTeamData {
	public void readTeamData(){
		File teamFile = new File(FilePath.teamPath+"/teams");
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(teamFile));
			String tempString = null;
			while((tempString = reader.readLine())!=null){
				System.out.println(tempString);
				if(tempString.charAt(2)=='═'){
					continue;
				}
				tempString.replace("║", "");
				String[] strings = tempString.split("│");
				TeamVO teamVO = new TeamVO(strings[0].trim(), strings[1].trim(), strings[2].trim(), strings[3].trim(), strings[4].trim(), strings[5].trim(), strings[6].trim());
				TeamList.addTeamVO(teamVO);
			}
		}catch(IOException exception){
			
		}
	}

}
