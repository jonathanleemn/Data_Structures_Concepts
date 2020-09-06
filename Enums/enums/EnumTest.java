package enums;

import java.util.EnumSet;

public class EnumTest 
{
   public static void main( String[] args ) 
   {
      System.out.println( "All books:\n" );
      
      Book myBook = Book.IW3HTP;
      
      System.out.println("Book: " + myBook.getTitle() + "\nCopyright: " + myBook.getCopyrightYear());
      System.out.println();

      // print all books in enum Book                          
      for ( Book book : Book.values() ) //values() returns an array of all values in the enum                       
         System.out.printf( "%-10s%-45s%s\n", book,
             book.getTitle(), book.getCopyrightYear() );

      System.out.println( "\nDisplay a range of enum constants:\n" );
    
      // print first four books                                 
      for ( Book book : EnumSet.range( Book.JHTP, Book.CPPHTP ) )//returns an array of values between the two values passed
         System.out.printf( "%-10s%-45s%s\n", book,
             book.getTitle(), book.getCopyrightYear() );
   } // end main
} // end class EnumTest
