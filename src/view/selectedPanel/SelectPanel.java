package view.selectedPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.File;
import view.mainFrame.Main;

public class SelectPanel extends JPanel{
	
	JLabel background;
	JLabel text;
	public IComboBox box;
	
	public SelectPanel(int width, int height, String[] item){
		box = new IComboBox();
		box.setSize(width, height);
		box.setLocation(0, 0);
		box.setOpaque(false);
		for(int i = 0; i < item.length; i++){
			box.addItem(item[i]);
		}
		
		background = Main.setJLabelWithIcon(File.file + File.TextBackground + File.PNG, width-height, height);
		background.setLocation(0, 0);
		text = new JLabel();
		text.setSize(width-height, height);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setLocation(0, 0);
		text.setText(item[0]);
		text.setOpaque(false);
		text.setForeground(XUtil.fontColor);
		
		this.add(background);
		this.add(box);
		this.add(text, 0);
		this.setOpaque(false);
		this.setSize(width, height);
		this.setLayout(null);
	}
	
	public String getSelectedItem(){
		return text.getText();
	}
	
	public void action(){
		String s = (String) box.getSelectedItem();
		text.setText(s);
		text.updateUI();
	}
}
