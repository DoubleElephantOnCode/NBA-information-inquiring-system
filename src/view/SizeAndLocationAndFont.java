package view;

import java.awt.Color;
import java.awt.Font;

public class SizeAndLocationAndFont {
	static public int frameWidth = 1000, frameHeight = 550;
	
	//搜索框参数
	static public int searchPanelWidth = 250, searchPanelHeight = 30,
			searchPanelLocationX = 650, searchPanelLocationY = 110;
	static public Font searchPanelFont = new Font("黑体",Font.BOLD,25);
	
	static public int selectPanelWidth = 200, selectPanelHeight = 30;
	
	static public int barWidth = 10;
	
	static public Color tableLabelColor = new Color(170, 170, 170);
	
	static public int quickCheckWidth = 30, quickCheckHeight = 30;
	
	static public int quickCheckLocationX = 900, quickCheckLocationY = 110;
	
	//开始界面
	static public int startPanelOriWidth = 337, startPanelOriHeight = 165;
	static public int startPanelEnterWidth = 340, startPanelEnterHeight = 175;
	
	static public int startPanelSplitX = 10, startPanelSplitY = 5;
	
	static public int startPanelQuitWidth = 100, startPanelQuitHeight = 50;
	
	//球员统计数据面板设置参数
	static public int playerAreaSelectPanelLocationX = 150, playerAreaSelectPanelLocationY = 110;
	
	static public int playerPositionSelectPanelLocationX = 400, playerPositionSelectPanelLocationY = 110;
	
	static public int playerCountTablePanelWidth = frameWidth, playerCountTablePanelHeight = 410;
	
	static public int playerCountTableWidth = 700, playerCountTableHeight = 300;
	
	static public int playerCountTableLocationX = 0, playerCountTableLocationY = SizeAndLocationAndFont.searchPanelLocationY+SizeAndLocationAndFont.searchPanelHeight+10;
	
	static public int playerCountPageRow = 10, playerCountPageColumn = 5;
	
	static public int playerCountHeadListForRowPanelWidth = 160;
			
	static public int playerCountHeadListForColumnPanelHeight = 45;
	
	static public int playerCountLeftSide = 80, playerCountRightSide = 20, playerCountDownSide = 20;
	
//	static public int playerCount
	
	//球队统计面板设置参数
	static public int teamCountTablePanelWidth = frameWidth, teamCountTablePanelHeight = 410;
	
	static public int teamCountTableWidth = 700, teamCountTableHeight = 300;
	
	static public int teamCountTableLocationX = 0, teamCountTableLocationY = SizeAndLocationAndFont.searchPanelLocationY+SizeAndLocationAndFont.searchPanelHeight+10;
	
	static public int teamCountPageRow = 6, teamCountPageColumn = 5;
	
	static public int teamCountHeadListForRowPanelWidth = 160;
			
	static public int teamCountHeadListForColumnPanelHeight = 45;
	
	static public int teamCountLeftSide = 80, teamCountRightSide = 20, teamCountDownSide = 20;
	
	static public int teamPicLabelWidth = 80, teamPicLabelHeight = 50;
}
