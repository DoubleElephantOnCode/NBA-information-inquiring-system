package view;

import java.awt.Color;
import java.awt.Font;

public class SizeAndLocationAndFont {
	static public int frameWidth = 1200, frameHeight = 650;
	
	//搜索框参数
	static public int searchPanelWidth = 300, searchPanelHeight = 35,
			searchPanelLocationX = 780, searchPanelLocationY = 130;
	static public Font searchPanelFont = new Font("黑体",Font.BOLD,27);
	
	static public int selectPanelWidth = 240, selectPanelHeight = 35;
	
	static public int barWidth = 12;
	
	static public Color tableLabelColor = new Color(170, 170, 170);
	
	static public int quickCheckWidth = 36, quickCheckHeight = 35;
	
	static public int quickCheckLocationX = 1080, quickCheckLocationY = 130;
	
	//开始界面
	static public int startPanelOriWidth = 404, startPanelOriHeight = 195;
	static public int startPanelEnterWidth = 408, startPanelEnterHeight = 206;
	
	static public int startPanelSplitX = 12, startPanelSplitY = 6;
	
	static public int startPanelQuitWidth = 100, startPanelQuitHeight = 50;
	
	//球员统计数据面板设置参数
	static public int playerAreaSelectPanelLocationX = 180, playerAreaSelectPanelLocationY = 130;
	
	static public int playerPositionSelectPanelLocationX = 480, playerPositionSelectPanelLocationY = 130;
	
	static public int playerCountTablePanelWidth = frameWidth, playerCountTablePanelHeight = 485;
	
	static public int playerCountTableWidth = 840, playerCountTableHeight = 360;
	
	static public int playerCountTableLocationX = 0, playerCountTableLocationY = SizeAndLocationAndFont.searchPanelLocationY+SizeAndLocationAndFont.searchPanelHeight+10;
	
	static public int playerCountPageRow = 12, playerCountPageColumn = 6;//列表显示行应当为偶数
	
	static public int playerCountHeadListForRowPanelWidth = 192;
			
	static public int playerCountHeadListForColumnPanelHeight = 53;
	
	static public int playerCountLeftSide = 96, playerCountRightSide = 24, playerCountDownSide = 25;
	
//	static public int playerCount
	
	//球队统计面板设置参数
	static public int teamCountTablePanelWidth = frameWidth, teamCountTablePanelHeight = 485;
	
	static public int teamCountTableWidth = 840, teamCountTableHeight = 360;
	
	static public int teamCountTableLocationX = 0, teamCountTableLocationY = SizeAndLocationAndFont.searchPanelLocationY+SizeAndLocationAndFont.searchPanelHeight+10;
	
	static public int teamCountPageRow = 6, teamCountPageColumn = 6;//列表显示行应当为偶数
	
	static public int teamCountHeadListForRowPanelWidth = 192;
			
	static public int teamCountHeadListForColumnPanelHeight = 53;
	
	static public int teamCountLeftSide = 96, teamCountRightSide = 24, teamCountDownSide = 25;
	
	static public int teamPicLabelWidth = 96, teamPicLabelHeight = 59;
	
	//信息中心界面参数
	//球员搜索框参数
	static public int searchPlayerPanelWidth = 213, searchPlayerPanelHeight = 28;
	static public int searchPlayerPanelLocationX = 787, searchPlayerPanelLocationY = 61;
	static public Font searchPlayerPanelFont = new Font("黑体",Font.BOLD,21);
	
	//单个球员查看面板设置参数
	static public int singlePlayerPanelWidth = 850, singlePlayerPanelHeight = 430;
	static public int singlePlayerPanelLocationX = 153, singlePlayerPanelLocationY = 148;
	
	static public int playerPhoto_1Width = 115, playerPhoto_1Height = 92;//半身照片
	static public int playerPhoto_2Width = 115, playerPhoto_2Height = 190;//运动照片
	//个人信息
	static public int singlePlayerInfoTableWidth = singlePlayerPanelWidth-playerPhoto_1Width, singlePlayerInfoTableHeight = 120;
	static public int singlePlayerInfoTableRow = 3, singlePlayerInfoTableColumn = 4;
	//历史比赛信息
	static public int playerMatchHistoryPanelWidth = singlePlayerPanelWidth-playerPhoto_2Width, playerMatchHistoryPanelHeight = 270;
	static public int playerMatchHistoryTableWidth = 600, playerMatchHistoryTableHeight = 228;
	static public int playerMatchHistoryTablePageRow = 6, playerMatchHistoryTablePageColumn = 6;//列表显示行应当为偶数
	static public int playerMatchHistoryTableLocationX = playerPhoto_2Width, playerMatchHistoryTableLocationY = singlePlayerPanelHeight-playerMatchHistoryPanelHeight;
	static public int playerMatchHistoryHeadListForRowWidth = 120;
	static public int playerMatchHistoryHeadListForColumnHeight = 30;
	
	//单个球队查看面板设置参数
	static public int singleTeamPanelWidth = 850, singleTeamPanelHeight = 430;
	static public int singleTeamPanelLocationX = 153, singleTeamPanelLocationY = 148;
	
	static public int teamPicWidth = 115, teamPicHeight = 120;
	static public int teamPicLocationX = 0, teamPicLocationY = 0;
	
	static public int singleTeamInfoTableWidth = singleTeamPanelWidth-teamPicWidth, singleTeamInfoTableHeight = teamPicHeight;
	
	static public int teamMatchHistoryPanelWidth = singleTeamPanelWidth, teamMatchHistoryPanelHeight = 270;
	static public int teamMatchHistoryTableWidth = 700, teamMatchHistoryTableHeight = 228;
	static public int teamMatchHistoryTablePageRow = 6, teamMatchHistoryTablePageColumn = 7;//列表显示行应当为偶数
	static public int teamMatchHistoryTableLocationX = 0, teamMatchHistoryTableLocationY = singlePlayerPanelHeight-teamMatchHistoryPanelHeight;
	static public int teamMatchHistoryHeadListForRowWidth = 120;
	static public int teamMatchHistoryHeadListForColumnHeight = 30;
}
