package etu.vue;

import intinfo.Jeu;
import intinfo.MenuControleur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import etu.utils.Configs;

public class AidePane extends JPanel {

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final ImageIcon bg  = new ImageIcon(Configs.bgPathImageMenu1) ;
	
	public AidePane (MenuControleur listener) {
		super() ;
		System.out.println((++Jeu.c)+". "+this.getClass().getSimpleName()+" -> constructeur(); hcode: "+this.hashCode()) ;
		setFocusable(true) ;
        setPreferredSize(new Dimension( Configs.largeurC, Configs.hauteurC)) ;
        setLayout(new BorderLayout()) ;
        
        CustomButton btn = new CustomButton("Retour Menu") ;
        btn.setActionCommand("retourAbout") ;
        btn.addActionListener(listener) ;
        add(btn, BorderLayout.SOUTH) ;
	}

	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(), 0, 0, getWidth(), getHeight(), this);
        g.setColor(Color.white) ;
		Font font = new Font(" TimesRoman ", Font.BOLD + Font.ITALIC, 25) ;   
		g.setFont(font);
		g.drawString("Goinfre V 0.1",(getWidth()/2)-40-30, getHeight()/2-20);
        g.drawString("HALIT Mounir", (getWidth()/2)-60-30, (getHeight()/2)+10);
        g.drawString("Seydou Amadou Beidari", (getWidth()/2)-100-30, (getHeight()/2)+40);
        //System.out.println("StartMenuPane -> paintComponent()") ;
    }
}
