package view.singlePlayerPanel;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

import statisticsAnalysis.TimeSeriesChart;
import statisticsAnalysis.playerAbility.PlayerRadarChartPanel;
import view.File;
import view.SizeAndLocationAndFont;
import view.TimeSetting;
import view.mainFrame.LabelEnterListener;
import view.mainFrame.LabelUsualListener;
import view.mainFrame.Main;
import view.selectedPanel.SelectPanel;
import view.tablePanel.TablePanel;
import view.timeSelectPanel.TimeSelectPanel;
import control.ShowPlayerController;

public class SinglePlayerPanel extends JPanel{
	
	static String NAME = "姓名", NUMBER = "球衣号码", POSITION = "位置", TALL = "身高", WEIGHT = "体重",
			BIRTH = "生日", AGE = "年龄", EXP = "球龄", SCHOOL = "毕业院校",
			AVGSCORE = "平均得分", AVGBOARD = "平均篮板", AVGASS = "平均助攻";
	
	static String[] choiceItem = {"得分", "篮板", "助攻", "抢断", "盖帽", "失误", "犯规", "三分命中率", "投篮命中率"};
	
	static double[] abilityWeight = {30D, 15D, 10D, 3D, 3D};
	
	static JLabel[] a = {new JLabel("得分"), new JLabel("篮板"), new JLabel("助攻"), new JLabel("抢断"), new JLabel("盖帽")};
	static int[] ax = {75, 135, 100, 45, 20};
	static int[] ay = {-15, 25, 80, 80, 25};
	
	public static Date Begin = TimeSetting.begin, End = TimeSetting.end;
	
	JLabel photo1;//静态半身照
	JLabel photo2;//静态运动照
	JLabel photo1_bg;
	JLabel photo2_bg;
	
	String name, number, position, tall, weight, birth, age, exp, school,
		avgscore, avgboard, avgass;
	
	TablePanel personalInfo;
	PlayerMatchHistoryTablePanel matchHistory;
	
	ImageIcon tableCellDeep, tableCellLight;
	ImageIcon photo1BG, photo2BG;
	ImageIcon photo1FG, photo2FG;
	
	TimeSelectPanel begin, end;
	JLabel checkByTime, checkByTimeEnter;
	
	PlayerRadarChartPanel radarChart;
	TimeSeriesChart lineChart;
	SelectPanel choice;
	
	String selfTeam;//所属球队
	
	int width = SizeAndLocationAndFont.singlePlayerPanelWidth, height = SizeAndLocationAndFont.singlePlayerPanelHeight;
	int photo1W = SizeAndLocationAndFont.playerPhoto_1Width, photo1H = SizeAndLocationAndFont.playerPhoto_1Height;
	int photo2W = SizeAndLocationAndFont.playerPhoto_2Width, photo2H = SizeAndLocationAndFont.playerPhoto_2Height;
	
	int personalInfoWidth = SizeAndLocationAndFont.singlePlayerInfoTableWidth, 
			personalInfoHeight = SizeAndLocationAndFont.singlePlayerInfoTableHeight;
	
