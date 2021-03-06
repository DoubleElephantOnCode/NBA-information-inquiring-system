package view.playerCompare;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.dataLogic.SelectPlayer;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYSeries;

import statisticsAnalysis.RadarChart;
import statisticsAnalysis.TimeSeriesChart;
import statisticsAnalysis.playerCompare.SingleAbilityCmp;
import view.SizeAndLocationAndFont;
import view.Team;
import view.selectedPanel.SelectPanel;
import control.PlayerStatisticController;

public class PlayerComparePanel extends JPanel{
	static String chart;
	static int Type;
	static String Season = Team.SEASON[0];
	static int s = 0;
	static int content = 0;
	
	static boolean p1 = false, p2 = false;
	static String PLAYER1, PLAYER2;
	
	static SingleAbilityCmp sac;
	static TimeSeriesChart tsc;
	static ChartPanel p;
	
	static RadarChart rc;
	static ChartPanel radar;
	
	static SelectPanel season, after, chartType, chartContent;
	static SelectPanel team1, player1, team2, player2;
	
	static JLabel player_1, player_2, score_1, score_2;
	
	static JLabel[] a = {new JLabel("得分"), new JLabel("篮板"), new JLabel("助攻"), new JLabel("抢断"), new JLabel("盖帽")};
	static int[] ax = {130, 200, 175, 85, 50};
	static int[] ay = {-10, 40, 120, 120, 40};
	
	static String[] SEASON = Team.SEASON,
			AFTER = Team.ISAFTER,
			CHARTTYPE = {"折线图", "箱形图"},
			CHARTCONTENT = {"得分", "篮板", "助攻", "盖帽", "抢断", "犯规", "失误", "投篮命中率", "三分命中率", "罚球命中率", "上场时间"},
			TEAM = Team.TEAM,
			TEAMEN = Team.TEAMEN;
	
	
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
			this.add(player_1, 0);
			
