package view.singleTeamPanel;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.data.time.TimeSeries;

import statisticsAnalysis.TimeSeriesChart;
import statisticsAnalysis.teamAbility.TeamRadarChartPanel;
import view.File;
import view.SVGLabel;
import view.SizeAndLocationAndFont;
import view.TimeSetting;
import view.mainFrame.LabelEnterListener;
import view.mainFrame.LabelUsualListener;
import view.mainFrame.Main;
import view.selectedPanel.SelectPanel;
import view.tablePanel.TablePanel;
import view.timeSelectPanel.TimeSelectPanel;
import control.ShowTeamController;

public class SingleTeamPanel extends JPanel{

	static String NAME = "队名", SHORTNAME = "简写", STATE = "所在州", AREA = "赛区", ZONE = "方位", HOME = "主场", 
			FOUND = "成立年";
	
	static String[] choiceItem = {"得分", "净胜分", "篮板", "前场篮板", "后场篮板", "助攻", "抢断", "盖帽", "失误", "犯规", "三分命中率", "投篮命中率", "罚球命中率"};
	
	public static String chartItem = choiceItem[0];
	
	public static Date Begin = TimeSetting.begin, End = TimeSetting.end;
	
	String name, shortname, state, area, zone, home, found;
	
	JLabel teamPic;
	
	TablePanel teamInfo;
	TeamMatchHistoryTablePanel matchHistory;
	
	ImageIcon tableCellDeep, tableCellLight;
	
	TimeSelectPanel begin, end;
	JLabel checkByTime, checkByTimeEnter;
	
	TeamRadarChartPanel radarChart;
	TimeSeriesChart lineChart;
	SelectPanel choice;
	
	int width = SizeAndLocationAndFont.singleTeamPanelWidth, height = SizeAndLocationAndFont.singleTeamPanelHeight;
	
	int teamPicWidth = SizeAndLocationAndFont.teamPicWidth,
			teamPicHeight = SizeAndLocationAndFont.teamPicHeight;
	
	int teamInfoWidth = SizeAndLocationAndFont.singleTeamInfoTableWidth, 
			teamInfoHeight = SizeAndLocationAndFont.singleTeamInfoTableHeight;
	
