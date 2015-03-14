package model.dataLogic;

import java.util.ArrayList;

import vo.PlayerVO;

/**
 * 显示球员列表
 * @author HalaWKS
 * @date 2015年3月14日 下午11:07:11
 *
 */
public class ShowPlayerDataModel {

	public ShowPlayerDataModel() {
		// TODO Auto-generated constructor stub
	}
	
	public void showPlayerInfo(){
		ArrayList<PlayerVO> playerList = PlayerList.getPlayers();
	}
	
}
