package intinfo;

import java.io.IOException;
import java.io.Serializable;

import etu.models.Bouffe;
import etu.models.Environnement;
import etu.models.Etoile;
import etu.models.Mechant;
import etu.models.ObjetDeBase;
import etu.models.Obstacle;
import etu.utils.Configs;
import etu.utils.Son;
import etu.vue.Conteneur;

public class Application implements Serializable { //, LineListener {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1756586510301022148L;
	protected MenuControleur menuControleur ;
	protected Environnement monEnvionnement ;
	protected Conteneur monConteneur ;
	protected Controleur controleur ;
	//protected transient static Son mesSon ;
	protected int stage ;

		
	public Application (MenuControleur menuControleur) {
		this (1, menuControleur) ;
		//System.out.println("Application -> constructeur(menuControleur)") ;
	}

	public Application (int stage, MenuControleur menuControleur) {
		this (stage, menuControleur, new Environnement(stage)) ;
	}
	
	public Application (int stage, MenuControleur menuControleur, Environnement env) {
		//System.out.println("Application -> constructeur(stage, menuControleur)") ;
		System.out.println((++Jeu.c)+". Application -> constructeur(); this "+this.hashCode()) ;
		this.stage = stage ;
		monEnvionnement = env ;
		monConteneur = new Conteneur(monEnvionnement) ;
		monConteneur.setFocusable(true);
		this.menuControleur = menuControleur ;
		this.menuControleur.setApp(this) ;
		controleur = new Controleur(monEnvionnement, monConteneur, menuControleur, this) ;	
		
		monConteneur.addKeyListener(menuControleur) ;
		//System.out.println("Application -> constructeur(stage, menuControleur) ajout Listener"+monConteneur+" menuControl"+menuControleur) ;
		monConteneur.addKeyListener(controleur) ;
		//System.out.println("Application -> constructeur(stage, menuControleur) ajout Listener control") ;
	}
	
	public void loadAllAppImages () throws IOException {
		System.out.println("\t Application -> loadAllImages()") ;
		getControl().getTiming().start() ;
		getMonconteneur().addKeyListener(this.menuControleur) ;
		monEnvionnement.getGoinfre().loadImage() ;
		getMonconteneur().loadImage() ;
		
		//System.out.println("Application -> loadAllImages(); mechant:") ;
		for (Mechant m: monEnvionnement.getMechants()){
			m.loadImage(Configs.mPathImage) ;
		}
		//System.out.println(" fin mechants") ;
		monEnvionnement.getBackground().loadImage() ;	
		//System.out.println("Application -> loadAllImages(); objets:") ;
		for (ObjetDeBase ob: monEnvionnement.getObjets()) {
			if (ob instanceof Bouffe) 
				ob.loadImage(Configs.gtPathImage) ;
			if (ob instanceof Etoile)
				ob.loadImage(Configs.ePathImage) ;
			if (ob instanceof Obstacle)
				ob.loadImage(Configs.obPathImage) ;
		}
		//System.out.println(" fin objets") ;
	}
	
	
	/**
	 * @return the monenvionnement
	 */
	public Environnement getMonenvionnement() {
		return monEnvionnement;
	}

	/**
	 * @param monenvionnement the monenvionnement to set
	 */
	public void setMonenvionnement(Environnement monenvionnement) {
		this.monEnvionnement = monenvionnement;
	}

	/**
	 * @return the monconteneur
	 */
	public Conteneur getMonconteneur() {
		return monConteneur;
	}

	/**
	 * @param monconteneur the monconteneur to set
	 */
	public void setMonconteneur(Conteneur monconteneur) {
		this.monConteneur = monconteneur;
	}

	/**
	 * @return the control
	 */
	public Controleur getControl() {
		return controleur;
	}

	/**
	 * @param control the control to set
	 */
	public void setControl(Controleur control) {
		this.controleur = control;
	}

	
	/**
	 * @return the mesSon
	 */
	/*public static Son getMesSon() {
		return mesSon;
	}*/

	/**
	 * @param mesSon the mesSon to set
	 */
	/*public static void setMesSon(Son mesSon) {
		Application.mesSon = mesSon;
	}*/

	/**
	 * @return the stage
	 */
	public int getStage() {
		return stage;
	}

	/**
	 * @param stage the stage to set
	 */
	public void setStage(int stage) {
		this.stage = stage;
	}

	/**
	 * @return the menuControleur
	 */
	public MenuControleur getMenuControleur() {
		return menuControleur;
	}

	/**
	 * @param menuControleur the menuControleur to set
	 */
	public void setMenuControleur(MenuControleur menuControleur) {
		this.menuControleur = menuControleur;
	}
	
	public Son getSon() {
		return new Son() ;
	}

}