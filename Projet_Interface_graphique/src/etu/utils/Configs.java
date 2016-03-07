package etu.utils ;

import java.awt.event.KeyEvent;

public class Configs {
	
	public final static int hauteurC = 600 ;
	public final static int largeurC = 850 ;

	public final static String titre = "Projet UPD7: Interface - Graphique" ;
	
	
	// Nombre des différents objets et personnages ...
	public final static int s1_nb_mechants = 3 ;
	public final static int s1_nb_gateaux = 2 ;
	public final static int s1_nb_etoiles = 2 ;
	public final static int s1_nb_munitions = 3 ;
	// Stage 2
	public final static int s2_nb_mechants = 5 ;
	public final static int s2_nb_gateaux = 1 ;
	public final static int s2_nb_etoiles = 4 ;
	public final static int s2_nb_munitions = 1 ;
	
	
	
	// Coordonnées des différents objets du stage 1
	public final static int s1_e1_x  = -280, 
							s1_e1_y  = -380,
							s1_e2_x  =  820,
							s1_e2_y  =  750,
							s1_me1_x =  600,
							s1_me1_y =  600,
							s1_me2_x = -400,
							s1_me2_y = 1400,
							s1_me3_x = 1200,
							s1_me3_y = 1200,
							s1_mu1_x =  200,
							s1_mu1_y =  100,
							s1_mu2_x = -200,
							s1_mu2_y = 1100,
							s1_mu3_x = 1600,
							s1_mu3_y = 200,
							s1_b1_x =    0,
							s1_b1_y =  -40,
							s1_b2_x =  500,
							s1_b2_y =  400,
							
							//Stage 2
							s2_e1_x  = -580, 
							s2_e1_y  = -380,
							s2_e2_x  =  720,
							s2_e2_y  =  1050,
							s2_e3_x  =  1020,
							s2_e3_y  =  450,
							s2_e4_x  =  820,
							s2_e4_y  =  -500,
							s2_me1_x =  600,
							s2_me1_y =  600,
							s2_me2_x = -400,
							s2_me2_y = 700,
							s2_me3_x = 1200,
							s2_me3_y = 100,
							s2_me4_x = -500,
							s2_me4_y = -400,
							s2_me5_x = 950,
							s2_me5_y = 200,
							s2_mu1_x =  800,
							s2_mu1_y =  -100,
							s2_b1_x =    0,
							s2_b1_y =  -40 ; 

	// chemin du fichier de sérialisation ...
	public final static String serialPath = "Resources/save/appli.ser" ;
	// images des icônes ...
	public final static String icPathImageHeart  = 		  "Resources/images/heart.png" ;
	public final static String icPathImageEtoile = "Resources/images/etoile_icone.png" ;
	
	// images des personnages ...
	public final static String gPathImageUp    = "Resources/images/goinfre_droite.png" ;
	public final static String gPathImageDown  = "Resources/images/goinfre_droite.png" ;
	public final static String gPathImageLeft  = "Resources/images/goinfre_gauche.png" ;
	public final static String gPathImageRight = "Resources/images/goinfre_droite.png" ;
	public final static String mPathImage = 			"Resources/images/mechant.png" ;
	
	// images des différents objets de base ...
	public final static String miPathImageUp    = "Resources/images/missile_up.png"    ;
	public final static String miPathImageDown  = "Resources/images/missile_down.png"  ;
	public final static String miPathImageLeft  = "Resources/images/missile_left.png"  ;
	public final static String miPathImageRight = "Resources/images/missile_right.png" ;
	public final static String muPathImage = "Resources/images/munition.png" ;
	public final static String gtPathImage = "Resources/images/Gateau.png" ;
	public final static String ePathImage  = "Resources/images/Etoile.png" ;
	public final static String obPathImage = "Resources/images/obstacle.jpeg" ;
	
	// images de fond: button, page menu, page principale ...
	public final static String btnPathImageIcon1 = "Resources/images/button_petit1.png" ;
	public final static String btnPathImageIconHover1 = "Resources/images/button_petit2.png" ;
	public final static String btnPathImageIconHover = "Resources/images/buttonFd-1.png" ;
	public final static String btnPathImageIcon = "Resources/images/buttonBg-1.png" ;
	public final static String bgPathImage1 = "Resources/images/verdure-2.jpg" ;
	public final static String bgPathImage2 = "Resources/images/stage2.jpg" ;
	public final static String bgPathImageMenu1 = "Resources/images/thief_bg.jpg" ;
	public final static String bgPathImageMenu2 = "Resources/images/farcry_bg.jpg" ;
	public final static String bgPathImageMenu3 = "Resources/images/cod_bg.jpg" ;
	public final static String bgPathImageGameOver = "Resources/images/GameOver.png" ;
	
	
	// chemin des sons du jeu ...
	public final static String pathSoundLM = "Resources/sons/missile.wav" ;
	public final static String pathSoundGT = "Resources/sons/Button-Sound.wav" ;
	public final static String pathSoundGG = "Resources/sons/Mange.wav" ;
	public final static String pathSoundGB = "Resources/sons/Button-Sound.wav" ;
	public final static String pathSoundMn = "Resources/sons/sonmenu.wav" ;
	public final static String pathSoundGO = "Resources/sons/GameOver.wav" ;
	public final static String pathSoundBgs = "Resources/sons/sonjeu.wav" ;
	
	

	// Touche des directions
	public static int UP  = 0,
					DOWN  = 0,
					LEFT  = 0,
					RIGHT = 0,
					TIRER = KeyEvent.VK_A ;
}