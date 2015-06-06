package view.teamCompare;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYSeries;

import statisticsAnalysis.RadarChart;
import statisticsAnalysis.TimeSeriesChart;
import statisticsAnalysis.playerCompare.SingleAbilityCmp;
import view.SizeAndLocationAndFont;
import view.selectedPanel.SelectPanel;

public class TeamComparePanel extends JPanel{

	static String chart;
	static int type;
	
	boolean p1 = false, p2 = false;
	
	static SingleAbilityCmp sac;
	static TimeSeriesChart tsc;
	static ChartPanel p;
	
	static RadarChart rc;
	static ChartPanel radar;
	
	static SelectPanel season, after, chartType, chartContent;
	static SelectPanel team1, player1, team2, player2;
	
	static String[] SEASON = {"11-12", "12-13", "13-14", "14-15"},
			AFTER = {"常规赛", "季后赛"},
			CHARTTYPE = {"稳定性", "发挥状态"},
			CHARTCONTENT = {"得分", "篮板", "助攻", "抢断", "盖帽", "失误", "犯规"},
			TEAM = {""};
	
	
	public TeamComparePanel(){
		initialSelectPlayer();
		inititalSelectPanel();
		set();
	}
	
	public TeamComparePanel(java.io.File teamPic1, double[] ability_1, String team_1Name, TimeSeries series1,
			java.io.File teamPic2, double[] ability_2, String team_2Name, TimeSeries series2){
		tsc = new TimeSeriesChart(null, "时间", chart);
		tsc.add(series1);
		tsc.add(series2);
		p = tsc.getChartPanel();
		p.setSize(SizeAndLocationAndFont.playerComparePanelChart_2Width, SizeAndLocationAndFont.playerComparePanelChart_2Height);
		p.setLocation(SizeAndLocationAndFont.playerComparePanelChart_2LocationX, SizeAndLocationAndFont.playerComparePanelChart_2LocationY);
		
		XYSeries s1 = new XYSeries(team_1Name), s2 = new XYSeries(team_2Name);
		rc = new RadarChart(null, ability_1.length);
		for(int i = 0; i < ability_1.length; i++){
			s1.add(i*rc.angle, ability_1[i]);
			s2.add(i*rc.angle, ability_2[i]);
		}
		rc.add(s1);
		rc.add(s2);
		radar = rc.getChartPanel(Color.LIGHT_GRAY, true);
		radar.setSize(SizeAndLocationAndFont.playerComparePanelRadarChartWidth, SizeAndLocationAndFont.playerComparePanelRadarChartHeight);
		radar.setLocation(SizeAndLocationAndFont.playerComparePanelRadarChartLocationX, SizeAndLocationAndFont.playerComparePanelRadarChartLocationY);
	}
	
	public TeamComparePanel(java.io.File teamPic1, double[] ability_1, String team_1Name, ArrayList<Double> list1,
			java.io.File teamPic2, double[] ability_2, String team_2Name, ArrayList<Double> list2){
		sac = new SingleAbilityCmp(chart, team_1Name, list1, team_2Name, list2);
		p = sac.getChartPanel();
		
		p.setSize(SizeAndLocationAndFont.playerComparePanelChart_2Width, SizeAndLocationAndFont.playerComparePanelChart_2Height);
		p.setLocation(SizeAndLocationAndFont.playerComparePanelChart_2LocationX, SizeAndLocationAndFont.playerComparePanelChart_2LocationY);
		
		XYSeries s1 = new XYSeries(team_1Name), s2 = new XYSeries(team_2Name);
		rc = new RadarChart(null, ability_1.length);
		for(int i = 0; i < ability_1.length; i++){
			s1.add(i*rc.angle, ability_1[i]);
			s2.add(i*rc.angle, ability_2[i]);
		}
		rc.add(s1);
		rc.add(s2);
		radar = rc.getChartPanel(Color.LIGHT_GRAY, true);
		radar.setSize(SizeAndLocationAndFont.playerComparePanelRadarChartWidth, SizeAndLocationAndFont.playerComparePanelRadarChartHeight);
		radar.setLocation(SizeAndLocationAndFont.playerComparePanelRadarChartLocationX, SizeAndLocationAndFont.playerComparePanelRadarChartLocationY);
	}
	
