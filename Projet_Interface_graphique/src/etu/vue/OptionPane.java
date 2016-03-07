package etu.vue ;


import intinfo.Jeu;
import intinfo.MenuControleur;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

import etu.utils.Configs;

public class OptionPane extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2818939559382190884L;
	public LabelCustom lUp, lDonw, lLeft, lRight, lTirer ; 
	public JTextField tUp, tDown, tLeft, tRight, tTirer ;
	public CustomButton buttonOk ;
	public CustomButton buttoncan ;
	public boolean  verifier = true ;
	private static final ImageIcon background = new ImageIcon(Configs.bgPathImageMenu1) ;
	
	
	public OptionPane (MenuControleur listener) {
		super () ;
		System.out.println((++Jeu.c)+". "+this.getClass().getSimpleName()+" -> constructeur(); hcode: "+this.hashCode()) ;
		//this.maframe = maframe ;
		setPreferredSize(new Dimension(Configs.largeurC, Configs.hauteurC)) ;
		
		System.out.print( Character.toString((char)Configs.UP) + "  " ) ;
		this.setLayout(new GridBagLayout()) ;
		buttonOk = new CustomButton("Valider", Configs.btnPathImageIconHover1, Configs.btnPathImageIcon1) ;
		buttoncan = new CustomButton("Retour", Configs.btnPathImageIconHover1, Configs.btnPathImageIcon1) ;
		buttonOk.addActionListener(listener) ;
		buttoncan.addActionListener(listener) ;
		lUp = new LabelCustom("Up") ;
		lDonw = new LabelCustom("Down") ;
		lLeft = new LabelCustom("Left") ;
		lRight = new LabelCustom("Right") ;
		lTirer = new LabelCustom("Tirer") ;
		tUp= new JTextField(5) ;
		tDown= new JTextField(5) ;
		tLeft= new JTextField(5) ;
		tRight = new JTextField(5) ;
		tTirer = new JTextField(5) ;
		
		 GridBagConstraints c = new GridBagConstraints () ;
		 c.insets = new Insets(3, 10, 3, 10) ;
	     c.gridx = 0 ;
	     c.gridy = 0 ;		
		this.add(lUp, c) ; 
		c.gridx = 1 ;
		this.add(tUp, c) ;
		c.gridx= 0 ;
		c.gridy++ ;
		this.add(lDonw, c) ;
		c.gridx++ ;
		this.add(tDown, c) ;
		c.gridx= 0 ;
		c.gridy++ ;
		this.add(lLeft, c) ;
		c.gridx++ ;
		this.add(tLeft, c) ;
		c.gridx= 0 ;
		c.gridy++ ;
		this.add(lRight, c) ;
		c.gridx++ ;
		this.add(tRight, c) ;
		c.insets = new Insets(15, 10, 15, 10) ;
	     
		c.gridx= 0 ;
		c.gridy++ ;
		this.add(lTirer, c) ;
		c.gridx++ ;
		this.add(tTirer, c) ;
		
		c.gridx = 0 ;
		c.gridy = 13 ;
		c.insets = new Insets(15, 10, 20, 10) ;
		this.add(buttonOk, c ) ;
		c.gridx ++ ;
		this.add(buttoncan, c) ;
	}

	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
	
	
	public boolean est_just (int up, int down, int left, int right, int tirer) {
		
		if ((up == 0 || (up != down && up !=left && up != right && up != tirer)) &&			
		     (down == 0 || ( down != left && down != right && down != tirer ))	&&
		     (left == 0 || (left != right && left != tirer)) && 
		     (right == 0 || (right != tirer))) return true ;	
		return false ;
	}	
	
	
	
}
