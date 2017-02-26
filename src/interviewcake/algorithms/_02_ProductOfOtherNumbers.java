package interviewcake.algorithms;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class _02_ProductOfOtherNumbers {

    public int[] getProductOfOtherNum(int [] arr) {
        
        int [] result = new int [arr.length]; 
        
        result[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }
        
        int right = 1;
        for(int i = arr.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= arr[i];
        }
        
        return result;
    }
    
    @Test
    public void test() {
        int [] r = getProductOfOtherNum(new int [] {1, 7, 3, 4});
        assertArrayEquals(new int []{84, 12, 28, 21}, r);
        
        r = getProductOfOtherNum(new int [] {1, 7, 3, 4, 0});
        assertArrayEquals(new int []{0, 0, 0, 0, 84}, r);
        
        r = getProductOfOtherNum(new int [] {3, 4, 0, 0});
        assertArrayEquals(new int []{0, 0, 0, 0}, r);

        r = getProductOfOtherNum(new int [] {3, 4});
        assertArrayEquals(new int []{4, 3}, r);

        r = getProductOfOtherNum(new int [] {0, 1});
        assertArrayEquals(new int []{1, 0}, r);

        r = getProductOfOtherNum(new int [] {3, 4, 0, 0, 1});
        assertArrayEquals(new int []{0, 0, 0, 0, 0}, r);

    }
}
