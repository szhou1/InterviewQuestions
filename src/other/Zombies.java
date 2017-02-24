package other;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Zombies {
    
    static class UnionFind {

        int [] arr;
        int [] size;

        public UnionFind(int N) {
            arr = new int [N];
            size = new int [N];
            for(int i = 0; i < N; i++) {
                arr[i] = i;
                size[i] = 1;
            }
        }

        public int root(int i) {
            while(arr[i] != i) {
                i = arr[i];
            }
            return i;
        }

        public boolean connected(int p, int q) {
            return root(p) == root(q);
        }

        public void union(int p, int q) {
            int rootP = root(p);
            int rootQ = root(q);

            if(rootP == rootQ) return;

            if(size[rootP] < size[rootQ]) {
                arr[rootP] = rootQ;
                size[q] += size[p];
            } else {
                arr[rootQ] = rootP;
                size[p] += size[q];
            }
        }
        public int [] getParents() {
            return arr;
        }
        public int [] getSizes() {
            return size;
        }
    }

    static int countIslands(int [][] arr) {
//        boolean visited [][] = new boolean [arr.length][arr.length];
        UnionFind uf = new UnionFind(arr.length);
        
        int count = 0;
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(arr[i][j] == 1) {
                    uf.union(i, j);                    
                }
            }
        }
        
        int [] parents = uf.getParents();
        int [] sizes = uf.getSizes();
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i < parents.length; i++) {
            System.out.println(parents[i] + " " + sizes[i]);
            set.add(parents[i]);
        }
                
        
        return set.size();
    }


    private static boolean isValid(int[][] arr, int row, int col, boolean[][] visited) {
        
        return (row >= 0) && (row < arr.length) &&
                (col >= 0) && (col < arr.length) &&
                (arr[row][col]==1 && !visited[row][col]);
    }

    static int zombieCluster(String[] zombies) {
        
        int [][] arr = new int [zombies.length][zombies.length];
        
        for(int i = 0; i < zombies.length; i++) {
            String[] z = zombies[i].split("");
            for(int j = 1; j < z.length; j++) {
                arr[i][j-1] = Integer.parseInt(z[j]);
            }
        }
//        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
//            {0, 1, 0, 0, 1},
//            {1, 0, 0, 1, 1},
//            {0, 0, 0, 0, 0},
//            {1, 0, 1, 0, 1}};
        
        return countIslands(arr);
    }
    
    public static void main(String[] args) throws IOException{

//        String [] zombies = new String [] {"1100", "1110", "0110", "0001"};
        String [] zombies = new String [] {"10101", "10000", "10101", "10000", "10101"};
//        String [] zombies2 = new String [] {"10000", "01000", "00100", "00010", "00001"};
        
        
        int c = zombieCluster(zombies);
        System.out.println(c);
    }
    
}
