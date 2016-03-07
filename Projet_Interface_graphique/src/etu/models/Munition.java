package etu.models;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import etu.utils.Configs;
import etu.utils.Son;

public class Munition extends ObjetDeBase {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2045987398118637618L;
	protected static int NbMunition = 5 ;
	
	public Munition(int position_x, int position_y, int pas_x, int pas_y) {
		super(position_x, position_y, 50, 50, pas_x, pas_y);
		loadImage () ;	
	}

	public void loadImage () {
		try {
			image = ImageIO.read(new File (Configs.muPathImage)) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doCollision(Goinfre g, Environnement env) {
		//boolean col = super.collision(g) ;
		//if (col) {
			System.out.println(this.getClass().getSimpleName()+" -> doCollision()") ;
			int nb = g.getNbArmes() ;
			g.setNbArmes(nb + getNbMunition()) ;
			this.setDraw(false) ;
			//env.getObjets().remove(this) ;
			(new Son()).playGoinfreGateau() ;		
		//}
	
		//return col ;
	}
	
	public int getNbMunition() {
		return NbMunition;
	}

	public void setNbMunition(int nbMunition) {
		NbMunition = nbMunition;
	}
	
	
}