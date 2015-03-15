package model.dataLogic;

import java.util.ArrayList;

import view.mainFrame.Main;
import view.mainFrame.Waiting;
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
		
		new Waiting(){
			@Override
			protected Void doInBackground() throws Exception{
				super.doInBackground();
				try{
				ArrayList<PlayerVO> playerList = PlayerList.getPlayers();
				PlayerVO player = playerList.get(0);
				String[][] content =
						new String[playerList.size()][PlayerList.getHeadForColumn().length];
				for (int i = 0; i < playerList.size(); i++) {
					player = playerList.get(i);
					String[] s = player.getPlayerInfo();
					for (int j = 0; j < s.length; j++) {
						content[i][j] = s[j];
					}
				}
				
				String[] column = PlayerList.getHeadForColumn();
				String[] row = PlayerList.getHeadForRow();
				
				Main.newPlayerCountPanel(content, row, column);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				return null;
			}
			
		}.execute();
		
	}
	
	public void sortByPlayerInfo(final int i,final boolean isPositiveSequence){
		
		new Waiting(){
			@Override
			protected Void doInBackground() throws Exception {
				super.doInBackground();
				
				
				
				return null;
			}
		}.execute();
		
	}
	
}