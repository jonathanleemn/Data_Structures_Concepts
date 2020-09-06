package org.cgorrill.mud.player;

import java.util.Scanner;

import org.cgorrill.mud.Inventory;
import org.cgorrill.mud.Location;

public class Player {
	private Location loc;
	private Inventory inventory=new Inventory();	
	
	public Player(Location loc){
		this.loc=loc;
	}	
	
	public void move(String dir){
		switch(dir.charAt(0)){
			case 'W':
			case 'w': loc.setRow(loc.getRow()-1);
			break;
			case 's':
			case 'S': loc.setRow(loc.getRow()+1);
			break;
			case 'a':
			case 'A': loc.setCol(loc.getCol()-1);
			break;
			case 'd':
			case 'D': loc.setCol(loc.getCol()+1);
			break;
		}
	}
	
	public void fight(){
		System.out.println("A fight would happen here.");
	}
	
	public Location getLocation(){
		return loc;
	}
	
	public Inventory getInventory(){
		return inventory;
	}
}
