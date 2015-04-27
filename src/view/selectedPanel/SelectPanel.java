package view.selectedPanel;

import java.awt.Color;
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
		box = new IComboBox(height, height);//这只设置ComboBox的arrow的大小
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
		text.setForeground(Color.white);
		
		this.add(background);
		this.add(box);
		this.add(text, 0);
		this.setOpaque(false);
		this.setSize(width, height);
		this.setLayout(null);
	}
	
	public SelectPanel(int width, int height){
		box = new IComboBox(height, height);//这只设置ComboBox的arrow的大小
		box.setSize(width, height);
		box.setLocation(0, 0);
		box.setOpaque(false);
		
		background = Main.setJLabelWithIcon(File.file + File.TextBackground + File.PNG, width-height, height);
		background.setLocation(0, 0);
		text = new JLabel();
		text.setSize(width-height, height);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setLocation(0, 0);
		text.setOpaque(false);
		text.setForeground(Color.white);
		
		this.add(background);
		this.add(box);
		this.add(text, 0);
		this.setOpaque(false);
		this.setSize(width, height);
		this.setLayout(null);
	}
	
	public void setItems(Object[] arg){
		box.removeAllItems();
		for(int i = 0; i < arg.length; i++){
			box.addItem(arg[i]);
		}
	}
	
	public void addItems(Object i){
		box.addItem(i);
	}
	
	public void setSelectedIndex(int index){
		box.setSelectedIndex(index);
		text.setText((String)box.getSelectedItem());
		this.updateUI();
	}
	
	public String getSelectedItem(){
		return text.getText();
	}
	
	public int getSelectedIndex(){
		return box.getSelectedIndex();
	}
	
	public void removeAllItems(){
		box.removeAllItems();
	}
	
	public void action(){
		String s = (String) box.getSelectedItem();
		text.setText(s);
		text.updateUI();
	}
}
