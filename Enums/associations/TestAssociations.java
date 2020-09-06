package associations;

public class TestAssociations {

	public static void main(String[] args) {
		CompositionClass comp=new CompositionClass("Person Johnson", 40, 345, 543);
		
		Person p1=new Person("Janeta Personella", 21);
		Numbers n1=new Numbers(123,321);
		
		AggregationClass aggs=new AggregationClass(n1, p1);
		AggregationClass aggs2=new AggregationClass(n1, p1);
	}

}
