package model.dataLogic;

import java.io.File;

import model.readData.ReadMatchData;
import view.mainFrame.Main;
import view.mainFrame.Waiting;
import vo.MatchVO;
import vo.TeamVO;


public class ShowMatchDataModel {
	public void showMatchTable(final String date,final String homeTeam,final String awayTeam){
		ReadMatchData.readMatch.setCurrentView(null);
		
		new Waiting(){	
				
			@Override
			protected Void doInBackground() throws Exception {
				super.doInBackground();
				try{
					TeamVO teamVO = null ;
					if(homeTeam.equals("NOP")||homeTeam.equals("NOH")){
						teamVO = TeamList.findTeamVO(awayTeam);
					}else{
						teamVO = TeamList.findTeamVO(homeTeam);
					}
					MatchVO matchVO = teamVO.findMatchVO(date,awayTeam);
				
					File hometeamPicture = matchVO.getHomeTeamPicture();
					File awayteamPicture = matchVO.getAwayTeamPicture();
					String[][] homeContent = matchVO.getHomeTeamContent();
					String[][] awayContent = matchVO.getAwayTeamContent();
					String[] homerow = matchVO.getHomeTeamInfoForRow();
					String[] awayrow = matchVO.getAwayTeamInfoForRow();
					String[] column = matchVO.getInfoForColumn();
					
					Main.setMatchPanel(hometeamPicture, homeContent, homerow, column,homeTeam,
							awayteamPicture, awayContent, awayrow, column,awayTeam,date);
					
					
				}catch(Exception e){
					e.printStackTrace();
				}
				return null;
			}
		}.execute();
	}
}
