package view.mainFrame.GoForwardOrBackward;

import java.util.Date;

import view.Type;

public class InformationForHistory {

	Type type;
	String teamName, playerName, beginDate, endDate, team2;
	Date Begin, End;
	int choice;
	boolean isSeason;
	
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
		isSeason = false;
	}
	
	public void setHotPlayerThisYear(int choice){
		this.choice = choice;
		isSeason = true;
	}
	
	public void setProgressGreatPlayer(int choice){
		this.choice = choice;
	}
	
	public void setHotTeam(int choice){
		this.choice = choice;
	}
	
	public void setplayerCount(){
		
	}
	
	public void setTeamCount(){
		
	}
	
	public void openThePanel(){
		switch(type){
		case main:
		}
	}
	
}
