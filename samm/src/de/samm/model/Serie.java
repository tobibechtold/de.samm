package de.samm.model;

import java.awt.image.BufferedImage;
import java.util.List;

public class Serie extends AbstractMedium {

	private List<Staffel> staffeln;
	private String sender;
	
	public Serie(String titel, String regisseur, String schauspieler,
			String wertung, String plot, String release, BufferedImage cover,
			String genre, String sender) {
		super(titel, regisseur, schauspieler, wertung, plot, release, cover, genre);
		this.sender = sender;
	}
	
	public Serie(String titel, String regisseur, String schauspieler,
			String wertung, String plot, String release, 
			String genre, String sender) {
		super(titel, regisseur, schauspieler, wertung, plot, release,  genre);
		this.sender = sender;
	}
	
	public void addStaffel(Staffel s) {
		staffeln.add(s);
	}
	
	public Staffel getStaffel(int nummer) {
		return staffeln.get(nummer - 1);
	}
	
	public List<Staffel> getStaffelListe() {
		return staffeln;
	}

	public List<Staffel> getStaffeln() {
		return staffeln;
	}

	public void setStaffeln(List<Staffel> staffeln) {
		this.staffeln = staffeln;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
	
	
}
