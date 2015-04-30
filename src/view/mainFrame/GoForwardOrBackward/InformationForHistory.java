package view.mainFrame.GoForwardOrBackward;

import java.util.Date;

import view.Type;
import control.ChangePageController;
import control.ShowMatchController;
import control.ShowPlayerController;
import control.ShowTeamController;

public class InformationForHistory {

	Type type;
	String teamName, playerName, beginDate, endDate, team2;
	Date Begin, End;
	int choice;
	
	public InformationForHistory(Type t){
		type = t;
	}
	
	public void setSinglePlayer(String player, String begin, String end){
		playerName = player;
		beginDate = begin;
		endDate = end;
	}
	
	public void setSingleTeam(String team, Date begin, Date end){
		teamName = team;
		Begin = begin;
		End = end;
	}
	
	public void setHotPlayerToday(int choice){
		this.choice = choice;
	}
	
	public void setHotPlayerThisYear(int choice){
		this.choice = choice;
	}
	
	public void setProgressGreatPlayer(int choice){
		this.choice = choice;
	}
	
	public void setHotTeam(int choice){
		this.choice = choice;
	}
	
	public void setPlayerCount(){
		
	}
	
	public void setTeamCount(){
		
	}
	
	public void setMatch(String date, String team1, String team2){
		beginDate = date;
		teamName = team1;
		this.team2 = team2;
	}
	
	public void openThePanel(){
		switch(type){
		case main: new ChangePageController().changePageToMainFrame();break;
		case playerCount: new ShowPlayerController(false).showPlayerInfo("-ALL", "-ALL");break;
		case teamCount: new ShowTeamController(false).showTeamTable();break;
		case singlePlayer: new ShowPlayerController(false).showSinglePlayerInfo(playerName, beginDate, endDate);break;
		case singleTeam: new ShowTeamController(false).showTeamFrame(teamName, Begin, End);break;
		case hotTeam: new ShowTeamController(false).showHotTeamTable(choice);
		case hotPlayerToday: new ShowPlayerController(false).showHotPlayerInfo(false, 5, choice);break;
		case hotPlayerThisYear: new ShowPlayerController(false).showHotPlayerInfo(true, 5, choice);break;
		case progressGreatPlayer: new ShowPlayerController(false).showProgressPlayerInfo(choice, 5);break;
		case match: new ShowMatchController(false).showMatchTable(beginDate, teamName, team2);
		default:break;
		}
	}
	
}
