
import java.lang.Character;
import java.util.ArrayList;
import java.util.Objects;

public class MyLinkedList {
    private MyNode head;
    private int size;

    public MyLinkedList(){
        this.size = 0;
        this.head = null;
    }

    public MyLinkedList(MyNode node){
        this.head = node;
        int c = 0;
        MyNode curr = head;
        while (curr != null) {
            c++;
            curr = curr.getNext();
        }
        this.size = c;
    }
    public MyLinkedList(String num){
        this.size = num.length();
        int firstInt = Character.getNumericValue(num.charAt((num.length()-1))); // gets the last char in num and turns it into an int
        MyNode curr = new MyNode(firstInt);
        if (num.length() == 1){
            head = curr;
        }
        else{
        head = curr;
        for (int i = num.length()-2; i >= 0; i--){
            curr.setNext(new MyNode(Character.getNumericValue(num.charAt((i)))));
            curr = curr.getNext();
            }

        }
    }

    public MyNode getHead() {
        return head;
    }

    @Override
    public boolean equals(Object o) {
        if (o==null) return false;
        if (o.getClass() != this.getClass()) return false;
        if (this.size != ((MyLinkedList) o).size) return false;
        if (hashCode() != ((MyLinkedList) o).hashCode()) return false;
        return (this.head.equals(((MyLinkedList) o).head));
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }

    public void addNode(int value){
        if (head == null){
            head = new MyNode(value);
        }else{
        MyNode curr = head;
        int i = 0;
        while (i < this.size-1){
            curr = curr.getNext();
            i++;
        }
        curr.setNext(new MyNode(value));
        }
        size++;
    }
    public ArrayList<Integer> getList() {
        ArrayList<Integer> myLinkedList = new ArrayList<>();
        MyNode realHead = head;
        while (head != null) {
            myLinkedList.add(head.getVal());
            head = head.getNext();
        }
        head = realHead;
        return myLinkedList;
    }
    public int getSize(){
        return size;
    }

    public String linkedListToString() { // change a linked list into the string of the corresponding number

        int ctdown = getSize()-1;
        String res = "";

        while (ctdown>=0) {
            String biggestDigit = getList().get(ctdown).toString();
            if (ctdown == 0) {
                res = res + biggestDigit;

            } else{
                if (!(res.equals("") && biggestDigit.equals("0"))) {
                    res = res + biggestDigit;
                }
            }
            ctdown--;
        }
        return res;
    }
}
