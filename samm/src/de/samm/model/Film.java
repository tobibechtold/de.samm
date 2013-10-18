package de.samm.model;

import java.io.File;
import java.util.Calendar;
import java.util.List;

public class Film extends AbstractMedium {
	/**
	 * Dauer in Minuten
	 */
	private int dauer;
	
	
	public Film(String titel, String regisseur, List<String> schauspieler,
			double wertung, String plot, Calendar release, File cover,
			String genre, int duration) {
		super(titel, regisseur, schauspieler, wertung, plot, release, cover, genre);
		this.setDuration(duration);
	}


	public int getDuration() {
		return dauer;
	}


	public void setDuration(int duration) {
		this.dauer = duration;
	}

	
	
	

}
