package etu.vue;

import intinfo.Jeu;

import java.awt.Dimension;
import java.awt.Graphics;
 
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import etu.utils.Configs;
 
public class StartMenuPane extends JPanel {
 
	//private boolean resume = false ;
	private static final long serialVersionUID = 1L;
    private static final ImageIcon bg = new ImageIcon(Configs.bgPathImageMenu1) ;
    private static final String options[] = {"Nouveau Jeu", "Resume", "Engeristrer", "Charger Jeu", "Options", "About", "Quitter"}, 
    				cmds[]   = {"nouveau", "resume", "enregistrer", "charger", "options", "aide", "quitter"} ;
    private CustomButton btnTab[] ;
    private boolean []actifs = {true, false, false, true, true, true, true } ;
    
    public StartMenuPane (ActionListener listener) {
        super();
        //System.out.println("StartMenuPane -> constructeur()") ;
        System.out.println((++Jeu.c)+". "+this.getClass().getSimpleName()+" -> constructeur(); hcode: "+this.hashCode()) ;
        setFocusable(true) ;
        setPreferredSize(new Dimension( Configs.largeurC, Configs.hauteurC)) ;
        setLayout(new GridBagLayout());
        
        btnTab = new CustomButton[options.length] ;
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        for (int i=0; i<options.length; i++) {
        	btnTab[i] = new CustomButton(options[i]) ;
        	btnTab[i].setActionCommand(cmds[i]) ;
        	c.gridy = i ;
        	this.add(btnTab[i], c) ;
        	btnTab[i].addActionListener(listener) ;
        	//btnTab[i].setEnabled(actifs[i]) ;
        		
        }
    }
 
    
    public void setResumeAndSaveBtn(boolean enabled) {
		actifs[1]=enabled ;
		actifs[2]=enabled ;
    }
     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(), 0, 0, getWidth(), getHeight(), this) ;
        for (int i=0; i<actifs.length; i++)
        	btnTab[i].setEnabled(actifs[i]) ;
        //System.out.println("StartMenuPane -> paintComponent()") ;
    }
    
    /**
	 * @return the resume
	 */
	public boolean isResume() {
		return actifs[1] ;
	}


	/**
	 * @param resume the resume to set
	 */
	public void setResume(boolean resume) {
		actifs[1] = resume;
	}




}