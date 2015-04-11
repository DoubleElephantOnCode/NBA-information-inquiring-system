package view.infomationCenter;

import javax.swing.JFrame;

public class testFrame {

	JFrame test;
	TeamLogoChosenPane t;
	
	testFrame(){
		
		test=new JFrame();
		test.setLayout(null);
		test.setSize(1200, 650);
		test.setUndecorated(true);
		test.setVisible(true);
		test.setLocationRelativeTo(null);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t=new TeamLogoChosenPane();
		t.updateUI();
		test.add(t);
	    test.repaint();
	
	}
	
	
	public static void main(String args[]){
		new testFrame();
	}
}
