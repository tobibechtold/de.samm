package de.samm.model;


public class Episode extends AbstractMedium{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5459886265720937501L;
	/**
	 * Nummer der Episode
	 */
	private int nummer;

	public Episode(String titel, String regisseur, String schauspieler,
			String wertung, String plot, String release, String cover,
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
