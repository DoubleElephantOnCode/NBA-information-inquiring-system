package model.dataLogic;

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
				 teamVO = TeamList.findTeamVO(homeTeam);
				MatchVO matchVO = teamVO.findMatchVO(date,awayTeam);
				
				
				}catch(Exception e){
					
				}
				return null;
			}
		}.execute();
	}
}
