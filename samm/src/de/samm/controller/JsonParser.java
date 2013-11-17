package de.samm.controller;



import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import de.samm.model.Film;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)


public class JsonParser
{



	private static final String apiKeyFilm = "bbee8e1952003639528110f5ee629f24";
	
	
	/**
	 * parst ein Film
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
			System.out.println(film.getOriginal_title());
			System.out.println(film.getOverview());
			System.out.println(film.getVote_average());
			System.out.println(film.getId());
			System.out.println(film.getPoster_path());
			System.out.println(film.getRuntime());
			
//			List<Genres> someClassList =
//					mapper.readValue(new URL("http://api.themoviedb.org/3/movie/550?api_key="+apiKeyFilm), TypeFactory.constructCollectionType(List.class,Genres.class));
			
//			List<Genres> list = mapper.readValue(new URL("http://api.themoviedb.org/3/movie/550?api_key="+apiKeyFilm), new TypeReference<List<Genres>>() { });
//			Genres[] array = mapper.readValue(new URL("http://api.themoviedb.org/3/movie/550?api_key="+apiKeyFilm), Genres[].class);
			
			System.out.println(film.getGenre());
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
