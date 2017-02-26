package interviewcake.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class _01_StockPrices {

    public int maxProfit(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int profit = prices[1] - prices[0];
        
        for(int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        
        return profit;
    }
    
    @Test
    public void test() {
        assertEquals(6, maxProfit(new int []{10, 7, 5, 8, 11, 9}));
        assertEquals(6, maxProfit(new int []{10, 7, 5, 8, 11, 9, 4}));
        assertEquals(-2, maxProfit(new int []{10, 7, 5}));
    }
    
}
