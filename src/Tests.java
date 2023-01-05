import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test
    public void testNode() {
        MyNode n = new MyNode(5, new MyNode(6));

        assertEquals(n.getVal(), 5);
        assertEquals(n.getNext().getVal(), 6);
        assertNull(n.getNext().getNext());

        MyNode n2 = new MyNode(9);
        assertEquals(n2.getVal(), 9);
        assertNull(n2.getNext());
        assertEquals(n2, new MyNode(9));
    }

    @Test
    public void testMyLinkedList() {
        MyLinkedList m = new MyLinkedList(new MyNode(5, new MyNode(6)));

        assertEquals(m.getHead().getVal(), 5);
        assertEquals(m.getHead().getNext().getVal(), 6);
        assertNull(m.getHead().getNext().getNext());

        MyLinkedList m2 = new MyLinkedList("65");
        assertEquals(m2.getHead().getVal(), 5);
        assertEquals(m2.getHead().getNext().getVal(), 6);
        assertNull(m2.getHead().getNext().getNext());
        assertEquals(m2, m);
    }

    @Test
    public void testAddNode() {
        MyLinkedList m = new MyLinkedList(new MyNode(5, new MyNode(6)));
        m.addNode(7);
        assertEquals(m, new MyLinkedList("765"));
        m.addNode(5);
        assertEquals(m, new MyLinkedList("5765"));
        MyLinkedList m2 = new MyLinkedList();
        m2.addNode(7);
        m2.addNode(7);
        assertEquals(m2, new MyLinkedList("77"));
    }

    @Test
    public void testGetList() {
        MyLinkedList m = new MyLinkedList(new MyNode(5, new MyNode(6)));
        m.addNode(7);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        assertEquals(m.getList(), list);

    }

    @Test
    public void testAddNums() {
        assertEquals(Calculations.addNums("1234", "1111"), "2345");
        assertEquals(Calculations.addNums("999", "1"), "1000");
        assertEquals(Calculations.addNums("768967", "86597"), "855564");
        assertEquals(Calculations.addNums("1234", "0"), "1234");
        assertEquals(Calculations.addNums("1234", "8767"), "10001");
        assertEquals(Calculations.addNums("1", "123456789"), "123456790");
        assertEquals(Calculations.addNums("1", "0000001"), "2"); // get rid of leading zeros
        assertEquals(Calculations.addNums("000097", "9003"), "9100");
        assertNotEquals(Calculations.addNums("1", "00001"), "00002");
        assertEquals(Calculations.addNums("0", "0"), "0");
        assertEquals(Calculations.addNums("00", "0000"), "0"); // get rid of leading zeros
        assertEquals(Calculations.addNums("0", "01"), "1");
        assertEquals(Calculations.addNums("66", "999"), "1065"); // cascading carry over
        assertEquals(Calculations.addNums("6", "99"), "105");
        assertEquals(Calculations.addNums("1234567890", "987654321"), "2222222211");
        assertEquals(Calculations.addNums("0", "1"), "1");
        assertEquals(Calculations.addNums("1", "00"), "1");
        assertEquals(Calculations.addNums("9", "9"), "18");
        assertEquals(Calculations.addNums("1", "1"), "2");
        assertEquals(Calculations.addNums("1", "2"), "3");
        assertEquals(Calculations.addNums("001", "000"), "1");
        assertEquals(Calculations.addNums("1", "0099"), "100");
        assertEquals(Calculations.addNums("0012", "099"), "111");
        assertEquals(Calculations.addNums("0", "000000"), "0");
        assertEquals(Calculations.addNums("9", "99"), "108"); // carry over where result is larger than inputs
        assertEquals(Calculations.addNums("9", "999"), "1008");
        assertEquals(Calculations.addNums("2", "8"), "10");

    }
    @Test
    // searching for border addition cases I missed that aren't passing the autograder
    public void testAdd() {
        assertEquals(Calculations.addNums("0", "0"),"0");
        assertEquals(Calculations.addNums("0", "0001"),"1");
        assertEquals(Calculations.addNums("0001", "0"),"1");
        assertEquals(Calculations.addNums("1", "0"),"1");
        assertEquals(Calculations.addNums("0", "1"),"1");
        assertEquals(Calculations.addNums("099", "0"),"99");
        assertEquals(Calculations.addNums("0", "099"),"99");
        assertEquals(Calculations.addNums("888", "99999"),"100887");
        assertEquals(Calculations.addNums("99999", "888"),"100887");
        assertEquals(Calculations.addNums("888", "0099"),"987");
        assertEquals(Calculations.addNums("0099", "888"),"987");
        assertEquals(Calculations.addNums("111", "2222"),"2333");
        assertEquals(Calculations.addNums("2222", "111"),"2333");
        assertEquals(Calculations.addNums("111", "0022"),"133");
        assertEquals(Calculations.addNums("0022", "111"),"133");
        assertEquals(Calculations.addNums("888", "888"),"1776");
        assertEquals(Calculations.addNums("111", "111"),"222");
        assertEquals(Calculations.addNums("0888", "0888"),"1776");
        assertEquals(Calculations.addNums("0111", "0111"),"222");
        assertEquals(Calculations.addNums("99999", "99999"),"199998");
        assertEquals(Calculations.addNums("9999999999999999999999999", "9999999999999999999999999"),"19999999999999999999999998");

        }

    @Test
    public void testMultNums() {
        assertEquals(Calculations.multNums("190", "9"), "1710");
        assertEquals(Calculations.multNums("456", "361"), "164616");
        assertEquals(Calculations.multNums("190", "0"), "0");
        assertEquals(Calculations.multNums("0003", "00005"), "15");
        assertEquals(Calculations.multNums("190023512324", "3"), "570070536972");
        assertEquals(Calculations.multNums("00001", "3"), "3");
        assertEquals(Calculations.multNums("999", "999"), "998001");
        assertEquals(Calculations.multNums("111111111", "122333444455555"), "13592604925913506171605");

    }

    @Test
    public void testExpNums() {
        assertEquals(Calculations.expNums("10", "50"), "100000000000000000000000000000000000000000000000000");
        assertEquals(Calculations.expNums("0", "50"), "0");
        assertEquals(Calculations.expNums("10", "0"), "1");
        assertEquals(Calculations.expNums("10", "1"), "10");
        assertEquals(Calculations.expNums("2", "16"), "65536");
        assertEquals(Calculations.expNums("2", "17"), "131072");

    }

}


/**
 Don't use these tests anymore because the functions are now private
 ____________________________________________________________________

    @Test
    public void testCheckIfZero() {
        assertTrue(Calculations.checkIfZero("0000000000000"));
        assertTrue(Calculations.checkIfZero("000"));
        assertTrue(Calculations.checkIfZero("0"));
        assertFalse(Calculations.checkIfZero("0000000000001"));
        assertFalse(Calculations.checkIfZero("12334"));
        assertFalse(Calculations.checkIfZero("0000010000200000"));
        assertFalse(Calculations.checkIfZero("10000"));
        assertFalse(Calculations.checkIfZero("010"));
        assertFalse(Calculations.checkIfZero("000131"));
    }


    @Test
    public void testProcessLine() {
        String s = "    134556        *    14512    ";
        System.out.println(FileProcessor.processLine(s));
    }
 ____________________________________________________________________
 **/

