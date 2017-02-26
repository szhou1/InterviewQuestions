package interviewcake.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class _03_HighestProductOf3 {

    public int productOf3(int [] a) {
        int maxProd3 = a[0] * a[1] * a[3];
        int maxProd2 = a[0] * a[1];
        int max = Math.max(a[0], a[1]);
        int minProd2 = a[0] * a[0];
        int min = Math.min(a[0], a[1]);
        
        for(int i = 2; i < a.length; i++) {
            int curr = a[i];
            maxProd3 = Math.max(maxProd3, Math.max(maxProd2 * curr, minProd2 * curr));
            maxProd2 = Math.max(maxProd2, Math.max(max * curr, min * curr));
            minProd2 = Math.min(minProd2, Math.min(max * curr, min * curr));
            max = Math.max(max, curr);
            min = Math.min(min, curr);
        }
        
        return maxProd3;
    }
    
    @Test
    public void test(){
        assertEquals(productOf3(new int []{1, 10, -5, 1, 100}), 1000);
        assertEquals(productOf3(new int []{1, 10, -5, 1, -100}), 5000);
    }
}
