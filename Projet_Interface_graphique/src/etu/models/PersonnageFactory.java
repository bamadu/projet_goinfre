package etu.models;

import etu.utils.Direction;
import etu.utils.TypePersonnage;

public class PersonnageFactory {
	
	public static  Personnage createPersonnage(TypePersonnage type, int pas_x, int pas_y, int position_x, int position_y) {
		switch (type) {
			case GOINFRE :
				return new Goinfre(position_x, position_y, 70, 70, Direction.LEFT, pas_x, pas_y);
			case MECHANT : 
				return new Mechant(position_x, position_y, 70, 70, Direction.LEFT, pas_x, pas_y);
			default: 
				return null;
		}
	}
	
}
