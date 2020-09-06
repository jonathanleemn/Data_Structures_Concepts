package org.cgorrill.mud;

import java.util.ArrayList;

public class PlayerInventory {
	ArrayList<Object> inventory =new ArrayList();
	
	public void addItem(Object item){
		inventory.add(item);
	}
}
