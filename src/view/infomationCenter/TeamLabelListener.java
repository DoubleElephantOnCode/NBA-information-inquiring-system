package view.infomationCenter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import control.ShowTeamController;

public class TeamLabelListener implements MouseListener {

	String teamName;
	static JLabel clicked;
	int x;
	int y;
	
	TeamLabelListener(String tName, int x, int y){
		teamName = tName;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		new ShowTeamController().showTeamFrame(teamName, null, null);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		//System.out.println(this.teamName);
		
		if(clicked.isVisible()&&clicked.getX()==x&&clicked.getY()==y){
			clicked.setVisible(false);
		}
		else{
			clicked.setLocation(x, y);
			clicked.setVisible(true);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

}
