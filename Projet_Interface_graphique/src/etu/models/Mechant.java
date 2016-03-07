package etu.models;

import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

import etu.utils.Configs;
import etu.utils.Direction;
import etu.vue.Conteneur;

public class Mechant extends Personnage  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5517176344102969898L;
	protected int direction_random = 0, pas_random=7 ;
	protected Random random ;
	protected Direction direction = Direction.UP ;
	protected boolean vivant = true ;

	public Mechant(int x, int y,int largeur, int hauteur, Direction direction, int pas_x, int pas_y) {
		super (x, y, largeur, hauteur, pas_x, pas_y) ;
		
		try {
			image = ImageIO.read(new File(Configs.mPathImage));	
		}
		catch (Exception e) {
		}
		setDirection(direction) ;
	}

	public void move ( Environnement env, Conteneur conteneur) {
		
		if (pas_random==0) {
			int lower = 30;
			int higher = 50;
			pas_random = (int)(Math.random() * (higher-lower)) + lower ; ;
			direction_random = (int)(Math.random() * (4)) + 0 ;
			switch (direction_random) {
				case 0 : direction = Direction.UP ; break ;
				case 1 : direction = Direction.DOWN ; break ;
				case 2 : direction = Direction.LEFT ; break ;
				case 3 : direction = Direction.RIGHT ; break ;
			}
			move ( env, conteneur) ; 
		} else { 
			
			int hautimage1_3 = env.getBackground().getHauteur()/3 ;
			int hauteurC = conteneur.getHauteurC() ;
			int largeurC = conteneur.getLargeurC() ;
			int largimage1_3 = env.getBackground().getLargeur()/3 ;
			pas_random-- ;
			switch (direction) {
			case DOWN : 
				int maxY = env.getBackground().getHauteur() - env.getBackground().getSy2() ;
				maxY = ((maxY * hauteurC) / hautimage1_3) +  hauteurC ;
				incremtY(maxY); 
				break ;
			
			case UP :
				int minY = -env.getBackground().getSy1() ;
				minY = (hauteurC * minY) / hautimage1_3 ;
				decremY(minY); 
				break ;
			
			case LEFT : 
				int minX = -env.getBackground().getSx1() ;
				minX = (largeurC * minX) / largimage1_3 ;
				decremX(minX); 
				break ;
			
			case RIGHT :		
				int maxX = env.getBackground().getLargeur() - env.getBackground().getSx2() ;
				maxX = ((maxX * largeurC) / largeurC) + largeurC ; 
				incremX(maxX); 
				break ;
				
			}
			}
		}
			
	}