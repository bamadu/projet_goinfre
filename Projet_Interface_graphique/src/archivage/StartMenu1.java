package archivage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class StartMenu1 extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9079229872748038493L;
	protected int choix = 0 ;
	protected BufferedImage image ;
	protected Color couleurTitre, couleurSelection, couleur ; 
	protected Font fontTitre, font ;
	protected String options[] = {
			"Nouveau Jeu", "Charger Jeu", "Aide", "Quitter"
	} ;
	
	public StartMenu1() {
		init () ;
	}
	
	public void init () {
		loadImage() ;
		fontTitre = new Font("Century Gothic", Font.PLAIN, 28) ;
		font = new Font("Arial", Font.PLAIN, 12) ;
		couleurSelection = Color.BLACK ;
		couleur = Color.RED ;	
	}
	
	public void loadImage () {
		try {
			image = ImageIO.read(new File("Resources/images/menubg.gif")) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paint (Graphics g) {
		
		super.paint(g) ;
		g = (Graphics2D) g ;
		
		// dessin de l'image de l'arrière plan ...
		g.drawImage(image, 0, 0, this) ;
		
		// dessin du titre Menu ...
		g.setColor(couleurTitre) ;
		g.setFont(fontTitre) ;
		g.drawString("Projet Interface Graphique", 80, 70) ;
		
		// dessin des options Menu ...
		g.setFont(font);
		for(int i = 0; i < options.length ; i++) {
			if(i == choix) 
				g.setColor(couleurSelection) ;
			else 
				g.setColor(couleur) ;
			g.drawString(options[i], 145, 140 + i * 15) ;
		}	
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_UP) {
			choix--;
			if(choix == -1) {
				choix = options.length - 1;
			}
		}
		if(k == KeyEvent.VK_DOWN) {
			choix++;
			if(choix == options.length) {
				choix = 0;
			}
		}
		repaint() ;
	}
	
	/**
	 * @return the choix
	 */
	public int getChoix() {
		return choix;
	}

	/**
	 * @param choix the choix to set
	 */
	public void setChoix(int choix) {
		this.choix = choix;
	}

	/**
	 * @return the image
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}

	/**
	 * @return the couleurTitre
	 */
	public Color getCouleurTitre() {
		return couleurTitre;
	}

	/**
	 * @param couleurTitre the couleurTitre to set
	 */
	public void setCouleurTitre(Color couleurTitre) {
		this.couleurTitre = couleurTitre;
	}

	/**
	 * @return the couleurSelection
	 */
	public Color getCouleurSelection() {
		return couleurSelection;
	}

	/**
	 * @param couleurSelection the couleurSelection to set
	 */
	public void setCouleurSelection(Color couleurSelection) {
		this.couleurSelection = couleurSelection;
	}

	/**
	 * @return the couleur
	 */
	public Color getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	/**
	 * @return the fontTitre
	 */
	public Font getFontTitre() {
		return fontTitre;
	}

	/**
	 * @param fontTitre the fontTitre to set
	 */
	public void setFontTitre(Font fontTitre) {
		this.fontTitre = fontTitre;
	}

	/**
	 * @return the font
	 */
	public Font getFont() {
		return font;
	}

	/**
	 * @param font the font to set
	 */
	public void setFont(Font font) {
		this.font = font;
	}

	
}
