package other;

import org.junit.Test;

public class QuickSort {

    public void sort(int [] A, int start, int end) {
        System.out.println("start: " + start + " end: " + end);
        if(start < end) {
            int pIndex = partition(A, start, end);
            System.out.println("pIndex: " + pIndex);
            print(A);
            sort(A, start, pIndex - 1);
            sort(A, pIndex + 1, end);
            
        }
        
        print(A);
    }
    
    
    private int partition(int[] A, int start, int end) {
        System.out.println("partition: " + start + " " + end);
        int pivot = A[end];
        int pIndex = start;
        
        for(int i = start; i < end; i++) {
            if(A[i] <= pivot) {
                swap(A, i, pIndex);
                pIndex++;
            }
        }
        swap(A, pIndex, end);
        return pIndex;
    }
    
    private void swap(int[] A, int a, int b) {
        if(a == b) return;
        System.out.println("    swap " + A[a] + " " + A[b]);
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    private void print(int [] A) {
        for(Integer i : A) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Test
    public void test() {
        int [] A = new int[]{7, 2, 1, 6, 8, 5, 3, 4};
        sort(A, 0, A.length-1);
        print(A);
//        assertArrayEquals(sort(new int[]{3, 4, 1, 5, 2}, 0, 4), new int[]{1, 2, 3, 4, 5});
    }
}
