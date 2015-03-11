package model.readData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import constant.FileName;

public class ReadMatchData {
	public void readMatchData(){
		File matchFile = new File(FileName.fileName+"/matches");
		 File[] matches = matchFile.listFiles();
		 
	}
	
	/**
	 * 读取一个match文件的数据
	 */
	public void readMatchFile(File file){
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
		}catch(IOException exception){
			
		}
	}
}
