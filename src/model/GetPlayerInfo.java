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
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/info/Aaron Brooks"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
