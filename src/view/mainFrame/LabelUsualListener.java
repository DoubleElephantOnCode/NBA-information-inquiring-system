package view.mainFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class LabelUsualListener implements MouseListener{

	public JLabel enter;
	public JLabel usual;
	public LabelUsualListener(JLabel usual, JLabel enter){
		this.enter = enter;
		this.usual = usual;
		
	}
	

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		enter.setVisible(true);
		usual.setVisible(false);
	}


	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		enter.setVisible(false);
		usual.setVisible(true);
	}


	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}