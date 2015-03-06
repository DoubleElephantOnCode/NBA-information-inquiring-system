package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.ImageIcon;

import view.TestFrame;

/**
 * 
 * @author HalaWKS
 *
 */
public class GetPlayerInfo{
	
	TestFrame frame;
	String playerInfo;
	
	public GetPlayerInfo() {
		// TODO Auto-generated constructor stub
//		frame = new TestFrame();
	}
	
	/**
	 * 显示球员信息
	 */
	public void showPlayerInfo(String name){
		ImageIcon image = getPlayerPic(name);
		String playerInfo = getPlayerInfo(name);
	}
	
	/**
	 * 获取球员图片
	 * @return
	 */
	private ImageIcon getPlayerPic(String name){
		return null;
	}
	
	/**
	 * 获取球员信息
	 * @return
	 */
	private String getPlayerInfo(String name){
		playerInfo = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/info/Aaron Brooks"));
			String data = br.readLine();
			if(data != null){
				playerInfo = disposeInfo(data) + ";";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return playerInfo;
	}
	
	/**
	 * 处理读出的信息
	 */
	private String disposeInfo(String data){
		String[] spl = new String[2];
		String info = "";
		//去掉║
		data.replace("║", "");
		//分割
		spl = data.split("│");
		info = info + spl[0].trim() + ":" + spl[1].trim();		
		
		return info;
	}
}
