package view.singleTeamPanel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;
import view.SVGLabel;
import view.SizeAndLocationAndFont;
import view.mainFrame.LabelEnterListener;
import view.mainFrame.LabelUsualListener;
import view.mainFrame.Main;
import view.tablePanel.TablePanel;
import view.timeSelectPanel.TimeSelectPanel;

public class SingleTeamPanel extends JPanel{

	static String NAME = "队名", SHORTNAME = "简写", STATE = "所在州", AREA = "赛区", ZONE = "方位", HOME = "主场", 
			FOUND = "成立年";
	
	String name, shortname, state, area, zone, home, found;
	
	JLabel teamPic;
	
	TablePanel teamInfo;
	TeamMatchHistoryTablePanel matchHistory;
	
	ImageIcon tableCellDeep, tableCellLight;
	
	TimeSelectPanel begin, end;
	JLabel checkByTime, checkByTimeEnter;
	
	int width = SizeAndLocationAndFont.singleTeamPanelWidth, height = SizeAndLocationAndFont.singleTeamPanelHeight;
	
	int teamPicWidth = SizeAndLocationAndFont.teamPicWidth,
			teamPicHeight = SizeAndLocationAndFont.teamPicHeight;
	
	int teamInfoWidth = SizeAndLocationAndFont.singleTeamInfoTableWidth, 
			teamInfoHeight = SizeAndLocationAndFont.singleTeamInfoTableHeight;
	
	public SingleTeamPanel(java.io.File svgFile, String[] infoName, String[] info, String[][] content, String[] headListForRow, String[] headListForColumn){
		teamPic = new SVGLabel(svgFile, teamPicWidth, teamPicHeight);
		teamPic.setLocation(SizeAndLocationAndFont.teamPicLocationX, SizeAndLocationAndFont.teamPicLocationY);
		
		tableCellDeep = new ImageIcon(File.file + File.table_cell2_deep + File.PNG);
		tableCellLight = new ImageIcon(File.file + File.table_cell2_light + File.PNG);
		
		if(infoName == null) infoName = new String[7];
		
		teamInfo = new TablePanel(4, 7, 4, 7, teamInfoWidth, teamInfoHeight);
		teamInfo.setLocation(SizeAndLocationAndFont.teamPicLocationX+SizeAndLocationAndFont.teamPicLabelWidth, SizeAndLocationAndFont.teamPicLocationY);
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
		
		begin = new TimeSelectPanel(SizeAndLocationAndFont.beginTimePanelWidth, SizeAndLocationAndFont.beginTimePanelHeight, 2010, 2015);
		begin.setLocation(SizeAndLocationAndFont.beginTimePanelLocationX, SizeAndLocationAndFont.beginTimePanelLocationY);
		
		end = new TimeSelectPanel(SizeAndLocationAndFont.endTimePanelWidth, SizeAndLocationAndFont.endTimePanelHeight, 2010, 2015);
		end.setLocation(SizeAndLocationAndFont.endTimePanelLocationX, SizeAndLocationAndFont.endTimePanelLocationY);
		
		checkByTime = Main.setJLabelWithIcon(File.file + File.checkByTime + File.PNG, SizeAndLocationAndFont.checkByTimeLabelWidth, SizeAndLocationAndFont.checkByTimeLabelHeight);
		checkByTimeEnter = Main.setJLabelWithIcon(File.file + File.checkByTime + File.enter + File.PNG, SizeAndLocationAndFont.checkByTimeLabelWidth, SizeAndLocationAndFont.checkByTimeLabelHeight);
		checkByTime.addMouseListener(new LabelUsualListener(checkByTime, checkByTimeEnter));
		checkByTimeEnter.addMouseListener(new LabelEnterListener(checkByTime, checkByTimeEnter){
			//TODO 重写click方法
		});
		checkByTime.setLocation(SizeAndLocationAndFont.checkByTimeLabelLocationX, SizeAndLocationAndFont.checkByTimeLabelLocationY);
		checkByTimeEnter.setLocation(SizeAndLocationAndFont.checkByTimeLabelLocationX, SizeAndLocationAndFont.checkByTimeLabelLocationY);
		checkByTimeEnter.setVisible(false);
		
		matchHistory = new TeamMatchHistoryTablePanel(content, headListForRow, headListForColumn);
		
		this.add(teamPic);
		this.add(teamInfo);
		this.add(begin);
		this.add(end);
		this.add(checkByTime);
		this.add(checkByTimeEnter, 0);
		this.add(matchHistory);
		
		this.setLayout(null);
		this.setSize(width, height);
		this.setLocation(SizeAndLocationAndFont.singleTeamPanelLocationX, SizeAndLocationAndFont.singleTeamPanelLocationY);
		this.setOpaque(false);
	}
	
}
