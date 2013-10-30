package de.samm.model;


public class Film extends AbstractMedium {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Dauer in Minuten
	 */
	private int dauer;
	
	
	public Film(String titel, String regisseur, String schauspieler,
			String wertung, String plot, String release, String cover,
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
