package etu.models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import etu.utils.Direction;
import etu.vue.Conteneur;

public class Arme extends ObjetDeBase implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7386500070702084229L;
	private static final int DEFAULT_LARGEUR = 70,
							 DEFAULT_HAUTEUR = 70;
	protected Timer timing ;
	protected static int deplacement = 5 ;
	protected Direction direction ;
	protected Conteneur vue ;

	
	public Arme (int [] pxy, int pas_x, int pas_y, Conteneur vue, Direction direction) {
		super (pxy[0], pxy[1], DEFAULT_LARGEUR, DEFAULT_HAUTEUR, pas_x, pas_y) ;		
		this.direction = direction ;
		this.vue = vue ;
		loadImage(direction) ;
		draw = true ;
	}

	// public Arme(int[] armeCoords, int pas_x, int pas_y, intinfo.Conteneur
	// vue2, Direction direction2) {
	// // TODO Auto-generated constructor stub
	// super (armeCoords[0], armeCoords[1], DEFAULT_HAUTEUR, DEFAULT_HAUTEUR,
	// pas_x, pas_y) ;
	// }

	public void updatePosition () {
		Background bg = vue.getEnv().getBackground() ;
		int largeurC = vue.getLargeurC(), hauteurC = vue.getHauteurC(),
			largimage = bg.getLargeur(),
			hautimage = bg.getHauteur() ;
		switch (direction) {				
			case DOWN : 
				int maxY = hautimage - bg.getSy2() ;
				// conversion echelle 2 (conteneur) ...
				maxY = ((maxY * hauteurC) / (hautimage/3)) +  hauteurC ;
				setDraw(incremtY(maxY, pas_y*2)) ;
				break ;
			case UP :
				int minY = -bg.getSy1() ;
				// conversion echelle 2 (conteneur) ...
				minY = (hauteurC * minY) / (hautimage/3) ;
				setDraw(decremY(minY, pas_y*2)) ;
				break ;
			case LEFT : 
				int minX = -bg.getSx1() ;
				// conversion echelle 2 (conteneur) ...
				minX = (largeurC * minX) / (largimage/3) ;
				setDraw(decremX(minX, pas_x*2) ) ;
				break ;
			case RIGHT :
				int maxX = largimage - bg.getSx2() ;
				// conversion echelle 2 (conteneur) ...
				maxX = ((maxX * largeurC) / (largimage/3)) + largeurC ; 
				setDraw(incremX(maxX, pas_x*2)) ;
				break ;
			default :
				System.out.println("Direction Inconnu AS") ;
		}
	}
		
	public void startTiming (int delay, ActionListener listener) {
		timing = new Timer(delay, listener) ;
		timing.addActionListener(listener) ;
		timing.start() ;
	}
	
	public void starTiming() {
		timing = new Timer(100, this) ;
		timing.addActionListener(this) ;
		timing.start() ;
	}
	
	public void stopTiming() {
		timing.stop() ;
	}
	
	protected void loadImage (Direction direction) {
		try {
			switch (direction) {
			case UP: image = ImageIO.read(new File("Resources/images/missile_up.png")) ;
				break ;
			case DOWN: image = ImageIO.read(new File("Resources/images/missile_down.png")) ;
				break ;
			case RIGHT: image = ImageIO.read(new File("Resources/images/missile_right.png")) ;
				break ;
			case LEFT: image = ImageIO.read(new File("Resources/images/missile_left.png")) ;
				break ;
			default:
				break;
			}
		} catch (IOException e) {
			System.out.println("Problème lors du chargement de l'image missile...") ;
			e.printStackTrace() ;
		}
	}

	public boolean decremX(int minX, int v) {
		if (position_x-v >= minX ) {
			position_x -= v ;
			return true ;
		}
		else 
			position_x = minX ;
		return false ;
	}
	
	public boolean decremY(int minY, int v) {
		if (position_y-v >= minY ) {
			position_y -= v ;
			return true ;
		}
		else 
			position_y = minY ;
		return false ;
	}
	
	public boolean incremX(int maxX, int v) {
		if(position_x+largeur+v<= maxX) {
			position_x += v ;
			return true ;
		}
		else 
			position_x = maxX - largeur ;
		return false ;
	}
	
		
	public boolean incremtY(int maxY, int v) {
		if (position_y+largeur+v <= maxY) {
			position_y += v ;
			return true ;
		}
		else 
			position_y = maxY - largeur ;
		return false ;
	}
	
	@Override	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		updatePosition() ;
		/*for (ObjetDeBase o : vue.getEnv().getObjets()) {	
			if (this.collision(o) && o instanceof Obstacle) draw = false ;
			break ; 
		}*/
		
		Mechant mort = null ;
		for (Mechant m : vue.getEnv().getMechants()) {
			if (this.collision(m)) {
				mort = m ;
				draw = false ;
				vue.getEnv().getGoinfre().setScore(vue.getEnv().getGoinfre().getScore() + 80) ;
			}
		}
		if (mort != null)  vue.getEnv().getMechants().remove(mort) ;
		
		if (!draw) {
			stopTiming() ;
			vue.getEnv().getObjets().remove(this) ;
		} else 
			vue.repaint() ;
	}

	@Override
	public void doCollision(Goinfre g, Environnement env) {
		// TODO Auto-generated method stub
		//return false;
	}
}