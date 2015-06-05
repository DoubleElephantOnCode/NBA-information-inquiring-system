package view;

import java.awt.Color;
import java.awt.Font;

public class SizeAndLocationAndFont {
	static public int frameWidth = 1200, frameHeight = 650;
	
	static public int exitLabelWidth = 30, exitLabelHeight = 30;
	static public int exitLabelLocationX = frameWidth-exitLabelWidth-25, exitLabelLocationY = 25;
	
	static public int menuLabelWidth = 100, menuLabelHeight = 50;
	static public int menuLabelLocationX = 25, menuLabelLocationY = 20;
	
	static public int goForwardOrBackwardPanelWidth = 120, goForwardOrBackwardPanelHeight = 30;
	static public int goForwardWidth = 55, goForwardHeight = 30;
	static public int goBackwardWidth = 55, goBackwardHeight = 30;
	static public int goForwardOrBackwardPanelLocationX = exitLabelLocationX-50-goForwardOrBackwardPanelWidth,
			goForwardOrBackwardPanelLocationY = exitLabelLocationY;
	
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
	static public int startPanelOriWidth = 404, startPanelOriHeight = 198;
	static public int startPanelEnterWidth = 428, startPanelEnterHeight = 221;
	
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
	
	static public int beginTimePanelWidth = 300, beginTimePanelHeight = 28;
	static public int beginTimePanelLocationX = 0, beginTimePanelLocationY = 125;
	
	static public int endTimePanelWidth = 300, endTimePanelHeight = 28;
	static public int endTimePanelLocationX = 550, endTimePanelLocationY = 125;
	
	static public int checkByTimeLabelWidth = 100, checkByTimeLabelHeight = 28;
	static public int checkByTimeLabelLocationX = 375, checkByTimeLabelLocationY = 125;
	
	static public int panelBoxWidth = 150, panelBoxHeight = 28;
	static public int panelBoxLocationX = 850, panelBoxLocationY = 585;
	
	//单个球员查看面板设置参数
	static public int singlePlayerPanelWidth = 850, singlePlayerPanelHeight = 670;
	static public int singlePlayerPanelLocationX = 153, singlePlayerPanelLocationY = 148;
	
	static public int playerPhoto_1Width = 115, playerPhoto_1Height = 92;//半身照片
	static public int playerPhoto_2Width = 115, playerPhoto_2Height = 190;//运动照片
	//个人信息
	static public int singlePlayerRadarChartWidth = 170, singlePlayerRadarChartHeight = 120;//同表格高度
	static public int singlePlayerInfoTableWidth = singlePlayerPanelWidth-playerPhoto_1Width-singlePlayerRadarChartWidth, singlePlayerInfoTableHeight = 120;
	static public int singlePlayerInfoTableRow = 3, singlePlayerInfoTableColumn = 4;
	
	//历史比赛信息
	static public int playerMatchHistoryPanelWidth = singlePlayerPanelWidth-playerPhoto_2Width, playerMatchHistoryPanelHeight = 270;
	static public int playerMatchHistoryTableWidth = 600, playerMatchHistoryTableHeight = 228;
	static public int playerMatchHistoryTablePageRow = 6, playerMatchHistoryTablePageColumn = 6;//列表显示行应当为偶数
	static public int playerMatchHistoryTableLocationX = playerPhoto_2Width, playerMatchHistoryTableLocationY = 430-playerMatchHistoryPanelHeight;
	static public int playerMatchHistoryHeadListForRowWidth = 120;
	static public int playerMatchHistoryHeadListForColumnHeight = 30;
	
	static public int playerMatchHistoryChartChoiceWidth = 150, playerMatchHistoryChartChoiceHeight = 28;
	static public int playerMatchHistoryChartChoiceLocationX = 10, playerMatchHistoryChartChoiceLocationY = 440;
	
	static public int playerMatchHistoryLineChartWidth = 850, playerMatchHistoryLineChartHeight = 200;
	static public int playerMatchHistoryLineChartLocationX = 0, playerMatchHistoryLineChartLocationY = 470;
	
	//单个球员面板camera参数
	static public int singlePlayerCameraWidth = 850, singlePlayerCameraHeight = 430;
	static public int singlePlayerCameraLocationX = 153, singlePlayerCameraLocationY = 148;
	
	//单个球队查看面板设置参数
	static public int singleTeamPanelWidth = 850, singleTeamPanelHeight = 670;
	static public int singleTeamPanelLocationX = 0, singleTeamPanelLocationY = 0;
	
