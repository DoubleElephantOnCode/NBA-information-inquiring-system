package view.infomationCenter;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;
import view.mainFrame.Main;

/***
 * 
 * @author XYJ
 *
 */

public class TeamLogoChosenPane extends JPanel{

	
	final static String[] teamName={
		"ATL","BKN","BOS","CHA","CHI","CLE","DAL","DEN","DET","GSW",
		"HOU","IND","LAC","LAL","MEM","MIA","MIL","MIN","NOP","NYK",
		"OKC","ORL","PHI","PHX","POR","SAC","SAS","TOR","UTA","WAS"
	};
	
	JLabel backgroundIcon;
	JLabel[] teamLogo;
	
	TeamLogoChosenPane(){
		
		this.setSize(148, 576);
		this.setLocation(1024, 60);
        this.setLayout(null);
		//this.setBackground(Color.RED);
		this.setVisible(true);
		
		backgroundIcon=Main.setJLabelWithIcon(File.file+"logo_chosen_frame"+File.PNG, 148, 576);
//		backgroundIcon=Main.setJLabelWithIcon("D://image//combo.png", 67, 54);
		backgroundIcon.setLocation(0, 0);
		backgroundIcon.setVisible(true);
		
		
		this.add(backgroundIcon);
		this.updateUI();
			
	}
	
	


}
