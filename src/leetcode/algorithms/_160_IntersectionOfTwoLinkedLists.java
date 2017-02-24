package leetcode.algorithms;

import org.junit.Test;

public class _160_IntersectionOfTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        while( a != b ) {
            if(a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if(b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        
        return a;
    }
    
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//        int lenA = 0;
//        int lenB = 0;
//
//        ListNode a = headA;
//        while (a != null) {
//            a = a.next;
//            lenA++;
//        }
//        ListNode b = headB;
//        while (b != null) {
//            b = b.next;
//            lenB++;
//        }
//
//        a = headA;
//        b = headB;
//        while (lenA > lenB && a != null) {
//            a = a.next;
//            lenA--;
//        }
//        while (lenB > lenA && b != null) {
//            b = b.next;
//            lenB--;
//        }
//        
//        while(a != null && b != null && a != b) {
//            a = a.next;
//            b = b.next;
//        }
//
//        return a;
//    }

    @Test
    public void test() {
        
        ListNode n = new ListNode(4);
        n.next = new ListNode(5);
        
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = n;

        ListNode n2 = new ListNode(2);
        n2.next = new ListNode(3);
        n2.next.next = n;
        
        ListNode res = getIntersectionNode(n1, n2);
        System.out.println(res.val);

    }
}
