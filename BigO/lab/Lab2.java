package lab;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Lab2
{
    public static void main(String [] args) throws IOException{
        AlgorithmTester test = new AlgorithmTester(args[0]);
        test.readFile();
        test.checkForLogN();
        test.checkForON();
        test.checkForONP2();
        test.checkForONP3();
    }
}

class AlgorithmTester{

    Stack<String> readStack;
    String line;
    ArrayList<String> fileContent;
    String keyWord = "for(){", file;

    int logN=0, oN=0, oN2=0, oN3=0;

    public AlgorithmTester(String file) throws IOException {
        this.file= file;
    }

    //parse file
    public void readFile() throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(file));
        String line; 

        fileContent = new ArrayList<>();
        readStack = new Stack<>();

        String[] splitFile;

        while ((line=input.readLine())!=null ) {
            line = input.readLine().trim();
            fileContent.add(line.trim());
        }

        for (int i = 0; i < fileContent.size(); i++) {
            readStack.push(fileContent.get(i));
        }
    }
    
    //checks for O(log n)
    public void checkForLogN() {
        while (!readStack.isEmpty()) {
            if (readStack.pop().equals("}")) {
                if (readStack.pop().equals("while(){")) {
                    System.out.println("O(log n)");
                    logN++;
                }
            } else {
                System.out.println("Not O(log n)");
            }
        }
    }

    //checks for O(n)
    public void checkForON() {
        while (!readStack.isEmpty()) {
            if (readStack.pop().equals("}")) {
                if (readStack.pop().equals(keyWord)) {
                    System.out.println("O(n)");
                    oN++;
                }
            } else {
                System.out.println("Not O(n)");
            }
        }
    }

    //checks for O(n^2)
    public void checkForONP2() {
        while (!readStack.isEmpty()) {
            if (readStack.pop().equals("}")) {
                if (readStack.pop().equals("}")) {
                    if (readStack.pop().equals(keyWord)) {
                        System.out.println("O(n^2)");
                        oN2++;
                    }
                } else {
                    System.out.println("Not O(n^2)");
                }
            }
        }
    }

    //checks for O(n^3)
    public void checkForONP3() {
        while (!readStack.isEmpty()) {
            if (readStack.pop().equals("}")) {
                if (readStack.pop().equals("}")) {
                    if (readStack.pop().equals("}")) {
                        if (readStack.pop().equals(keyWord)) {
                            System.out.println("O(n^3)");
                            oN3++;
                        }
                    } else {
                        System.out.println("not O(n^3)");
                    }
                }
            }
        }
    }
    
    public void checkTime(long maxIt, long minIt){
        // borrowed code from ProcessEval.java
        long MAX_ITERATIONS = maxIt;
        int MIN_ITERATIONS = (int)minIt;
        int step = 100;

        // not finished. Need to replace processA(n) with a new method that rebuilds
        // parsed method(s)
        for(long n = MIN_ITERATIONS; n <= MAX_ITERATIONS; n += step) {

            Date time_start = new Date();       // start timer 
            long Aresult = 0;//processA(n);
            Date time_end = new Date();         // stop timer 
            long Atime = (time_end.getTime() - time_start.getTime()) / 1000; 
        }

        //return Atime;
    }
}
