package etu.models;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import etu.utils.BouffeType;
import etu.utils.Configs;
import etu.utils.Son;

public class Bouffe extends ObjetDeBase  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1598847145566519270L;
	protected int energie, point ;
	protected BouffeType type ;

	public Bouffe (int position_x, int position_y, int pas_x, int pas_y) {
		super (position_x, position_y, 70, 70, pas_x, pas_y) ;
		energie = 10 ;
		point = 50 ;
		loadImage () ;
	} 
	
	public void loadImage () {
		try {
			image = ImageIO.read(new File(Configs.gtPathImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doCollision(Goinfre g, Environnement env) {
		//boolean col = super.collision(g) ;
		//if (col){
			System.out.println(this.getClass().getSimpleName()+" -> doCollision()") ;
			g.setScore(g.getScore() + getPoint() ) ;
			g.setEnergie(g.getEnergie() + getEnergie()) ;
			this.setDraw(false) ;
			//env.getObjets().remove(this) ;
			(new Son()).playGoinfreGateau() ;
		//}
		//return col;
	}
	
	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
}