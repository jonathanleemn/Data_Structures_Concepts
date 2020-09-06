package whileStuff;

public class PowersOf2 {

	public static void main(String[] args) {
		powersOfTwo(5);
	}
	static void powersOfTwo(int numPowersofTwo){
		int output=1;
		int counter=1;
		while(counter<=numPowersofTwo){
			output*=2;
			System.out.println(output);
			counter++;
		}
	}

}
