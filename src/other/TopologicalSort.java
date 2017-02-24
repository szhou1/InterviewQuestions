package other;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TopologicalSort<T> {
    
    public Deque<Vertex<T>> sort(Graph<T> g) {
        
        Set<Vertex<T>> visited = new HashSet<>();
        Deque<Vertex<T>> stack = new ArrayDeque<>();
        
        for(Vertex<T> v : g.getAllVertex()) {
            if(visited.contains(v)) {
                continue;
            }
            topSortHelper(v, stack, visited);
        }
        return stack;
        
    }
    
    private void topSortHelper(Vertex<T> v, Deque<Vertex<T>> stack, Set<Vertex<T>> visited) {
        visited.add(v);
        for(Vertex<T> c : v.getAdjacentVertexes()) {
            if(visited.contains(v)) {
                continue;
            }
            topSortHelper(c, stack, visited);
        }
        stack.offerFirst(v);
    }

    public static void main(String [] args) {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);
        
        TopologicalSort<Integer> sort = new TopologicalSort<Integer>();
        Deque<Vertex<Integer>> result = sort.sort(graph);
        while(!result.isEmpty()){
            System.out.println(result.poll());
        }
    }

    
}
