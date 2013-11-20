package de.samm.controller;

import java.io.IOException;
import java.net.URL;
import de.samm.model.Film;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)


public class JsonParser
{
	private static final String apiKeyFilm = "bbee8e1952003639528110f5ee629f24";
	
	
	/**
	 * Parst einen Film
	 * @param filmname
	 * @return
	 */
	public Film parseFilm(String filmname)
	{
		ObjectMapper mapper = new ObjectMapper();
		
		String id = getFilmID(filmname);
		
		try
		{
			Film film = mapper.readValue(new URL("http://api.themoviedb.org/3/movie/550?api_key="+apiKeyFilm), Film.class);
			
			System.out.println("Titel :"+film.getOriginal_title());
			System.out.println("Overview: "+film.getOverview());
			System.out.println("Rating: "+film.getVote_average());
			System.out.println("Film-ID: "+film.getId());
			System.out.println("Poster Path: "+film.getPoster_path());
			System.out.println("Dauer : "+film.getRuntime());
			System.out.println("Genre :"+film.getGenres().get(0).getName());
			System.out.println("Untertitel: "+film.getTagline());
			return film;
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	private String getFilmID(String filmname)
	{
		//api.themoviedb.org/3/search/movie?api_key=bbee8e1952003639528110f5ee629f24&query="+filmname
		return null;
	}
	
	
}
