package lectureFiles;

public class PickerTester {

	public static void main(String[] args) {
		ElementPicker e=new ElementPicker();
		e.fillArr();
		System.out.println("Int array:");
		e.printArr();
		e.pickMoves(10);
		System.out.println();
		System.out.println("Moves picked:");
		e.printPickedMoves();
		e.pickElements();
		System.out.println();
		System.out.println("Elements picked from int array:");
		e.printElements();

	}

}
