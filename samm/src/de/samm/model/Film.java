package de.samm.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Film implements Serializable {

	public  class Genres
	{		
		private String name;
				
		public String getName()
		{
			
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
			
		}
	}


	private static final long serialVersionUID = 1L;
	
	/**
	 * Dauer in Minuten
	 */
	
	
	private String original_title,overview,vote_average,id,
					poster_path,release_date,runtime,status;
	
	private List<Genres> genres = new  ArrayList<Genres>();
	
	public  List<Genres> getGenre()
	{
		return genres;
	}

	public void setGenre(List<Genres> genres)
	{
		this.genres= genres;
	}



	public String getPoster_path()
	{
		return poster_path;
	}



	public void setPoster_path(String poster_path)
	{
		this.poster_path = poster_path;
	}



	public String getRelease_date()
	{
		return release_date;
	}



	public void setRelease_date(String release_date)
	{
		this.release_date = release_date;
	}



	public String getRuntime()
	{
		return runtime;
	}



	public void setRuntime(String runtime)
	{
		this.runtime = runtime;
	}



	public String getStatus()
	{
		return status;
	}



	public void setStatus(String status)
	{
		this.status = status;
	}



	public Film()
	{}
	
	
	
	public String getVote_average()
	{
		return vote_average;
	}



	public void setVote_average(String vote_average)
	{
		this.vote_average = vote_average;
	}



	public Film(String titel, String regisseur, String schauspieler,
			String wertung, String plot, String release, String cover,
			String genre, int duration) {
		
		
	}
	
	public String getId()
	{
		return id;
	}



	public void setId(String id)
	{
		this.id = id;
	}


	public String getOriginal_title()
	{
		return original_title;
	}



	public void setOriginal_title(String original_title)
	{
		this.original_title = original_title;
	}



	public String getOverview()
	{
		return overview;
	}



	public void setOverview(String overview)
	{
		this.overview = overview;
	}
	
	


}
