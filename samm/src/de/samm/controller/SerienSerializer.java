package de.samm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import de.samm.model.Serie;

public class SerienSerializer {
	
	//TODO Pfad bei jedem Benutzer, sprich bei mir ein anderen Pfad als bei Tobi
	File output = new File("C:/Git/SAMM/repositories/de.samm/samm/SerialisierteObjekte");
	
	public SerienSerializer() 
	{
		
	}
	
	
	public void serializeSerie(Serie s){
		 
		   try
		   {
			File f = new File(output, s.getTitel()+".dat");
			output.mkdir();
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
			File f = new File(output, titel);
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
