import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a description of class AlgorithmTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

//Algorithm tester class
public class AlgorithmTester {

    public AlgorithmTester() throws IOException {

    }
    
    public void run(){
        try{
            readFile("PredictRunTime.java");
            checkAll();
            System.out.println(checkBigO());
        }catch(IOException e){
        }
    }

    Stack<String> readStack;
    String line;
    ArrayList<String> fileContent;
    String keyWord = "for(){";
    int logn = 0, nCubed = 0, nSquared = 0, ones = 0;

    //reading the file and pushing it into a stack
    public void readFile(String file) throws IOException {
        Scanner scanFile = new Scanner(Paths.get(file));
        fileContent = new ArrayList<>();
        readStack = new Stack<>();

        String[] splitCode;

        while (scanFile.hasNext()) {
            line = scanFile.nextLine().trim();
            fileContent.add(line.trim());
        }

        System.out.println(fileContent);
        for (int i = 0; i < fileContent.size(); i++) {
            readStack.push(fileContent.get(i));
        }

    }
    
    public void checkAll(){
        checkForLogN();
        checkForNSquared();
        checkForNCubed();
        checkOne();
    }

    //checking for logn
    public void checkForLogN() {

        while (!readStack.isEmpty()) {
            if (readStack.pop().equals("}")) {
                if (readStack.pop().equals("while(){")) {
                    System.out.println("This File is log n");
                    logn++;
                } //end checking for log n
            } else {
                System.out.println("This file is not log n");
                System.exit(0);
            }
        }
    }

    //checking for N^2
    public void checkForNSquared() {
        while (!readStack.isEmpty()) {
            if (readStack.pop().equals("}")) {
                if (readStack.pop().equals("}")) {
                    if (readStack.pop().equals(keyWord)) {
                        System.out.println("This File is N^2");
                        nSquared++;
                    }

                } else {
                    System.out.println("This file is not N^2");
                    System.exit(0);
                }
            }

        }

        
    }

    //checking for N^3
    public void checkForNCubed() {
        while (!readStack.isEmpty()) {
            if (readStack.pop().equals("}")) {
                if (readStack.pop().equals("}")) {
                    if (readStack.pop().equals("}")) {
                        if (readStack.pop().equals(keyWord)) {
                            System.out.println("This File is N^3");
                            nCubed++;
                        }
                    } else {
                        System.out.println("This file is not N^3");
                        System.exit(0);
                    }
                }
            }

        }

        
    }

    //this method is checking for O1
    public void checkOne() {
        
        while (!readStack.isEmpty()) {
            //finding the first }
            if (readStack.pop().equals("}")) {
                //if the next pop is the keyword of for(){
                if (readStack.pop().equals(keyWord)) {
                    System.out.println("This File is O1");
                    ones++;
                } //end checking for n1
            } else {
                System.out.println("This file is not O1");
                System.exit(0);
            }
        }
        
    }
    
    public double checkBigO(){
        int tempOnes = ones;
        int tempLog = logn;
        int tempSquared = nSquared;
        int tempCubed = nCubed;
        double sum = 0;
        PredictRunTime runTime = new PredictRunTime();
        
        while(tempLog > 0){
            sum += runTime.getLog();
            tempLog--;
        }
        
        while(tempCubed > 0){
            sum += runTime.getNcubed();
            tempCubed--;
        }
        
        while(tempSquared > 0){
            sum += runTime.getNsquared();
            tempSquared--;
        }
        
        while(tempOnes > 0){
            sum += 1;
            tempOnes--;
        }
        
        return sum;
    }
}
