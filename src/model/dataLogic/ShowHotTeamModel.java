package model.dataLogic;

import java.io.File;
import java.util.ArrayList;

import view.mainFrame.Main;
import view.mainFrame.Waiting;
import vo.TeamVO;
import model.readData.ReadMatchData;

public class ShowHotTeamModel implements ShowView{
	public int i ;
	public void showTeamTable(final int i){
		
		this.i = i;
		
		ReadMatchData.readMatch.setCurrentView(this);
		
		
		new Waiting(){
			@Override
			protected Void doInBackground() throws Exception {
				super.doInBackground();
				try{
					TeamList.sortHotTeam(i);
					ArrayList<TeamVO> teamVOList = TeamList.getTeamVOList();
					File[] fs = new  File[5];
					TeamVO t;
					String[][][] content= new String[5][3][8];
					
					String[] teamNames = new String[5];
					for(int i = 0;i<5;i++){
						t = teamVOList.get(i);
						
						teamNames[i] = t.abbreviation;
						
						fs[i] = new File(t.getPath());
						String[][] s= t.toStringArrayForHotTeam();
						for(int j = 0;j<3;j++){
							for(int h = 0;h<8;h++){
								content[i][j][h] = s[j][h];
							}
						}
					}
					
					Main.setHotTeamPanel(fs, content,teamNames);
				}catch(Exception e){
					e.printStackTrace();
				}
				
				
				return null;
			}
			
		}.execute();
		

		
	}

	@Override
	public void changeData() {
		// TODO Auto-generated method stub
		try{
			TeamList.sortHotTeam(i);
			ArrayList<TeamVO> teamVOList = TeamList.getTeamVOList();
			File[] fs = new  File[5];
			TeamVO t;
			String[][][] content= new String[5][3][8];
			
			String[] teamNames = new String[5];
			
			for(int i = 0;i<5;i++){
				t = teamVOList.get(i);
				
				teamNames[i] = t.abbreviation;
				
				
				fs[i] = new File(t.getPath());
				String[][] s= t.toStringArrayForHotTeam();
				for(int j = 0;j<3;j++){
					for(int h = 0;h<8;h++){
						content[i][j][h] = s[j][h];
					}
				}
			}
			
			Main.setHotTeamPanel(fs, content,teamNames);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
}
