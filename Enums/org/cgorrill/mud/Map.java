package org.cgorrill.mud;

import java.util.Random;
import java.util.Scanner;

import org.cgorrill.mud.player.Player;

public class Map {
	Random rand=new Random();//this is used to create the elements in the map.  
	Scanner scan=new Scanner(System.in);
	private final int ROW=10, COLUMN=10;//these fields are used to set the size of the map
	private int[][] map=new int[ROW][COLUMN];//map is a 2d array of random ints between 1 and 8
	//a map has a Player object
	private Player johnny=new Player(new Location(4, 4));//a Player is constructed using a Location
	
	//construct the Map
	public Map(){
		fillMap();
		System.out.println("Location: "+johnny.getLocation());
		printMap();		
		}

	
	//Fill the map with ints that will set encounters when a player makes a move
	private void fillMap(){
		for(int row=0; row<map.length; row++){
			for(int col=0; col<map[row].length; col++){
				map[row][col]=rand.nextInt(8)+1;				
			}//inner for			
		}//outer for
	}//end fillMap()
	
	
	public void printMap(){
		System.out.println("New Map!");
		for(int row=0; row<map.length; row++){
			for(int col=0; col<map[row].length; col++){
				if(col==johnny.getLocation().getCol()&&row==johnny.getLocation().getRow())//print an 'X' in the player's location
					System.out.print("X ");
				else
					System.out.print(map[row][col]+" ");				
			}//inner for	
			System.out.println();
		}//outer for
		System.out.println();
	}
	

	public void makeMove(){
		System.out.println("Please make a move:");
		System.out.println("press \'w\' to move up:");
		System.out.println("press \'s\' to move down:");
		System.out.println("press \'a\' left:");
		System.out.println("press \'d\' to move right:");
		johnny.move(scan.next());//a Player has a move() method
		setEncounter(johnny.getLocation());//a player has a Location we get it with an accesor method
		
	}
	
	//this will create an encounter based upon the element at the players location in the map
	public void setEncounter(Location loc){
		int row=loc.getRow();
		int col=loc.getCol();
		Encounter encounter=new Encounter(map[row][col], johnny);
	}

	//you will need to access the Player in the Map
	public Player getPlayer(){
		return johnny;
	}
}
