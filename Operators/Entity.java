
public class Entity {
	private int attack, defense, mana; // stats
	String name; // name
	int locX, locY; // location

	public Entity(String n, int x, int y){
		attack=50;
		defense=25;
		mana=20;
		name = n; 
		locX = x;
		locY = y;
		
	}
	
	public void setAttack(int a) {
		attack = a;
	}

	public int getAttack() {
		return attack;
	}

	public void setDefense(int d) {
		defense = d;
	}

	public int getDefense() {
		return defense;
	}

	public void setMana(int m) {
		mana = m;
	}

	public int getMana() {
		return mana;
	}

	public void setName(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	public void setLocX(int x) {
		locX = x;
	}

	public int getLocX() {
		return locX;
	}

	public void setLocY(int y) {
		locY = y;
	}

	public int getLocY() {
		return locY;
	}
	
	public String toString(){
		return "Name:" + name + " Attack:" + attack + " Defense:" + defense + 
				" Mana:" + mana + " Location X:" + locX + " Location Y:" + locY;
	}
}
