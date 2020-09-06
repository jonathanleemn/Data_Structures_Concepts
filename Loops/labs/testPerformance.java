package labs;

public class testPerformance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Performance review=new Performance();
		review.inputRating();
		review.setOnProbation(true);
		System.out.println(review.review());

	}

}
