package ctci.ch8_recursiondp;

import org.junit.Test;

public class TripleStep {
    
    public int countWays(int[] steps, int n) {
        
        int [] memo = new int [n + 1];
        
        memo[0] = 1;
        
        for(int i = 0; i < steps.length; i++) {
            int stepSize = steps[i];
            
            for(int j = stepSize; j < memo.length; j++) {
                int old = memo[j - stepSize];
                memo[j] += old;
            }
            
        }
        
        for(Integer i : memo) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        return 0;
    }
    
    @Test
    public void test() {
        
        countWays(new int []{1, 2, 3}, 10);
    }

}
