package org.cgorrill.mud;

public class MudTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//The test class will just test the software that I am creating.  
		//You should use the test class to test your software with many different data states 
		//you test to ensure that you do not have bugs
		Map myMap=new Map();
		myMap.printMap();
		for(int i=0; i<10; i++){
			myMap.makeMove();
			System.out.println("Location: "+myMap.getPlayer().getLocation());//a map has a Player, a Player has a Location
			myMap.printMap();
			}
		

	}

}