			if(score_1 != null) this.remove(score_1);
			score_1 = new JLabel(Integer.toString(score), JLabel.CENTER);
			score_1.setSize(SizeAndLocationAndFont.playerComparePanelScoreLabelWidth, SizeAndLocationAndFont.playerComparePanelScoreLabelHeight);
			score_1.setLocation(SizeAndLocationAndFont.playerComparePanelScore_1LabelLocationX, SizeAndLocationAndFont.playerComparePanelScore_1LabelLocationY);
			score_1.setOpaque(false);
			score_1.setFont(SizeAndLocationAndFont.scoreFont);
			score_1.setVisible(true);
			score_1.setForeground(Color.white);
			this.add(score_1, 0);
		}
		else if(index == 2){
			if(player_2 != null) this.remove(player_2);
			player_2 = setJLabelWithIcon(playerPic, SizeAndLocationAndFont.playerComparePanelPhotoWidth, SizeAndLocationAndFont.playerComparePanelPhotoHeight);
			player_2.setLocation(SizeAndLocationAndFont.playerComparePanelPhoto_2LocationX, SizeAndLocationAndFont.playerComparePanelPhoto_2LocationY);
			this.add(player_2, 0);
			
			if(score_2 != null) this.remove(score_2);
			score_2 = new JLabel(Integer.toString(score), JLabel.CENTER);
			score_2.setSize(SizeAndLocationAndFont.playerComparePanelScoreLabelWidth, SizeAndLocationAndFont.playerComparePanelScoreLabelHeight);
			score_2.setLocation(SizeAndLocationAndFont.playerComparePanelScore_2LabelLocationX, SizeAndLocationAndFont.playerComparePanelScore_2LabelLocationY);
			score_2.setOpaque(false);
			score_2.setFont(SizeAndLocationAndFont.scoreFont);
			score_2.setVisible(true);
			score_2.setForeground(Color.white);
			this.add(score_2, 0);
		}
	}
	
	public void setRadarChart(double[] ability_1, String player_1Name, double[] ability_2, String player_2Name){
		if(radar != null) this.remove(radar);
		if(ability_1.length != ability_2.length || ability_1.length != 5) return;
		XYSeries s1 = new XYSeries(player_1Name), s2 = new XYSeries(player_2Name);
		rc = new RadarChart(null, ability_1.length);
		s1.add(0*rc.angle, ability_1[0]/30D);
		s2.add(0*rc.angle, ability_2[0]/30D);
		s1.add(rc.angle, ability_1[1]/15D);
		s2.add(rc.angle, ability_2[1]/15D);
		s1.add(2*rc.angle, ability_1[2]/10D);
		s2.add(2*rc.angle, ability_2[2]/10D);
		s1.add(3*rc.angle, ability_1[3]/3D);
		s2.add(3*rc.angle, ability_2[3]/3D);
		s1.add(4*rc.angle, ability_1[4]/3D);
		s2.add(4*rc.angle, ability_2[4]/3D);
		rc.add(s1);
		rc.add(s2);
		radar = rc.getChartPanel(Color.LIGHT_GRAY, true);
		radar.setSize(SizeAndLocationAndFont.playerComparePanelRadarChartWidth, SizeAndLocationAndFont.playerComparePanelRadarChartHeight);
		radar.setLocation(SizeAndLocationAndFont.playerComparePanelRadarChartLocationX, SizeAndLocationAndFont.playerComparePanelRadarChartLocationY);
		radar.setLayout(null);
		for(int i = 0; i < 5; i++){
			a[i].setOpaque(false);
			a[i].setSize(50, 50);
			a[i].setLocation(ax[i], ay[i]);
			radar.add(a[i], 0);
		}
		
		this.add(radar);
	}
	
	public void setTimeSeriesPanel(TimeSeries series1, TimeSeries series2, int v1, int v2){//TODO
		if(p != null)
			this.remove(p);
		
		tsc = new TimeSeriesChart(PLAYER1+CHARTCONTENT[content]+"稳定性"+getResult(v1)+PLAYER2+"\n"+PLAYER1+CHARTCONTENT[content]+"能力"+getResult(v2)+PLAYER2, "时间", chart);
		tsc.add(series1);
		tsc.add(series2);
//		p = tsc.getChartPanel();
//		p.setSize(SizeAndLocationAndFont.playerComparePanelChart_2Width, SizeAndLocationAndFont.playerComparePanelChart_2Height);
//		p.setLocation(SizeAndLocationAndFont.playerComparePanelChart_2LocationX, SizeAndLocationAndFont.playerComparePanelChart_2LocationY);
//		this.add(p);
		JFreeChart c = tsc.getJFreeChart();
		TimeSeriesChart.setRange(c, new Date(112+s, 9, 20), new Date(113+s, 6, 30));
		p = new ChartPanel(c, true);
		p.setSize(SizeAndLocationAndFont.playerComparePanelChart_2Width, SizeAndLocationAndFont.playerComparePanelChart_2Height);
		p.setLocation(SizeAndLocationAndFont.playerComparePanelChart_2LocationX, SizeAndLocationAndFont.playerComparePanelChart_2LocationY);
		this.add(p);
	}
	
	public void setBoxPanel(String player_1Name, ArrayList<Double> list1, String player_2Name, ArrayList<Double> list2, int v1, int v2){//TODO
		if(p != null)
			this.remove(p);
		sac = new SingleAbilityCmp(PLAYER1+CHARTCONTENT[content]+"稳定性"+getResult(v1)+PLAYER2+"\n"+PLAYER1+CHARTCONTENT[content]+"能力"+getResult(v2)+PLAYER2, chart, player_1Name, list1, player_2Name, list2);
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
		
		season.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				season.action();
				Season = season.getSelectedItem();
				s = season.getSelectedIndex();
				setChart_2();
				setAbilityChart();
			}
		});
		
		after.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				after.action();
				setChart_2();
			}
		});
		
		chartContent.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chartContent.action();
				content = chartContent.getSelectedIndex();
				setChart_2();
			}
		});
		
		chartType.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chartType.action();
				setChart_2();
			}
		});
		
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
				p1 = false;
				player1.setItems(SelectPlayer.selectByTeam(TEAMEN[s]));
			}
		});
		
		team2.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				team2.action();
				int s = team2.getSelectedIndex();
				p2 = false;
				player2.setItems(SelectPlayer.selectByTeam(TEAMEN[s]));
			}
		});
		
		player1.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				player1.action();
				PLAYER1 = player1.getSelectedItem();
				p1 = true;
				if(PLAYER1 == null) p1 = false;
				new PlayerStatisticController().showPlayer(PLAYER1, 1);
				setAbilityChart();
				setChart_2();
			}
		});
		
		player2.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				player2.action();
				PLAYER2 = player2.getSelectedItem();
				p2 = true;
				if(PLAYER2 == null) p2 = false;
				new PlayerStatisticController().showPlayer(PLAYER2, 2);
				setAbilityChart();
				setChart_2();
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
	
	private void setAbilityChart(){
		if(p1&&p2&&(!PLAYER1.equals(PLAYER2))){//两个球员选定
			new PlayerStatisticController().showPlayerAbility(PLAYER1, PLAYER2, Season);
		}
	}
	
	private void setChart_2(){
		if(p1&&p2&&(!PLAYER1.equals(PLAYER2))){
			new PlayerStatisticController().playerStatistic(PLAYER1, PLAYER2, Season, after.getSelectedIndex(), chartContent.getSelectedIndex(), chartType.getSelectedIndex());
		}
	}
	
	private static JLabel setJLabelWithIcon(String IconPath, int width, int height){
		ImageIcon icon = new ImageIcon(IconPath);
		icon.setImage(icon.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
		JLabel label = new JLabel(icon);
		label.setSize(width, height);
		label.setOpaque(false);
		return label;
	}
	
	private enum R{
		显著高于,
		显著低于,
		不显著高于,
		不明确
	}
	
	private String getResult(int v){
		switch(v){
		case 1:
			return R.显著高于.toString();
		case -1:
			return R.显著低于.toString();
		case 0:
			return R.不显著高于.toString();
		default:
			return R.不明确.toString();
		}
	}
	
}
