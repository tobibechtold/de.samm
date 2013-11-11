package de.samm.model;

import java.io.Serializable;

public class Episode implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5459886265720937501L;
	/**
	 * Nummer der Episode
	 */
	private int nummer;
	private String titel;
	private String regisseur;
	private String wertung;
	private String plot;
	private String gastschausspieler;
	private String release;

	public Episode(String titel, String regisseur, String wertung, String plot,
			String release, String gastschausspieler, int nummer)
	{
		setTitel(titel);
		setRegisseur(regisseur);
		setWertung(wertung);
		setRelease(release);
		setGastschausspieler(gastschausspieler);
		setPlot(plot);
		this.setNummer(nummer);
	}

	public String getGastschausspieler()
	{
		return gastschausspieler;
	}

	public void setGastschausspieler(String gastschausspieler)
	{
		if ( gastschausspieler == null )
			gastschausspieler = "";
		this.gastschausspieler = gastschausspieler;
	}

	public String getTitel()
	{
		return titel;
	}

	public void setTitel(String titel)
	{
		if ( titel == null )
			titel = "";
		this.titel = titel;
	}

	public String getRegisseur()
	{
		return regisseur;
	}

	public void setRegisseur(String regisseur)
	{
		if ( regisseur == null )
			regisseur = "";
		this.regisseur = regisseur;
	}

	public String getWertung()
	{
		return wertung;
	}

	public void setWertung(String wertung)
	{
		if ( wertung == null )
			wertung = "";
		this.wertung = wertung;
	}

	public String getPlot()
	{
		return plot;
	}

	public void setPlot(String plot)
	{

		if ( plot == null )
		{
			this.plot = "";
			return;	
		}

		this.plot = plot;
	}

	public String getRelease()
	{
		return release;
	}

	public void setRelease(String release)
	{
		if ( release == null )
			release = "";
		this.release = release;
	}

	public int getNummer()
	{
		return nummer;
	}

	public void setNummer(int nummer)
	{
		this.nummer = nummer;
	}

}
