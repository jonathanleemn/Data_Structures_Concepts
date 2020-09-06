    // ProcessEval.java 
    // rough code to evaluate select algorithms; by Jack Pope for CSCI 2002
    // time the operation of given algorithms 
        import java.util.Date; 
        import java.io.*; 
        import java.util.*; 

    public class ProcessEval {
          
          public static void main (String[] args) throws IOException { 

            long MAX_ITERATIONS = 10000;
            int MIN_ITERATIONS = 1000;
            int step = 100;         // use step since we don't need every iteration to see trends

            // set up output file
            FileWriter fw = null; 
            File file = null; 

        try { 
              file = new File("timings.txt"); 

              if(!file.exists()) { 
                file.createNewFile(); 
              } 

              fw = new FileWriter(file); 
 
              fw.write("Iterations, Aresult, \tAtime, \tBresult, \tBtime,"
              		+ " \tCresult, \tCtime\n");  // \n for new line

              for(long n = MIN_ITERATIONS; n <= MAX_ITERATIONS; n += step) {

                Date time_start = new Date();       // start timer 
                long Aresult = processA(n);
                Date time_end = new Date();         // stop timer 
                long Atime = (time_end.getTime() - time_start.getTime()) / 1000;      // seconds

                time_start = new Date();           // start timer 
                long Bresult = processB(n);
                time_end = new Date();             // stop timer 
                long Btime = (time_end.getTime() - time_start.getTime()) / 1000;      // seconds

                time_start = new Date();           // start timer 
                long Cresult = processC(n);
                time_end = new Date();             // stop timer 
                long Ctime = (time_end.getTime() - time_start.getTime()) / 1000;      // seconds
        
                fw.write(n + ", \t\t" + Aresult + ", \t\t" + Atime + ", \t\t" + Bresult + ", \t\t" + 
                Btime + ", \t\t" + Cresult + ", \t\t" + Ctime + "\n");  // \n for new line
                // System.out.println(  );

                
              }

              fw.close();       // fw.close() automatically called fw.flush() ... should be automatic on scope exit 
            } catch (IOException e) { 
              e.printStackTrace(); 
            } 

          }

          // algorithms to test
          //process A
          public static long processA (long n) 
          {
            long sum = 0;

            for(long i = 1; i <= n; i++) 
              sum += i;

            return sum / n;    
          }

          //process B
          public static long processB (long n) 
          {  
            long sum = 0;

           for(long i = 1; i <= n; i++) 
            {
              for(long j = 1; j <= i; j++) 
              {
                sum += 1;
              } 
            }
           
            return sum / n;
          } 

          //process C
          public static long processC (long n) 
          {
            return n * (n + 1) / 2 / n;
          }

    }

