package view.mainFrame;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.File;
import view.SizeAndLocationAndFont;
import view.mainFrame.GoForwardOrBackward.GoForwardOrBackwardPanel;
import view.startView.StartPanel;
import control.ChangePageController;

public class MenuLabel {

	JLabel menu;
	JLabel menuEnter;
	
	int width = SizeAndLocationAndFont.menuLabelWidth, height = SizeAndLocationAndFont.menuLabelHeight;
	
	ArrayList<JPanel> pList;
	
	public MenuLabel(){
		menu = Main.setJLabelWithIcon(File.file + File.menu + File.PNG, width, height);
		menuEnter = Main.setJLabelWithIcon(File.file + File.menu + File.enter + File.PNG, width, height);
		menu.setLocation(SizeAndLocationAndFont.menuLabelLocationX, SizeAndLocationAndFont.menuLabelLocationY);
		menuEnter.setLocation(SizeAndLocationAndFont.menuLabelLocationX, SizeAndLocationAndFont.menuLabelLocationY);
		menuEnter.setVisible(false);
		
		menu.setOpaque(false);
		menuEnter.setOpaque(false);
		
//		pList = new ArrayList<JPanel>(); TODO
		
		menu.addMouseListener(new LabelUsualListener(menu, menuEnter));
		menuEnter.addMouseListener(new LabelEnterListener(menu, menuEnter){
			@Override
			public void mouseClicked(MouseEvent e) {
				if(StartPanel.self == null) return;
				StartPanel.self.setVisible(true);
				//TODO 移除加入的界面
				if(Main.teamCountPanel != null) Main.mainFrame.remove(Main.teamCountPanel);
				if(Main.playerCountPanel != null) Main.mainFrame.remove(Main.playerCountPanel);
				if(Main.informationCenterPanel != null) Main.mainFrame.remove(Main.informationCenterPanel);
//				for(JPanel p : pList){ TODO
//					if(p != null) Main.mainFrame.remove(p);
//				}
				
				StartPanel.exit = new ExitLabel();
				StartPanel.exit.addToPanel(StartPanel.self);
				StartPanel.goForwardOrBackward = new GoForwardOrBackwardPanel();
				StartPanel.goForwardOrBackward.addToPanel(StartPanel.self);
				
				
				if(StartPanel.background == null){
					StartPanel.background = StartPanel.Background.getIcon();
				}
				StartPanel.Background.setIcon(StartPanel.BackgroundDarker.getIcon());
				StartPanel.Background.updateUI();
				
				StartPanel.self.remove(menu);
				StartPanel.self.remove(menuEnter);
				
				StartPanel.self.add(StartPanel.Quit, 0);
				StartPanel.self.add(StartPanel.QuitEnter, 0);
				
				StartPanel.Quit.setVisible(true);
				StartPanel.QuitEnter.setVisible(false);
				
				StartPanel.TeamCount.setVisible(true);
				StartPanel.TeamInfo.setVisible(true);
				StartPanel.PlayerCount.setVisible(true);
				StartPanel.PlayerInfo.setVisible(true);
				
				new ChangePageController().changePageToMainFrame();
			}
		});
	}
	
	public void addToPanel(JPanel p){
		p.add(menu, 0);
		p.add(menuEnter, 0);
		menu.setVisible(true);
		menuEnter.setVisible(false);
	}
	
	public void addListenPanel(JPanel p){
		pList.add(p);
	}
	
}
