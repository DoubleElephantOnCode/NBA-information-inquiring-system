package model.dataLogic;

import java.util.ArrayList;
import java.util.Collections;

import vo.PlayerVO;


/**
 * 根据特定条件筛选球员
 * @author HalaWKS
 * @date 2015年3月16日 下午3:08:29
 *
 */
public class SelectPlayer {
	

	public SelectPlayer() {

	}
	
	/**
	 * 根据位置、赛区筛选球员
	 * @param position
	 * @param area
	 */
	public static ArrayList<PlayerVO> selectPlayer(ArrayList<PlayerVO> playerList,
			String position, String area){
		
		ArrayList<PlayerVO> players = new ArrayList<PlayerVO>();
		
		if(position.equalsIgnoreCase("ALL") && area.equalsIgnoreCase("ALL")){
			return playerList;
		}
		if(position.equalsIgnoreCase("ALL") && !area.equalsIgnoreCase("ALL")){
			for (int i = 0; i < playerList.size(); i++) {
				PlayerVO p = playerList.get(i);
				if(p.getCompetion().equalsIgnoreCase(area) ||
						p.getPartition().equalsIgnoreCase(area)){
					players.add(p);
				}
			}
			return players;
		}
		if(!position.equalsIgnoreCase("ALL") && area.equalsIgnoreCase("ALL")){
			for (int i = 0; i < playerList.size(); i++) {
				PlayerVO p = playerList.get(i);
				if(p.getPosition().contains(position)){
					players.add(p);
				}
			}
			return players;
		}
		
		for (int i = 0; i < playerList.size(); i++) {
			PlayerVO p = playerList.get(i);
			if(p.getPosition().contains(position) && (p.getCompetion().equalsIgnoreCase(area) ||
					p.getPartition().equalsIgnoreCase(area))){
				players.add(p);
			}
		}
		
		
		return players;
	}
	
//	/**
//	 * 排序并筛选
//	 * @return
//	 */
//	public ArrayList<PlayerVO> sortAndselectPlayer(){
//		ComparePlayer c = new ComparePlayer();
//		Collections.sort(playersAfterSort, c.comparForSelect[i]);
//		return playersAfterSort;
//	}
}
