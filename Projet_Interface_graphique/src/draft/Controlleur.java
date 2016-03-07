//package draft;
//
//import java.awt.event.ActionEvent ;
//import java.awt.event.ActionListener ;
//import java.awt.event.KeyEvent ;
//import java.awt.event.KeyListener ;
//
//import javax.swing.Timer;
//
//import etu.models.Arme;
//import etu.models.Goinfre;
//import etu.models.Mechant;
//import etu.models.Personnage;
//import etu.utils.Direction;
//import intinfo.Environnement;
//
////import javax.swing.Timer;
//
//public class Controlleur implements KeyListener, ActionListener{
//	
//	private Environnement env ;
//	private Conteneur2 conteneur ;
//	private Timer timing ;
//	private Goinfre goinfre ;
//	
//	public Controlleur(Environnement environnement, Conteneur2 conteneur) {
//		this.env = environnement ;
//		this.conteneur = conteneur ;
//		timing = new Timer (150, this) ;
//		timing.addActionListener(this) ;
//		this.goinfre = environnement.getGoinfre() ;
//		timing.start() ;
//	}
//	
//	@Override
//	public void keyPressed(KeyEvent arg) {
//		// TODO Auto-generated method stub
//		
//		switch (arg.getKeyCode()) {
//		
//		
//		case KeyEvent.VK_RIGHT :
//			goinfre.move(env , conteneur, Direction.RIGHT) ; 
//			//System.out.println("Touche droit") ;
//			break ;
//			
//		case KeyEvent.VK_LEFT :
//			goinfre.move(env, conteneur, Direction.LEFT) ; 
//			//System.out.println("Touche gauche") ;
//			break ;
//		
//		case KeyEvent.VK_UP :
//			goinfre.move(env, conteneur, Direction.UP) ; 
//			//System.out.println("Touche haut") ;
//			break ;
//		
//		case KeyEvent.VK_DOWN :
//			goinfre.move(env, conteneur, Direction.DOWN) ;
//			//System.out.println("Touche bas") ;
//			break ;
//		case KeyEvent.VK_A :
//			System.out.println("Pressed A") ;
//			Arme arme = new Arme(goinfre.getArmeCoords(), goinfre.getPas_x(), goinfre.getPas_y(), conteneur, goinfre.getDirection()) ;
//			env.addObjet(arme) ;
//			arme.starTiming() ;
//			break ;
//		default :
//			System.out.println("Direction Inconnu") ;
//		}
//		conteneur.repaint() ;
//	}
//
//	@Override
//	public void keyReleased(KeyEvent arg) {
//		// TODO Auto-generated method stub
//		//System.out.println("Released "+arg.getKeyChar()) ;
//	}
//
//	@Override
//	public void keyTyped(KeyEvent arg) {
//		// TODO Auto-generated method stub
//		//System.out.println("Typed "+arg.getKeyChar()) ;
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent arg) {
//		// TODO Auto-generated method stub
//		for (Mechant m : env.getMechants()) m.move(env,conteneur)
//				  ;
//		conteneur.repaint() ;
//	}
//}
