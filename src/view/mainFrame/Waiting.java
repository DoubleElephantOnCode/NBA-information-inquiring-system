package view.mainFrame;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import view.File;

public class Waiting{
	static JPanel panel;
	static JLabel label;
	static int width = 127, height = 303;
	Timer timer;
	
	public Waiting(){
		new SwingWorker<Void, Void>(){
			@Override
			protected Void doInBackground() throws Exception {
				publish();
				return null;
			}
			@Override
			protected void process(List<Void> chunks) {
				timer = new Timer();
				TimerTask task = new TimerTask(){
					@Override
					public void run() {
						label = Main.setJLabelWithIcon(File.file + File.waiting + File.GIF, width, height);
						label.setLocation(0, 0);
						panel = new JPanel();
						panel.add(label);
						panel.setLayout(null);
						panel.setBounds((Main.width-width)/2, (Main.height-height)/2, width, height);
						panel.setOpaque(false);
						
						Main.mainFrame.add(panel, 0);
					}
				};
				timer.schedule(task, 0);
			}
		}.execute();
	}
	
	public void cancel(){
		Main.mainFrame.remove(panel);
		timer.cancel();
	}
	
}
