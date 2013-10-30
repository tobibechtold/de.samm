package de.samm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Serie extends AbstractMedium implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9007306221573471920L;
	private ArrayList<Staffel> staffeln;
	private String sender;
	
	public Serie(String titel, String regisseur, String schauspieler,
			String wertung, String plot, String release, String cover,
			String genre, String sender) {
		super(titel, regisseur, schauspieler, wertung, plot, release, cover, genre);
		this.sender = sender;
		staffeln = new ArrayList<Staffel>();
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

	public void setStaffeln(ArrayList<Staffel> staffeln) {
		this.staffeln = staffeln;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
}
