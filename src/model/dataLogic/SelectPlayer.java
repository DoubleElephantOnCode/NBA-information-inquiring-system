package model.dataLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.readData.ReadMatchData;
import test.SortFieldAndOrder;
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
		if(s1.length == 1 && s2.length == 1){
			position = s1[0];
			area = s2[0];
		} else {
			position = s1[1];
			area = s2[1];
		}

		
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
	
	/**
	 * 测试专用筛选进步最快球员
	 * @param playerList
	 * @param selectItem
	 * @return
	 */
	public static ArrayList<PlayerVO> selectProgressPlayer(ArrayList<PlayerVO> playerList,
			int selectItem){
		
		ArrayList<PlayerVO> players = new ArrayList<PlayerVO>();
		ArrayList<PlayerVO> tempPlayers = new ArrayList<PlayerVO>();
		
		for (int i = 0; i < playerList.size(); i++) {
			tempPlayers.add(playerList.get(i));
		}
		tempPlayers = PlayerList.sortForProgressPlayer(tempPlayers, selectItem);
		
		for (int i = 0; i < tempPlayers.size(); i++) {
			players.add(tempPlayers.get(i));
		}
		
		return players;
	}
	
	/**
	 * 测试专用筛选热点球员
	 * @param playerList 待筛选的球员列表
	 * @param isSeason 是否筛选赛季热点球员
	 * @param selectItem 筛选依据项
	 * @return 
	 */
	public static ArrayList<PlayerVO> selectHotPlayers(ArrayList<PlayerVO> playerList,
			boolean isSeason, int selectItem){
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
		
		for (int i = 0; i < tempPlayers.size(); i++) {
			players.add(tempPlayers.get(i));
		}
		
		
		return players;
	}
	
	
	/**
	 * * 测试专用筛选方法（带排序）
	 * 
	 * @param playerList
	 *            所有球员列表
	 * @param position
	 *            筛选的位置
	 * @param area
	 *            筛选的地区
	 * @param age
	 *            筛选的年龄段
	 * @param sortFieldAndOrderList
	 *            筛选信息
	 * @return
	 */
	public static ArrayList<PlayerVO> selectPlayerForTest(
			ArrayList<PlayerVO> playerList, String position, String area,
			String age, ArrayList<SortFieldAndOrder> sortFieldAndOrderList) {
		// TODO 测试专用筛选方法

//		for (int i = 0; i < array.length; i++) {
//			
//		}
		
		ArrayList<PlayerVO> players = new ArrayList<PlayerVO>();
		ArrayList<Comparator<PlayerVO>> playerCmpList = setComparatorList(sortFieldAndOrderList);

		PlayerVO player = new PlayerVO();
		// 先按位置和赛区筛选
		players = SelectPlayer.selectPlayer(playerList, position, area);
		// 再按年龄筛选
		for (int i = 0; i < players.size(); i++) {
			player = players.get(i);
			if (!isInAgeRange(player, age)) {
				players.remove(i);
			}
		}
		// 排序
		ArrayList<Comparator<PlayerVO>> comparatorList = setComparatorList(sortFieldAndOrderList);
		playerList = sort(playerList, comparatorList);
		
		return playerList;
	}

	/**
	 * 多属性优先级排序
	 * @param playerList 筛选好的、待排序的player们
	 * @param comparatorList 条件比较器们
	 * @return
	 */
	private static ArrayList<PlayerVO> sort(ArrayList<PlayerVO> playerList,
			final ArrayList<Comparator<PlayerVO>> comparatorList){
		if(playerList == null){
			return playerList;
		}
		
		Comparator<PlayerVO> cmp = new Comparator<PlayerVO>() {
			
			@Override
			public int compare(PlayerVO o1, PlayerVO o2) {
				
				for (Comparator<PlayerVO> comparator : comparatorList) {
					if(comparator.compare(o1, o2) > 0){
						return 1;
					} else if(comparator.compare(o1, o2) < 0){
						return -1;
					} else {
						return 0;
					}
				}
				return 0;
			}
		};
		Collections.sort(playerList, cmp);
		
		return playerList;
	}
	
	
	/**
	 * 球员比较器列表
	 * 
	 * @param sortFieldAndOrderList
	 *            筛选信息
	 * @return
	 */
	private static ArrayList<Comparator<PlayerVO>> setComparatorList(
			ArrayList<SortFieldAndOrder> sortFieldAndOrderList) {
		// TODO 球员比较器列表
		ArrayList<Comparator<PlayerVO>> playerCmpList = new ArrayList<Comparator<PlayerVO>>();

		for (int i = 0; i < sortFieldAndOrderList.size(); i++) {
			SortFieldAndOrder sortInfo = sortFieldAndOrderList.get(i);
			ComparePlayer c = new ComparePlayer(sortInfo.isPositiveSequence());
			playerCmpList.add(c.comparator[sortInfo.getField()]);
		}

		return playerCmpList;
	}

	/**
	 * 判断是否在年龄范围内
	 * 
	 * @param player
	 *            待筛选的球员
	 * @param age
	 *            年龄范围
	 * @return
	 */
	private static boolean isInAgeRange(PlayerVO player, String age) {

		int age_int = Integer.parseInt(player.getAge());
		if (age.equalsIgnoreCase("<=22")) {
			if (age_int <= 22) {
				return true;
			} else {
				return false;
			}
		} else if (age.equalsIgnoreCase("22< X <=25")) {
			if (age_int > 22 && age_int <= 25) {
				return true;
			} else {
				return false;
			}
		} else if (age.equalsIgnoreCase("25< X <=30")) {
			if (age_int > 25 && age_int <= 30) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

}
