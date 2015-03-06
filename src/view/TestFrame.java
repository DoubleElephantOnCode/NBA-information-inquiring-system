package view;

import java.awt.Button;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestFrame extends JFrame implements ShowService{
	
	JPanel panel;
	JLabel nameLabel;
	JLabel photoLabel;
	JButton sureButton;
	JTextField nameField;
	public TestFrame(){
		setSize(800,400);
		
		panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		
		nameField = new JTextField();
		nameField.setSize(100,50);
		nameField.setLocation(100, 50);
		panel.add(nameField);
		
		sureButton = new JButton("»∑»œ");
		sureButton.setSize(100, 50);
		sureButton.setLocation(400, 50);
		panel.add(sureButton);
		
		nameLabel = new JLabel("–’√˚");
		nameLabel.setSize(100, 50);
		nameLabel.setLocation(100, 200);
		panel.add(nameLabel);
		
		photoLabel = new JLabel("’’∆¨");
		photoLabel.setSize(100, 50);
		photoLabel.setLocation(100, 200);
		panel.add(photoLabel);
		
		panel.setVisible(true);
		setVisible(true);
	}
	
	
	private void showName(String name) {
		nameLabel.setText(name);
	}
	private void showPhoto(ImageIcon photo) {
		photoLabel.setIcon(photo);
	}


	public void showInfo(String name, ImageIcon photo) {
		// TODO Auto-generated method stub
		showName(name);
		showPhoto(photo) ;
	}
}
