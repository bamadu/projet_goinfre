package intinfo;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.util.ArrayList;

//import javax.swing.Timer;

import etu.models.Arme;
import etu.models.Goinfre;
import etu.vue.Conteneur;

public class ArmeControlleur implements KeyListener {//, ActionListener  {
	
	//protected ArrayList<Arme> armes ;
	protected Conteneur vue ;
	protected Environnement env ;
	protected Goinfre goinfre ;
	//protected int compteurArme = 0 ;
	//protected Timer timing ;
	
	public ArmeControlleur(Goinfre _goinfre, Conteneur _vue, Environnement _env) {
		vue = _vue ;
		env = _env ;
		goinfre = _goinfre ;
		//armes = new ArrayList<Arme>() ;
	}

	@Override
	public void keyPressed(KeyEvent kevent) {
		// TODO Auto-generated method stub
		/*System.out.println("\nKeyPressed:\n Code:"+kevent.getKeyCode()
				+"\nVK:"+KeyEvent.VK_A+"\n") ; */
		if (kevent.getKeyCode() == KeyEvent.VK_A) {
			System.out.println("Pressed A") ;
			Arme arme = new Arme(goinfre.getArmeCoords(), goinfre.getPas_x(), goinfre.getPas_y(), vue, goinfre.getDirection()) ;
			//armes.add(arme) ;
			env.addObjet(arme) ;
			arme.starTiming() ;
			//arme.startTiming(150, "cmd_"+compteurArme, this) ;
			//if (compteurArme == 0) {
				//timing = new Timer(1000, this) ;
				//timing.start() ;
			//}
			vue.repaint() ;
		}
	}

	@Override
	public void keyTyped(KeyEvent kevent) {
		// TODO Auto-generated method stub
		/*System.outx².println("\n\nKeyTyped:\n Code:"+kevent.getKeyCode()
				+"\nVK:"+KeyEvent.VK_A) ;
		*/
	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (Arme arme: armes){
			//if (e.getActionCommand() == arme.getCmd()) {
			arme.updatePosition(env.getBackground(), vue.getLargeurC(), vue.getHauteurC());
			//System.out.println(arme.getCmd()) ;
			//}
		}
		vue.repaint() ;
	}
	 */
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}