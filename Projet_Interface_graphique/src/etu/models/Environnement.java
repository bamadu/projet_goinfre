package etu.models;

import intinfo.Jeu;

import java.io.Serializable;
import java.util.ArrayList;

import etu.utils.Configs;
import etu.utils.TypePersonnage;

public class Environnement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3592485668472735541L;
	private Goinfre goinfre;
	private Background background ;
	private ArrayList<Mechant> mechants ;
	private ArrayList<ObjetDeBase> objets ;
	/*private ArrayList<Etoile> etoiles ;
	private ArrayList<Munition> munitions ;
	private ArrayList<Bouffe> bouffes ;*/
	private int NbEtoile ;
	private int pas_x, pas_y,
				nbr_mechant,
				nbr_etoile,
				nbr_munition,
				nbr_gateaux ;
	
	
	public Environnement (int stage) {
		//init () ;
		System.out.println((++Jeu.c)+". Environnement -> construction()") ;
		try {
			this.NbEtoile = Configs.class.getField("s"+stage+"_nb_etoiles").getInt(this) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("erreur -stage 2 nb etoile");
		} 
		
	
	
	//public void init () {
		System.out.println("\t Environnement -> bloc initialisation") ;	
		background = new Background (stage) ;
		objets = new ArrayList<ObjetDeBase>() ;
		/*etoiles = new ArrayList<Etoile>() ;
		munitions = new ArrayList<Munition>() ;
		bouffes = new ArrayList<Bouffe>() ;
		*/
		pas_x = (Configs.largeurC * background.getMvt()) / (background.getLargeur()/3)  ;
		pas_y = (Configs.hauteurC * background.getMvt()) / (background.getHauteur()/3)  ;	
		
		
		goinfre = (Goinfre) PersonnageFactory.createPersonnage(TypePersonnage.GOINFRE, pas_x, pas_y, Configs.largeurC/2, Configs.hauteurC/2) ;
		mechants = new ArrayList<Mechant>() ;
		
		// Ajout des méchants ...
		try {
			 nbr_mechant = Configs.class.getField("s"+stage+"_nb_mechants").getInt(this) ;
			 nbr_etoile = Configs.class.getField("s"+stage+"_nb_etoiles").getInt(this) ;
			 nbr_munition = Configs.class.getField("s"+stage+"_nb_munitions").getInt(this) ;
			 nbr_gateaux = Configs.class.getField("s"+stage+"_nb_gateaux").getInt(this) ;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		for (int i = 1; i <= nbr_mechant; i++) {
			int x, y;
			try {
				x = Configs.class.getField("s"+stage+"_me"+i+"_x").getInt(this);
				y = Configs.class.getField("s"+stage+"_me"+i+"_y").getInt(this);
				//System.out.println("pas_x = "+pas_x) ;
				//System.out.println("pas_y = "+pas_y) ;
				Mechant mechant = 
						(Mechant) PersonnageFactory.createPersonnage(TypePersonnage.MECHANT, pas_x, pas_y, x, y) ;
				mechants.add(mechant) ;
			} catch (Exception e) {	e.printStackTrace() ;} 
		}
		
		// Ajout des étoiles ...
		for (int i=1; i<=nbr_etoile; i++) {
			int x, y;
			try {
				x = Configs.class.getField("s"+stage+"_e"+i+"_x").getInt(this);
				y = Configs.class.getField("s"+stage+"_e"+i+"_y").getInt(this);
				objets.add(new Etoile(x, y, pas_x, pas_y)) ;
				//etoiles.add(new Etoile(x, y, pas_x, pas_y)) ;
			} catch (Exception e) {	e.printStackTrace() ;} 
		}
				
		// ajout des munitions ...
		for (int i=1; i<=nbr_munition; i++) {
			int x, y;
			try {
				x = Configs.class.getField("s"+stage+"_mu"+i+"_x").getInt(this);
				y = Configs.class.getField("s"+stage+"_mu"+i+"_y").getInt(this);
				objets.add(new Munition(x, y, pas_x, pas_y)) ;
				//munitions.add(new Munition(x, y, pas_x, pas_y)) ;
			} catch (Exception e) {	e.printStackTrace() ;} 
		}
		
		// Ajout des gâteaux miam miam ...
		for (int i=1; i<=nbr_gateaux; i++) {
			int x, y;
			try {
				x = Configs.class.getField("s"+stage+"_b"+i+"_x").getInt(this);
				y = Configs.class.getField("s"+stage+"_b"+i+"_y").getInt(this);
				objets.add(new Bouffe(x, y, pas_x, pas_y)) ;
				//bouffes.add(new Bouffe(x, y, pas_x, pas_y)) ;
			} catch (Exception e) {	e.printStackTrace() ;} 
		}
		
	}
	
	/**
	 * @return the NbEtoile
	 */
	public int getNbEtoile() {
		return NbEtoile;
	}

	
	/**
	 * @param NbEtoile the NbEtoile to set
	 */
	public void setNbEtoile(int NbEtoile) {
		this.NbEtoile = NbEtoile;
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

	
	public ArrayList<Mechant> getMechants() {
		return mechants;
	}
	
	
	// to fix ...
	public void setMechants(ArrayList<Mechant> mechants) {
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
	
	/**
	 * @return the pas_x
	 */
	public int getPas_x() {
		return pas_x;
	}

	/**
	 * @param pas_x the pas_x to set
	 */
	public void setPas_x(int pas_x) {
		this.pas_x = pas_x;
	}

	/**
	 * @return the pas_y
	 */
	public int getPas_y() {
		return pas_y;
	}

	/**
	 * @param pas_y the pas_y to set
	 */
	public void setPas_y(int pas_y) {
		this.pas_y = pas_y;
	}

	/**
	 * @return the etoiles
	 *
	public ArrayList<Etoile> getEtoiles() {
		return etoiles;
	}

	/**
	 * @param etoiles the etoiles to set
	 *
	public void setEtoiles(ArrayList<Etoile> etoiles) {
		this.etoiles = etoiles;
	}

	/**
	 * @return the munitions
	 *
	public ArrayList<Munition> getMunitions() {
		return munitions;
	}

	/**
	 * @param munitions the munitions to set
	 *
	public void setMunitions(ArrayList<Munition> munitions) {
		this.munitions = munitions;
	}

	/**
	 * @return the bouffes
	 *
	public ArrayList<Bouffe> getBouffes() {
		return bouffes;
	}

	/**
	 * @param bouffes the bouffes to set
	 *
	public void setBouffes(ArrayList<Bouffe> bouffes) {
		this.bouffes = bouffes;
	}*/
	
}