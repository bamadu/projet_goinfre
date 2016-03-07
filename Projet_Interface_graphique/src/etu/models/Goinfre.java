package etu.models;

import intinfo.Jeu;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import etu.utils.Configs;
import etu.utils.Direction;
import etu.utils.Son;
import etu.vue.Conteneur;

public class Goinfre extends Personnage {	
	
 	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6392517097917590759L;
	protected transient BufferedImage[] images ;
	protected int energie, 
 				  score, 
 				  nbArmes,
 				  imageActuel ;
	
	public Goinfre(int x, int y,int largeur, int hauteur, Direction direction, int pas_x, int pas_y) {
		super (x, y, largeur, hauteur, pas_x, pas_y) ;
		System.out.println((++Jeu.c)+". "+this.getClass().getSimpleName()+" -> constructeur(); hcode: "+this.hashCode()) ;
		loadImage() ;
		nbArmes = 6 ;
		energie = 100 ;
		score = 0 ;
		setDirection(direction) ;
	}
	
	public void loadImage() {
		System.out.print("\t Goinfre -> loadImage() ") ;
		images = new BufferedImage[4] ;
		try {
			images[0] = ImageIO.read(new File(Configs.gPathImageUp));
			System.out.print("img0 ") ;
			images[1] = ImageIO.read(new File(Configs.gPathImageDown));
			System.out.print("img1 ") ;
			images[2] = ImageIO.read(new File(Configs.gPathImageLeft));
			System.out.print("img2 ") ;
			images[3] = ImageIO.read(new File(Configs.gPathImageRight));
			System.out.println("img3 ") ;
		}
		catch (Exception e) { 
			System.out.println("\t Erreur Image goinfre:") ;
			e.printStackTrace() ;
		}
	}
	
	public int getNbArmes() {
		return nbArmes;
	}

	public void setNbArmes(int nbArmes) {
		this.nbArmes = nbArmes;
	}

	public int getScore() {
		return score;
	}

	public synchronized void setScore(int score) {
		this.score = score;
	}

	public int getEnergie() {
		return energie;
	}

	public synchronized void setEnergie(int energie) {
		if (energie <= 0) this.energie = 0 ;
		else if (energie >= 100) this.energie = 100 ; 
		else this.energie = energie ;
	}

