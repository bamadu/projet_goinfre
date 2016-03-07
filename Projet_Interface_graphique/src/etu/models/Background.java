package etu.models;

import intinfo.Jeu;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;

import javax.imageio.ImageIO;

import etu.utils.Configs;

/**
 * @author netbook
 *
 */
public class Background implements Cloneable, Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 887265447280788561L;
	private static int mvt = 7 ;
	private transient BufferedImage bgImage ;
	private int sx1, sy1, sx2, sy2 ;
	private int hauteur ;
	private int largeur ;
	private int stage ;

	public Background (int stage ) {
		System.out.println((++Jeu.c)+". "+this.getClass().getSimpleName()+" -> constructeur(); hcode: "+this.hashCode()) ;
		this.stage = stage ;
		loadImage() ;
		largeur = bgImage.getWidth() ;
		hauteur = bgImage.getHeight() ;
		
		//System.out.println("largeur "+largeur) ;
		//System.out.println(" hauteur"+hauteur) ;
		
		sx1 = largeur /3 ;
		sy1 = hauteur /3 ;
		sx2 = (largeur * 2) /3 ;
		sy2 = (hauteur * 2) /3 ;
		
		//System.out.print(" sx1 =  "+sx1) ;
		//System.out.print(" sy1 =  "+sy1) ;
		//System.out.print(" sx2 =  "+sx2) ;
		//System.out.println(" sy2 =  "+sy2) ;
		
	}
	
	
	public void loadImage () {
		//System.out.println("Background -> loadImage()") ;
		try {
			String path = (String)Configs.class.getField("bgPathImage"+stage).get(new String()) ;
		    bgImage = ImageIO.read(new File(path));
		    //System.out.println("Chargement de l'image de fond !!!") ;
		} catch (Exception e) {
			System.out.println("Erreur: chargement de l'image de fond !!!") ;
		}
	}
	
	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

		
	public int getSx1() {
		return sx1;
	}


	public void setSx1(int sx1) {
		this.sx1 = sx1;
	}


	public int getSy1() {
		return sy1;
	}


	public void setSy1(int sy1) {
		this.sy1 = sy1;
	}


	public int getSx2() {
		return sx2;
	}


	public void setSx2(int sx2) {
		this.sx2 = sx2;
	}


	public int getSy2() {
		return sy2;
	}


	public void setSy2(int sy2) {
		this.sy2 = sy2;
	}
	
	
	public int getMvt() {
		return mvt;
	}


	public BufferedImage getBgImage() {
		if (bgImage==null) 
			loadImage() ;
		return bgImage;
	}


	public void setBgImage(BufferedImage bgImage) {
		this.bgImage = bgImage;
	}
		
}