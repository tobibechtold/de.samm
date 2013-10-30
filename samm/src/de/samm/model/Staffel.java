package de.samm.model;

import java.util.List;

public class Staffel {
	private List<Episode> episoden;
	private int nummer;
	
	public Staffel()
	{}
	
	public Staffel(int nummer) {
		this.nummer = nummer;
	}
	
	public Staffel(int nummer, List<Episode> episoden) {
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

	public void setEpisoden(List<Episode> episoden) {
		this.episoden = episoden;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
}
