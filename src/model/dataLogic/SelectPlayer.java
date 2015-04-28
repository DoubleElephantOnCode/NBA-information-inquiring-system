package model.dataLogic;

import java.util.ArrayList;

import model.readData.ReadMatchData;
import vo.PlayerDataPerMatchVO;
import vo.PlayerVO;


/**
 * 根据特定条件筛选球员
 * @author HalaWKS
 * @date 2015年3月16日 下午3:08:29
 *
 */
public class SelectPlayer {
	
	private String defualtPosition = "-ALL";
	private String defaultArea = "-ALL";

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
	
	
	/**
	 * 筛选热点球员
	 * @param playerList 待筛选的球员列表
	 * @param isSeason 是否筛选赛季热点球员
	 * @param presentDate 当前日期
	 * @param selectNum 筛选人数
	 * @param selectItem 筛选依据项
	 * @return 
	 */
	public static ArrayList<PlayerVO> selectHotPlayers(ArrayList<PlayerVO> playerList,
			boolean isSeason, int selectNum, int selectItem){
		//TODO 是否筛选赛季热点球员
		ArrayList<PlayerVO> players = new ArrayList<PlayerVO>();
		ArrayList<PlayerVO> tempPlayers = new ArrayList<PlayerVO>();
		
		if(!isSeason){	//筛选的是当天热点球员
			for (int i = 0; i < playerList.size(); i++) {
				PlayerVO pvo = playerList.get(i);
				ArrayList<PlayerDataPerMatchVO> matchDataList = pvo.getDataPerMatchList();
				//最后一场比赛的数据
				if(matchDataList.size() != 0){
					PlayerDataPerMatchVO latestMatchData =
							matchDataList.get(matchDataList.size() - 1);
					
					if(ReadMatchData.getCurrentDate().equals( latestMatchData.getMatchDate() )){
						//TODO 输出以观察正确性
						System.out.println(pvo.getName());
						System.out.println("当前日期：" + ReadMatchData.getCurrentDate());
						System.out.println("最后一场比赛日期：" + latestMatchData.getMatchDate());
						
						//如果最后一场比赛的日期是当前日期
						PlayerVO player = new PlayerVO(latestMatchData, pvo);
						
						tempPlayers.add(player);
					}
				}

			}
			tempPlayers = PlayerList.sortForHotPlayer(tempPlayers, selectItem);
		} else {	//筛选赛季热点球员
			for (int i = 0; i < playerList.size(); i++) {
				tempPlayers.add(playerList.get(i));
			}
			tempPlayers = PlayerList.sortForHotPlayer(tempPlayers, selectItem);
		}
		
		for (int i = 0; i < selectNum; i++) {
			players.add(tempPlayers.get(i));
		}
		
		
		return players;
	}
	

	/**
	 * 筛选进步最快球员
	 * @param playerList 
	 * @param selectItem
	 * @param selectNum
	 * @return
	 */
	public static ArrayList<PlayerVO> selectProgressPlayer(ArrayList<PlayerVO> playerList,
			int selectItem, int selectNum){
		
		ArrayList<PlayerVO> players = new ArrayList<PlayerVO>();
		ArrayList<PlayerVO> tempPlayers = new ArrayList<PlayerVO>();
		
		for (int i = 0; i < playerList.size(); i++) {
			tempPlayers.add(playerList.get(i));
		}
		tempPlayers = PlayerList.sortForProgressPlayer(tempPlayers, selectItem);
		
		for (int i = 0; i < selectNum; i++) {
			players.add(tempPlayers.get(i));
		}
		
		return players;
	}
}
