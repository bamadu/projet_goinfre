package etu.vue;

import intinfo.Jeu;
import intinfo.MenuControleur;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import etu.utils.Configs;

public class GameOverPane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2062334795843816394L;
	private static final ImageIcon bg = new ImageIcon(Configs.bgPathImageGameOver) ;
	
	public GameOverPane (MenuControleur listener) {
		super() ;
		System.out.println((++Jeu.c)+". "+this.getClass().getSimpleName()+" -> constructeur(); hcode: "+this.hashCode()) ;
		setFocusable(true) ;
        setPreferredSize(new Dimension( Configs.largeurC, Configs.hauteurC)) ;
        setLayout(new BorderLayout()) ;
        CustomButton btn = new CustomButton("Retour Menu") ;
        btn.setActionCommand("gameOver") ;
        btn.addActionListener(listener) ;
        add(btn, BorderLayout.SOUTH) ;

	}

	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(), 0, 0, getWidth(), getHeight(), this);
        //System.out.println("StartMenuPane -> paintComponent()") ;
    }
}
