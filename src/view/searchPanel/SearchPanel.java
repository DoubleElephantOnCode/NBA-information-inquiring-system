package view.searchPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import view.File;
import view.mainFrame.LabelUsualListener;
import view.mainFrame.Main;

public class SearchPanel extends JPanel{

	public JTextArea area;
	
	public JLabel search;
	public JLabel searchEnter;
	
	JLabel areaBackground;
	
	int width, height;
	
	public SearchPanel(int width, int height){
		this.width = width;
		this.height = height;
		
		search = Main.setJLabelWithIcon(File.file + File.search + File.PNG, (int)(height * 1.2), height);
		searchEnter = Main.setJLabelWithIcon(File.file + File.search + File.enter + File.PNG, (int)(height * 1.2), height);
		
		area = new JTextArea();
		area.setSize(width - (int)(height * 1.2), height);
		
		areaBackground = Main.setJLabelWithIcon(File.file + File.TextBackground + File.PNG, width - (int)(height * 1.2), height);
		
		area.setLocation(5, 0);
		areaBackground.setLocation(0, 0);
		
		area.setOpaque(false);
		areaBackground.setOpaque(false);
		
		search.setLocation(width - (int)(height * 1.2), 0);
		searchEnter.setLocation(width - (int)(height * 1.2), 0);
		search.setVisible(true);
		searchEnter.setVisible(false);
		
		search.addMouseListener(new LabelUsualListener(search, searchEnter));
		
		add(areaBackground, 0);
		add(area, 0);
		add(search, 0);
		add(searchEnter, 0);
		
		this.setSize(width, height);
		this.setLayout(null);
		this.setOpaque(false);
	}
	
	public String getInputText(){
		return area.getText();
	}
	
}
