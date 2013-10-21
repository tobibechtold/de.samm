package de.samm.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import de.samm.model.Serie;


public class XMLParser
{
	private static final String apiKey = "0717C50D3B6B66E5";
	private SAXBuilder builder,sxbuild;
	
	public XMLParser()
	{
		builder = new SAXBuilder();
		sxbuild = new SAXBuilder();
	}

		
	public Serie parseSerie(String serienname)
	{
		int serienid = getSerienID(serienname);
		String wertung;
		BufferedImage cover;
		String sender,genre,beschreibung,schausspieler,regisseur,titel,release;
		Serie serie;
		String link = "http://thetvdb.com/api/0717C50D3B6B66E5/series/"+serienid+"/all/en.xml";
		InputSource is = new InputSource(link);	
			
		try
		{
			Document readDoc = sxbuild.build(is);
			Element root = readDoc.getRootElement();
			schausspieler = root.getChild("Series").getChildText("Actors");
			beschreibung = root.getChild("Series").getChildText("Overview");
			wertung = root.getChild("Series").getChildText("Rating");
			genre = root.getChild("Series").getChildText("Genre");
			sender = root.getChild("Series").getChildText("Network");
			release = root.getChild("Series").getChildText("FirstAired");
			cover = getCover(root.getChild("Series").getChildText("poster"));
			titel = root.getChild("Series").getChildText("SeriesName");
			regisseur = "test";
			//System.out.println(cover.getAbsoluteFile());
			System.out.println(schausspieler);
			System.out.println(beschreibung);
			System.out.println(wertung);
			System.out.println(genre);
			System.out.println(sender);
			System.out.println(release);
		
			serie = new Serie(titel,regisseur,schausspieler,wertung,beschreibung,release,cover,genre,sender);
			return serie;
		} catch (JDOMException | IOException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
//	
//	public ArrayList<Serie> parseFilm(String serienname)
//	{
//		int serienid = getSerienID(serienname);
//	}
	 
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
	 
	 public BufferedImage getCover(String pfad)
	 {
		 try
		{
			 
			 URL url = new URL("http://www.thetvdb.com/banners/"+pfad); 
			 System.out.println(url);
//			 String tDir = System.getProperty("java.io.tmpdir");
//			 String path ="C:/git/de.samm/samm"; 
//			 File  file = new File(path);
//			 file.deleteOnExit();
//			 FileUtils.copyURLToFile(url, file);
			 BufferedImage img = ImageIO.read(url);
			return img;
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		 return null;
	 }
}
