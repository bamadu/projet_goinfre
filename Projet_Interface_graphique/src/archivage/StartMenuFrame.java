package archivage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import etu.utils.Configs;
import etu.vue.StartMenuPane;

public class StartMenuFrame extends JFrame implements ActionListener, Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StartMenuPane stmPane;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new StartMenuFrame());
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		stmPane = new StartMenuPane(this) ;
        this.setTitle("BackgroundPanel and Custom button !") ;
        this.setSize(Configs.largeurC, Configs.hauteurC) ;
        this.setLocationRelativeTo(null) ;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        this.getContentPane().add(stmPane) ;
        this.setVisible(true) ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Application app ;
		switch (e.getActionCommand()) {
		
		case "nouveau" :
			System.out.println("\nnouveau") ;
			/*app = new Application(false) ;
			this.dispose() ;
			SwingUtilities.invokeLater(app) ;
			*/break;
		case "charger" :
			System.out.println("\ncharger") ;
			/*app = Serialisation.load() ;
			app.getMonenvionnement().setAncien(true) ;
			try {
				app.loadAllAppImages() ;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose() ;
			SwingUtilities.invokeLater(app) ;
			*/break;
		case "aide" :
			System.out.println("\naide") ;
			break;
		case "quitter" :
			System.out.println("\nquitter") ;
			System.exit(0) ;
			break;
		case "About" :
			System.out.println("\nabout") ;
			break;
		}
	}

}
