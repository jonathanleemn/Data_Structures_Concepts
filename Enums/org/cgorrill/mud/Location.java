package org.cgorrill.mud;

public class Location {
	int column, row;
	
	public Location(int r, int c){
		setRow(r);
		setCol(c);
	}
	
	public int getCol(){
		return column;
	}
	
	public int getRow(){
		return row;
	}
	
	public void setCol(int c){
		column=c;
	}
	public void setRow(int r){
		row=r;
	}
	
	public String toString(){
		return "Row: "+row+" Column: "+column;
	}
	

}