	private void inititalSelectPanel(){
		season = new SelectPanel(SizeAndLocationAndFont.playerComparePanelSelectSeasonWidth, SizeAndLocationAndFont.playerComparePanelSelectSeasonHeight, SEASON);
		season.setLocation(SizeAndLocationAndFont.playerComparePanelSelectSeasonLocationX, SizeAndLocationAndFont.playerComparePanelSelectSeasonLocationY);
		
		after = new SelectPanel(SizeAndLocationAndFont.playerComparePanelSelectAfterWidth, SizeAndLocationAndFont.playerComparePanelSelectAfterHeight, AFTER);
		after.setLocation(SizeAndLocationAndFont.playerComparePanelSelectAfterLocationX, SizeAndLocationAndFont.playerComparePanelSelectAfterLocationY);
		
		chartType = new SelectPanel(SizeAndLocationAndFont.playerComparePanelSelectTypeWidth, SizeAndLocationAndFont.playerComparePanelSelectTypeHeight, CHARTTYPE);
		chartType.setLocation(SizeAndLocationAndFont.playerComparePanelSelectTypeLocationX, SizeAndLocationAndFont.playerComparePanelSelectTypeLocationY);
		
		chartContent = new SelectPanel(SizeAndLocationAndFont.playerComparePanelSelectChartContentWidth, SizeAndLocationAndFont.playerComparePanelSelectChartContentHeight, CHARTCONTENT);
		chartContent.setLocation(SizeAndLocationAndFont.playerComparePanelSelectChartContentLocationX, SizeAndLocationAndFont.playerComparePanelSelectChartContentLocationY);
		
		this.add(season);
		this.add(after);
		this.add(chartContent);
		this.add(chartType);
	}
	
	private void initialSelectPlayer(){
		team1 = new SelectPanel(SizeAndLocationAndFont.playerComparePanelSelectPlayer_1_TeamWidth, SizeAndLocationAndFont.playerComparePanelSelectPlayer_1_TeamHeight, TEAM);
		team1.setLocation(SizeAndLocationAndFont.playerComparePanelSelectPlayer_1_TeamLocationX, SizeAndLocationAndFont.playerComparePanelSelectPlayer_1_TeamLocationY);
		
		team2 = new SelectPanel(SizeAndLocationAndFont.playerComparePanelSelectPlayer_2_TeamWidth, SizeAndLocationAndFont.playerComparePanelSelectPlayer_2_TeamHeight, TEAM);
		team2.setLocation(SizeAndLocationAndFont.playerComparePanelSelectPlayer_2_TeamLocationX, SizeAndLocationAndFont.playerComparePanelSelectPlayer_2_TeamLocationY);
		
		player1 = new SelectPanel(SizeAndLocationAndFont.playerComparePanelSelectPlayer_1_NameWidth, SizeAndLocationAndFont.playerComparePanelSelectPlayer_1_NameHeight);
		player1.setLocation(SizeAndLocationAndFont.playerComparePanelSelectPlayer_1_NameLocationX, SizeAndLocationAndFont.playerComparePanelSelectPlayer_1_NameLocationY);
		
		player2 = new SelectPanel(SizeAndLocationAndFont.playerComparePanelSelectPlayer_2_NameWidth, SizeAndLocationAndFont.playerComparePanelSelectPlayer_2_NameHeight);
		player2.setLocation(SizeAndLocationAndFont.playerComparePanelSelectPlayer_2_NameLocationX, SizeAndLocationAndFont.playerComparePanelSelectPlayer_2_NameLocationY);
	
		this.add(team1);
		this.add(team2);
		this.add(player1);
		this.add(player2);
	}
	
	private void set(){
		this.setOpaque(false);
		this.setSize(SizeAndLocationAndFont.playerComparePanelWidth, SizeAndLocationAndFont.playerComparePanelHeight);
		this.setLayout(null);
		this.setLocation(SizeAndLocationAndFont.playerComparePanelLocationX, SizeAndLocationAndFont.playerComparePanelLocationY);
	}
	
}
