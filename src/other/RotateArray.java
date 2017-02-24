package other;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class RotateArray {

    public int[] rotateArray(int [] A, int B, int dir) {
        
        int [] result = new int[A.length];
        int size = 0;
        
        if(dir > 0) {
            B = -B;
        }
        
        if(B < 0) {
            B = Math.abs(A.length + (B % A.length));
        }
        
        for(int i = 0; i < A.length; i++){ 
            result[size++] = A[(i + B) % A.length];
        }
        
        return result;
    }
    
    public int[] rotateArrayInPlace(int [] A, int B) {
        int n = A.length;
        reverseArray(A, 0, n-1);
        reverseArray(A, 0, B-1);
        reverseArray(A, B, n-1);
        
        for(int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
        
        return A;
    }
    
    private void reverseArray(int[] A, int i, int j) {
        while(i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }
    
    @Test
    public void rotateInPlace() {
        assertArrayEquals(rotateArrayInPlace(new int[]{1, 2, 3, 4, 5}, 2), new int []{4, 5, 1, 2, 3});
    }

    @Test
    public void forwards() {
        assertArrayEquals(rotateArray(new int[]{1, 2, 3, 4, 5}, 2, 1), new int []{4, 5, 1, 2, 3});
        assertArrayEquals(rotateArray(new int[]{1, 2, 3, 4, 5}, 7, 1), new int []{4, 5, 1, 2, 3});
        assertArrayEquals(rotateArray(new int[]{1, 2, 3, 4, 5}, 12, 1), new int []{4, 5, 1, 2, 3});
        assertArrayEquals(rotateArray(new int[]{1, 2, 3, 4, 5}, -3, 1), new int []{4, 5, 1, 2, 3});
        assertArrayEquals(rotateArray(new int[]{1, 2, 3, 4, 5}, -8, 1), new int []{4, 5, 1, 2, 3});
        assertArrayEquals(rotateArray(new int[]{1, 2, 3, 4, 5}, -13, 1), new int []{4, 5, 1, 2, 3});
        assertArrayEquals(rotateArray(new int[]{1, 2, 3, 4, 5}, 0, 1), new int []{1, 2, 3, 4, 5});
        
    }
    
    @Test
    public void backwards() {
        assertArrayEquals(rotateArray(new int[]{1, 2, 3, 4, 5}, 2, -1), new int []{3, 4, 5, 1, 2});
        assertArrayEquals(rotateArray(new int[]{1, 2, 3, 4, 5}, 7, -1), new int []{3, 4, 5, 1, 2});
        assertArrayEquals(rotateArray(new int[]{1, 2, 3, 4, 5}, 12, -1), new int []{3, 4, 5, 1, 2});
        assertArrayEquals(rotateArray(new int[]{1, 2, 3, 4, 5}, -3, -1), new int []{3, 4, 5, 1, 2});
        assertArrayEquals(rotateArray(new int[]{1, 2, 3, 4, 5}, -8, -1), new int []{3, 4, 5, 1, 2});
        assertArrayEquals(rotateArray(new int[]{1, 2, 3, 4, 5}, -13, -1), new int []{3, 4, 5, 1, 2});
        assertArrayEquals(rotateArray(new int[]{1, 2, 3, 4, 5}, 0, -1), new int []{1, 2, 3, 4, 5});
        assertArrayEquals(rotateArray(new int[]{1, 2, 3, 4, 5}, -2, -1), new int []{4, 5, 1, 2, 3});
        


    }
}
