package ctci.ch16_moderate;

import org.junit.Test;

public class NumberSwapper {

    public void swapNumber(int a, int b) {
        a = a - b;
        b = a + b;
        a = b - a;
        
        System.out.println(a);
        System.out.println(b);
        
    }
    
    public void swapNumberXOR(int a, int b) {
        
        a = a^b;
        b = a^b;
        a = b^a;
        System.out.println(a);
        System.out.println(b);
        
    }
    
    @Test
    public void test() {
        int a = 3;
        int b = 7;
        swapNumber(a, b);
        swapNumberXOR(a, b);
        
//        System.out.println(a);
//        System.out.println(b);
    }
    
}
