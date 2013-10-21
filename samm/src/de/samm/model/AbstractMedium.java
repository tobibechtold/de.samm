package de.samm.model;

import java.awt.image.BufferedImage;
import java.io.File;

public abstract class AbstractMedium {
	private String titel;
	private String regisseur;
	private String schauspieler; 
	private String wertung;
	private String plot;
	private String release;
	private BufferedImage cover;
	private String genre;
	
	
	
	public AbstractMedium(String titel, String regisseur,
			String schauspieler, String wertung, String plot,
			String release, BufferedImage cover, String genre) {
		super();
		this.titel = titel;
		this.regisseur = regisseur;
		this.schauspieler = schauspieler;
		this.wertung = wertung;
		this.plot = plot;
		this.release = release;
		this.cover = cover;
		this.genre = genre;
	}
	
	public AbstractMedium(String titel, String regisseur,
			String schauspieler, String wertung, String plot,
			String release, String genre) {
		super();
		this.titel = titel;
		this.regisseur = regisseur;
		this.schauspieler = schauspieler;
		this.wertung = wertung;
		this.plot = plot;
		this.release = release;
		this.genre = genre;
	}
	
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getRegisseur() {
		return regisseur;
	}
	public void setRegisseur(String regisseur) {
		this.regisseur = regisseur;
	}
	public String getSchauspieler() {
		return schauspieler;
	}
	public void setSchauspieler(String schauspieler) {
		this.schauspieler = schauspieler;
	}
	public String getWertung() {
		return wertung;
	}
	public void setWertung(String wertung) {
		this.wertung = wertung;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public BufferedImage getCover() {
		return cover;
	}
	public void setCover(BufferedImage cover) {
		this.cover = cover;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
