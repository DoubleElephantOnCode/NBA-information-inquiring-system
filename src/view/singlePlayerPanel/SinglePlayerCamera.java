package view.singlePlayerPanel;

import javax.swing.JPanel;

public class SinglePlayerCamera extends JPanel{
	SinglePlayerPanel spp;
	public SinglePlayerCamera(String pathOfPhoto1, String pathOfPhoto2, String[][] info, String[][] content, String[] headListForRow, String[] headListForColumn, String playerName){
		spp = new SinglePlayerPanel(pathOfPhoto1, pathOfPhoto2, info, content, headListForRow, headListForColumn, playerName);
		
	}
	
}
