package view;

import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JLabel;

import org.apache.batik.swing.svg.JSVGComponent;


public class SVGLabel extends JLabel{
	
	protected JSVGComponent svgComponent;
	
	public SVGLabel(File svgFile, int width, int height){
		svgComponent = new JSVGComponent(null, false, false);
		try {
			svgComponent.loadSVGDocument(svgFile.toURL().toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		this.add(svgComponent);
		this.setSize(width, height);
		svgComponent.setLocation(0, 0);
		this.setLayout(null);
		this.setLocation(0, 0);
	}
	@Override
	public void setSize(int width, int height){
		super.setSize(width, height);
		svgComponent.setSize(width, height);
	}
	
}