	public SingleTeamPanel(java.io.File svgFile, String[] infoName, String[] info, String[][] content, String[] headListForRow, String[] headListForColumn, String teamName, double[] ability, TimeSeries series){
		name = teamName;
		
		teamPic = new SVGLabel(svgFile, teamPicWidth, teamPicHeight);
		teamPic.setLocation(SizeAndLocationAndFont.teamPicLocationX, SizeAndLocationAndFont.teamPicLocationY);
		
		tableCellDeep = new ImageIcon(File.file + File.table_cell2_deep + File.PNG);
		tableCellLight = new ImageIcon(File.file + File.table_cell2_light + File.PNG);
		
		if(infoName == null) infoName = new String[7];
		
		teamInfo = new TablePanel(4, 7, 4, 7, teamInfoWidth, teamInfoHeight);
		teamInfo.setLocation(SizeAndLocationAndFont.teamPicWidth, SizeAndLocationAndFont.teamPicLocationY);
		tableCellDeep.setImage(tableCellDeep.getImage().getScaledInstance(teamInfoWidth / 7, teamInfoHeight / 2, Image.SCALE_DEFAULT));
		tableCellLight.setImage(tableCellLight.getImage().getScaledInstance(teamInfoWidth / 7, teamInfoHeight / 2, Image.SCALE_DEFAULT));
		
		teamInfo.setRowBackground(tableCellDeep, 0);
		teamInfo.setRowBackground(tableCellLight, 1);
		teamInfo.setRowBackground(tableCellDeep, 2);
		teamInfo.setRowBackground(tableCellLight, 3);
		//TODO 基本信息表格
		if(infoName != null && info != null){
			String[][] temp;
			temp = new String[4][7];
			for(int i = 0; i < 7; i++){
				temp[0][i] = infoName[i];
				temp[2][i] = infoName[i+7];
				temp[1][i] = info[i];
				temp[3][i] = info[i+7];
			}
			teamInfo.setContent(temp);
		}
		
		//TODO
		radarChart = new TeamRadarChartPanel(ability[0], ability[1], ability[2], ability[3], ability[4]);
		radarChart.p.setSize(SizeAndLocationAndFont.singleTeamRadarChartWidth, SizeAndLocationAndFont.singleTeamRadarChartHeight);
		radarChart.p.setLocation(teamPicWidth+teamInfoWidth, 0);
		
		begin = new TimeSelectPanel(SizeAndLocationAndFont.beginTimePanelWidth, SizeAndLocationAndFont.beginTimePanelHeight, TimeSetting.beginYear, TimeSetting.endYear);
		begin.setLocation(SizeAndLocationAndFont.beginTimePanelLocationX, SizeAndLocationAndFont.beginTimePanelLocationY);
		
		end = new TimeSelectPanel(SizeAndLocationAndFont.endTimePanelWidth, SizeAndLocationAndFont.endTimePanelHeight, TimeSetting.beginYear, TimeSetting.endYear);
		end.setLocation(SizeAndLocationAndFont.endTimePanelLocationX, SizeAndLocationAndFont.endTimePanelLocationY);
		
		begin.setDate(Begin);
		end.setDate(End);
		
		checkByTime = Main.setJLabelWithIcon(File.file + File.checkByTime + File.PNG, SizeAndLocationAndFont.checkByTimeLabelWidth, SizeAndLocationAndFont.checkByTimeLabelHeight);
		checkByTimeEnter = Main.setJLabelWithIcon(File.file + File.checkByTime + File.enter + File.PNG, SizeAndLocationAndFont.checkByTimeLabelWidth, SizeAndLocationAndFont.checkByTimeLabelHeight);
		checkByTime.addMouseListener(new LabelUsualListener(checkByTime, checkByTimeEnter));
		checkByTimeEnter.addMouseListener(new LabelEnterListener(checkByTime, checkByTimeEnter){
			//TODO 重写click方法
			public void mouseClicked(MouseEvent e) {
				Begin = begin.getDate();
				End = end.getDate();
				new ShowTeamController(true).showTeamFrame(name, Begin, End, chartItem);
			}
		});
		checkByTime.setLocation(SizeAndLocationAndFont.checkByTimeLabelLocationX, SizeAndLocationAndFont.checkByTimeLabelLocationY);
		checkByTimeEnter.setLocation(SizeAndLocationAndFont.checkByTimeLabelLocationX, SizeAndLocationAndFont.checkByTimeLabelLocationY);
		checkByTimeEnter.setVisible(false);
		
		matchHistory = new TeamMatchHistoryTablePanel(content, headListForRow, headListForColumn);
		
		//TODO
		lineChart = new TimeSeriesChart(null, chartItem, "时间");
		lineChart.add(series);
		ChartPanel lineChartPanel = lineChart.getChartPanel();
		lineChartPanel.setLocation(SizeAndLocationAndFont.teamMatchHistoryLineChartLocationX, SizeAndLocationAndFont.teamMatchHistoryLineChartLocationY);
		lineChartPanel.setSize(SizeAndLocationAndFont.teamMatchHistoryLineChartWidth, SizeAndLocationAndFont.teamMatchHistoryLineChartHeight);
		
		choice = new SelectPanel(SizeAndLocationAndFont.teamMatchHistoryChartChoiceWidth, SizeAndLocationAndFont.teamMatchHistoryChartChoiceHeight, choiceItem);
		choice.setLocation(SizeAndLocationAndFont.teamMatchHistoryChartChoiceLocationX, SizeAndLocationAndFont.teamMatchHistoryChartChoiceLocationY);
		
		this.add(teamPic);
		this.add(teamInfo);
		this.add(begin);
		this.add(end);
		this.add(checkByTime);
		this.add(checkByTimeEnter, 0);
		this.add(matchHistory);
		
		this.add(radarChart.p);
		this.add(choice);
		this.add(lineChartPanel);
		
		this.setLayout(null);
		this.setSize(width, height);
		this.setLocation(SizeAndLocationAndFont.singleTeamPanelLocationX, SizeAndLocationAndFont.singleTeamPanelLocationY);
		this.setOpaque(false);
	}
	
	public static void initialTime(){
		Begin = TimeSetting.begin;
		End = TimeSetting.end;
	}
	
}
