package leetcode.algorithms;

import org.junit.Test;

public class _002_AddTwoNumbers {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode (int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result = null;
        ListNode head = null;

        boolean hasCarry = false;
        
        while(l1 != null || l2 != null || hasCarry){
            int sum = hasCarry ? 1 : 0;
            
            if(l1 != null) {
                sum += l1.val;
            }
            if(l2 != null) {
                sum += l2.val;
            }
//            System.out.println("sum: " + sum);
            ListNode n = null;
            if(sum > 9) {
                n = new ListNode(sum % 10);
                hasCarry = true;
            } else {
                n = new ListNode(sum);
                hasCarry = false;
            }
            if(result == null) {
                result = n;
                head = n;
            } else {
                head.next = n;
                head = head.next;
            }
//            System.out.println("result: " + result.val);
//            System.out.println("head: " + head.val);
            l1 = (l1 == null || l1.next == null) ? null : l1.next;
            l2 = (l2 == null || l2.next == null) ? null : l2.next;
        }
        
        return result;
    }
    
    @Test
    public void test(){
        
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        _002_AddTwoNumbers p = new _002_AddTwoNumbers();
        ListNode n = p.addTwoNumbers(l1, l2);
        
        while(n!=null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }
    
    @Test
    public void test1(){
        
        ListNode l1 = new ListNode(5);
        
        ListNode l2 = new ListNode(5);

        _002_AddTwoNumbers p = new _002_AddTwoNumbers();
        ListNode n = p.addTwoNumbers(l1, l2);
        
        while(n!=null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();

    }
}
