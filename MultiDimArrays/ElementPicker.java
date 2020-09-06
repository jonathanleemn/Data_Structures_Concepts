package lectureFiles;

import java.util.ArrayList;

public class ElementPicker {
	final int ROWS=10, COLS=10;
	int[][] arr=new int[ROWS][COLS];
	//moves that i'm going to pick from
	ArrayList<Integer> rowMove=new ArrayList<Integer>();
	ArrayList<Integer> colMove=new ArrayList<Integer>();
	ArrayList<Integer> elements=new ArrayList<Integer>();
	
	//fill array with randoms
	public void fillArr(){
		for(int row=0; row<arr.length; row++){
			for(int col=0; col<arr[row].length; col++){
				arr[row][col]=(int)(Math.random()*2);
			}
		}
	}
	
	//loop over for a total number of numMoves
	public void pickMoves(int numMoves){
		for(int i=0; i<numMoves; i++){
			rowMove.add((int)(Math.random()*ROWS));
			colMove.add((int)(Math.random()*COLS));
		}
		
	}
	
	//looks over the two arraylists rowMove and colMove
	public void pickElements(){
		
		for(int i=0; i<rowMove.size(); i++){
			elements.add(arr[rowMove.get(i)][colMove.get(i)]);
		}
	}
	
	public void printElements(){
		System.out.println(elements.toString());		
	}
	
	public void printArr(){
		for(int[] nums: arr){
			for(int num: nums){
				System.out.print(num);
			}
			System.out.println();
		}		
	}
	
	public void printPickedMoves(){
		for(int i=0; i<rowMove.size(); i++)
		System.out.printf("(%d,%d)%n", rowMove.get(i), colMove.get(i));
	}
}
