package associations;

//doesn't exist outside of the class
public class CompositionClass {
	private Person p;
	private Numbers nums;
	
	public CompositionClass(String name, int age, int n1, int n2){
		p=new Person(name, age);
		nums=new Numbers(n1, n2);
	}

	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}

	public Numbers getNums() {
		return nums;
	}

	public void setNums(Numbers nums) {
		this.nums = nums;
	}

	@Override
	public String toString() {
		return "CompositionObject [p=" + p + ", nums=" + nums + "]";
	}
	
	
}
