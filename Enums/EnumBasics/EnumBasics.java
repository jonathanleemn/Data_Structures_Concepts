package EnumBasics;

import java.util.Random;

public class EnumBasics {
	//enum behaves similar to a class
	private enum Status{SLEEPIING, EATING, CODING, GAMING};
	
	public static void main(String[]args){
		Random rand=new Random();
		int randNum=rand.nextInt(4)+1; //number between 1-4
		Status curentStatus = null;
		
		switch(randNum){
			case 1:
				curentStatus=Status.SLEEPIING;
				break;
			case 2:
				curentStatus=Status.EATING;
				break;
			case 3:
				curentStatus=Status.CODING;
				break;
			case 4:
				curentStatus=Status.GAMING;
				break;		
		}
		
		switch(curentStatus){
		case SLEEPIING:
			System.out.println("Go away! Sleeping. . .");
			break;
		case EATING:
			System.out.println("Go away! Eating. . .");
			break;
		case CODING:
			System.out.println("Go away! Writing Code. . .");
			break;	
		default:
			System.out.println("Go away! Gaming. . .");
		}
	}
}