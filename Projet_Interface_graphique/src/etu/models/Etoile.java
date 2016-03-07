package etu.models;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import etu.utils.Configs;
import etu.utils.Son;

public class Etoile extends ObjetDeBase  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6869973174743082356L;
	protected int point ;

	public Etoile (int position_x, int position_y, int pas_x, int pas_y) {
		super (position_x, position_y, 50, 50, pas_x, pas_y) ;
		point = 150 ;
		loadImage() ;
	}
	
	public void loadImage () {
		try {
			image = ImageIO.read(new File (Configs.ePathImage)) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("erreur chargement etoile") ;
		}
	}
	
	public void doCollision(Goinfre g, Environnement env) {
		//boolean col = super.collision(g) ;
		//if (col) {
			System.out.println(this.getClass().getSimpleName()+" -> doCollision()") ;
			g.setScore(g.getScore() + getPoint()) ;
			env.setNbEtoile(env.getNbEtoile() - 1 ) ;
			this.setDraw(false) ;
			//env.getObjets().remove(this) ;
			(new Son()).playGoinfreGateau() ;
			// a completer quand il reste plus d'étoile 	
		//}
		//return col ;
	}
	
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}