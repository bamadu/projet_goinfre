package etu.models;

import etu.utils.Direction;

public class Personnage extends ObjetDeBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5075443375341457618L;
	protected Direction  direction ;
	
	public Personnage (int position_x, int position_y,int largeur, int hauteur, int pas_x, int pas_y) {
		super (position_x, position_y, largeur, hauteur, pas_x, pas_y) ;
	}	
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction _direction) {
		direction = _direction ;
	}

	@Override
	public void doCollision(Goinfre g, Environnement env) {
		// TODO Auto-generated method stub
		//return false;
	}
	
}