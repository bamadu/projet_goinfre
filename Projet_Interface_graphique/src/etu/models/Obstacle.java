package etu.models;

public class Obstacle extends ObjetDeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2327940882939543993L;

	public Obstacle (int position_x, int position_y, int largeur, int hauteur, int pas_x, int pas_y) {
		super (position_x, position_y, largeur, hauteur, pas_x, pas_y) ;
	}

	@Override
	public void doCollision(Goinfre g, Environnement env) {
		// TODO Auto-generated method stub
		//return false;
	}
}