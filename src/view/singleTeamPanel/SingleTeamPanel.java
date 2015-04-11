package view.singleTeamPanel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;
import view.SVGLabel;
import view.SizeAndLocationAndFont;
import view.tablePanel.TablePanel;

public class SingleTeamPanel extends JPanel{

	static String NAME = "队名", SHORTNAME = "简写", STATE = "所在州", AREA = "赛区", ZONE = "方位", HOME = "主场", 
			FOUND = "成立年";
	
	String name, shortname, state, area, zone, home, found;
	
	JLabel teamPic;
	
	TablePanel teamInfo;
	TeamMatchHistoryTablePanel matchHistory;
	
	ImageIcon tableCellDeep, tableCellLight;
	
	int width = SizeAndLocationAndFont.singleTeamPanelWidth, height = SizeAndLocationAndFont.singleTeamPanelHeight;
	
	int teamPicWidth = SizeAndLocationAndFont.teamPicWidth,
			teamPicHeight = SizeAndLocationAndFont.teamPicHeight;
	
	int teamInfoWidth = SizeAndLocationAndFont.singleTeamInfoTableWidth, 
			teamInfoHeight = SizeAndLocationAndFont.singleTeamInfoTableHeight;
	
	public SingleTeamPanel(java.io.File svgFile, String[] info, String[][] content, String[] headListForRow, String[] headListForColumn){
		teamPic = new SVGLabel(svgFile, teamPicWidth, teamPicHeight);
		teamPic.setLocation(SizeAndLocationAndFont.teamPicLocationX, SizeAndLocationAndFont.teamPicLocationY);
		
		tableCellDeep = new ImageIcon(File.file + File.table_cell2_deep + File.PNG);
		tableCellLight = new ImageIcon(File.file + File.table_cell2_light + File.PNG);
		
		teamInfo = new TablePanel(2, 7, 2, 7, teamInfoWidth, teamInfoHeight);
		teamInfo.setLocation(SizeAndLocationAndFont.teamPicLocationX+SizeAndLocationAndFont.teamPicLabelWidth, SizeAndLocationAndFont.teamPicLocationY);
		tableCellDeep.setImage(tableCellDeep.getImage().getScaledInstance(teamInfoWidth / 7, teamInfoHeight / 2, Image.SCALE_DEFAULT));
		tableCellLight.setImage(tableCellLight.getImage().getScaledInstance(teamInfoWidth / 7, teamInfoHeight / 2, Image.SCALE_DEFAULT));
		
		teamInfo.setRowBackground(tableCellDeep, 0);
		teamInfo.setRowBackground(tableCellLight, 1);
		
		//TODO
//		teamInfo.setContent(null);
		
		matchHistory = new TeamMatchHistoryTablePanel(content, headListForRow, headListForColumn);
		
		this.add(teamPic);
		this.add(teamInfo);
		this.add(matchHistory);
		
		this.setLayout(null);
		this.setSize(width, height);
		this.setLocation(SizeAndLocationAndFont.singleTeamPanelLocationX, SizeAndLocationAndFont.singleTeamPanelLocationY);
		this.setOpaque(false);
	}
	
}
