
package de.samm.view;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import de.samm.controller.SerienSerializer;
import de.samm.controller.XMLParser;
import de.samm.model.Serie;

public class SammView {
	private BufferedImage img;
	
	public SammView() {
		XMLParser parser = new XMLParser();
		
//		Serie bb = parser.parseSerie("Breaking Bad");
		SerienSerializer ss = new SerienSerializer();
		Serie bb = ss.deserializeSerie("Breaking Bad");
		if(bb != null) {
			System.out.println(bb.getTitel());
			System.out.println(bb.getPlot());
			System.out.println("Director: "+bb.getRegisseur());
			img = parser.getCoverByURL(bb);
			JFrame frame = new JFrame();
	        JLabel label = new JLabel(new ImageIcon(img));
	        label.setSize(200, 300);
	        frame.add(label);
	        frame.pack();
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
}

