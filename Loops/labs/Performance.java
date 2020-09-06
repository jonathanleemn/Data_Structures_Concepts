package labs;

import java.util.Scanner;

public class Performance {
	private String rating="";
	private double raise=0;
	private boolean onProbation=false;
	private Scanner scan=new Scanner(System.in);
	
	public void setRating(String rating) {
		this.rating=rating;
	}
	
	public String getRating(){
		return rating;
	}
	
	public void inputRating(){
		System.out.println("Please enter a rating of excellent, good, satisfactory or poor:");
		setRating(scan.next());
	}
	
	public void setOnProbation(boolean onProbation){
		this.onProbation=onProbation;
	}
	
	public String review(){
		if(rating.equalsIgnoreCase("excellent")){
			raise=.06;
			return"You get a 6% raise";			
			}
		else if( rating.equalsIgnoreCase("good")){
			raise=.04;
			return "You get a 4% raise";			
		}
		else if(rating.equalsIgnoreCase("Satisfactory")){
			raise=.03;
			return"You get a 3% raise" ;			
		}
		else if(onProbation)
			return "Jeston!You're FIRED!!" ;
		else{
			onProbation=true;
			return "You are on probation and get no raise" ;			
		}
	}
	
	
}
