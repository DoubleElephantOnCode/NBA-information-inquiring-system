package view.mainFrame;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import view.File;

public class Waiting extends SwingWorker<Void, Void>{
	static JPanel panel;
	static JLabel label;
	static int width = 127, height = 303;
	static int count = 0;
	
	public Waiting(){
		super();
		count++;
	}

	@Override
	protected Void doInBackground() throws Exception {
		publish();
		return null;
	}
	
	@Override
	protected void process(List<Void> chunks) {
			label = Main.setJLabelWithIcon(File.file + File.waiting + File.GIF, width, height);
			label.setLocation(0, 0);
			panel = new JPanel();
			panel.add(label);
			panel.setLayout(null);
			panel.setBounds((Main.width-width)/2, (Main.height-height)/2, width, height);
			panel.setOpaque(false);
			if(count == 1)
				Main.mainFrame.add(panel, 0);
			panel.updateUI();
	}
	
	@Override
	protected void done(){
		Main.mainFrame.remove(panel);
		Main.mainFrame.repaint();
		count--;
		if(count < 0) count = 0;
		this.cancel(true);
	}
	
}
