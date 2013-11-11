package de.samm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Staffel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Episode> episoden;
	private int nummer;
	
	public Staffel()
	{}
	
	public Staffel(int nummer) 
	{
		this.nummer = nummer;
		episoden = new  ArrayList<Episode>();
	}
	
	public Staffel(int nummer, ArrayList<Episode> episoden) {
		this.nummer = nummer;
		this.episoden = episoden;
	}
	
	public void addEpisode(Episode e) {
		episoden.add(e);
	}
	
	public Episode getEpisode(int nummer) {
		return episoden.get(nummer - 1);
	}

	public List<Episode> getEpisoden() {
		return episoden;
	}

	public void setEpisoden(ArrayList<Episode> episoden) {
		this.episoden = episoden;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
}
