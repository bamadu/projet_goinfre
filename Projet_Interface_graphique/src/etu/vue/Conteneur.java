package etu.vue ;
import intinfo.Jeu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;    //import the sun.audio package

import etu.models.Environnement;
import etu.models.Mechant;
import etu.models.ObjetDeBase;
import etu.utils.Configs;

public class Conteneur extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1741443978784664254L;
	private Environnement env ;
	private transient BufferedImage coeur ;
	private transient BufferedImage iconMissile ;
	private transient BufferedImage iconEtoile ;
	private int hauteurC, largeurC ;
	private int dx1, dy1, dx2, dy2 ;
	
	public Conteneur(Environnement environnement)  {
		System.out.println((++Jeu.c)+". "+this.getClass().getSimpleName()+" -> constructeur(); hcode: "+this.hashCode()) ;
		this.setFocusable(true) ;
		this.env = environnement ;
		this.hauteurC = Configs.hauteurC ;
		this.largeurC = Configs.largeurC ;
		this.setPreferredSize(new Dimension(hauteurC, largeurC)) ;
		this.setFocusable(true) ;
		dx1 = dy1 = 0  ;
		dx2 = largeurC ;
		dy2 = hauteurC ;
		loadImage() ;
	}
	
	public void loadImage() {
		System.out.println("\t Conteneur -> loadImage()") ;
		try {
			coeur = ImageIO.read(new File (Configs.icPathImageHeart)) ;
			iconMissile = ImageIO.read(new File (Configs.miPathImageUp)) ;
			iconEtoile = ImageIO.read( new File (Configs.icPathImageEtoile)) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Environnement getEnv() {
		return env;
	}
	
	
	
	public void paint(Graphics g) {
		//System.out.println("Conteneur -> paint()") ;
		super.paint(g) ;
		g = (Graphics2D) g ;	
		
		// dessin de l'arri�re plan ...
		g.drawImage(env.getBackground().getBgImage(),
				dx1, dy1, dx2, dy2, 
				env.getBackground().getSx1(), env.getBackground().getSy1(), env.getBackground().getSx2(), env.getBackground().getSy2(), 
				this) ;
				
		// dessin des m�chants ...
		for (Mechant m : env.getMechants()) {
			g.drawImage(m.getImage() , m.getPosition_x(), 
				m.getPosition_y(), m.getLargeur(), m.getLargeur(),this) ;	
			
		}
		
		// dessin du goinfre ...
		g.drawImage(env.getGoinfre().getImage() , env.getGoinfre().getPosition_x(), env.getGoinfre().getPosition_y(), env.getGoinfre().getLargeur(), env.getGoinfre().getLargeur(),this) ;
		
		// dessin des différents objets de base (arme, gâteau, etc ...)
		for (ObjetDeBase o : env.getObjets()) {
			if (o.isDraw())
			g.drawImage(o.getImage() , o.getPosition_x(), 
					o.getPosition_y(), o.getLargeur(), o.getLargeur(),this) ;
		}
		
		// Affiche des infos: score, nb armes, etc ...
		g.setColor(Color.red) ;
		Font fonte = new Font(" TimesRoman ", Font.BOLD + Font.ITALIC, 30) ;
		g.setFont(fonte) ;
		g.drawString(env.getGoinfre().getEnergie()+"", 745, 28) ;
		g.setColor(Color.blue) ;
		g.drawString("Score : "+env.getGoinfre().getScore(), 30, 28) ;
		g.drawImage(coeur, 800, 7, this) ;
		g.drawImage(iconMissile, 660, 8, 40, 21, this) ;
		g.setColor(Color.black) ;
		g.drawString(""+env.getGoinfre().getNbArmes(), 630, 30) ;
		g.drawImage(iconEtoile, 580, 10, 20, 20, this) ;
		g.drawString(env.getNbEtoile()+"", 540, 30) ;
		
	}

	public int getHauteurC() {
		return hauteurC;
	}

	public void setHauteurC(int hauteurC) {
		this.hauteurC = hauteurC;
	}

	public int getLargeurC() {
		return largeurC;
	}

	public void setLargeurC(int largeurC) {
		this.largeurC = largeurC;
	}

	/**
	 * @param env the env to set
	 */
	public void setEnv(Environnement env) {
		this.env = env;
	}
}
