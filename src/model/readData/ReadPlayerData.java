package model.readData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import constant.FileName;

/**
 * 读取球员数据
 * @author HalaWKS
 * @date 2015年3月11日 下午9:25:56
 *
 */
public class ReadPlayerData {

	public ReadPlayerData() {
		// TODO Auto-generated constructor stub
	}
	
	public void readPlayerData(){
		File playerInfoFile = new File("D:/data/players/info");
		File[] playerInfo = playerInfoFile.listFiles();
	}

	/**
	 * 读取一个球员的信息文件
	 */
	private void readAPlayer(File playerInfo){
		String info = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(playerInfo));
			String row = br.readLine();
			while((row = br.readLine()) != null){
				row = row.replace("║", "");
				row = row.replace("	", "");
				System.out.println(row);
				info = info + row;
				row = br.readLine();
			}
			System.out.println();
			info = info.replace("║", "");
			System.out.println(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ReadPlayerData rpd = new ReadPlayerData();
		rpd.readAPlayer(new File("D:/data/players/info/Alan Anderson"));
	}
	
}
