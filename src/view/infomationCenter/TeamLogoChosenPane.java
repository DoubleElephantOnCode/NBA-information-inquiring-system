package view.infomationCenter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.SVGLabel;
import view.mainFrame.Main;

/***
 * 
 * @author XYJ
 *
 */

public class TeamLogoChosenPane extends JPanel{

		
	final static String[] EastTeamName={
		"ATL","BKN","BOS","CHA","CHI","CLE","DET","IND","MIA","MIL","NYK","ORL","PHI","TOR","WAS"
	};
	
	final static String[] WestTeamName={
		"DAL","DEN","GSW","HOU","LAC","LAL","MEM","MIN","NOP","OKC","PHX","POR","SAC","SAS","UTA"
	};
	
	JLabel title;
	JLabel backgroundIcon;
	JLabel[] EastTeamBG;
	JLabel[] EastTeamLogo;
	JLabel[] WestTeamBG;
	JLabel[] WestTeamLogo;
	
	JLabel light;
	
	TeamLogoChosenPane(){
		
		this.setSize(155, 580);
		this.setLocation(1024, 60);
        this.setLayout(null);
        this.setOpaque(false);
		//this.setBackground(Color.RED);
		this.setVisible(true);
		
		backgroundIcon = Main.setJLabelWithIcon(view.File.file+"logo_chosen_frame"+view.File.PNG, 155, 580);
		backgroundIcon.setLocation(0, 0);
		backgroundIcon.setVisible(true);
        
		light = Main.setJLabelWithIcon(view.File.file+view.File.teamLogoFrameLight+view.File.PNG, 73, 36);
		light.setLocation(5, 37);
        light.setVisible(false);
        this.add(light, 0);
        TeamLabelListener.clicked = light;
		
		WestTeamBG = new JLabel[15];
		EastTeamBG = new JLabel[15];
		WestTeamLogo = new SVGLabel[15];
		EastTeamLogo = new SVGLabel[15];
	
		//加入队徽
		for(int i=0; i<15; i++){
			
			int x = 5;
			int y = 37+i*36;
			
			WestTeamBG[i] = Main.setJLabelWithIcon(view.File.file+view.File.teamLogoFrame+view.File.PNG, 73, 36);
			WestTeamBG[i].setLocation(x, y);
			WestTeamBG[i].addMouseListener(new TeamLabelListener(WestTeamName[i], x, y));
			WestTeamBG[i].setVisible(true);
			
			File logoFile = new File(constant.FilePath.teamPath+"/"+WestTeamName[i]+".svg");
			WestTeamLogo[i] = new SVGLabel(logoFile, 73, 36);

			WestTeamLogo[i].setLocation(x, y);
			this.add(WestTeamBG[i]);
			this.add(WestTeamLogo[i]);			

		}
		
		for(int i=0; i<15; i++){
			
			int x = 78;
			int y = 37+i*36;
			
			EastTeamBG[i] = Main.setJLabelWithIcon(view.File.file+view.File.teamLogoFrame+view.File.PNG, 73, 36);
			EastTeamBG[i].setLocation(x, y);
			EastTeamBG[i].addMouseListener(new TeamLabelListener(EastTeamName[i], x, y));
			EastTeamBG[i].setVisible(true);

			File logoFile = new File(constant.FilePath.teamPath+"/"+EastTeamName[i]+".svg");
			EastTeamLogo[i] = new SVGLabel(logoFile, 73, 36);

			EastTeamLogo[i].setLocation(x, y);
			this.add(EastTeamBG[i]);
			this.add(EastTeamLogo[i]);
			
		}
				
		
		title = Main.setJLabelWithIcon(view.File.file+view.File.teamChosenPaneTitle+view.File.PNG, 146, 25);
		title.setLocation(4, 6);
		title.setVisible(true);
		
		this.add(title);
		this.add(backgroundIcon);
		this.updateUI();
			
	}
	
	


}
