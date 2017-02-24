package other;

public class Dijkstras {
    
    private int V;
    private int [][] graph;
    private int src;
    
    public Dijkstras(int [][] graph, int src) {
        this.V = graph.length;
        this.graph = graph;
        this.src = src;
    }
    
    public void shortestPath() {
        int dist [] = new int[V];
        
        Boolean visited[] = new Boolean[V];
        
        for(int i=0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        
        dist[src] = 0;
        
        for(int count = 0; count < V-1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;
            
            for(int v = 0; v < V; v++) {
                if(visited[v] == false 
                        && graph[u][v] > 0 
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        
        for(int i = 0; i < V; i++) {
            System.out.println(dist[i]);
        }
        
        
    }
    
    
    private int minDistance(int[] dist, Boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for(int v = 0; v < V; v++) {
            if(visited[v]==false && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void main (String[] args)
    {
        /* Let us create the example graph discussed above */
       int graph[][] = new int[][]{   {0, 4, 0, 0, 0, 0, 0, 8, 0},
                                      {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                      {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                      {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                      {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                      {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                      {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                      {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                      {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                 };
        Dijkstras t = new Dijkstras(graph, 0);
        t.shortestPath();
    }

}
