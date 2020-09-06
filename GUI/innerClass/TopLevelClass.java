package innerClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopLevelClass {
	private int field1, field2;
	private String name;
	InnerClass inner=new InnerClass();//create object from InnerClass

	public TopLevelClass(int i1, int i2, String n){
		field1=i1;
		field2=i2;
		name=n;
	}
	
	public void setFieldsInnerValues(){
		field1=innerField1;//this does not work, I don't have direct access
		field1=inner.getInnerField1();
	}

	/*
	 *An inner class is defined inside of the top level class.
	 *An inner class has an implicit reference to the top level class.
	 *An inner class has direct access to all of the fields and methods of the top level class.
	 *The top level class does not have direct access to the members and methods of the inner class
	 *
	 * */
	private class InnerClass{
		private int innerField1, innerField2;
		private String innerName;
		public InnerClass(){
			innerField1=field1;
			innerField2=field2;
			innerName=name;
		}
		
		public int getInnerField1(){
			return innerField1;
		}

	}
}
