package basics;

public class MultiArgumentParameter {
	private double averageOfThree;
	private int one, two, three;
	
	
	public void average(int a, int b, int c){
		one=a;
		two=b;
		three=c;
		setAverageOfThree((double)(one+two+three)/3);
	}


	public double getAverageOfThree() {
		return averageOfThree;
	}


	public void setAverageOfThree(double averageOfThree) {
		this.averageOfThree = averageOfThree;
	}
	
}
