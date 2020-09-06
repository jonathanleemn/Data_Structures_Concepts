package org.cgorrill.mud;

import org.cgorrill.mud.player.Player;

public class Encounter {
	private Player player;
	
	public Encounter(int type, Player player){
		this.player=player;
		setEncounter(type);
	}
	
	private void setEncounter(int type){
			setMessage(type);
			setEffect(type);
	}
	
	private void setMessage(int type){
		switch(type){
		case 1:
			System.out.println("OhNOOOOO!!! A TRAP!");
			break;
		case 2:			
		case 3:
		case 4:
			System.out.println("Sweet! You have discovered a hidden tresure!");
			break;
		case 5:
		case 6:
		case 7:
			System.out.println("A monster! Fight and win or DIE!!!");
	
		}
	}
	
	private void setEffect(int type){
		switch(type){
		case 1:
			System.out.println("Game over!");
			System.exit(0);
			break;
		case 2:			
		case 3:
		case 4:
			player.getInventory().addItem(new Item("Sword"));
			break;
		case 5:
		case 6:
		case 7:
			player.fight();
	
		}
	}
}
