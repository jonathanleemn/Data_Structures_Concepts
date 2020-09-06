package time;

public class Time1Test {

	   public static void main(String[] args)
	   {
	      // create and initialize a Time1 object
	      Time1 time = new Time1(); // invokes Time1 constructor
	      //I do not have direct access to the data fields
	      //I need to use accessors and mutators to access the fields
	      time.minute=1500;
	      time.hour=100;
	      time.second=1234;
	      
	      // output string representations of the time
	      System.out.print( "The initial universal time is: " );
	      System.out.println( time.toUniversalString() );
	      System.out.print( "The initial standard time is: " );
	      System.out.println( time.toString() );
	      System.out.println(); // output a blank line

	      // change time and output updated time 
	      time.setTime( 0, 27, 6 ); 
	      System.out.print( "Universal time after setTime is: " );
	      System.out.println( time.toUniversalString() );
	      System.out.print( "Standard time after setTime is: " );
	      System.out.println( time.toString() );
	      System.out.println(); // output a blank line

	      // attempt to set time with invalid values
	      try
	      {
	         time.setTime( 99, 99, 99 ); // all values out of range
	      } // end try
	      catch ( IllegalArgumentException e )
	      {
	         System.out.printf( "Exception: %s\n\n", e.getMessage() );
	      } // end catch

	      // display time after attempt to set invalid values
	      System.out.println( "After attempting invalid settings:" );
	      System.out.print( "Universal time: " );
	      System.out.println( time.toUniversalString() );
	      System.out.print( "Standard time: " );
	      System.out.println( time.toString() );
	   } // end main
}
