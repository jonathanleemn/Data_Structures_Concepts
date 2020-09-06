import java.util.Random;


public class Randoms {
/*
 * Here is a great explanation from our friends at StackOverflow!
 * http://stackoverflow.com/questions/363681/generating-random-numbers-in-a-range-with-java
 * */
	public static void main(String[] args) {
		//instantiate an object of class Random
		//need to import the class from java.util
		Random rand=new Random();
		int randNum1, randNum2, randNum3, max, min;
		
		randNum1=rand.nextInt(6);//this will give us a random int 0-5
		randNum2=rand.nextInt(6)+1;//this will give us 1-6.  The +1 will shift the range up by 1
		max=6; 
		min=3;
		//generate a number between min and max inclusive
		randNum3 = rand.nextInt((max - min) + 1) + min;//this will give you a value between 1-10
		System.out.printf("Random between 0-5: %d\nRandom between 1-6: %d\nRandom in the range of %d and %d: %d", randNum1, randNum2, min, max, randNum3);
		
		//Math.random generates a random floating point value between 0.0 and 1.0
		randNum1=(int) (1+Math.random()*6);
		System.out.printf("Math.random() 1-6: %d\n", randNum1);
		//generate in a range from min - max
		//cast to int to get an int result
		randNum2=(int) (min + (Math.random() * (max - min)));
		System.out.printf("Math.random() min-max: %d\n", randNum2);
		
		//do it with doubles to get a floating point result
		double randf1, minf=1, maxf=10;
		randf1=(minf + (Math.random() * (maxf - minf)));
		System.out.printf("Math.random() min-max: %.2f\n", randf1);
	}

}
