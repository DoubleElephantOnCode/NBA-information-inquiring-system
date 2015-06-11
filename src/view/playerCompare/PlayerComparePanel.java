package view.playerCompare;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYSeries;

import statisticsAnalysis.RadarChart;
import statisticsAnalysis.TimeSeriesChart;
import statisticsAnalysis.playerCompare.SingleAbilityCmp;
import view.SizeAndLocationAndFont;
import view.Team;
import view.selectedPanel.SelectPanel;

public class PlayerComparePanel extends JPanel{
	static String chart;
	static int type;
	
	static boolean p1 = false, p2 = false;
	static String PLAYER1, PLAYER2;
	
	static SingleAbilityCmp sac;
	static TimeSeriesChart tsc;
	static ChartPanel p;
	
	static RadarChart rc;
	static ChartPanel radar;
	
	static SelectPanel season, after, chartType, chartContent;
	static SelectPanel team1, player1, team2, player2;
	
	static JLabel player_1, player_2, score1, score2;
	
	static String[] SEASON = {"11-12", "12-13", "13-14", "14-15"},
			AFTER = {"常规赛", "季后赛"},
			CHARTTYPE = {"稳定性", "发挥状态"},
			CHARTCONTENT = {"得分", "篮板", "助攻", "抢断", "盖帽", "失误", "犯规"},
			TEAM = Team.TEAM,
			TEANEN = Team.TEAMEN;
	
	
	public PlayerComparePanel(){
		initialSelectPlayer();
		inititalSelectPanel();
		set();
	}
	
//	public PlayerComparePanel(String player_1Pic, double[] ability_1, String player_1Name, TimeSeries series1,
//			String player_2Pic, double[] ability_2, String player_2Name, TimeSeries series2){
//		setTimeSeriesPanel(series1, series2);
//		setRadarChart(ability_1, player_1Name, ability_2, player_2Name);
//	}
	
//	public PlayerComparePanel(String player_1Pic, double[] ability_1, String player_1Name, ArrayList<Double> list1,
//			String player_2Pic, double[] ability_2, String player_2Name, ArrayList<Double> list2){
//		setBoxPanel(player_1Name, list1, player_2Name, list2);
//		setRadarChart(ability_1, player_1Name, ability_2, player_2Name);
//	}
	
	public void setPlayerPic(String playerPic, int score, int index){
		if(index == 1){
			if(player_1 != null) this.remove(player_1);
			player_1 = setJLabelWithIcon(playerPic, SizeAndLocationAndFont.playerComparePanelPhotoWidth, SizeAndLocationAndFont.playerComparePanelPhotoHeight);
			player_1.setLocation(SizeAndLocationAndFont.playerComparePanelPhoto_1LocationX, SizeAndLocationAndFont.playerComparePanelPhoto_1LocationY);
			this.add(player_1);
		}
		else if(index == 2){
			if(player_2 != null) this.remove(player_2);
			player_2 = setJLabelWithIcon(playerPic, SizeAndLocationAndFont.playerComparePanelPhotoWidth, SizeAndLocationAndFont.playerComparePanelPhotoHeight);
			player_2.setLocation(SizeAndLocationAndFont.playerComparePanelPhoto_2LocationX, SizeAndLocationAndFont.playerComparePanelPhoto_2LocationY);
			this.add(player_2);
		}
	}
	
	public void setRadarChart(double[] ability_1, String player_1Name, double[] ability_2, String player_2Name){
		if(radar != null) this.remove(radar);
		XYSeries s1 = new XYSeries(player_1Name), s2 = new XYSeries(player_2Name);
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
		this.add(radar);
	}
	
	public void setTimeSeriesPanel(TimeSeries series1, TimeSeries series2){
		if(p != null)
			this.remove(p);
		tsc = new TimeSeriesChart(null, "时间", chart);
		tsc.add(series1);
		tsc.add(series2);
		p = tsc.getChartPanel();
		p.setSize(SizeAndLocationAndFont.playerComparePanelChart_2Width, SizeAndLocationAndFont.playerComparePanelChart_2Height);
		p.setLocation(SizeAndLocationAndFont.playerComparePanelChart_2LocationX, SizeAndLocationAndFont.playerComparePanelChart_2LocationY);
		this.add(p);
	}
	
	public void setBoxPanel(String player_1Name, ArrayList<Double> list1, String player_2Name, ArrayList<Double> list2){
		if(p != null)
			this.remove(p);
		sac = new SingleAbilityCmp(chart, player_1Name, list1, player_2Name, list2);
		p = sac.getChartPanel();
		
		p.setSize(SizeAndLocationAndFont.playerComparePanelChart_2Width, SizeAndLocationAndFont.playerComparePanelChart_2Height);
		p.setLocation(SizeAndLocationAndFont.playerComparePanelChart_2LocationX, SizeAndLocationAndFont.playerComparePanelChart_2LocationY);
		this.add(p);
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
	
		team1.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				team1.action();
				int s = team1.getSelectedIndex();
				
			}
		});
		
		team2.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				team2.action();
				int s = team2.getSelectedIndex();
				
			}
		});
		
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
	
	private static JLabel setJLabelWithIcon(String IconPath, int width, int height){
		ImageIcon icon = new ImageIcon(IconPath);
		icon.setImage(icon.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
		JLabel label = new JLabel(icon);
		label.setSize(width, height);
		label.setOpaque(false);
		return label;
	}
	
}
