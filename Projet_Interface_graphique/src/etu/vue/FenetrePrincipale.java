/**
 * 
 */
package etu.vue;

import intinfo.Jeu;
import intinfo.MenuControleur;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.SwingUtilities;


import etu.utils.Configs;
import etu.utils.Son;

/**
 * @author Beid
 *
 */
public class FenetrePrincipale extends JFrame implements Runnable {

		
	/**
	 * 
	 */
	private static final long serialVersionUID = -8918181927181874334L;
	private StartMenuPane menuPane ;
	private OptionPane optionPane ;
	private JPanel mesConteneurs [] ;
	private int actualConteneur ;
	private MenuControleur menuControleur ;
	private transient Son s ;
	private transient Son sj ;
	//private transient Clip clipMenu  ;

	
	public FenetrePrincipale () {
		System.out.println((++Jeu.c)+". "+this.getClass().getSimpleName()+" -> constructeur(); hcode: "+this.hashCode()) ;
		setTitle(Configs.titre) ;
		actualConteneur = 0 ;
		mesConteneurs = new JPanel[5] ;
		menuControleur = new MenuControleur(this) ;	
	}
	
	
	
	public void init () {	
		System.out.println("\t FenetrePrincipale -> init()") ;
		s  = new Son();
		sj = new Son() ;
		sj.playSonJeu();
		sj.stop();
		s.playSonMenu();		//setClipMenu((new Son ()).getplaySonMenu()) ;
		mesConteneurs[0] = menuPane ;
		setActualConteneur(0) ;
		//this.getContentPane().add(mesConteneurs[actualConteneur]) ;
		this.setResizable(false) ;
		this.pack() ;
		this.setVisible(true) ;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		this.setLocationRelativeTo(null) ;
		
	}

	public void addPane (JPanel pane, int index) {
		if (index<5 && pane != null) {
			mesConteneurs[index] = pane ;
		} else {
			System.out.println("\t FenetrePrincipale -> addPane: index >=5 ou pane = null") ;
		}
	}
	public void setConteneur (Conteneur conteneur) {
		mesConteneurs[1] = conteneur ;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		init () ;
	}

		
	/**
	 * @return the mesConteneurs
	 */
	public JPanel[] getMesConteneurs() {
		return mesConteneurs;
	}

	/**
	 * @param mesConteneurs the mesConteneurs to set
	 */
	public void setMesConteneurs(JPanel[] mesConteneurs) {
		this.mesConteneurs = mesConteneurs;
	}

	/**
	 * @return the actualConteneur
	 */
	public int getActualConteneur() {
		return actualConteneur;
	}

	/**
	 * @param actualConteneur the actualConteneur to set
	 */
	public void setActualConteneur(int actualConteneur) {
		
		switch (actualConteneur) {
		case 0 : 
			sj.stop();
			s.play();
			break ;
		case 1 : 
			s.stop();
			sj.play() ;
			System.out.println("0000 je suis la son menuuuu ");
			//new Son().
			//clipMenu.start();
			break ;
			
		case 3 : 
			s.stop();
			sj.stop();
			//clipMenu.stop(); 
			//System.out.print("clip stopppppp");
			//clipMenu.stop();
			//clipGameOver.start(); 
			break ;
		}
		
		/*
		 * System.out.println("FenetrePrincipale -> setActualConteneur(), actual="+actualConteneur) ;
		 * if (mesConteneurs[actualConteneur]==null)
		 * System.out.println("FenetrePrincipale -> setActualConteneur(), mesConteneurs["+actualConteneur+"] is null") ;
		 * else
		 * System.out.println("FenetrePrincipale -> setActualConteneur(), mesConteneurs["+actualConteneur+"] is NOT null") ;
		*/
		this.actualConteneur = actualConteneur ;
		this.getContentPane().removeAll() ;
		//System.out.println("ma fenetre principale "+this);
		this.getContentPane().add(mesConteneurs[actualConteneur]) ;
		this.revalidate() ;
		this.setFocusable(false) ;
		this.repaint() ;
		mesConteneurs[actualConteneur].requestFocusInWindow();
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
		this.menuPane = menuPane;
		this.mesConteneurs[0] = menuPane ;
	}

	/**
	 * @return the optionPane
	 */
	public OptionPane getOptionPane() {
		return optionPane;
	}

	/**
	 * @param optionPane the optionPane to set
	 */
	public void setOptionPane(OptionPane optionPane) {
		this.optionPane  = optionPane ;
		mesConteneurs[2] = optionPane ;
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



}