	static public int teamPicWidth = 115, teamPicHeight = 120;
	static public int teamPicLocationX = 0, teamPicLocationY = 0;
	
	static public int singleTeamRadarChartWidth = 170, singleTeamRadarChartHeight = 120;//同表格高度
	static public int singleTeamInfoTableWidth = singleTeamPanelWidth-teamPicWidth, singleTeamInfoTableHeight = teamPicHeight;
	
	static public int teamMatchHistoryPanelWidth = singleTeamPanelWidth, teamMatchHistoryPanelHeight = 270;
	static public int teamMatchHistoryTableWidth = 600, teamMatchHistoryTableHeight = 240;
	static public int teamMatchHistoryTablePageRow = 6, teamMatchHistoryTablePageColumn = 3;//列表显示行应当为偶数
	static public int teamMatchHistoryTableLocationX = 0, teamMatchHistoryTableLocationY = singlePlayerPanelHeight-teamMatchHistoryPanelHeight;
	static public int teamMatchHistoryHeadListForRowWidth = 220;
	static public int teamMatchHistoryHeadListForColumnHeight = 30;
	
	static public int teamMatchHistoryChartChoiceWidth = 150, teamMatchHistoryChartChoiceHeight = 28;
	static public int teamMatchHistoryChartChoiceLocationX = 10, teamMatchHistoryChartChoiceLocationY = 440;
	
	static public int teamMatchHistoryLineChartWidth = 850, teamMatchHistoryLineChartHeight = 200;
	static public int teamMatchHistoryLineChartLocationX = 0, teamMatchHistoryLineChartLocationY = 470;
	
	//单个球队面板camera参数
	static public int singleTeamCameraWidth = 850, singleTeamCameraHeight = 430;
	static public int singleTeamCameraLocationX = 153, singleTeamCameraLocationY = 148;
	
	//查询热点球员参数
	static public int hotPlayerPhotoWidth = 114, hotPlayerPhotoHeight = 86;
	static public int hotPlayerInfoPanelWidth = 739, hotPlayerInfoPanelHeight = hotPlayerPhotoHeight;
	static public int hotPlayerSelectPanelWidth = 200, hotPlayerSelectPanelHeight = 28;
//	static public Font hotPlayerSelectPanelFont = new Font("黑体",Font.BOLD,21);
	static public int hotPlayerSelectPanelLocationX = 0, hotPlayerSelectPanelLocationY = 0;
	
	static public int hotPlayerPanelWidth = 853, hotPlayerPanelHeight = 432;
	static public int hotPlayerPanelLocationX = 153, hotPlayerPanelLocationY = 148;
	
	//查询热点球队参数
	static public int hotTeamPhotoWidth = 200, hotTeamPhotoHeight = 100;
	static public int hotTeamInfoPanelWidth = 653, hotTeamInfoPanelHeight = hotTeamPhotoHeight;
	static public int hotTeamSelectPanelWidth = 200, hotTeamSelectPanelHeight = 28;
	static public int hotTeamSelectPanelLocationX = 0, hotTeamSelectPanelLocationY = 0;
	static public int hotTeamPanelWidth = 853, hotTeamPanelHeight = 432;
	static public int hotTeamPanelLocationX = 153, hotTeamPanelLocationY = 148;
	
	//查询单场比赛数据（单个球队参数）
	static public int oneTeamStatisticsTablePanelWidth = 853, oneTeamStatisticsTablePanelHeight = 180;
	static public int oneTeamStatisticsTablePanelLocationX = 0, oneTeamStatisticsTablePanelLocationY = 36;
	
	static public int oneTeamStatisticsTableWidth = 700, oneTeamStatisticsTableHeight = 135;
	static public int oneTeamStatisticsTableHeadListForRowWidth = 140;
	static public int oneTeamStatisticsTableHeadListForColumnHeight = 30;
	static public int oneTeamStatisticsTablePageRow = 5, oneTeamStatisticsTablePageColumn = 7;
	
	static public int teamStatisticsPanelSVGLabelWidth = 60, teamStatisticsPanelSVGLabelHeight = 36;
	
	static public int teamStatisticsPanelWidth = 853, teamStatisticsPanelHeight = 216;
	
	static public int matchPanelWidth = 853, matchPanelHeight = 432;
	static public int matchPanelLocationX = 153, matchPanelLocationY = 148;
}
