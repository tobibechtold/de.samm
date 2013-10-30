package de.samm.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import de.samm.model.Episode;
import de.samm.model.Serie;
import de.samm.model.Staffel;


public class XMLParser
{
	private static final String apiKeyserie = "0717C50D3B6B66E5";
	private static final String apiKeyFilm = "0717C50D3B6B66E5";
	private SAXBuilder builder,sxbuild;
	private SerienSerializer ss;
	
	public XMLParser()
	{
		setBuilder(new SAXBuilder());
		sxbuild = new SAXBuilder();
		ss = new SerienSerializer();
	}

	/**
	 * Parst die XML-Datei die TheTVDB.com zurueckliefert
	 * @param serienname: Serien name der geparst werden soll
	 * @return liefert die vollständige Serie mit allen Werten(Wertung, Name, Schauspieler,...) zurueck
	 */
	
	//TODO Cover richtig parsen
	
	public Serie parseSerie(String serienname)
	{
		int serienid = getSerienID(serienname);
		String wertung;

		
		String cover,sender,genre,beschreibung,schausspieler,regisseur,titel,release,gastschausspieler;

		Serie serie;
		String link = "http://thetvdb.com/api/0717C50D3B6B66E5/series/"+serienid+"/all/en.xml";
		InputSource is = new InputSource(link);	
			
		try
		{
			//Attribute werden gesetzt
			Document readDoc = sxbuild.build(is);
			Element root = readDoc.getRootElement();
			schausspieler = root.getChild("Series").getChildText("Actors");
			beschreibung = root.getChild("Series").getChildText("Overview");
			wertung = root.getChild("Series").getChildText("Rating");
			genre = root.getChild("Series").getChildText("Genre");
			sender = root.getChild("Series").getChildText("Network");
			release = root.getChild("Series").getChildText("FirstAired");
			cover = root.getChild("Series").getChildText("poster");
			titel = root.getChild("Series").getChildText("SeriesName");
			regisseur = "test";
			//System.out.println(cover.getAbsoluteFile());
			System.out.println(schausspieler);
			System.out.println(beschreibung);
			System.out.println(wertung);
			System.out.println(genre);
			System.out.println(sender);
			System.out.println(release);
		
			serie = new Serie(titel, regisseur, schausspieler,wertung, beschreibung, release, cover,
					genre, sender);
			
			//ss.serializeSerie(serie);
			
			//Staffeln und Episoden werden hinzugefuegt
			
			//Staffeln hinzufuegen
			int staffelnr = 1;
			for(Element staffelelement:root.getChildren("Episode"))
			{
			
				if(staffelelement.getChildText("Combined_season").equals(""+staffelnr))
				{
					serie.addStaffel(new Staffel(staffelnr));
					
					++staffelnr;
				}
			}
			
			//Episoden hnzufuegen
			int episodennr = 1;
			for(Staffel s:serie.getStaffelListe())
			{
				for(Element staffelelement:root.getChildren("Episode"))
				{
					
					if(staffelelement.getChildText("Combined_season").equals(s.getNummer()+""))
					{
						gastschausspieler = root.getChild("Series").getChildText("Actors");
						beschreibung = root.getChild("Series").getChildText("Overview");
						wertung = root.getChild("Series").getChildText("Rating");
						release = root.getChild("Series").getChildText("FirstAired");
						titel = root.getChild("Series").getChildText("SeriesName");
						Episode episode = new Episode(titel, regisseur, wertung, beschreibung, release,gastschausspieler, episodennr);
						s.addEpisode(episode);
						episodennr++;
					}
				}
				episodennr = 1;
				
			}
			
			return serie;
		} catch (JDOMException | IOException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
//	
//	public Film parseFilm(String filmname)
//	{
//		int serienid = getSerienID(serienname);
//	}
	 
	/**
	 * Liefert die SerienID zurueck
	 * @param serienname 
	 * @return
	 */
	 private int getSerienID(String serienname)
	 {
		 InputSource is = new InputSource("http://www.thetvdb.com/api/GetSeries.php?seriesname="+serienname);
		 int serienid = 0;
		 try
		{
			Document readDoc = sxbuild.build(is);
			Element root = readDoc.getRootElement();
			serienid = Integer.parseInt(root.getChildren("Series").get(0).getChildText("seriesid"));
			System.out.println(serienid);
		} catch (JDOMException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return serienid;
	 }
	 
	 /**
	  * Methode um das Cover-Bild einer Serie als BufferedImage zu erhalten. Wird kein 
	  * Cover gefunden gibt die Methode null zurück.
	  * @param s - Serie deren Cover heruntergeladen werden soll
	  * @return Gibt das Cover Bild der übergebenen Serie als BufferedImage zurück
	  */
	 public BufferedImage getCoverByURL(Serie s)
	 {
		 try
		{
			 URL url = new URL("http://www.thetvdb.com/banners/"+s.getCover()); 
			 System.out.println(url);
			 BufferedImage img = ImageIO.read(url);
			return img;
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		 return null;
	 }

	public static String getApikey() {
		return getApikey();
	}

	public SAXBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(SAXBuilder builder) {
		this.builder = builder;
	}
}
