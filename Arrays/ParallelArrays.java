


public class ParallelArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * This is one way of creating the people for the Zombie project
		 * */
		
		//initialize an array of names for the people
		String[] names={"Charlie", "Pete", "Ella", "Lila", "Mason", "Christine", "Stella", "Gregg", "Tellah", "Andrew", 
				"Paige", "Brian","Rex", "Christian", "Jaquie", "Lizzy", "Brennan", "Brendan", "John", "Corie", "Champ",
				"Mandee", "Helen", "Randy", "Randi", "Rage", "Jim", "Sheila", "Carin", "Mary", "Matt", "Bella", "Jacob",
				"Edward"};
		//create an array of people
		Person[] people=new Person[25];
		
		//use index i of the names array as the parameter for a Person constructor
		//put new Person in each indes of the people array
		for(int i=0; i<people.length; i++)
			people[i]=new Person(names[i]);
		
		//use an enhanced for loop to iterate over the people array and print their names
		for(Person person: people)
			System.out.println(person.getName());
		
		for(int i = 0; i<people.length; i++){
			System.out.println(people[i].getName());
		}

	}

}
