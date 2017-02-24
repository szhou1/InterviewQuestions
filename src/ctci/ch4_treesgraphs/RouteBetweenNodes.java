package ctci.ch4_treesgraphs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

public class RouteBetweenNodes {
    
    enum State {
        UNVISITED,
        VISITED
    }
    
    private class Node {
        int data;
        State state;
        ArrayList<Node> children;
        public Node(int data){
            this.data = data;
            this.state = State.UNVISITED;
            this.children = new ArrayList<Node>();
        }
    }
    
    public boolean routeExists(Node a, Node b) {
        
        LinkedList<Node> q = new LinkedList<Node>();
        
        a.state = State.VISITED;
        q.add(a);

        while(q.isEmpty() == false) {
            Node u = q.removeFirst();
            for(Node c : u.children) {
                if(c.state == State.UNVISITED){
                    System.out.println(c.data);
                    if(c == b) {
                        return true;
                    }
                    c.state = State.VISITED;
                    q.add(c);
                }
            }
        }
        
        return false;
    }
    
    @Test
    public void test() {
        ArrayList<Node> g = getNewGraph();
        assertTrue(routeExists(g.get(0), g.get(2)));
        g = getNewGraph();
        assertTrue(routeExists(g.get(0), g.get(1)));
        g = getNewGraph();
        assertTrue(routeExists(g.get(0), g.get(2)));
        g = getNewGraph();
        assertFalse(routeExists(g.get(0), g.get(4)));
        g = getNewGraph();
        assertTrue(routeExists(g.get(4), g.get(0)));
    }
    
    private ArrayList<Node> getNewGraph() {
        Integer [][] m = new Integer [][]{
            {0, 1, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0},
            {0, 0, 1, 0, 0}
        };
        
        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(new Node(0));
        nodes.add(new Node(1));
        nodes.add(new Node(2));
        nodes.add(new Node(3));
        nodes.add(new Node(4));
        
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[0].length; j++) {
                if(m[i][j] == 1) {
                    nodes.get(i).children.add(nodes.get(j));
                }
            }
        }
        return nodes;
    }
    
    
}
