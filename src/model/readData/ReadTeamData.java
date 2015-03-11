package model.readData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import constant.FileName;

public class ReadTeamData {
	public void readTeamData(){
		File teamFile = new File(FileName.fileName+"/teams/teams");
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(teamFile));
			String tempString = null;
			while((tempString = reader.readLine())!=null){
				System.out.println(tempString);
			}
		}catch(IOException exception){
			
		}
	}
	public static void main(String[] args) {
		new ReadTeamData();
	}
}
