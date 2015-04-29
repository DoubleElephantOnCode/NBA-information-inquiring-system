package view.mainFrame.GoForwardOrBackward;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;
import view.SizeAndLocationAndFont;
import view.mainFrame.LabelEnterListener;
import view.mainFrame.LabelUsualListener;
import view.mainFrame.Main;

public class GoForwardOrBackwardPanel extends JPanel{
	
	JLabel goForward, goBackward, goForwardEnter, goBackwardEnter;
	
	public GoForwardOrBackwardPanel(){
		goForward = Main.setJLabelWithIcon(File.file + File.goForward + File.PNG, SizeAndLocationAndFont.goForwardWidth, SizeAndLocationAndFont.goForwardHeight);
		goForwardEnter = Main.setJLabelWithIcon(File.file + File.goForward + File.enter + File.PNG, SizeAndLocationAndFont.goForwardWidth, SizeAndLocationAndFont.goForwardHeight);
		
		goBackward = Main.setJLabelWithIcon(File.file + File.goBackward + File.PNG, SizeAndLocationAndFont.goBackwardWidth, SizeAndLocationAndFont.goBackwardHeight);
		goBackwardEnter = Main.setJLabelWithIcon(File.file + File.goBackward + File.enter + File.PNG, SizeAndLocationAndFont.goBackwardWidth, SizeAndLocationAndFont.goBackwardHeight);
		
		goForward.addMouseListener(new LabelUsualListener(goForward, goForwardEnter));
		goForwardEnter.addMouseListener(new LabelEnterListener(goForward, goForwardEnter));
		goForwardEnter.setVisible(false);
		
		goBackward.addMouseListener(new LabelUsualListener(goBackward, goBackwardEnter));
		goBackwardEnter.addMouseListener(new LabelEnterListener(goBackward, goBackwardEnter));
		goBackwardEnter.setVisible(false);
		
		goBackward.setLocation(0, 0);
		goBackwardEnter.setLocation(0, 0);
		goForward.setLocation(SizeAndLocationAndFont.goBackwardWidth+10, 0);
		goForwardEnter.setLocation(SizeAndLocationAndFont.goBackwardWidth+10, 0);
		
		this.add(goForward);
		this.add(goForwardEnter, 0);
		this.add(goBackward);
		this.add(goBackwardEnter, 0);
		
		this.setLayout(null);
		this.setSize(SizeAndLocationAndFont.goForwardOrBackwardPanelWidth, SizeAndLocationAndFont.goForwardOrBackwardPanelHeight);
		this.setLocation(SizeAndLocationAndFont.goForwardOrBackwardPanelLocationX, SizeAndLocationAndFont.goForwardOrBackwardPanelLocationY);
		this.setOpaque(false);
	}
	
	public void addToPanel(JPanel p){
		p.add(this, 0);
	}
	
}
