package de.samm.model;

import java.io.File;
import java.util.Calendar;
import java.util.List;

public class Episode extends AbstractMedium{
	/**
	 * Nummer der Episode
	 */
	private int nummer;

	public Episode(String titel, String regisseur, List<String> schauspieler,
			double wertung, String plot, Calendar release, File cover,
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
