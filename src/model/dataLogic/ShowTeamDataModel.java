package model.dataLogic;

import java.io.File;
import java.util.ArrayList;

import model.readData.ReadMatchData;
import view.mainFrame.Main;
import view.mainFrame.Waiting;
import vo.TeamVO;

public class ShowTeamDataModel implements ShowView{
	public ShowView showView= this;
	File[] fs ;
		String[] column;
		String[] row ;
		String[][] content;
	public void showTeamTable(){
		ReadMatchData.readMatch.setCurrentView(this);
	    
		new Waiting(){
			@Override
			protected Void doInBackground() throws Exception {
				super.doInBackground();
				
				
				ArrayList<TeamVO> teamVOList = TeamList.getTeamVOList();
				TeamVO t = teamVOList.get(0);
				
				System.out.println(teamVOList.size());
				
				
				fs = new  File[teamVOList.size()];
				content = new String[teamVOList.size()][TeamList.getHeadListForColumn().length];
				
				try{
				for(int i = 0;i<teamVOList.size();i++){
					
					t=teamVOList.get(i);
					
					
					String[] s = t.toStringArray();
					fs[i] = new File(t.getPath());
					for(int j=0;j<s.length;j++){
						content[i][j] = s[j];
					}
				}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				column = TeamList.getHeadListForColumn();
				row = TeamList.getHeadListForRow();
				
				return null;
			}
			
			@Override
			protected void done(){
				super.done();
				System.out.println("newTeam11111");
				Main.newTeamCountPanel(content,row,column,fs);
			}
		}.execute();
		

		
	}
	
	public void sortTeamTable(final int i,final boolean isPositiveSequence){
		
		new Waiting(){
			@Override
			protected Void doInBackground() throws Exception {
				super.doInBackground();
				TeamList.sortTeam(i, isPositiveSequence);
				ArrayList<TeamVO> teamVOList = TeamList.getTeamVOList();
				File[] fs = new  File[teamVOList.size()];
				TeamVO t = teamVOList.get(0);
				String[][] content = new String[teamVOList.size()][TeamList.getHeadListForColumn().length];
				for(int h = 0;h<teamVOList.size();h++){
					t=teamVOList.get(h);
					String[] s = t.toStringArray();
					fs[h] = new File(t.getPath());
					for(int j=0;j<s.length;j++){
						content[h][j] = s[j];
					}
				}
				String[] row = TeamList.getHeadListForRow();
				
				
				Main.resetTeamCountPanel(content, row,fs);
				return null;
			}
		}.execute();
		
	}

	@Override
	public void changeData() {
		// TODO Auto-generated method stub
		
				ArrayList<TeamVO> teamVOList = TeamList.getTeamVOList();
				TeamVO t = teamVOList.get(0);
				File[] fs = new  File[teamVOList.size()];
				String[][] content = new String[teamVOList.size()][TeamList.getHeadListForColumn().length];
				for(int i = 0;i<teamVOList.size();i++){
					t=teamVOList.get(i);
					String[] s = t.toStringArray();
					fs[i] = new File(t.getPath());
					for(int j=0;j<s.length;j++){
						content[i][j] = s[j];
					}
				}
				
				String[] column = TeamList.getHeadListForColumn();
				String[] row = TeamList.getHeadListForRow();
				
				Main.newTeamCountPanel(content,row,column,fs);
				
			

	}
	
}
