package model.dataLogic;

import java.io.File;

import view.mainFrame.Waiting;
import vo.MatchVO;
import vo.TeamVO;

public class ShowMatchDataModel {
	public void showMatchTable(final String date,final String homeTeam,final String awayTeam){
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
					String[][] awayComtent = matchVO.getAwayTeamContent();
					
				}catch(Exception e){
					e.printStackTrace();
				}
				return null;
			}
		}.execute();
	}
}
