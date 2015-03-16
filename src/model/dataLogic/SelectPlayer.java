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
	
	int i = 0;
	ArrayList<PlayerVO> playersAfterSort;
	
	public SelectPlayer(int i, ArrayList<PlayerVO> players) {
		// TODO Auto-generated constructor stub
		this.i = i;
		this.playersAfterSort = players;
	}
	
	/**
	 * 排序并筛选
	 * @return
	 */
	public ArrayList<PlayerVO> sortAndselectPlayer(){
		ComparePlayer c = new ComparePlayer();
		Collections.sort(playersAfterSort, c.comparForSelect[i]);
		return playersAfterSort;
	}
}
