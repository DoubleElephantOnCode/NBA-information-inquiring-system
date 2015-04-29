package view.mainFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class LabelEnterListener implements MouseListener{
	
	public JLabel usual, enter;
	
	public LabelEnterListener(JLabel usual, JLabel enter){
		this.usual = usual;
		this.enter = enter;
	}
	

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		usual.setVisible(false);
		enter.setVisible(true);
	}


	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		usual.setVisible(true);
		enter.setVisible(false);
	}


	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}