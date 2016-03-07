package draft ;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import etu.models.Mechant;
import etu.models.ObjetDeBase;
import intinfo.Environnement;

public class Conteneur2 extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8079614840578195585L;
	private int hauteurC, largeurC ;
	private int dx1, dy1, dx2, dy2;
	private Environnement env ;
	
	public Environnement getEnv() {
		return env;
	}

	public Conteneur2(Environnement environnement, int hauteur, int largeur) {
		this.env = environnement ;
		hauteurC = hauteur ;
		largeurC = largeur ;
		this.setPreferredSize(new Dimension(hauteurC, largeurC)) ;
		this.setFocusable(true) ;
		dx1 = dy1 = 0  ;
		dx2 = dy2 = hauteurC ;
		
	}
	
	public void paint(Graphics g) {
		super.paint(g) ;
		g = (Graphics2D) g ;	
		
		g.drawImage(env.getBackground().getBgImage(),
				dx1, dy1, dx2, dy2, 
				env.getBackground().getSx1(), env.getBackground().getSy1(), env.getBackground().getSx2(), env.getBackground().getSy2(), 
				this) ;
		
		for (Mechant m : env.getMechants()) {
			g.drawImage(m.getImage() , m.getPosition_x(), 
				m.getPosition_y(), m.getLargeur(), m.getLargeur(),this) ;	
			
		}
		
		g.drawImage(env.getGoinfre().getImage() , env.getGoinfre().getPosition_x(), env.getGoinfre().getPosition_y(), env.getGoinfre().getLargeur(), env.getGoinfre().getLargeur(),this) ;
		
		
		for (ObjetDeBase o : env.getObjets()) {
			if (o.isDraw())
				g.drawImage(o.getImage(), o.getPosition_x(), 
							o.getPosition_y(), o.getLargeur(), o.getLargeur(),this) ;	
				
		}
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
}