package model.dataLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	static ArrayList<PlayerVO> players = new ArrayList<PlayerVO>();
	
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

	/**
	 * 获取球员信息表—列表头
	 * @return
	 */
	public static String[] getHeadForColumn(){
		String[] s = new String[]{
			"姓名","所属球队", "位置", "参赛场数", "先发场数", "两双次数", "总上场时间", "场均上场时间",
			"总篮板", "场均篮板", "总进攻篮板", "场均进攻篮板", "总防守篮板", "场均防守篮板", "总助攻", "场均助攻",
			"投篮命中率", "三分命中率", "罚球命中率", "赛季总抢断", "场均抢断", "赛季总盖帽", "场均盖帽",
			"赛季总失误数", "场均失误数", "赛季总犯规数", "场均犯规数", "赛季总得分", "场均得分",
			"效率", "GmSc效率值", "真实命中率", "投篮效率", "篮板率", "进攻篮板率", "防守篮板率",
			"助攻率", "抢断率", "盖帽率", "失误率", "使用率"};
		
		return s;
	}
	
	/**
	 * 获取球员信息表—行表头
	 * @return
	 */
	public static String[] getHeadForRow(){
		String s[] = new String[players.size()];
		
		for (int i = 0; i < players.size(); i++) {
			s[i] = players.get(i).getName();
		}
		
		return s;
	}
	
	public static ArrayList<PlayerVO> getPlayers() {
		return players;
	}
	
	/**
	 * 根据某项球员信息排序
	 * @param i
	 * @param isPositiveSequence
	 */
	public static void sortPlayer(int i,boolean isPositiveSequence){
		
		Comparator c =new CompareTeamData(i, isPositiveSequence);
		Collections.sort(players, c);;
	}
	
	
}
