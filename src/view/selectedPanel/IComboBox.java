package view.selectedPanel;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class IComboBox extends JComboBox{  
 int width, height;
 public IComboBox(int width, int height){  
  super();  
  this.width = width;
  this.height = height;
  init();  
 }  
 public IComboBox(ComboBoxModel model){  
  super(model);  
  init();  
 }  
 public IComboBox(Object[] items){  
  super(items);  
  init();  
 }  
 public IComboBox(Vector items){  
  super(items);  
  init();  
 }  
 private void init(){  
  setOpaque(false);  
  setUI(new IComboBoxUI(width, height));  
  setRenderer(new IComboBoxRenderer());  
  setBackground(XUtil.defaultComboBoxColor);
 }  
 public Dimension getPreferredSize(){  
  return super.getPreferredSize();  
 }  
} 