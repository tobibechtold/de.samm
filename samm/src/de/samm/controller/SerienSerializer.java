package de.samm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import de.samm.model.Serie;

public class SerienSerializer {
	
	//TODO Pfad bei jedem Benutzer, sprich bei mir ein anderen Pfad als bei Tobi
	File output = new File("C:/SAMM");
	File serienOrdner;
	public SerienSerializer() 
	{
		
	}
	
	public void serializeSerie(Serie s){
		 
		   try
		   {
			   if(!output.exists())
				   output.mkdir();
			  serienOrdner = new File(output,s.getTitel());
			   if(!serienOrdner.exists())
				   serienOrdner.mkdir();
			   File f = new File(serienOrdner, s.getTitel()+".dat");
			   FileOutputStream fout = new FileOutputStream(f);
			   ObjectOutputStream oos = new ObjectOutputStream(fout);   
			   oos.writeObject(s);
			   oos.close();
	 
		   }catch(Exception ex){
			   ex.printStackTrace();
		   }
	   }
	
	public Serie deserializeSerie(String titel) {
		Serie s;
			
		try {
			serienOrdner = new File(output,titel);
			File f = new File(serienOrdner, titel+".dat");
			FileInputStream fin = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fin);
			s = (Serie) ois.readObject();
			ois.close();
	 
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
