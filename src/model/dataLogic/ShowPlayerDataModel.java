package model.dataLogic;

import java.util.ArrayList;
import java.util.Date;

import model.readData.ReadMatchData;

import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;

import view.mainFrame.Main;
import view.mainFrame.Waiting;
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

	public class ShowPlayerInfo implements ShowView {

		private String position = "";
		private String area = "";

		public ShowPlayerInfo(String position, String area) {
			this.position = position;
			this.area = area;
		}

		@Override
		public void changeData() {
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
		}

	}

	public void showPlayerInfo(final String position, final String area) {
		ReadMatchData.readMatch.setCurrentView(new ShowPlayerInfo(position,
				area));

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

		ReadMatchData.readMatch.setCurrentView(new sortByPlayerInfo(position,
				area, i, isPositiveSequence));

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

	public class sortByPlayerInfo implements ShowView {

		private String position = "";
		private String area = "";
		private int i = 0;
		private boolean isPositiveSequence = true;

		public sortByPlayerInfo(String position, String area, int i,
				boolean isPositiveSequence) {
			this.position = position;
			this.area = area;
			this.i = i;
			this.isPositiveSequence = isPositiveSequence;
		}

		@Override
		public void changeData() {
			// TODO Auto-generated method stub
			ArrayList<PlayerVO> playerList = PlayerList.sortPlayer(SelectPlayer
					.selectPlayer(PlayerList.players, position, area), i,
					isPositiveSequence);
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
		}

	}

	/**
	 * 筛选所选项前50的球员
	 * 
	 * @param i
	 */
	public void selectByPlayerInfo(final String position, final String area,
			final int i) {

		ReadMatchData.readMatch.setCurrentView(new SelectByPlayerInfo(position,
				area, i));

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

	public class SelectByPlayerInfo implements ShowView {

		private String position = "";
		private String area = "";
		private int i = 0;

		public SelectByPlayerInfo(String position, String area, int i) {
			// TODO Auto-generated constructor stub
			this.position = position;
			this.area = area;
			this.i = i;
		}

		@Override
		public void changeData() {
			// TODO Auto-generated method stub
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
		}

	}

	/**
	 * 根据位置或地区筛选球员
	 * 
	 * @param position
	 * @param area
	 */
	public void selectByAreaOrPosition(final String position, final String area) {

		ReadMatchData.readMatch.setCurrentView(new ShowPlayerInfo(position,
				area));

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
	public void selectHotPlayer(final boolean isSeason, final int selectNum,
			final int selectItem) {

		ReadMatchData.readMatch.setCurrentView(new SelectHotPlayer(isSeason,
				selectNum, selectItem));

		new Waiting() {
			@Override
			protected Void doInBackground() throws Exception {
				super.doInBackground();

				try {
					ArrayList<PlayerVO> playerList = SelectPlayer
							.selectHotPlayers(PlayerList.players, isSeason,
									selectNum, selectItem);

					if (!isSeason) { // 筛选的是当天热点球员
						// 照片列表
						String[] picPath = new String[selectNum];
						for (int i = 0; i < picPath.length; i++) {
							picPath[i] = playerList.get(i).getPortrait();
						}
						String[][][] playerContents = new String[selectNum][][];
						for (int i = 0; i < selectNum; i++) {
							playerContents[i] = playerList.get(i)
									.getHotPlayerInfo(isSeason, selectItem);
						}
						// 姓名列表
						String[] playerNames = new String[selectNum];
						for (int i = 0; i < playerNames.length; i++) {
							playerNames[i] = playerList.get(i).getName();
						}

						// TODO 调用界面层方法，重设界面
						Main.setHotPlayerTodayPanel(picPath, playerContents,
								playerNames);

					} else { // 筛选的是赛季热点球员

						String[] picPath = new String[selectNum];
						for (int i = 0; i < picPath.length; i++) {
							picPath[i] = playerList.get(i).getPortrait();
						}
						// 球员信息显示[第几个球员][行][列]
						String[][][] playerContents = new String[selectNum][][];
						// String[][] singlePlayerContent =
						// playerList.get(0).getDailyHotPlayerInfo();
						for (int i = 0; i < selectNum; i++) {
							playerContents[i] = playerList.get(i)
									.getHotPlayerInfo(isSeason, selectItem);
						}
						// 姓名列表
						String[] playerNames = new String[selectNum];
						for (int i = 0; i < playerNames.length; i++) {
							playerNames[i] = playerList.get(i).getName();
						}
						// TODO 调用界面层方法，重设界面
						Main.setHotPlayerThisYearPanel(picPath, playerContents,
								playerNames);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				return null;
			}

		}.execute();
	}

	public class SelectHotPlayer implements ShowView {

		private boolean isSeason = true;
		private int selectNum = 0;
		private int selectItem = 0;

		public SelectHotPlayer(boolean isSeason, int selectNum, int selectItem) {
			this.isSeason = isSeason;
			this.selectNum = selectNum;
			this.selectItem = selectItem;
		}

		@Override
		public void changeData() {
			try {
				ArrayList<PlayerVO> playerList = SelectPlayer.selectHotPlayers(
						PlayerList.players, isSeason, selectNum, selectItem);
				if (!isSeason) { // 筛选的是当天热点球员
					// 照片列表
					String[] picPath = new String[selectNum];
					for (int i = 0; i < picPath.length; i++) {
						picPath[i] = playerList.get(i).getPortrait();
					}
					String[][][] playerContents = new String[selectNum][][];
					for (int i = 0; i < selectNum; i++) {
						playerContents[i] = playerList.get(i).getHotPlayerInfo(
								isSeason, selectItem);
					}
					// 姓名列表
					String[] playerNames = new String[selectNum];
					for (int i = 0; i < playerNames.length; i++) {
						playerNames[i] = playerList.get(i).getName();
					}

					// TODO 调用界面层方法，重设界面
					Main.setHotPlayerTodayPanel(picPath, playerContents,
							playerNames);

				} else { // 筛选的是赛季热点球员

					String[] picPath = new String[selectNum];
					for (int i = 0; i < picPath.length; i++) {
						picPath[i] = playerList.get(i).getPortrait();
					}
					// 球员信息显示[第几个球员][行][列]
					String[][][] playerContents = new String[selectNum][][];
					// String[][] singlePlayerContent =
					// playerList.get(0).getDailyHotPlayerInfo();
					for (int i = 0; i < selectNum; i++) {
						playerContents[i] = playerList.get(i).getHotPlayerInfo(
								isSeason, selectItem);
					}
					// 姓名列表
					String[] playerNames = new String[selectNum];
					for (int i = 0; i < playerNames.length; i++) {
						playerNames[i] = playerList.get(i).getName();
					}

					// TODO 调用界面层方法，重设界面
					Main.setHotPlayerThisYearPanel(picPath, playerContents,
							playerNames);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 筛选进步最快球员
	 */
	public void selectProgressPlayer(final int selectItem, final int selectNum) {

		ReadMatchData.readMatch.setCurrentView(new SelectProgressPlayer(
				selectItem, selectNum));

		new Waiting() {

			protected Void doInBackground() throws Exception {

				ArrayList<PlayerVO> playerList = SelectPlayer
						.selectProgressPlayer(PlayerList.players, selectItem,
								selectNum);
				// 照片列表
				String[] picPath = new String[selectNum];
				for (int i = 0; i < picPath.length; i++) {
					picPath[i] = playerList.get(i).getPortrait();
				}
				String[][][] playerContents = new String[selectNum][][];
				for (int i = 0; i < selectNum; i++) {
					playerContents[i] = playerList.get(i).getProgressInfo();
				}
				// 姓名列表
				String[] playerNames = new String[selectNum];
				for (int i = 0; i < playerNames.length; i++) {
					playerNames[i] = playerList.get(i).getName();
				}

				// TODO 调用界面层方法
				Main.setProgressGreatPlayerPanel(picPath, playerContents,
						playerNames);

				return null;
			}

		}.execute();
	}

	public class SelectProgressPlayer implements ShowView {

		private int selectItem = 0;
		private int selectNum = 0;

		public SelectProgressPlayer(int selectItem, int selectNum) {
			this.selectItem = selectItem;
			this.selectNum = selectNum;
		}

		@Override
		public void changeData() {
			ArrayList<PlayerVO> playerList = SelectPlayer.selectProgressPlayer(
					PlayerList.players, selectItem, selectNum);
			// 照片列表
			String[] picPath = new String[selectNum];
			for (int i = 0; i < picPath.length; i++) {
				picPath[i] = playerList.get(i).getPortrait();
			}
			String[][][] playerContents = new String[selectNum][][];
			for (int i = 0; i < selectNum; i++) {
				playerContents[i] = playerList.get(i).getProgressInfo();
			}
			// 姓名列表
			String[] playerNames = new String[selectNum];
			for (int i = 0; i < playerNames.length; i++) {
				playerNames[i] = playerList.get(i).getName();
			}
			// TODO 调用界面层方法
			Main.setProgressGreatPlayerPanel(picPath, playerContents,
					playerNames);

		}

	}

	/**
	 * 显示一个球员的详细信息
	 */
	public void showSinglePlayerInfo(final String name, final String startDate,
			final String endDate) {

		ReadMatchData.readMatch.setCurrentView(new ShowSinglePlayerInfo(name,
				startDate, endDate));

		new Waiting() {

			protected Void doInBackground() throws Exception {

				try {
					PlayerVO player = PlayerList.findAPlayer(name);
					if (player.getName().equalsIgnoreCase("")) {
						Main.failedToFindPlayer();
						return null;
					}
					ArrayList<PlayerDataPerMatchVO> matchDataList = SelectMatch
							.selectMatchByDate(player.getDataPerMatchList(),
									startDate, endDate);
					PlayerDataPerMatchVO matchData = new PlayerDataPerMatchVO();

					String[][] content = new String[matchDataList.size()][PlayerList
							.getHeadForSinglePlayer().length];
					// 给要显示的表格填上内容
					if (matchDataList.size() == 0) {
						content = new String[1][1];
						content[0][0] = "";
					} else {
						for (int i = 0; i < matchDataList.size(); i++) {
							matchData = matchDataList.get(i);
							String[] s = matchData.getMatchInfo();
							for (int j = 0; j < s.length; j++) {
								content[i][j] = s[j];
							}
						}
					}

					// 行表头，显示日期
					String[] dateList = new String[matchDataList.size()];
					if (matchDataList.size() == 0) {
						dateList = new String[6];
						for (int i = 0; i < dateList.length; i++) {
							dateList[i] = " ";
						}
					} else {
						for (int i = 0; i < dateList.length; i++) {
							dateList[i] = matchDataList.get(i).getMatchDate();
						}
					}

					double[] ability = player.getAbility();

					Main.setSinglePlayerPanel(player.getPortrait(),
							player.getAction(), player.getBasicPlayerInfo(),
							content, dateList,
							PlayerList.getHeadForSinglePlayer(),
							player.getName(), ability);

				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}

		}.execute();
	}

	public class ShowSinglePlayerInfo implements ShowView {

		private String name = "";
		private String startDate = "";
		private String endDate = "";

		public ShowSinglePlayerInfo(String name, String startDate,
				String endDate) {
			this.name = name;
			this.startDate = startDate;
			this.endDate = endDate;
		}

		@Override
		public void changeData() {
			try {
				PlayerVO player = PlayerList.findAPlayer(name);
				if (player.getName().equalsIgnoreCase("")) {
					Main.failedToFindPlayer();
					return;
				}

				ArrayList<PlayerDataPerMatchVO> matchDataList = SelectMatch
						.selectMatchByDate(player.getDataPerMatchList(),
								startDate, endDate);
				PlayerDataPerMatchVO matchData = new PlayerDataPerMatchVO();

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

				double[] ability = player.getAbility();

				Main.setSinglePlayerPanel(player.getPortrait(),
						player.getAction(), player.getBasicPlayerInfo(),
						content, dateList, PlayerList.getHeadForSinglePlayer(),
						player.getName(), ability);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 
	 * @param playerName
	 *            球员姓名
	 * @param index
	 *            第几个球员
	 */
	public void showPlayer(final String playerName, final int index) {
		try {
			PlayerVO player = PlayerList.findAPlayer(playerName);
			Main.setPlayerCmp_player(player.getPortrait(),
					player.getEvaluate(), index);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 雷达图
	 * @param name1
	 * @param name2
	 */
	public void showPlayerAbility(String name1, String name2, String season){
		PlayerVO player1 = PlayerList.findAPlayer(name1);
		PlayerVO player2 = PlayerList.findAPlayer(name2);
		
		player1.calSeasonData(season, false, false);
		player2.calSeasonData(season, false, false);
		
		Main.setPlayerCmp_setRadarChart(name1, player1.getAbility(), name2, player2.getAbility());
	}
	
	/**
	 * 球员统计、对比
	 * 
	 * @param name1
	 *            球员1
	 * @param name2
	 *            球员2
	 * @param season
	 *            哪个赛季
	 * @param after
	 *            是否季后赛——0：全部；1：常规赛；2：季后赛
	 * @param index
	 *            哪一项
	 * @param type
	 *            类型——0：折线图；1：箱型图
	 */
	public void playerStatistic(final String name1, final String name2,
			final String season, final int after, final int index,
			final int type) {

		// 折线图
		TimeSeries series1 = new TimeSeries(name1);
		TimeSeries series2 = new TimeSeries(name2);
		// 箱型图
		ArrayList<Double> dataForBox1 = new ArrayList<Double>();
		ArrayList<Double> dataForBox2 = new ArrayList<Double>();

		series1.add(new Day(new Date()), 1);
		// 是否只是季后赛
		boolean isOnlyPlayoff = false;
		// 是否只是季后赛
		boolean isOnlyRegular = false;

		if (after == 1) {
			isOnlyRegular = true;
		}
		if (after == 2) {
			isOnlyPlayoff = true;
		}

		try {

			PlayerVO player1 = PlayerList.findAPlayer(name1);
			PlayerVO player2 = PlayerList.findAPlayer(name2);

			System.out.println(player1.getDataPerMatchList().get(0).getSeason());
			System.out.println(player2.getDataPerMatchList().get(0).getSeason());
			System.out.println(season);
			
			player1.calSeasonData(season, isOnlyPlayoff, isOnlyRegular);
			player2.calSeasonData(season, isOnlyPlayoff, isOnlyRegular);

			for (int i = 0; i < player1.getDataPerMatchList().size(); i++) {
				PlayerDataPerMatchVO matchData = player1.getDataPerMatchList().get(i);
				if (matchData.getSeason().equals(season)) {
					System.out.println(season + matchData.getSeason());
					System.out.println(matchData.getMatchDate());
					series1.add(new Day(matchData.getDate()),
							matchData.getForStatistic(index));
					dataForBox1.add(matchData.getForStatistic(index));
				}
			}
			for (int i = 0; i < player2.getDataPerMatchList().size(); i++) {
				PlayerDataPerMatchVO matchData = player2.getDataPerMatchList()
						.get(i);
				if (matchData.getSeason().equals(season)) {
//					System.out.println(season);
					series2.add(new Day(matchData.getDate()),
							matchData.getForStatistic(index));
					dataForBox2.add(matchData.getForStatistic(index));
				}
			}
			

			if (type == 0) { // 折线图
				Main.setPlayerCmp_setTimeSeriesChart(series1, series2);
			} else { // 箱型图
				Main.setPlayerCmp_setBoxChart(name1, dataForBox1, name2,
						dataForBox2);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
