package de.samm.controller;

import de.samm.model.Serie;
import de.samm.view.SammView;


public class SammController {
	
	
	
	public static void main(String[] args0) {
		
//		new SammLoginView();
		XMLParser parser = new XMLParser();
		
		SerienSerializer ss = new SerienSerializer();
		Serie bb = ss.deserializeSerie("Breaking Bad");
//		Serie bb = parser.parseSerie("Breaking Bad");
//		ss.serializeSerie(bb);
		System.out.println("Staffeln: " + bb.getStaffelListe().size());
		new SammView();
	}
	
}
