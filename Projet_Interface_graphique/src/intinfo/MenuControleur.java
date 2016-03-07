package intinfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.prefs.Preferences;

import javax.swing.JOptionPane;

import etu.utils.Configs;
import etu.utils.Serialisation;
import etu.utils.Son;
import etu.vue.AidePane;
import etu.vue.FenetrePrincipale;
import etu.vue.GameOverPane;
import etu.vue.OptionPane;
import etu.vue.StartMenuPane;

public class MenuControleur implements Serializable, ActionListener, KeyListener {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 929024819077960752L;
	private Application app ;
	private StartMenuPane menuPane ;
	private OptionPane optionPane ;
	private FenetrePrincipale fenetre ;
	private transient Preferences prefs ;
	
	public MenuControleur(FenetrePrincipale fen) {
		System.out.println((++Jeu.c)+". MenuControleur -> constructeur(); this "+this.hashCode()) ;
		prefs = Preferences.userRoot().node("MenuControleur");
		fenetre = fen ;
		menuPane = new StartMenuPane(this) ; 
		optionPane = new OptionPane(this) ;
		fenetre.setMenuPane(menuPane) ;
		fenetre.setOptionPane(optionPane) ;
		fenetre.addPane(new GameOverPane(this), 3) ;
		fenetre.addPane(new AidePane(this), 4);
		if (menuPane == null) {
			System.out.println("MenuControleur: menuPane == null") ;
		}
	}
	
	public int getTouche(String touche) {
		return prefs.getInt(touche, 0) ;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Application app ;
		switch (e.getActionCommand()) {
		
		case "nouveau" :
			nouveauJeu () ;
			break;
			
		case "enregistrer" :
			enregistrer () ;
			break ;
			
		case "resume" :
			app.getControl().getTiming().start(); 
			fenetre.setActualConteneur(1);
			fenetre.getMesConteneurs()[1].setEnabled(true) ;
			break;
			
		case "charger" :
			try { charger (Configs.serialPath) ;} catch (IOException e1) {e1.printStackTrace(); System.exit(0); }
			break ;
			
		case "aide" :
			fenetre.setActualConteneur(4);
			break;
			
		case "quitter" :
			System.out.println("\nquitter") ;
			quitter () ;
			break ;
	
		case "retourAbout" : 
			fenetre.setActualConteneur(0);
			break ;
			
		case "options" :
			fenetre.setActualConteneur(2) ;
			System.out.println("\noptions") ;
			break ;
			
		case "Valider" :
			if (optionPane.tUp.getText().trim().length() > 1 ||
					optionPane.tDown.getText().trim().length() > 1 || 
					optionPane.tLeft.getText().trim().length() > 1 || 
					optionPane.tRight.getText().trim().length() > 1 
					) optionPane.verifier = false ; 
				
				int up = 0 ;
				int down = 0 ; 
				int left = 0;
				int right = 0 ;
				int tirer  = 0 ;
				
				if (!optionPane.tUp.getText().trim().equals("")) up =  (int) (optionPane.tUp.getText()).toUpperCase() .charAt(0) ;  
				
				if (!optionPane.tDown.getText().trim().equals("")) down =  (int) optionPane.tDown.getText().toUpperCase().charAt(0) ;  
				
				if (!optionPane.tLeft.getText().trim().equals("")) left =  (int) optionPane.tLeft.getText().toUpperCase().charAt(0) ;  
				
				if (!optionPane.tRight.getText().trim().equals("")) right =  (int) optionPane.tRight.getText().toUpperCase().charAt(0) ;  
				
				if (!optionPane.tTirer.getText().trim().equals("")) tirer =  (int) optionPane.tTirer.getText().toUpperCase().charAt(0) ;  
				
								
				if (optionPane.est_just (up, down, left, right, tirer)) {
					System.out.println("tout est juste") ;
					/*Configs.UP = up ;
					Configs.DOWN = down ;
					Configs.LEFT = left ;
					Configs.RIGHT = right ;
					Configs.TIRER = tirer ;*/
					prefs.putInt("UP", up) ;
					prefs.putInt("DOWN", down) ;
					prefs.putInt("LEFT", left) ;
					prefs.putInt("RIGHT", right) ;
					prefs.putInt("TIRER", tirer) ;
					JOptionPane.showMessageDialog(null, "Modification effectée avec succès", "changement de touche", JOptionPane.INFORMATION_MESSAGE);
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Veuillez verifier les touches ", "erreur", JOptionPane.ERROR_MESSAGE) ;
				}
				

			System.out.println("Valider") ;
			break ;
		case "gameOver" :
			fenetre.setActualConteneur(0) ;
			System.out.println("GameOver") ;
			break ;
			
		case "Retour" :
			fenetre.setActualConteneur(0) ;
			System.out.println("Retour") ;
			break ;
		}
	}

	
	public void gameOver () {
		fenetre.getMesConteneurs()[1].setEnabled(false);
		app.getControl().getTiming().stop();
		//fenetre.getMenuPane().setResume(false) ;
		fenetre.getMenuPane().setResumeAndSaveBtn(false);
		fenetre.setActualConteneur(3) ;
		new Son().playGameOver() ;
	}
	
