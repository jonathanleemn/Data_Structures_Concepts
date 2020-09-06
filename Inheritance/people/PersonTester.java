package people;

public class PersonTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person thisGuy=new Person();
			
		Student thisStudent=new Student("Student", "Guy", 165, 65, 19);		
		
		Teacher thisTeacher=new Teacher("Teacher", "Guy", 180, 72, 22);
		Teacher thisTeacher2=new Teacher();
		
	
		System.out.printf("%s output:\n", thisGuy.getClass().getName().substring(thisGuy.getClass().getName().lastIndexOf('.')+1));
		System.out.println(thisGuy);
		System.out.printf("%s output:\n", thisStudent.getClass().getName());
		System.out.println(thisStudent);
		System.out.printf("%s output:\n", thisTeacher.getClass().getName());
		System.out.println(thisTeacher);
		System.out.printf("%s output:\n", thisTeacher2.getClass().getName());
		System.out.println(thisTeacher2);
	}

}
