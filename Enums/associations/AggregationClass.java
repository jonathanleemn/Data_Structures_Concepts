package associations;

//passing objects of type numbers and type person into the constructor
//exist outside of the class
public class AggregationClass {
	private Numbers num1;
	private Person p1;	
	
	public AggregationClass(Numbers num1, Person p1) {
		this.num1 = num1;
		this.p1 = p1;
	}
	public Numbers getNum1() {
		return num1;
	}
	public void setNum1(Numbers num1) {
		this.num1 = num1;
	}
	public Person getP1() {
		return p1;
	}
	public void setP1(Person p1) {
		this.p1 = p1;
	}
	@Override
	public String toString() {
		return "AggregationObject [num1=" + num1 + ", p1=" + p1 + "]";
	}
	
	
}