	public SinglePlayerPanel(String pathOfPhoto1, String pathOfPhoto2, String[][] info, String[][] content, String[] headListForRow, String[] headListForColumn, String playerName, double[] ability){
		name = playerName;
		selfTeam = info[0][1];
		photo1BG = new ImageIcon(File.file + File.table_cell2_light + File.PNG);
		photo1BG.setImage(photo1BG.getImage().getScaledInstance(photo1W, personalInfoHeight, Image.SCALE_DEFAULT));
		photo1_bg = new JLabel(photo1BG);
		photo1_bg.setSize(photo1W, personalInfoHeight);
		photo1_bg.setLocation(0, 0);
		photo1_bg.setOpaque(false);
		
		photo2BG = new ImageIcon(File.file + File.table_cell2_light + File.PNG);
		photo2BG.setImage(photo2BG.getImage().getScaledInstance(photo2W, SizeAndLocationAndFont.playerMatchHistoryPanelHeight, Image.SCALE_DEFAULT));
		photo2_bg = new JLabel(photo2BG);
		photo2_bg.setSize(photo2W, SizeAndLocationAndFont.playerMatchHistoryPanelHeight);
		photo2_bg.setLocation(0, SizeAndLocationAndFont.playerMatchHistoryTableLocationY);
		photo2_bg.setOpaque(false);
		
		photo1FG = new ImageIcon(pathOfPhoto1);
		photo1FG.setImage(photo1FG.getImage().getScaledInstance(photo1W, photo1H, Image.SCALE_DEFAULT));
		photo1 = new JLabel(photo1FG);
		photo1.setSize(photo1W, photo1H);
		photo1.setLocation(0, personalInfoHeight-photo1H);
		
		photo2FG = new ImageIcon(pathOfPhoto2);
		photo2FG.setImage(photo2FG.getImage().getScaledInstance(photo2W, photo2H, Image.SCALE_DEFAULT));
		photo2 = new JLabel(photo2FG);
		photo2.setSize(photo2W, photo2H);
		photo2.setLocation(0, SizeAndLocationAndFont.playerMatchHistoryTableLocationY + photo2_bg.getHeight() - photo2H);
		//TODO
		radarChart = new PlayerRadarChartPanel(ability[0], ability[1], ability[2], ability[3], ability[4]);
		radarChart.p.setSize(SizeAndLocationAndFont.singlePlayerRadarChartWidth, SizeAndLocationAndFont.singlePlayerRadarChartHeight);
		radarChart.p.setLocation(photo1W+personalInfoWidth, 0);
		radarChart.p.setLayout(null);
		for(int i = 0; i < 5; i++){
			a[i].setOpaque(false);
			a[i].setSize(50, 50);
			a[i].setLocation(ax[i], ay[i]);
			radarChart.p.add(a[i], 0);
		}
		
		tableCellDeep = new ImageIcon(File.file + File.table_cell2_deep + File.PNG);
		tableCellLight = new ImageIcon(File.file + File.table_cell2_light + File.PNG);
		
		personalInfo = new TablePanel(info.length, info[0].length, info.length, info[0].length, personalInfoWidth, personalInfoHeight);
		tableCellDeep.setImage(tableCellDeep.getImage().getScaledInstance(personalInfoWidth / info[0].length, personalInfoHeight / info.length, Image.SCALE_DEFAULT));
		tableCellLight.setImage(tableCellLight.getImage().getScaledInstance(personalInfoWidth / info[0].length, personalInfoHeight / info.length, Image.SCALE_DEFAULT));
		
		for(int i = 0; i < info.length; i++){
			if(i%2 == 0)
				personalInfo.setRowBackground(tableCellLight, i);
			else
				personalInfo.setRowBackground(tableCellDeep, i);
		}
		
		personalInfo.setLocation(photo1W, 0);
		personalInfo.setContent(info);
		
		begin = new TimeSelectPanel(SizeAndLocationAndFont.beginTimePanelWidth, SizeAndLocationAndFont.beginTimePanelHeight, 2010, 2015);
		begin.setLocation(SizeAndLocationAndFont.beginTimePanelLocationX, SizeAndLocationAndFont.beginTimePanelLocationY);
		
		end = new TimeSelectPanel(SizeAndLocationAndFont.endTimePanelWidth, SizeAndLocationAndFont.endTimePanelHeight, 2010, 2015);
		end.setLocation(SizeAndLocationAndFont.endTimePanelLocationX, SizeAndLocationAndFont.endTimePanelLocationY);
		
		begin.setDate(Begin);
		end.setDate(End);
		
		checkByTime = Main.setJLabelWithIcon(File.file + File.checkByTime + File.PNG, SizeAndLocationAndFont.checkByTimeLabelWidth, SizeAndLocationAndFont.checkByTimeLabelHeight);
		checkByTimeEnter = Main.setJLabelWithIcon(File.file + File.checkByTime + File.enter + File.PNG, SizeAndLocationAndFont.checkByTimeLabelWidth, SizeAndLocationAndFont.checkByTimeLabelHeight);
		checkByTime.addMouseListener(new LabelUsualListener(checkByTime, checkByTimeEnter));
		checkByTimeEnter.addMouseListener(new LabelEnterListener(checkByTime, checkByTimeEnter){
			public void mouseClicked(MouseEvent e) {
				Begin = begin.getDate();
				End = end.getDate();
				new ShowPlayerController(true).showSinglePlayerInfo(name, TimeSetting.sdf.format(Begin), TimeSetting.sdf.format(End));
			}
		});
		checkByTime.setLocation(SizeAndLocationAndFont.checkByTimeLabelLocationX, SizeAndLocationAndFont.checkByTimeLabelLocationY);
		checkByTimeEnter.setLocation(SizeAndLocationAndFont.checkByTimeLabelLocationX, SizeAndLocationAndFont.checkByTimeLabelLocationY);
		checkByTimeEnter.setVisible(false);
		
		matchHistory = new PlayerMatchHistoryTablePanel(content, headListForRow, headListForColumn, selfTeam);
		
		//TODO
		lineChart = new TimeSeriesChart(null, "得分", "时间");
		ChartPanel lineChartPanel = lineChart.getChartPanel();
		lineChartPanel.setLocation(SizeAndLocationAndFont.playerMatchHistoryLineChartLocationX, SizeAndLocationAndFont.playerMatchHistoryLineChartLocationY);
		lineChartPanel.setSize(SizeAndLocationAndFont.playerMatchHistoryLineChartWidth, SizeAndLocationAndFont.playerMatchHistoryLineChartHeight);
		
		choice = new SelectPanel(SizeAndLocationAndFont.playerMatchHistoryChartChoiceWidth, SizeAndLocationAndFont.playerMatchHistoryChartChoiceHeight, choiceItem);
		choice.setLocation(SizeAndLocationAndFont.playerMatchHistoryChartChoiceLocationX, SizeAndLocationAndFont.playerMatchHistoryChartChoiceLocationY);
		
		choice.box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String item = choice.getSelectedItem();
				int index = getHeadListIndex(item);
				if(index > 0){
					
					choice.action();
				}
			}
		});
		
		this.add(photo1_bg);
		this.add(photo1, 0);
		this.add(photo2_bg);
		this.add(photo2, 0);
		this.add(personalInfo);
		this.add(begin);
		this.add(end);
		this.add(checkByTime);
		this.add(checkByTimeEnter, 0);
		this.add(matchHistory);
		
		this.add(radarChart.p);
		this.add(choice);
		this.add(lineChartPanel);
		
		this.setLayout(null);
		this.setOpaque(false);
		this.setSize(width, height);
		this.setLocation(SizeAndLocationAndFont.singlePlayerPanelLocationX, SizeAndLocationAndFont.singlePlayerPanelLocationY);
	}
	
	public static void initialTime(){
		Begin = TimeSetting.begin;
		End = TimeSetting.end;
	}
	
	private int getHeadListIndex(String item){
		for(int i = 0; i < matchHistory.headListForColumn.length; i++){
			if(matchHistory.headListForColumn[i].equals(item)){
				return i;
			}
		}
		return -1;
	}
	
}
