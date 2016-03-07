package intinfo;

import java.util.ArrayList;

import etu.models.Goinfre;
import etu.models.Mechant;
import etu.models.ObjetDeBase;

public class Environnement {

	private Goinfre goinfre;
	private Background background ;
	private Mechant [] mechants ;
	private ArrayList<ObjetDeBase> objets ;
		
	public Environnement (Goinfre goinfre, Mechant[] mechants,Background background, ArrayList<ObjetDeBase>  objets) {
	this.goinfre = goinfre ;
	this.mechants = mechants ;
	this.background = background ;
	this.objets = objets ;
	}
	
	public boolean collision(int[][] p1, int[][] p2) {
		//a completer
		return false; 
	}
	
	public Background getBackground() {
		return background;
	}

	public void setBackground(Background background) {
		this.background = background;
	}

	public Goinfre getGoinfre() {
		return goinfre;
	}

	public void setGoinfre(Goinfre goinfre) {
		this.goinfre = goinfre;
	}

	public Mechant[] getMechants() {
		return mechants;
	}

	public void setMechants(Mechant[] mechants) {
		this.mechants = mechants;
	}

	public ArrayList<ObjetDeBase> getObjets() {
		return objets;
	}

	public void setObjets(ArrayList<ObjetDeBase> objets) {
		this.objets = objets;
	}
	
	public void addObjet(ObjetDeBase objet) {
		objets.add(objet) ;
	}
	
	public ObjetDeBase getObjet (int index) {
		return objets.get(index) ;
	}

}

