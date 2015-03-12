package model.dataLogic;

import java.util.ArrayList;

import vo.MatchDataPerPlayerVO;
import vo.PlayerVO;

/**
 * 球员列表类
 * @author HalaWKS
 * @date 2015年3月10日 下午7:10:06
 *
 */
public class PlayerList {

	/**
	 * 所有球员列表
	 */
	static ArrayList<PlayerVO> players = new ArrayList<PlayerVO>();;
	
	public PlayerList() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 往球员列表里添加一条球员数据
	 * @param pvo 一条球员数据
	 */
	public static void addPlayer(PlayerVO pvo){
		players.add(pvo);
	}
	
	/**
	 * 从球员列表里找到一条球员信息
	 * @param playerName 球员姓名作为目前唯一的判别标准
	 * @return
	 */
	public static PlayerVO findAPlayer(String playerName){
		PlayerVO pvo = new PlayerVO();
		
		for (PlayerVO p : players){
			if(p.getName().equalsIgnoreCase(playerName)){
				pvo = p;
			}
		}
		
		return pvo;
	}
	

	/**
	 * 添加一条比赛信息
	 * @param matchData
	 */
	public static void addAMatch(MatchDataPerPlayerVO matchData){
		PlayerVO pvo = findAPlayer(matchData.getPlayerName());
		pvo.addDataPerMatchList(matchData);
	}
	
}
