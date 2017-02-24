package ctci.ch2_linkedlists;

import java.util.HashSet;

import org.junit.Test;

public class RemoveDups {

    private class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    
    public void removeDuplicates(Node n) {
        HashSet<Integer> map = new HashSet<Integer>();
        
        Node previous = n;
        while(n != null) {
            if(map.contains(n.val)) {
                previous.next = n.next;
            } else {
                map.add(n.val);
            }
            previous = n;
            n = n.next;
        }
    }
    
    public void printLinkedList(Node n) {
        while(n != null) {
            System.out.print(n.val + " -> " );
            n = n.next;
        }
        System.out.print("null");
        System.out.println();
    }
    
    @Test
    public void test() {
        
        int [] arr = new int []{3, 2, 4, 5, 2};
        
        Node n = new Node(arr[0]);
        Node head = n;
        for(int i = 1; i < arr.length; i++) {
            n.next = new Node(arr[i]);
            n = n.next;
        }
        
        printLinkedList(head);
        
        removeDuplicates(head);
        
        printLinkedList(head);
        
        
        
    }
}