	public int[] getArmeCoords() {
		int []coords = new int[2] ;
		switch (direction) {
		case LEFT :
			coords[0] = position_x ; coords[1] = position_y + hauteur/2 ;
			break ;
		case UP :
			coords[0] = position_x + largeur/2 ; coords[1] = position_y ;
			break ;
		case RIGHT :
			coords[0] = position_x + largeur ; coords[1] = position_y + hauteur/2 ;
			break ;
		case DOWN :
			coords[0] = position_x + largeur/2 ; coords[1] = position_y + hauteur ;
			break ;
		}
		coords[0] = position_x + largeur/2 ; coords[1] = position_y + hauteur/2 ;
		return coords ;
	}
	
public void move (Environnement env, Conteneur conteneur, Direction direction) {
		ArrayList<ObjetDeBase> objets = env.getObjets() ;
				
		this.setDirection(direction) ;
		int hautimage1_3 = env.getBackground().getHauteur()/3 ;
		int hauteurC = conteneur.getHauteurC() ;
		int largeurC = conteneur.getLargeurC() ;
		int largimage1_3 = env.getBackground().getLargeur()/3 ;
		int [] mcx = new int[env.getMechants().size()] ;
		int [] mcy = new int[env.getMechants().size()] ;
		int [] ocx = new int[objets.size()] ;
		int [] ocy = new int[objets.size()] ;
		int [] sxy = new int[4] ;
		sxy[0] = env.getBackground().getSx1() ;
		sxy[1] = env.getBackground().getSy1() ;
		sxy[2] = env.getBackground().getSx2() ;
		sxy[3] = env.getBackground().getSy2() ;
		
		
		int i = 0 ;
		for (Mechant m : env.getMechants()) {
			mcx[i] = m.getPosition_x() ;
			mcy[i] = m.getPosition_y() ;
			i++ ;
		}
		i = 0 ;
		
		for (ObjetDeBase ob : objets) {
			ocx[i] = ob.getPosition_x() ;
			ocy[i] = ob.getPosition_y() ;
			i++ ;
		}
		
		switch (direction) {
		
		case LEFT:
			if ( env.getBackground().getSx1() - env.getBackground().getMvt()   >= 0) {// move the screen
				if (getPosition_x()> Configs.largeurC/2) {
					decremX(0) ;				
				} else {
					for (Mechant m : env.getMechants()) {
						int maxX = env.getBackground().getLargeur() - env.getBackground().getSx2() ;
						maxX = ((maxX * largeurC) / largeurC) + largeurC ; 
						m.incremX(maxX) ;
					}
					for (ObjetDeBase o : objets) {
						int maxX = env.getBackground().getLargeur() - env.getBackground().getSx2() ;
						maxX = ((maxX * largeurC) / largeurC) + largeurC ; 
						o.incremX(maxX) ;
					}
			
					env.getBackground().setSx1(env.getBackground().getSx1() - env.getBackground().getMvt()) ; 
					env.getBackground().setSx2(env.getBackground().getSx2() - env.getBackground().getMvt()) ;
				}
			} else if (env.getBackground().getSx1() < env.getBackground().getMvt() && env.getBackground().getSx1() > 0) {
				
				for (Mechant m : env.getMechants()) {
					int maxX = env.getBackground().getLargeur() - env.getBackground().getSx2() ;
					maxX = ((maxX * largeurC) / largeurC) + largeurC ; 
					m.incremX(maxX) ;
				}
				
				for (ObjetDeBase o : objets) {
					int maxX = env.getBackground().getLargeur() - env.getBackground().getSx2() ;
					maxX = ((maxX * largeurC) / largeurC) + largeurC ; 
					o.incremX(maxX) ;
				}
				
				env.getBackground().setSx2(env.getBackground().getSx2() - env.getBackground().getSx1()) ;
				env.getBackground().setSx1(0) ;
			} else { // otherwise it's the goinfre move
				decremX(0) ;
			}
			break;
		
			
		case RIGHT:
			if (env.getBackground().getSx2() + env.getBackground().getMvt() <= env.getBackground().getBgImage().getWidth()) { // move the screen
				if (getPosition_x() < Configs.largeurC/2) {
					incremX(Configs.largeurC) ;
				} else {
					
					for (Mechant m : env.getMechants()) {
						int minX = -env.getBackground().getSx1() ;
						minX = (largeurC * minX) / largimage1_3 ;
						m.decremX(minX); 
					}
					
					for (ObjetDeBase o: objets) {
						int minX = -env.getBackground().getSx1() ;
						minX = (largeurC * minX) / largimage1_3 ;
						o.decremX(minX); 
					}
					
					env.getBackground().setSx1(env.getBackground().getSx1() + env.getBackground().getMvt()) ; 
					env.getBackground().setSx2(env.getBackground().getSx2() + env.getBackground().getMvt()) ;
				}
			} else if (env.getBackground().getSx2() < env.getBackground().getBgImage().getWidth()) {
				
				for (Mechant m : env.getMechants()) {
					int minX = -env.getBackground().getSx1() ;
					minX = (largeurC * minX) / largimage1_3 ;
					m.decremX(minX); 
				}
				
				for (ObjetDeBase o: objets) {
					int minX = -env.getBackground().getSx1() ;
					minX = (largeurC * minX) / largimage1_3 ;
					o.decremX(minX); 
				}
				
				env.getBackground().setSx1 (env.getBackground().getSx1() + (env.getBackground().getBgImage().getWidth() - env.getBackground().getSx2())) ;
				env.getBackground().setSx2(env.getBackground().getBgImage().getWidth()) ;
			} else { // otherwise it's the goinfre move
				incremX(Configs.largeurC) ;
			}
			break;

			
		case UP: 
			if (env.getBackground().getSy1() - env.getBackground().getMvt() >= 0) { // move the screen
				if (getPosition_y() > Configs.hauteurC/2) {
					decremY(0);
				} else {
					
					for (Mechant m : env.getMechants()) {
						int maxY = env.getBackground().getHauteur() - env.getBackground().getSy2() ;
						maxY = ((maxY * hauteurC) / hautimage1_3) +  hauteurC ;
						m.incremtY(maxY); 
					}
					
					for (ObjetDeBase o : objets) {
						int maxY = env.getBackground().getHauteur() - env.getBackground().getSy2() ;
						maxY = ((maxY * hauteurC) / hautimage1_3) +  hauteurC ;
						o.incremtY(maxY); 
					}
					
					env.getBackground().setSy1(env.getBackground().getSy1() - env.getBackground().getMvt()) ;
					env.getBackground().setSy2(env.getBackground().getSy2() - env.getBackground().getMvt()) ;
				}
			} else if (env.getBackground().getSy1()>0 && env.getBackground().getSy1() < env.getBackground().getMvt()) {
				
				for (Mechant m : env.getMechants()) {
					int maxY = env.getBackground().getHauteur() - env.getBackground().getSy2() ;
					maxY = ((maxY * hauteurC) / hautimage1_3) +  hauteurC ;
					m.incremtY(maxY); 
				}
				
				for (ObjetDeBase o : objets) {
					int maxY = env.getBackground().getHauteur() - env.getBackground().getSy2() ;
					maxY = ((maxY * hauteurC) / hautimage1_3) +  hauteurC ;
					o.incremtY(maxY); 
				}
				
				env.getBackground().setSy2(env.getBackground().getSy2() - env.getBackground().getSy1()) ;
				env.getBackground().setSy1(0) ;
			} else { // otherwise it's the goinfre move
				decremY(0) ;
			}
			break ;
			
			
		case DOWN:
			if (env.getBackground().getSy2() + env.getBackground().getMvt() <= env.getBackground().getBgImage().getHeight()) { // move the screen
				
				if (getPosition_y() < Configs.hauteurC/2) {
					incremtY(Configs.hauteurC) ;
				} else {
					
					for (Mechant m : env.getMechants()) {
						int minY = -env.getBackground().getSy1() ;
						minY = (hauteurC * minY) / hautimage1_3 ;
						m.decremY(minY);
					}
					
					for (ObjetDeBase o : objets) {
						int minY = -env.getBackground().getSy1() ;
						minY = (hauteurC * minY) / hautimage1_3 ;
						o.decremY(minY);
					}
					
					env.getBackground().setSy1(env.getBackground().getSy1() + env.getBackground().getMvt()) ;
					env.getBackground().setSy2(env.getBackground().getSy2() + env.getBackground().getMvt()) ;
				}
				
			} else if (env.getBackground().getSy2() < env.getBackground().getBgImage().getHeight()) {
				
				for (Mechant m : env.getMechants()) {
					int minY = -env.getBackground().getSy1() ;
					minY = (hauteurC * minY) / hautimage1_3 ;
					m.decremY(minY);
				}
				
				for (ObjetDeBase o : objets) {
					int minY = -env.getBackground().getSy1() ;
					minY = (hauteurC * minY) / hautimage1_3 ;
					o.decremY(minY);
				}
				
				env.getBackground().setSy1(env.getBackground().getSy1() + (env.getBackground().getBgImage().getHeight() - env.getBackground().getSy2())) ;
				env.getBackground().setSy2(env.getBackground().getBgImage().getHeight()) ;
			}
			else { // otherwise it's the goinfre move
				incremtY(Configs.hauteurC) ;
			}
		
			
		default:
			break;
		}
		
		collision_object (env, conteneur, mcx, mcy, ocx, ocy, sxy, objets) ;
		
	}	
	
	
	public void collision_object (Environnement env, Conteneur conteneur, int [] mcx, int [] mcy, int [] ocx, int [] ocy, int [] sxy, ArrayList<ObjetDeBase> objets) {
		
		int goinfre_x = getPosition_x() ;
		int goinfre_y = getPosition_y() ;
		int i ;
		for (Mechant m : env.getMechants()) {
			if (this.collision(m)) {
				
				i = 0 ;
				for (Mechant mm : env.getMechants()) {
					mm.setPosition_x(mcx[i]) ;
					mm.setPosition_y(mcy[i]) ;
					i++ ;
				}
				
				i= 0 ;
				for (ObjetDeBase o : objets) {
					o.setPosition_x(ocx[i]) ;
					o.setPosition_y(ocy[i]) ;
					i++ ;
				}
				
				setPosition_x(goinfre_x) ;
				setPosition_y(goinfre_y) ;
				env.getBackground().setSx1(sxy[0]) ;
				env.getBackground().setSy1(sxy[1]) ;
				env.getBackground().setSx2(sxy[2]) ;
				env.getBackground().setSy2(sxy[3]) ;
				setEnergie(getEnergie() - 2) ;

				new Son().playGoinfreBouge();
				return ;
			}
		}
		
		i = 0 ;
		
		/*for (ObjetDeBase o : env.getObjets()) {
			o.collision(this, env) ;
		}
		
		for (Bouffe b : env.getBouffes()) {
			b.collision(this, env) ;
		}
		
		for (Etoile e : env.getEtoiles()) {
			e.collision(this, env) ;
		}
		
		for (Munition m : env.getMunitions()) {
			m.collision(this, env) ;
		}*/
		
		for (ObjetDeBase o : env.getObjets()) {
			
			if (this.collision(o)) {
				o.doCollision(this, env) ;
				/*if (o instanceof Bouffe) {
					setScore(getScore() + ((Bouffe) o).getPoint() ) ;
					setEnergie(getEnergie() + ((Bouffe) o).getEnergie()) ;
					env.getObjets().remove(o) ;
					(new Son()).playGoinfreGateau() ;
					return ;
				} else if (o instanceof Etoile) {
					setScore(getScore() + ((Etoile) o).getPoint()) ;
					conteneur.getEnv().setNbEtoile(conteneur.getEnv().getNbEtoile() - 1 ) ;
					env.getObjets().remove(o) ;
					(new Son()).playGoinfreGateau() ;
					// a completer quand il reste plus d'Ã©toile 	
					return ;
				} else if (o instanceof Munition) {
					int nb = conteneur.getEnv().getGoinfre().getNbArmes() ;
					conteneur.getEnv().getGoinfre().setNbArmes(nb + ((Munition)o).getNbMunition()) ;
					env.getObjets().remove(o) ;
					(new Son()).playGoinfreGateau() ;
					return ;		
				} else { // sinon le test pour les obstacles (non implementés...) to fix
					System.out.println("else no no no ") ;
					o.setPosition_x(ocx[i]) ;
					o.setPosition_y(ocy[i]) ;
					setPosition_x(goinfre_x) ;
					setPosition_y(goinfre_y) ;
					env.getBackground().setSx1(sxy[0]) ;
					env.getBackground().setSy1(sxy[1]) ;
					env.getBackground().setSx2(sxy[2]) ;
					env.getBackground().setSy2(sxy[3]) ;
					return ;
				}*/
			}
			//i++ ;
		}
	} // Fin collision_object

	
	public void setDirection(Direction direction) {
		this.direction = direction;
		switch (direction) {		
		case UP :
			//imageActuel = 0 ;
			break ;
		
		case DOWN :
			//imageActuel = 1 ;
			break ;
			
		case LEFT :
			imageActuel = 2 ;
			break ;
		
		case RIGHT :
			imageActuel = 3 ;
			break ;
		}
			
	}
	
	public BufferedImage[] getImages() {
		return images;
	}

	public void setImages(BufferedImage[] images) {
		this.images = images;
	}

	public Direction getDirection() {
		return direction;
	}

	public BufferedImage getImage() {
		/*if (imageActuel==0) {
			System.out.print("Goinfre -> getImage(); imageActuel == 0") ;
		}
		if (images==null) {
			System.out.println("Goinfre -> getImage(); images[] == null") ;
			loadImage() ;
		}*/
		return images[imageActuel];
	}

	public void setImage(int i) {
		this.imageActuel = i;
	}

	public void tirer () {
		// a completer
	}

	public void manger () {
		// a completer	
	}
	
}