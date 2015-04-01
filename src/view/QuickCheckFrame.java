package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.tablePanel.BarInColumnPanel;

public class QuickCheckFrame extends JFrame{
	
	JLabel[][] back;
	JLabel[][] str;
	JPanel panel;
	
	int totalRow, totalColumn;
	
	ImageIcon grid_deep, grid_light;
	
	JLabel selected;
	
	BarInColumnPanel bp;
	
	int barWidth = SizeAndLocationAndFont.barWidth;
	
	int pointerRow = 0;
	
	Color fontColor = SizeAndLocationAndFont.tableLabelColor;
	
	static Point origin = new Point();//实现屏幕拖拽
	
	public QuickCheckFrame(String[] text, int width, int height, final int row, int column){
		final int labelWidth = width/column;
		final int labelHeight = height/row;
		width = labelWidth*column;
		
		panel = new JPanel();
		
		totalColumn = column;
		
		totalRow = text.length/column;
		if(text.length%column != 0){
			++totalRow;
		}
		
		height = labelHeight*(totalRow+1);
		
		panel.setSize(width, height);
		
		grid_deep = new ImageIcon(File.file + File.grid_deep + File.PNG);
		grid_deep.setImage(grid_deep.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_DEFAULT));
		
		grid_light = new ImageIcon(File.file + File.grid_light + File.PNG);
		grid_light.setImage(grid_light.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_DEFAULT));
		
		this.back = new JLabel[totalRow][totalColumn];
		this.str = new JLabel[totalRow][totalColumn];
		
		for(int i = 0; i < totalRow; i++){
			for(int j = 0; j < totalColumn; j++){
				back[i][j] = new JLabel();
				back[i][j].setSize(labelWidth, labelHeight);
				back[i][j].setLocation(j*labelWidth, i*labelHeight);
				back[i][j].setOpaque(false);
				str[i][j] = new JLabel();
				str[i][j].setSize(labelWidth, labelHeight);
				str[i][j].setLocation(j*labelWidth, i*labelHeight);
				str[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				str[i][j].setForeground(fontColor);
				str[i][j].setOpaque(false);
				panel.add(back[i][j], 0);
				panel.add(str[i][j], 0);
			}
		}
		
		for(int i = 0; i < totalRow; i++){
			if(i%2 == 0)
				for(int j = 0; j < totalColumn; j++){
					back[i][j].setIcon(grid_deep);
				}
			else
				for(int j = 0; j < totalColumn; j++){
					back[i][j].setIcon(grid_light);
				}
		}
		
		for(int i = 0; i < text.length; i++){
			str[i/totalColumn][i%totalColumn].setText(text[i]);
		}
		
		panel.setLayout(null);
		panel.setVisible(true);
		panel.setOpaque(false);
		panel.setLocation(0, 0);
		
		this.setContentPane(panel);
		this.setUndecorated(true);
		this.setSize(width, height);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		this.addMouseListener(new MouseAdapter(){
    		public void mousePressed(MouseEvent e){
    			origin.x = e.getX();
                origin.y = e.getY();
            }
            public void mouseClicked(MouseEvent e) {
            	
            }
            public void mouseReleased(MouseEvent e) {
            	super.mouseReleased(e);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	repaint();
            }
         });
		
		this.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                Point p = getLocation();
                setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y );
              }
            }
        );
	}
	
	private JLabel setJLabelWithIcon(String IconPath, int width, int height){
		ImageIcon icon = new ImageIcon(IconPath);
		icon.setImage(icon.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
		JLabel label = new JLabel(icon);
		label.setSize(width, height);
		label.setOpaque(false);
		return label;
	}
	
	public static void main(String[] args){
		String[] t = {"1", "2", "3", "4", "5", "6"};
		new QuickCheckFrame(t, 200, 300, 10, 2);
	}
	
}
