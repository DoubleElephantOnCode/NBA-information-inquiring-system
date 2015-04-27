package model.dataLogic;

import java.util.ArrayList;

import model.readData.ReadMatchData;
import model.readData.ReadPlayerData;
import model.readData.ReadTeamData;
import view.mainFrame.Main;
import view.mainFrame.Waiting;
import view.singlePlayerPanel.TestFrame;
import vo.PlayerDataPerMatchVO;
import vo.PlayerVO;

/**
 * 显示球员列表
 * 
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

	public void showPlayerInfo(final String position, final String area) {

		new Waiting() {
			@Override
			protected Void doInBackground() throws Exception {
				super.doInBackground();

				try {
					ArrayList<PlayerVO> playerList = SelectPlayer.selectPlayer(
							PlayerList.players, position, area);
					PlayerVO player = playerList.get(0);
					String[][] content = new String[playerList.size()][PlayerList
							.getHeadForColumn().length];
					for (int i = 0; i < playerList.size(); i++) {
						player = playerList.get(i);
						String[] s = player.getPlayerInfo();
						for (int j = 0; j < s.length; j++) {
							content[i][j] = s[j];
						}
					}

					String[] column = PlayerList.getHeadForColumn();
					// System.out.println("column = " + column.length);
					// System.out.println("row = " + row.length);
					String[] row = new String[playerList.size()];
					for (int j = 0; j < playerList.size(); j++) {
						row[j] = playerList.get(j).getName();
					}

					Main.newPlayerCountPanel(content, row, column);
				} catch (Exception e) {
					e.printStackTrace();
				}

				return null;
			}

		}.execute();

	}

	public void sortByPlayerInfo(final String position, final String area,
			final int i, final boolean isPositiveSequence) {

		new Waiting() {
			@Override
			protected Void doInBackground() throws Exception {
				super.doInBackground();

				ArrayList<PlayerVO> playerList = PlayerList.sortPlayer(
						SelectPlayer.selectPlayer(PlayerList.players, position,
								area), i, isPositiveSequence);
				PlayerVO player = playerList.get(0);
				String[][] content = new String[playerList.size()][PlayerList
						.getHeadForColumn().length];
				for (int j = 0; j < playerList.size(); j++) {
					player = playerList.get(j);
					String[] s = player.getPlayerInfo();
					for (int k = 0; k < s.length; k++) {
						content[j][k] = s[k];
					}
				}
				String[] row = new String[playerList.size()];
				for (int j = 0; j < playerList.size(); j++) {
					row[j] = playerList.get(j).getName();
				}

				Main.resetPlayerCountPanel(content, row);

				return null;
			}
		}.execute();

	}

	/**
	 * 筛选所选项前50的球员
	 * 
	 * @param i
	 */
	public void selectByPlayerInfo(final String position, final String area,
			final int i) {

		new Waiting() {

			protected Void doInBackground() throws Exception {

				try {
					ArrayList<PlayerVO> playerList = SelectPlayer.selectPlayer(
							PlayerList.players, position, area);
					playerList = PlayerList.sortPlayer(playerList, i, false);
					PlayerVO player = playerList.get(0);
					String[][] content = new String[showNum][PlayerList
							.getHeadForColumn().length];
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
					System.out.println("rowLength = " + row.length);

					Main.resetPlayerCountPanel(content, row);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}

		}.execute();

	}

	/**
	 * 根据位置或地区筛选球员
	 * 
	 * @param position
	 * @param area
	 */
	public void selectByAreaOrPosition(final String position, final String area) {

		new Waiting() {
			@Override
			protected Void doInBackground() throws Exception {
				super.doInBackground();

				try {
					ArrayList<PlayerVO> playerList = SelectPlayer.selectPlayer(
							PlayerList.players, position, area);
					PlayerVO player = playerList.get(0);
					String[][] content = new String[playerList.size()][PlayerList
							.getHeadForColumn().length];
					for (int i = 0; i < playerList.size(); i++) {
						player = playerList.get(i);
						String[] s = player.getPlayerInfo();
						for (int j = 0; j < s.length; j++) {
							content[i][j] = s[j];
						}
					}

					// String[] column = PlayerList.getHeadForColumn();
					// System.out.println("column = " + column.length);

					String[] row = new String[playerList.size()];
					for (int j = 0; j < playerList.size(); j++) {
						row[j] = playerList.get(j).getName();
					}

					System.out.println("rowLength = " + row.length + "  "
							+ content.length);

					Main.resetPlayerCountPanel(content, row);

				} catch (Exception e) {
					e.printStackTrace();
				}

				return null;
			}

		}.execute();

	}

	/**
	 * 筛选热点球员
	 * 
	 * @param isSeason
	 *            是否筛选赛季热点球员
	 * @param selectNum
	 *            筛选数目
	 * @param selectItem
	 *            筛选依据项
	 */
	public void selectHotPlayer(final boolean isSeason,
			final String presentDate, final int selectNum, final int selectItem) {
		new Waiting() {
			@Override
			protected Void doInBackground() throws Exception {
				super.doInBackground();

				try {
					ArrayList<PlayerVO> playerList = SelectPlayer
							.selectHotPlayers(PlayerList.players, isSeason,
									presentDate, selectNum, selectItem);

					PlayerVO player = playerList.get(0);

					if (!isSeason) { // 筛选的是当天热点球员
					// String[][] content = new
					// String[playerList.size()][PlayerList
					// .getHeadForDailyHotPlayers().length];
					// // 给要显示的表格填上内容
					// for (int i = 0; i < playerList.size(); i++) {
					// player = playerList.get(i);
					// String[] s = player.getDailyHotPlayerInfo();
					// for (int j = 0; j < s.length; j++) {
					// content[i][j] = s[j];
					// }
					// }
					// // 球员姓名列
					// String[] row = new String[playerList.size()];
					// for (int i = 0; i < playerList.size(); i++) {
					// row[i] = playerList.get(i).getName();
					// }
						// TODO 调用界面层方法，重设界面

					} else { // 筛选的是赛季热点球员
					// String[][] content = new
					// String[playerList.size()][PlayerList
					// .getHeadForColumn().length];
						// 给要显示的表格填上内容
						// for (int i = 0; i < playerList.size(); i++) {
						// player = playerList.get(i);
						// String[] s = player.getPlayerInfo();
						// for (int j = 0; j < s.length; j++) {
						// content[i][j] = s[j];
						// }
						// }
						// 球员姓名列
						// String[] row = new String[playerList.size()];
						// for (int i = 0; i < playerList.size(); i++) {
						// row[i] = playerList.get(i).getName();
						// }
						// 球员们的照片
						String[] picPath = new String[selectNum];
						for (int i = 0; i < picPath.length; i++) {
							picPath[i] = playerList.get(i).getPortrait();
						}
						// 球员信息显示[第几个球员][行][列]
						String[][][] playerContents = new String[selectNum][][];
//						String[][] singlePlayerContent = playerList.get(0).getDailyHotPlayerInfo();
						for (int i = 0; i < selectNum; i++) {
							 playerContents[i] = playerList.get(i).getDailyHotPlayerInfo();
						}

						// TODO 调用界面层方法，重设界面
						Main.setHotPlayerThisYearPanel(picPath, playerContents);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				return null;
			}

		}.execute();
	}

	/**
	 * 筛选进步最快球员
	 */
	public void selectProgressPlayer(final int selectItem, final int selectNum) {

		new Waiting() {

			protected Void doInBackground() throws Exception {

				ArrayList<PlayerVO> playerList = SelectPlayer
						.selectProgressPlayer(PlayerList.players, selectItem,
								selectNum);
				PlayerVO player = playerList.get(0);
				String[][] content = new String[playerList.size()][PlayerList
						.getHeadForProgressPlayers().length];

				// 给要显示的表格填上内容
				for (int i = 0; i < playerList.size(); i++) {
					player = playerList.get(i);
					String[] s = player.getProgressInfo();
					for (int j = 0; j < s.length; j++) {
						content[i][j] = s[j];
					}
				}

				/**
				 * 球员姓名列
				 */
				String[] nameColumn = new String[playerList.size()];
				for (int i = 0; i < nameColumn.length; i++) {
					nameColumn[i] = playerList.get(i).getName();
				}

				// TODO 调用界面层方法

				return null;
			}

		}.execute();
	}

	/**
	 * 显示一个球员的详细信息
	 */
	public void showSinglePlayerInfo(final String name, final String startDate,
			final String endDate) {
		new Waiting() {

			protected Void doInBackground() throws Exception {

				try {
					PlayerVO player = PlayerList.findAPlayer(name);
					ArrayList<PlayerDataPerMatchVO> matchDataList = player
							.getDataPerMatchList();
					// ArrayList<PlayerDataPerMatchVO> matchDataList =
					// SelectMatch.selectMatchByDate(
					// player.getDataPerMatchList(), startDate, endDate);
					PlayerDataPerMatchVO matchData = matchDataList.get(0);

					String[][] content = new String[matchDataList.size()][PlayerList
							.getHeadForSinglePlayer().length];
					// 给要显示的表格填上内容
					for (int i = 0; i < matchDataList.size(); i++) {
						matchData = matchDataList.get(i);
						String[] s = matchData.getMatchInfo();
						for (int j = 0; j < s.length; j++) {
							content[i][j] = s[j];
						}
					}
					// 行表头，显示日期
					String[] dateList = new String[matchDataList.size()];
					for (int i = 0; i < dateList.length; i++) {
						dateList[i] = matchDataList.get(i).getMatchDate();
					}

					view.singlePlayerPanel.TestFrame testFrame = new TestFrame();

					view.singlePlayerPanel.TestFrame.back.setSinglePlayerPanel(
							player.getPortrait(), player.getAction(), null,
							content, dateList,
							PlayerList.getHeadForSinglePlayer());

				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}

		}.execute();
	}

	public static void main(String[] args) {
		ReadTeamData readTeam = new ReadTeamData();
		readTeam.readTeamData();

		ReadPlayerData readPlayer = new ReadPlayerData();
		readPlayer.readPlayerData();

		ReadMatchData readMatch = new ReadMatchData();
		readMatch.readMatchData();

		// PlayerVO player = PlayerList.findAPlayer("Kobe Bryant");
		// ArrayList<PlayerDataPerMatchVO> matchDataList = player
		// .getDataPerMatchList();
		// // ArrayList<PlayerDataPerMatchVO> matchDataList =
		// // SelectMatch.selectMatchByDate(
		// // player.getDataPerMatchList(), startDate, endDate);
		// PlayerDataPerMatchVO matchData = matchDataList.get(0);
		//
		// String[][] content = new String[matchDataList.size()][PlayerList
		// .getHeadForSinglePlayer().length];
		// // 给要显示的表格填上内容
		// for (int i = 0; i < matchDataList.size(); i++) {
		// matchData = matchDataList.get(i);
		// String[] s = matchData.getMatchInfo();
		// for (int j = 0; j < s.length; j++) {
		// content[i][j] = s[j];
		// }
		// }
		// // 行表头，显示日期
		// String[] dateList = new String[matchDataList.size()];
		// for (int i = 0; i < dateList.length; i++) {
		// dateList[i] = matchDataList.get(i).getMatchDate();
		// }
		//
		// view.singlePlayerPanel.TestFrame testFrame = new TestFrame();
		//
		// String[] s = new String[0];
		// String portait = player.getPortrait();
		// String action = player.getAction();
		// System.out.println(portait);
		// System.out.println(action);
		//
		// testFrame.back.setSinglePlayerPanel(portait, action, s, content,
		// dateList, PlayerList.getHeadForSinglePlayer());
	}
}
