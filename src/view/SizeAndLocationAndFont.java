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
}
