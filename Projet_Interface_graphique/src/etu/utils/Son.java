package etu.utils;

import intinfo.Jeu;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Son {
	AudioInputStream LanceMissile ;
	AudioInputStream Goinfrebouge ;
	AudioInputStream GoinfreGateau ;
	AudioInputStream GoinfreTuer ;
	AudioInputStream Menu ;
	AudioInputStream GameOver ;
	AudioInputStream BgSound ;
	File audiofileLM ;
	File audiofileGB ;
	File audiofileGG ;
	File audiofileGT ;
	File audiofileMN ;
	File audiofileGO ;
	File audiofileBgs ;
	AudioFormat format ;
    DataLine.Info info ;
    Clip audioClip ;

	
	public Son ()  {
		System.out.println((++Jeu.c)+". "+this.getClass().getSimpleName()+" -> constructeur(); hcode: "+this.hashCode()) ;
		audiofileLM = new File(Configs.pathSoundLM);
		audiofileGB = new File(Configs.pathSoundGB);
		audiofileGG = new File(Configs.pathSoundGG);
		audiofileGT = new File(Configs.pathSoundGT);
		audiofileMN  = new File(Configs.pathSoundMn);
		audiofileGO  = new File(Configs.pathSoundGO);
		audiofileBgs = new File(Configs.pathSoundBgs);
		
		try {
			LanceMissile = AudioSystem.getAudioInputStream(audiofileLM);
			Goinfrebouge = AudioSystem.getAudioInputStream( audiofileGB);
			GoinfreGateau = AudioSystem.getAudioInputStream( audiofileGG);
			GoinfreTuer = AudioSystem.getAudioInputStream( audiofileGT);
			Menu = AudioSystem.getAudioInputStream(audiofileMN);
			GameOver = AudioSystem.getAudioInputStream(audiofileGO);
			BgSound = AudioSystem.getAudioInputStream(audiofileBgs);
			
			 format = Goinfrebouge.getFormat(); 
			 info = new DataLine.Info(Clip.class, format);
		     //audioClip = (Clip) AudioSystem.getLine(info);
			 //audioClip.open(Goinfrebouge);
			
		}
		catch (Exception e) { System.out.println("erreurtttttttttttt"); } 
		}
	
	
	public void playlanceMissile ()  {		
		try{
			AudioFormat format = LanceMissile.getFormat(); 
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(LanceMissile);
			audioClip.start();
		} catch (Exception e) {} 
	}
	
	public void playGoinfreBouge () {	
		try {
		Goinfrebouge = AudioSystem.getAudioInputStream( audiofileGB);
		//System.out.print("entrer") ;
		format = Goinfrebouge.getFormat(); 
		 info = new DataLine.Info(Clip.class, format);
	     audioClip = (Clip) AudioSystem.getLine(info);
		 audioClip.open(Goinfrebouge) ;
		 //audioClip.loop(20);
		audioClip.start() ;
		} catch (Exception e) { e.printStackTrace() ; }
	}
	
	public void playGoinfreTuer () {		
		try{
			audioClip.open(GoinfreTuer);
			audioClip.start();
		} catch (Exception e) {} 
	}
	
	public void playGoinfreGateau () {		
		try{
			AudioFormat format = GoinfreGateau.getFormat(); 
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(GoinfreGateau);
			audioClip.start();
		} catch (Exception e) {} 
	}
	
	public void playSonMenu () {		
		try{
			Menu = AudioSystem.getAudioInputStream( audiofileMN);
			//System.out.print("entrer") ;
			format = Menu.getFormat(); 
			 info = new DataLine.Info(Clip.class, format);
		     audioClip = (Clip) AudioSystem.getLine(info);
			 audioClip.open(Menu) ;
			 audioClip.loop(20);
			audioClip.start() ;
		} catch (Exception e) {System.out.print("erreur");}
		 //return audioClip ;
	}
	
	public void playGameOver () {		
		try{
			AudioFormat format = GameOver.getFormat(); 
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(GameOver);
			audioClip.start();
			
		} catch (Exception e) {System.out.print("erreur"); } 
		//return audioClip ;
	}
	
	
	public void playSonJeu () {		
		try{
			BgSound = AudioSystem.getAudioInputStream(audiofileBgs);
			//System.out.print("entrer") ;
			format = Goinfrebouge.getFormat(); 
			 info = new DataLine.Info(Clip.class, format);
		     audioClip = (Clip) AudioSystem.getLine(info);
		     audioClip.loop(20);
		     audioClip.open(BgSound) ;
			audioClip.start() ;
		} catch (Exception e) {System.out.print("erreur");}
		 //return audioClip ;
	}
	
	
	
	
	
	
	
	
	public void stop () {
		audioClip.stop();		
	}
	
	public void play () {
		audioClip.loop(20);
		audioClip.start();		
	}
	

}
