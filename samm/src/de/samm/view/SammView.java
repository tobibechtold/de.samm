package de.samm.view;

import java.awt.Graphics;
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
//		XMLParser parser = new XMLParser();
//		Serie bb = parser.parseSerie("Breaking Bad");
		SerienSerializer ss = new SerienSerializer();
		Serie bb = ss.deserializeSerie("Breaking Bad.dat");
		if(bb != null) {
			System.out.println(bb.getTitel());
			img = bb.getCover();
			JFrame frame = new JFrame();
	        frame.setSize(300, 300);
	        JLabel label = new JLabel(new ImageIcon(img));
	        frame.add(label);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
}
