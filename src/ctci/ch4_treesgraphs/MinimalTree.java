package ctci.ch4_treesgraphs;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class MinimalTree {

    private class Node {
        int data;
        Node left;
        Node right;
        public Node (int data) {
            this.data = data;
        }
    }
    
    private Node createTreeHelper(int [] arr, int low, int high) {
        if(high < low) return null;
        
        int mid = (high + low) / 2;
        System.out.println(high + " " + low);
        System.out.println(mid);
        Node n = new Node(arr[mid]);
        n.left = createTreeHelper(arr, low, mid-1);
        n.right = createTreeHelper(arr, mid+1, high);
        
        return n;
        
    }
    
    private Node createTree(int[] arr) {
        Node n = createTreeHelper(arr, 0, arr.length-1);
        return n;
    }
    
    
    @Test
    public void test() {
        int [] arr = new int []{1, 2, 3, 4, 5, 6};
        
        Node root = createTree(arr);
        
        System.out.println(root.data);
        Queue<Integer> q = new LinkedList<Integer>();
        
    }

}
