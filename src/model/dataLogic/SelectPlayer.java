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
		
		System.out.println("size1 = " + playerList.size());
		
		String[] s1 = position.split("-");
		String[] s2 = area.split("-");
		
		position = s1[1];
		area = s2[1];
		
		System.out.println("pos = " + position);
		System.out.println("are = " + area);
		
		ArrayList<PlayerVO> players = new ArrayList<PlayerVO>();
		
		if(position.equalsIgnoreCase("ALL") && area.equalsIgnoreCase("ALL")){
			return playerList;
		}
		if(position.equalsIgnoreCase("ALL") && !area.equalsIgnoreCase("ALL")){
			
			System.out.println("只看地区");
			for (int i = 0; i < playerList.size(); i++) {
				PlayerVO p = playerList.get(i);
				if(p.getCompetion().equalsIgnoreCase(area) ||
						p.getPartition().equalsIgnoreCase(area)){
					players.add(p);
				}
			}
//			return players;
			
		} else if(!position.equalsIgnoreCase("ALL") && area.equalsIgnoreCase("ALL")){
			
			System.out.println("只看位置");
			System.out.println("position = " + position);
			for (int i = 0; i < playerList.size(); i++) {
				PlayerVO p = playerList.get(i);
				if(p.getPosition().contains(position)){
					players.add(p);
				}
			}
//			return players;
			
		} else {
			
			System.out.println("俩都看");
			for (int i = 0; i < playerList.size(); i++) {
				PlayerVO p = playerList.get(i);
				if(p.getPosition().contains(position) && (p.getCompetion().equalsIgnoreCase(area) ||
						p.getPartition().equalsIgnoreCase(area))){
					players.add(p);
				}
			}
			
		}

		System.out.println("size2 = " + players.size());
		
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
