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
	 * ��ʾ��Ա��Ϣ
	 */
	public void showPlayerInfo(String name){
		ImageIcon image = getPlayerPic(name);
		String playerInfo = getPlayerInfo(name);
	}
	
	/**
	 * ��ȡ��ԱͼƬ
	 * @return
	 */
	private ImageIcon getPlayerPic(String name){
		return null;
	}
	
	/**
	 * ��ȡ��Ա��Ϣ
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
