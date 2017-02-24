package other;

import static org.junit.Assert.*;

import org.junit.Test;

public class GCD {
    public int gcd(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        
        int x = min;
        
        while(max % min != 0) {
            x = max % min;
            max = min;
            min = x;
        }
        
        return x;
        
    }
    
    @Test
    public void test() {
        assertEquals(5, gcd(10, 5));
        assertEquals(2, gcd(10, 2));
        assertEquals(1, gcd(10, 1));
        assertEquals(6, gcd(24, 6));
        assertEquals(3, gcd(24, 9));
        
    }
}
