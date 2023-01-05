import java.util.Objects;

public class Calculations {

    private static boolean checkIfZero(String num){ //returns true if the string is 0, false otherwise
        for (int i = 0; i < num.length(); i++){
            if (num.charAt(i) != '0'){
                return false;
            }
        }
        return true;
    }
    public static String addNums(String num1, String num2){ // returns a string with the value of the addition operation
        if (checkIfZero(num1)){
            if (!checkIfZero(num2)) {
                MyLinkedList ll2 = new MyLinkedList(num2); // linkedListToString method removes leading zeros
                num2 = ll2.linkedListToString();
                return num2;
            } else {
                return "0";
            }

        }
        if (checkIfZero(num2)){
            MyLinkedList ll1 = new MyLinkedList(num1);
            num1 = ll1.linkedListToString();
            return num1;
        }
        MyNode n1 = new MyLinkedList(num1).getHead();
        MyNode n2 = new MyLinkedList(num2).getHead();
        MyLinkedList sumList = new MyLinkedList();
        int carry = 0;
        while (n1 != null || n2 != null) { // while loop continues until both n1 and n2 have been fully used
            if (n1 == null) {
                 int sum = n2.getVal() + carry;
                 carry = 0;
                 while (sum >= 10){ // while loop calculates carry value and what the new node should hold (sum)
                     sum = sum - 10;
                     carry ++;}
                 sumList.addNode(sum);
                 n2 = n2.getNext();

            }else if (n2 == null) {
                int sum = n1.getVal() + carry;
                carry = 0;
                while (sum >= 10){ // while loop calculates carry value and what the new node should hold (sum)
                    sum = sum - 10;
                    carry ++;}
                sumList.addNode(sum);
                n1 = n1.getNext();

            }else{
                int sum = n1.getVal() + n2.getVal() + carry;
                carry = 0;
                while (sum >= 10){ // while loop calculates carry value and what the new node should hold (sum)
                    sum = sum - 10;
                    carry ++;}
                sumList.addNode(sum);
                n1 = n1.getNext();
                n2 = n2.getNext();
            }
        }
        if (carry != 0) {
            sumList.addNode(carry);
        }
        String res;

        res = String.valueOf(sumList.linkedListToString());

        return res;
    }

    public static String multNums(String num1, String num2) {
        MyNode n1 = new MyLinkedList(num1).getHead();
        MyNode n2 = new MyLinkedList(num2).getHead();
        MyNode n2Head = n2;
        String res = "";
        int newVal;
        String newStr;
        int carry = 0;
        String carryStr;
        int i;
        int j;
        for (i = 0; i < num1.length(); i++) {
            for (j = 0; j < num2.length(); j++) {

                newVal = n1.getVal() * n2.getVal();
                while (newVal >= 10) {
                    newVal -= 10;
                    carry ++;
                }

                carryStr = Integer.toString(carry);
             //   System.out.println(carryStr);

                if (!carryStr.equals("0")) {
                carryStr = carryStr + "0";}


                newStr = Integer.toString(newVal);

                newStr = addNums(carryStr, newStr);

                String trailingZeros = "";
                for (int k = 0;k < (i+j); k++){
                    trailingZeros = trailingZeros + "0";
                }

                newStr = newStr + trailingZeros; // string is the result of the multiplication of two digits and the 0's

                res = addNums(res,newStr);

                carry = 0;
                n2 = n2.getNext();
            }
            n2 = n2Head;
            n1 = n1.getNext();
        }

        return res;
    }

    public static String expNums(String num1, String num2) {
        num1 = addNums(num1, "0");
        num2 = addNums(num2, "0");
        if (num2.equals("0")) {
            return "1";
        }
        if (num2.equals("1")) {
            return num1;
        }
        if (num1.equals("0")) {
            return "0";
        }
        int n = Integer.parseInt(num2);
        return exponentiationBySquaring(num1, n);


    }

    private static String exponentiationBySquaring(String x, int n) {
        if (n == 1) {
            return x;
        }

        if (n % 2 == 1){ // if n is odd
            return multNums(x, exponentiationBySquaring(multNums(x,x),(n-1)/2));
        } else { // if n is even
            return exponentiationBySquaring(multNums(x,x), n/2);
        }
    }
}
