//Project 2
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader inFile = new FileReader(args[0]);
        FileWriter outFile1 = new FileWriter(args[1]);
        FileWriter outFile2 = new FileWriter(args[2]);
        
        LinkedList listH = new LinkedList();
        listH.constructLL(listH.getListHead(), inFile, outFile2);
        outFile1.write("Orginal sorted list:\n");
        listH.printList(listH.getListHead(), outFile1);
        
        listH.reverseLL(listH.getListHead(), outFile2);
        outFile1.write("\nReversed sorted list:\n");
        listH.printList(listH.getListHead(), outFile1);
        
        inFile.close();
        outFile1.close();
        outFile2.close();
        
    }
}
class ListNode{
    private String data;
    private ListNode next;
    
    public ListNode() {
        this.data = "dummy";
        this.next = null;
    }
    public ListNode(String d, ListNode n) {
        this.data = d;
        this.next = n;
    }
    public String getData() {
        return data;
    }
    public ListNode getNext() {
        return next;
    }
    public void setData(String d) {
        data = d;
    }
    public void setNext(ListNode n) {
        next = n;
    }
    /*public void printNode(ListNode middleNode, FileWriter outFile1) throws IOException {
        if (middleNode.getNext() != null){
            outFile1.write("The middle node is: (" + middleNode.getData() + "," + middleNode + "," 
                        + middleNode.getNext() + "," + middleNode.getNext().getData() + ")");
        } else {
            outFile1.write( "-->NULL");
        }

    }*/
    
}
class LinkedList {
    private ListNode listHead;
    
    public LinkedList() {
        listHead = new ListNode();
    }
    public ListNode getListHead() {
        return listHead;
    }
    public void setListHead(ListNode LHead) {
        listHead = LHead;
    }
    public void constructLL(ListNode LHead, FileReader inFile, FileWriter outFile2) throws IOException {
        LHead.setNext(new ListNode());
        Scanner scan = new Scanner(inFile);
        outFile2.write("Debugging from constructLL method:\n");
        while (scan.hasNext()) {
            ListNode newNode = new ListNode(scan.next(), null);
            listInsert(LHead.getNext(), newNode);
            
            printList(LHead, outFile2);
            outFile2.write("\n");
        }
        LHead.setNext(LHead.getNext().getNext());
    }
    public void listInsert(ListNode LHead, ListNode newNode) {
        ListNode spot = findSpot(LHead, newNode);
        newNode.setNext(spot.getNext());
        spot.setNext(newNode);
    }
    public ListNode findSpot(ListNode LHead, ListNode newNode) {
        ListNode spot = LHead;
        while (spot.getNext() != null && spot.getNext().getData().compareTo(newNode.getData()) < 0) {
            spot = spot.getNext();
        }
        return spot;
    }
    /*public ListNode findMiddleNode(ListNode LHead, FileWriter outFile2) throws IOException {
        ListNode walk1 = LHead;
        ListNode walk2 = LHead;
        this.listHead.printNode(walk1, outFile2);
        while (walk2 != null && walk2.getNext() != null){
            walk1 = walk1.getNext();
            walk2 = walk2.getNext().getNext();
        }
        return walk1;
    }*/
    public void reverseLL(ListNode LHead, FileWriter outFile2) throws IOException {
        ListNode last = LHead.getNext();
        outFile2.write("Debugging from reverseLL method:\n");
        while (last.getNext() != null) {
            moveSpotNodeToFront(LHead, last);
            
            printList(LHead, outFile2);
            outFile2.write("\n");
        }
    }
    public void moveSpotNodeToFront(ListNode LHead, ListNode last) {
        ListNode spot = last.getNext();
        last.setNext(spot.getNext());
        spot.setNext(LHead.getNext());
        LHead.setNext(spot);
    }
    public void printList(ListNode LHead, FileWriter outFile) throws IOException {
        outFile.write("listHead");
        ListNode temp = LHead;
        while (temp.getNext() != null) {
            outFile.write("-->(" + temp.getData() + ", " + temp + ", " + temp.getNext() + ", " + temp.getNext().getData() + ")");
            temp = temp.getNext();
        }
        outFile.write("-->(" + temp.getData() + "," + temp + ", " + temp.getNext() + ", " + "NULL)-->NULL");
    }
}
