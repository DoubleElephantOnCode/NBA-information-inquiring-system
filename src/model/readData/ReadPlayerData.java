package model.readData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

import model.dataLogic.PlayerList;
import model.sqlLogic.PlayerSQL;
import vo.PlayerVO;
import constant.FilePath;

/**
 * 读取球员数据
 * @author HalaWKS
 * @date 2015年3月11日 下午9:25:56
 *
 */
public class ReadPlayerData {

	/**
	 * 链接球员的数据库
	 */
	private PlayerSQL playerDB;
	
	public ReadPlayerData() {
		// TODO Auto-generated constructor stub
//		playerDB = new PlayerSQL();
	}
	
	public void readPlayerData(){
		File playerInfoFile = new File(FilePath.playerInfoPath);
		File[] playerInfo = playerInfoFile.listFiles();
		for(File player : playerInfo){
			PlayerList.addPlayer(createAPlayer(readAPlayer(player)));
		}
//		playerDB.addPlayers();
	}
	
	public void readPlayerDataFromDB(){
		playerDB.addPlayers();
	}

	/**
	 * 读取一个球员的信息文件
	 */
	private String readAPlayer(File playerInfo){
		String info = "";
		InputStreamReader insReader =null;
		try {
			insReader =  new InputStreamReader(new FileInputStream(playerInfo) ,"UTF-8");
			BufferedReader br = new BufferedReader(insReader);
			String row = br.readLine();
			while((row = br.readLine()) != null){
				//处理读出的行
				row = row.replace("║", "");
				row = row + " ";
				String[] temp = row.split("│");
				temp[0] = temp[0].trim();
				temp[1] = temp[1].trim();
//				System.out.println(temp[0] + ":" + temp[1]);
				info = info + temp[1] + ";";
				row = br.readLine();
			}
//			System.out.println();
			info = info + "end";
//			System.out.println(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}
	
	/**
	 * 生成一个球员VO
	 * @param info 球员基本信息：姓名;球衣号码;位置;身高;体重;生日;年龄;球龄;毕业学校;
	 * @return
	 */
	private PlayerVO createAPlayer(String info){
		String[] playerInfo = info.split(";");
		PlayerVO player = new PlayerVO(playerInfo[0], playerInfo[1], playerInfo[2], playerInfo[3],
				playerInfo[4], playerInfo[5], playerInfo[6], playerInfo[7], playerInfo[8]);
//		playerDB.insertPlayerInfo(playerInfo[0], playerInfo[1], playerInfo[2], playerInfo[3],
//				playerInfo[4], playerInfo[5], playerInfo[6], playerInfo[7], playerInfo[8]);
		return player;
	}
	
//	public static void main(String[] args) {
//		ReadPlayerData r = new ReadPlayerData();
//		r.readPlayerData();
//	}

}
