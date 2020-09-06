
public class TestEntity {

	public static void main(String[] args) {
		Entity ent1 = new Entity("Grim", 50, 50);
		Entity ent2 = new Entity("Nova", 25, 25);

		System.out.println("Ent1 att: " + ent1.getAttack());
		System.out.println("Ent2 att: " + ent2.getAttack());

		System.out.println("Ent1 def: " + ent1.getDefense());
		System.out.println("Ent2 def: " + ent2.getDefense());

		System.out.println("Ent1 mana: " + ent1.getMana());
		System.out.println("Ent2 mana: " + ent2.getMana());


		System.out.println("Ent1 name: " + ent1.getName());
		System.out.println("Ent2 name: " + ent2.getName());

		System.out.println("Ent1 locX: " + ent1.getLocX());
		System.out.println("Ent1 locY: " + ent1.getLocY());

		System.out.println("Ent2 locX: " + ent2.getLocX());
		System.out.println("Ent2 locY: " + ent2.getLocY());
		
		System.out.println(ent1.toString());
	
	}

}
