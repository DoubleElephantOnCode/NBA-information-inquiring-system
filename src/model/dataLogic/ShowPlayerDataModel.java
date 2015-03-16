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

	/**
	 * 筛选球员数（50名）
	 */
	public static final int showNum = 50;
	
	public ShowPlayerDataModel() {
		// TODO Auto-generated constructor stub
	}
	
	public void showPlayerInfo(final String position, final String area){
		
		new Waiting(){
			@Override
			protected Void doInBackground() throws Exception{
				super.doInBackground();

				try{
				ArrayList<PlayerVO> playerList = SelectPlayer.selectPlayer(
						PlayerList.getPlayers(), position, area);
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
//				System.out.println("column = " + column.length);
				String[] row = PlayerList.getHeadForRow();
//				System.out.println("row = " + row.length);
				
				Main.newPlayerCountPanel(content, row, column);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				return null;
			}
			
		}.execute();
		
	}
	
	public void sortByPlayerInfo(final String position, final String area,
			final int i,final boolean isPositiveSequence){
		
		new Waiting(){
			@Override
			protected Void doInBackground() throws Exception {
				super.doInBackground();
				
				ArrayList<PlayerVO> playerList = PlayerList.sortPlayer(
						SelectPlayer.selectPlayer(PlayerList.getPlayers(), position, area),
						i, isPositiveSequence);
				PlayerVO player = playerList.get(0);
				String[][] content =
						new String[playerList.size()][PlayerList.getHeadForColumn().length];
				for (int j = 0; j < playerList.size(); j++) {
					player = playerList.get(j);
					String[] s = player.getPlayerInfo();
					for (int k = 0; k < s.length; k++) {
						content[j][k] = s[k];
					}
				}
				String[] row = PlayerList.getHeadForRow();
				
				Main.resetPlayerCountPanel(content, row);
				
				
				return null;
			}
		}.execute();
		
	}
	
	/**
	 * 筛选所选项前50的球员
	 * @param i
	 */
	public void selectByPlayerInfo(final String position, final String area, final int i){
		
		new Waiting(){
			
			protected Void doInBackground() throws Exception {

				try{
				ArrayList<PlayerVO> playerList = PlayerList.sortPlayer(
						SelectPlayer.selectPlayer(PlayerList.getPlayers(), position, area),
						i, true);
				PlayerVO player = playerList.get(0);
				String[][] content =
						new String[showNum][PlayerList.getHeadForColumn().length];
				for (int j = 0; j < showNum; j++) {
					player = playerList.get(j);
					String[] s = player.getPlayerInfo();
					for (int k = 0; k < s.length; k++) {
						content[j][k] = s[k];
					}
				}
				String[] row = new String[showNum];
				for (int i = 0; i < showNum; i++) {
					row[i] = playerList.get(i).getName();
				}
				
				Main.resetPlayerCountPanel(content, row);
				} catch(Exception e){
					e.printStackTrace();
				}
				return null;
			}
			
			
		}.execute();
		
	}
	
//	public void selectByPlayerInfo(final int i){
//		new Waiting(){
//			
//			protected Void doInBackground() throws Exception {
//				super.doInBackground();
//				ArrayList<PlayerVO> playerList = PlayerList.selectPlayer(i);
//				PlayerVO player = playerList.get(0);
//				String[][] content =
//	                      new String[playerList.size()][PlayerList.getHeadForColumn().length];
//				for (int j = 0; j < playerList.size(); j++) {
//					player = playerList.get(j);
//					String[] s = player.getPlayerInfo();
//					for (int k = 0; k < s.length; k++) {
//						content[j][k] = s[k];
//					}
//				}
//				String[] row = new String[playerList.size()];
//				for (int i = 0; i < playerList.size(); i++) {
//					row[i] = playerList.get(i).getName();
//				}
//					
//				Main.resetPlayerCountPanel(content, row);
//				
//				return null;
//			}
//			
//		}.execute();
//	}
	

}
