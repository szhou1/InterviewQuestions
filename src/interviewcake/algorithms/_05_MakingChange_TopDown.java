package interviewcake.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class _05_MakingChange_TopDown {
    
    public int makeChangeHelper(int amount, int [] denominations, int denomIndex) {
        if(amount == 0) return 1;
        if(amount < 0) return 0;
        
        int result = 0;
        
        while(amount >= 0 && denomIndex < denominations.length) {
            result += makeChangeHelper(amount, denominations, denomIndex + 1);
            amount -= denominations[denomIndex];
        }
        
        return result;
    }

    public int makeChange(int amount, int [] denominations) {
        if(amount < 1) return 0;
        
        int result = makeChangeHelper(amount, denominations, 0);
        return result;
    }
    
    @Test
    public void test() {
        
        assertEquals(0, makeChange(0, new int[]{1, 2, 3}));
        assertEquals(1, makeChange(1, new int[]{1, 2, 3}));
        assertEquals(2, makeChange(2, new int[]{1, 2, 3}));
        assertEquals(3, makeChange(3, new int[]{1, 2, 3}));
        assertEquals(4, makeChange(4, new int[]{1, 2, 3}));
        assertEquals(5, makeChange(5, new int[]{1, 2, 3}));
        assertEquals(7, makeChange(6, new int[]{1, 2, 3}));
        
    }
}
