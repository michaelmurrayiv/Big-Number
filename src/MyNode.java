import java.util.Objects;

public class MyNode {
    private int val;
    private MyNode next;

    public MyNode(int val){
        this.val = val;
        this.next = null;
    }
    public MyNode(int val, MyNode next){
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode newNode) {
        this.next = newNode;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        MyNode n = (MyNode) o;
        if (hashCode() != ((MyNode) o).hashCode()) return false;
        if (this.next == null && n.next == null) return true;
        return (val == n.val) && this.next.equals(n.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
