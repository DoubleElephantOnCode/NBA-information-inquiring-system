package view.infomationCenter;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class testFrame {

	JFrame test;
	TeamLogoChosenPane t;
	JPanel bg;
	
	testFrame(){
		
		test=new JFrame();
		test.setLayout(null);
		test.setSize(1200, 650);
		test.setUndecorated(true);
		test.setVisible(true);
		test.setLocationRelativeTo(null);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bg=new JPanel();
		bg.setLayout(null);
		bg.setBackground(Color.gray);
		t=new TeamLogoChosenPane();
		t.updateUI();
		bg.add(t);
		bg.updateUI();
		test.setContentPane(bg);
	    test.repaint();
	
	}
	
	
	public static void main(String args[]){
		new testFrame();
	}
}
