package interviewcake.algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class _05_MakingChange_BottomUp {
    
    public int makeChange(int amount, int [] denominations) {
        
        int [] memo = new int [amount+1];
        memo[0] = 1;
        
        for(int coin : denominations) {
            for(int higherAmount = coin; higherAmount < amount+1; higherAmount++) {
                int amountLeft = higherAmount - coin;
                memo[higherAmount] += memo[amountLeft];
            }
            
        }
        
        return memo[amount];
    }
    
    @Test
    public void test() {
        int [] denom = new int []{1, 3, 5};
        assertEquals(1, makeChange(0, denom));
        assertEquals(1, makeChange(1, denom));
        assertEquals(1, makeChange(2, denom));
        assertEquals(3, makeChange(5, denom));
        assertEquals(4, makeChange(6, denom));
        
    }
//
//    @Test
//    public void test1() {
//        int [] denom = new int []{1, 2, 3};
//        assertEquals(1, makeChange(0, denom));
//        assertEquals(1, makeChange(1, denom));
//        assertEquals(2, makeChange(2, denom));
//        assertEquals(3, makeChange(5, denom));
//        assertEquals(4, makeChange(6, denom));
//        
//    }

}
