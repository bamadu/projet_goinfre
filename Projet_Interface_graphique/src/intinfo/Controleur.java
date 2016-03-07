package intinfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

import javax.swing.Timer;

import etu.models.Arme;
import etu.models.Environnement;
import etu.models.Goinfre;
import etu.models.Mechant;
import etu.models.ObjetDeBase;
import etu.utils.Direction;
import etu.utils.Son;
import etu.vue.Conteneur;


public class Controleur implements KeyListener, ActionListener, Serializable {
	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -2058838172137562118L;
	private Environnement env ;
	private Conteneur conteneur ;
	private Timer timing ;
	private Goinfre goinfre ;
	private MenuControleur menuControleur ;
	private Application app ;
	
	public Controleur(Environnement environnement, Conteneur conteneur, MenuControleur menuControleur, Application app) {
		//System.out.println("Controleur -> constructeur(Env, Conteneur)") ;
		System.out.println((++Jeu.c)+". Controleur -> constructeur(); this "+this.hashCode()) ;
		this.env = environnement ;
		this.app = app ;
		this.conteneur = conteneur ;
		this.menuControleur =  menuControleur ;
		timing = new Timer (100, this) ;
		timing.addActionListener(this) ;
		this.goinfre = environnement.getGoinfre() ;
		timing.start() ;
	}
	
	@Override
	public void keyPressed(KeyEvent arg)  {
		//System.out.println("Controleur -> keyPressed()") ;
		
		if (arg.getKeyCode() == KeyEvent.VK_RIGHT  || arg.getKeyCode() == menuControleur.getTouche("RIGHT") ) {
			goinfre.move(env , conteneur, Direction.RIGHT) ; 
		}
		else if (arg.getKeyCode() == KeyEvent.VK_LEFT  || arg.getKeyCode() == menuControleur.getTouche("LEFT") ) 
			goinfre.move(env , conteneur, Direction.LEFT) ; 
		
		else if (arg.getKeyCode() == KeyEvent.VK_UP  || arg.getKeyCode() == menuControleur.getTouche("UP") ) 
			goinfre.move(env , conteneur, Direction.UP) ; 
				
		else if (arg.getKeyCode() == KeyEvent.VK_DOWN  || arg.getKeyCode() == menuControleur.getTouche("DOWN") ) 
			goinfre.move(env , conteneur, Direction.DOWN) ; 
					
		else if (arg.getKeyCode() == KeyEvent.VK_A || arg.getKeyCode() == menuControleur.getTouche("TIRER") ) {
			int nb = env.getGoinfre().getNbArmes() ;
			if (nb != 0 ) {			
				new Son().playlanceMissile() ;
				
				env.getGoinfre().setNbArmes(nb - 1) ;
				Arme arme = new Arme(goinfre.getArmeCoords(), goinfre.getPas_x(), goinfre.getPas_y(), conteneur, goinfre.getDirection()) ;
				env.addObjet(arme) ;
				//env.addArme(arme) ;
				arme.starTiming() ;
			}
		}
		
		if (goinfre.getEnergie() == 0) {
			timing.stop() ;
			menuControleur.gameOver () ;
			
		}
		
		if (env.getNbEtoile() == 0 ) {
			int score = env.getGoinfre().getScore() ;
			app = new Application (2, menuControleur) ;
			conteneur.setEnv(env = app.getMonenvionnement()) ;
			goinfre = env.getGoinfre() ;
			goinfre.setScore(score);
		}
		
		
		conteneur.repaint() ;
	}

	@Override
	public void keyReleased(KeyEvent arg) {
		// TODO Auto-generated method stub
		//System.out.println("Released "+arg.getKeyChar()) ;
	}

	@Override
	public void keyTyped(KeyEvent arg) {
		// TODO Auto-generated method stub
		//System.out.println("Typed "+arg.getKeyChar()) ;
	}
	
	public void actionPerformed(ActionEvent arg) {
		// TODO Auto-generated method stub
		try {
		int s_x, s_y ;
		boolean sort  ;
		for (Mechant m : env.getMechants()) { 
			sort = false ;
			s_x = m.getPosition_x() ;
			s_y = m.getPosition_y() ;
			m.move(env,conteneur) ;
			for (ObjetDeBase o : env.getObjets()) {
				if (m.collision(o)) {
					//System.out.println("colision avec objet") ;
					sort = true ;
					m.setPosition_x(s_x) ;
					m.setPosition_y(s_y) ;
				}
				if (sort) break ;	
			}
			if (sort) continue ;
			for (Mechant mm : env.getMechants()) {
				if (m.collision(mm) && m != mm) {
					//System.out.println("colision avec mechant") ;
					sort = true ;
					m.setPosition_x(s_x) ;
					m.setPosition_y(s_y) ;
				}
				if (sort) break ;
			}
			
			if (sort) continue ; 
			if (m.collision(env.getGoinfre())) {
				//System.out.println("colision avec goinfre") ;
				sort = true ;

				//new Son().playGoinfreGateau();
				env.getGoinfre().setEnergie(env.getGoinfre().getEnergie() - 2) ;
				m.setPosition_x(s_x) ;
				m.setPosition_y(s_y) ;
			}
		} 
		
		conteneur.repaint() ;
		} catch (Exception e) {System.out.print("erreur mechant");}
	}

	/**
	 * @return the timing
	 */
	public Timer getTiming() {
		return timing;
	}

	/**
	 * @param timing the timing to set
	 */
	public void setTiming(Timer timing) {
		this.timing = timing;
	}
}
