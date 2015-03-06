package view;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.TestControl;
import control.TestControlService;

public class TestFrame extends JFrame implements ShowService{
	
	TestControlService controllerService;
	
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
		
		sureButton = new JButton("ȷ��");
		sureButton.setSize(100, 50);
		sureButton.setLocation(400, 50);
		sureButton.addActionListener(new SureListener());
		panel.add(sureButton);
		
		nameLabel = new JLabel("����");
		nameLabel.setSize(100, 50);
		nameLabel.setLocation(100, 200);
		panel.add(nameLabel);
		
		photoLabel = new JLabel("��Ƭ");
		photoLabel.setSize(100, 50);
		photoLabel.setLocation(400, 200);
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
	
	class SureListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			controllerService = new TestControl();
			
			String name = nameField.getText();
			controllerService.showPlayerInfo(name);
		}
		
	}
}