	public void nouveauJeu () {
		System.out.println("\t MenuControleur -> nouveauJeu()") ;
		app = new Application(this) ;
		fenetre.setConteneur(app.getMonconteneur()) ;
		fenetre.setActualConteneur(1) ;
		//menuPane.setResume(true);
		menuPane.setResumeAndSaveBtn(true) ;
	}	
	
	public void charger (String path) throws IOException {
		System.out.println("\t MenuControleur -> charger()") ;
		Application appli = Serialisation.load(path) ;
		appli.loadAllAppImages() ;		
		app = new Application(appli.getStage(), this, appli.getMonenvionnement()) ;
		fenetre.setConteneur (app.getMonconteneur()) ;
		fenetre.setActualConteneur(1) ;
		//menuPane.setResume(true);
		menuPane.setResumeAndSaveBtn(true) ;
		/*
		 * Application.setMesSon(new Son()) ;
		 * fenetre.setClipMenu ((new Son ()).getplaySonMenu()) ;
		 * StartMenuPane st = app.getMenuControleur().getMenuPane() ;
		 * if (st != null) System.out.println("MenuControleur -> charger(); menuPane NOT NULL") ;
		 * else System.out.println("MenuControleur -> charger(); menuPane null") ;
		 * fenetre.setMenuPane(st) ;
		*/
		System.out.println ("\t "+this.getClass().getSimpleName()+" -> charger(); Chargement réussie.") ;
	}
	
	
	public void enregistrer () {
		System.out.println("\t MenuControleur -> enregistrer()") ;
		System.out.println(""+app) ;
		Serialisation.save(app, Configs.serialPath) ;
		System.out.println ("Sauvegarde réussie.") ;
		JOptionPane.showMessageDialog(menuPane, "Sauvegarde réussie", "Sauvegarde", JOptionPane.INFORMATION_MESSAGE) ;
	}
	
	
	public void afficherOptions () {
		
	}
	
	public void quitter () {
		System.exit(0) ;
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("menuControleur -> keyPressed()") ;
		if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.out.println("\t "+this.getClass().getSimpleName()+" -> keyPressed==VK_ESCAPE") ;
			app.getControl().getTiming().stop() ;
			fenetre.getMesConteneurs()[1].setEnabled(false) ;
			fenetre.setActualConteneur(0) ;
			//Serialisation.save(app, Configs.serialPathResume) ;
		}
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * @return the app
	 */
	public Application getApp() {
		return app;
	}



	/**
	 * @param app the app to set
	 */
	public void setApp(Application app) {
		this.app = app;
	}



	/**
	 * @return the menuPane
	 */
	public StartMenuPane getMenuPane() {
		return menuPane;
	}



	/**
	 * @param menuPane the menuPane to set
	 */
	public void setMenuPane(StartMenuPane menuPane) {
		if (menuPane==null)System.out.println("MenuControleur->setMenuPane: menuPane = null") ;
		this.menuPane = menuPane;
	}



	/**
	 * @return the fenetre
	 */
	public FenetrePrincipale getFenetre() {
		return fenetre;
	}



	/**
	 * @param fenetre the fenetre to set
	 */
	public void setFenetre(FenetrePrincipale fenetre) {
		this.fenetre = fenetre;
	}

}
