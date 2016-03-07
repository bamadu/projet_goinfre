package etu.vue;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelCustom extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6378388659243717767L;
	Font font ;
	public LabelCustom (String name) {
		super (name) ;
		setForeground(Color.WHITE);
		font = new Font(" TimesRoman ", Font.BOLD , 13) ;
		this.setFont(font) ;
	}
	
	
}
