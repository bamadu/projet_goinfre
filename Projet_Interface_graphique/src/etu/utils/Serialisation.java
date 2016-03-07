package etu.utils;

import intinfo.Application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Serialisation {
	
	public static void save (Application app, String path) {
	    //ObjectOutputStream oos = null;
	    DebuggingObjectOutputStream oos = null ;
	    try {
	      final FileOutputStream fichier = new FileOutputStream(path) ;
	      oos = new DebuggingObjectOutputStream(fichier);
	      oos.writeObject(app);
	      oos.flush();
	    } catch (Exception e) {
	    	System.out.println("\n-----------------log serial----------------------\n");
  		  /*throw new RuntimeException(
    		      "Serialization error. Path to bad object: " 
    		          + oos.getStack(), e);*/
	    	e.printStackTrace();
    	} finally {
	      try {
	        if (oos != null) {
	          oos.flush();
	          oos.close();
	        }
	      } catch (final IOException ex) {
	        ex.printStackTrace();
	      }
	    }
	  }

	public static Application load (String path) {
		
		ObjectInputStream ois = null;
		 Application app = null ;
	    try {
	      final FileInputStream fichier = new FileInputStream(path) ;
	      ois = new ObjectInputStream(fichier);
	       app = (Application) ois.readObject();
	      
	    } catch (final java.io.IOException e) {
	      e.printStackTrace();
	    } catch (final ClassNotFoundException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        if (ois != null) {
	          ois.close();
	        }
	      } catch (final IOException ex) {
	        ex.printStackTrace();
	      }
	    }
		return app;
	}
}
