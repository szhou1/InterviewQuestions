package other;

import java.util.ArrayList;

public class RotateMatrix {

    public void rotate(ArrayList<ArrayList<Integer>> a) {

        if(a.size() <= 1) {
            return;
        }
        
        
        for(int r = 0, c = a.size() - 1; r < c; r++, c--) {
            int N = c - r;
            System.out.println("r:" + r + " c:" + c + " N:" + N);
            
            ArrayList<Integer> top = new ArrayList<Integer>(a.get(r).subList(r, c));
            print(top);
            // replace top with left
            int i = r, j = c;
            int count = r;
            while(j > i) {
                System.out.println(i + ", " + count + " <= " + j + ", " + i);
//              a.get(i).set(N - j, a.get(j).get(i));
              a.get(i).set(count, a.get(j).get(i));
                j--;
                count++;
            }
            
            //replace left with bottom
            i = r; j = c;
            while(j > 0) {
                a.get(j).set(i, a.get(N).get(j));
                j--;
            }
            
            // replace bottom with right
            j = c;
            count = c;
            while(j > 0) {
                System.out.println(r + ", " + j + " <= " + count + ", " + count);
//              a.get(N).set(j, a.get(count).get(N));
              a.get(N).set(j, a.get(count).get(count));
                j--;
            }
            
            // replace right with cached top
            j = 0;
            while(j < top.size()) {
                a.get(j).set(N, top.get(j));
                j++;
            }
            
            
            printMatrix(a);
//            break;
        }
        
        
    }
    
    public void print(ArrayList<Integer> a) {
        System.out.println("************ PRINT ROW ************");
        for(Integer i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void printMatrix(ArrayList<ArrayList<Integer>> arr) {
        System.out.println("*****************PRINT MATRIX ************************");
        
        for(ArrayList<Integer> a : arr) {
            for(Integer i : a) {
                System.out.print(i + " ");                
            }
            System.out.println();
        }
    }
    
    public void rotateSolution(ArrayList<ArrayList<Integer>> A) {
        int n;
        
        if (A == null)
            return;
        
        n = A.size();
        
        if (n == 0)
            return;
        
        int layers = n;
//        int row1, col1, row2, col2;
//        int num;
//        int temp;
        int first, last;
        
        for (int layer = 0; layer < layers / 2; layer++) {
            
            first = layer;
            last = n - layer - 1;
//            System.out.println(first + " " + last);
            
            for (int i = first; i < last; i++) {
                
                int offset = i - layer;
                
                int top = A.get(first).get(i);
                
                A.get(first).set(i, A.get(last - offset).get(first));
                
                A.get(last - offset).set(first, A.get(last).get(last - offset));
                
                A.get(last).set(last - offset, A.get(i).get(last));
                
                A.get(i).set(last, top);
            }
            
        }
        
        printMatrix(A);
        
    }
    
    public void rotate2(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        int N = a.size();
        
        for(int i = 0; i < N; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(int j = 0; j < N; j++) {
                row.add(j, a.get(N - j - 1).get(i));
            }
            arr.add(row);
        }
        
        printMatrix(arr);
    }
    
    public static void main(String [] args) {
        
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        int N = 4;
        for(int i = 0; i < N; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = i * N + 1; j <= (i * N) + N; j++) {
                row.add(j);
            }
            a.add(row);
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                System.out.print(a.get(i).get(j) + " ");
            }
            System.out.println();
        }
        
        RotateMatrix r = new RotateMatrix();
        r.rotateSolution(a);
//        r.printMatrix(arr);
    }

}
