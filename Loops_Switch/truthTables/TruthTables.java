package truthTables;

public class TruthTables {
	public static void main(String[]Args){
		boolean a=true, b=true, c=true;
		
		System.out.println((a&&b)||!c);
		
		a=false; b=true; c=true;		
		System.out.println((a&&b)||!c);
		
		a=true; b=false; c=true;		
		System.out.println(a&&b||!c);
		
		a=true; b=true; c=false;		
		System.out.println((a&&b)||!c);
		
		a=false; b=false; c=true;		
		System.out.println((a&&b)||!c);
		
		a=true; b=false; c=false;		
		System.out.println((a&&b)||!c);
		
		a=false; b=true; c=false;		
		System.out.println((a&&b)||!c);
		
		a=false; b=false; c=false;		
		System.out.println((a&&b)||!c);
		
	}

}
