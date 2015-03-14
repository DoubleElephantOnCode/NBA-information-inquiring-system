package view.mainFrame;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;


public class ExitLabel {

	static JLabel exit;
	static JLabel exitEnter;
	
	int width = 30, height = 30;
	
	public ExitLabel(){
		exit = Main.setJLabelWithIcon(File.file + File.exit + File.PNG, width, height);
		exitEnter = Main.setJLabelWithIcon(File.file + File.exit + File.enter + File.PNG, width, height);
		exit.setLocation(Main.width - width - 10, 10);
		exitEnter.setLocation(Main.width - width - 10, 10);
		exitEnter.setVisible(false);
		
		exit.setOpaque(false);
		exitEnter.setOpaque(false);
		
		exit.addMouseListener(new LabelUsualListener(exit, exitEnter));
		exitEnter.addMouseListener(new LabelEnterListener(exit, exitEnter){
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void addToPanel(JPanel p){
		p.add(exit, 0);
		p.add(exitEnter, 0);
		exit.setVisible(true);
		exitEnter.setVisible(false);
	}
	
}
