package de.samm.model;

import java.awt.image.BufferedImage;
import java.io.File;

public class Episode 
{
	/**
	 * Nummer der Episode
	 */
	private int nummer;
	private String titel;
	private String regisseur;
	private String wertung;
	private String plot;
	private String gastschausspieler;
	
	public Episode(String titel, String regisseur, String wertung, String plot,
			String release,String gastschausspieler, int nummer)
	{
		this.titel = titel;
		this.regisseur = regisseur;
		this.wertung = wertung;
		this.release = release;
		this.gastschausspieler = gastschausspieler;
		this.setNummer(nummer);
	}
	
	public String getTitel()
	{
		return titel;
	}

	public void setTitel(String titel)
	{
		this.titel = titel;
	}

	public String getRegisseur()
	{
		return regisseur;
	}

	public void setRegisseur(String regisseur)
	{
		this.regisseur = regisseur;
	}

	public String getWertung()
	{
		return wertung;
	}

	public void setWertung(String wertung)
	{
		this.wertung = wertung;
	}

	public String getPlot()
	{
		return plot;
	}

	public void setPlot(String plot)
	{
		this.plot = plot;
	}

	public String getRelease()
	{
		return release;
	}

	public void setRelease(String release)
	{
		this.release = release;
	}

	private String release;
	


	public int getNummer()
	{
		return nummer;
	}

	public void setNummer(int nummer)
	{
		this.nummer = nummer;
	}

}
