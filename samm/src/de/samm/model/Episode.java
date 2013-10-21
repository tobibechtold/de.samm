package de.samm.model;

import java.awt.image.BufferedImage;
import java.io.File;

public class Episode extends AbstractMedium{
	/**
	 * Nummer der Episode
	 */
	private int nummer;

	public Episode(String titel, String regisseur, String schauspieler,
			String wertung, String plot, String release, BufferedImage cover,
			String genre, int nummer) {
		super(titel, regisseur, schauspieler, wertung, plot, release, cover, genre);
		this.setNummer(nummer);
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	
}
