package etu.models;

import java.awt.image.BufferedImage ;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

public abstract class  ObjetDeBase implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6081866118265160441L;
	protected transient BufferedImage image ;
	protected int position_x, 
	  			  position_y,
	  			  largeur,
	  			  hauteur ;
	protected  int pas_x, 
				   pas_y ; 
	protected boolean draw = true ;
	
	public boolean isDraw() {
		return draw;
	}

	
	public ObjetDeBase(int position_x, int position_y, int largeur, int hauteur, int pas_x, int pas_y) {
		this.position_x = position_x ;
		this.position_y = position_y ;
		this.largeur = largeur ;
		this.hauteur = hauteur ;
		this.pas_x = pas_x ;
		this.pas_y = pas_y ; 
		
	}
	
	public void setDraw(boolean draw){
		this.draw = draw ;
	}
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public int getPosition_x() {
		return position_x;
	}
	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}
	public int getPosition_y() {
		return position_y;
	}
	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	
	
	public boolean decremX(int minX) {
		if (position_x-pas_x >= minX ) {
			position_x -= pas_x ;
			return true ;
		}
		else 
			position_x = minX ;
		return false ;
	}
	
	public boolean decremY(int minY) {
		if (position_y-pas_y >= minY ) {
			position_y -= pas_y ;
			return true ;
		}
		else 
			position_y = minY ;
		return false ;
	}
	
	public boolean incremX(int maxX) {
		if(position_x+largeur+pas_x<= maxX) {
			position_x += pas_x ;
			return true ;
		}
		else 
			position_x = maxX - largeur ;
		return false ;
	}
	
		
	public boolean incremtY(int maxY) {
		if (position_y+largeur+pas_y <= maxY) {
			position_y += pas_y ;
			return true ;
		}
		else 
			position_y = maxY - largeur ;
		return false ;
	}

	
	public int getPas_x() {
		return pas_x;
	}

	public void setPas_x(int pas_x) {
		this.pas_x = pas_x;
	}

	public int getPas_y() {
		return pas_y;
	}

	public void setPas_y(int pas_y) {
		this.pas_y = pas_y;
	}
	
	public BufferedImage loadImage (String path) throws IOException {
		
		System.out.println("\t "+this.getClass().getSimpleName()+" -> loadImage()") ;
		image = ImageIO.read(new File(path)) ;
		return image ;
	}
	
	public  boolean collision(ObjetDeBase ob) {	
		if((this.position_x +15  >= ob.getPosition_x() + ob.getLargeur())      // trop à droite
			    || (this.position_x + this.getLargeur()  <= ob.getPosition_x() +15 ) // trop à gauche
			    || (this.getPosition_y() >= ob.getPosition_y() + ob.getHauteur() - 15 ) // trop en bas
			    || (this.getPosition_y() + ob.getHauteur() <= ob.getPosition_y() + 20  ))  // trop en haut
			return false ;  
		else
			return true ;
	}
	
	public  abstract void doCollision(Goinfre g, Environnement env) ;
		
}