import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String myLine = processLine(line);
                if (!(myLine.charAt(0) == ' ')){
                    System.out.println(myLine);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }

    /** This function processes a String, reformatting it correctly and isolating the input parameters for the Calculations **/
    private static String processLine(String line){
        String currStr = "";
        String num1 = "";
        String num2;
        String op = "";
        String res;

        for (int i = 0; i < line.length(); i++){
            if (line.charAt(i) == ' '){

            } else if (line.charAt(i) == '+') {
                num1 = currStr;
                op = "+";
                currStr = "";
            } else if (line.charAt(i) == '*') {
                num1 = currStr;
                op = "*";
                currStr = "";
            } else if (line.charAt(i) == '^') {
                num1 = currStr;
                op = "^";
                currStr = "";
            } else {
                currStr = currStr + line.charAt(i);
            }
        }
        num2 = currStr;

        String opResult = "";
        if (op.equals("+")){
            opResult = Calculations.addNums(num1,num2);
        }else if (op.equals("*"))
            opResult = Calculations.multNums(num1,num2);
        else{
            opResult = Calculations.expNums(num1, num2);
        }
        if (!(num1.equals("") && num2.equals(""))){
            num1 = Calculations.addNums(num1, "0");
            num2 = Calculations.addNums(num2, "0");}

        res = num1 + " " + op + " " + num2 + " = " + opResult;
        return res;
    }
}
