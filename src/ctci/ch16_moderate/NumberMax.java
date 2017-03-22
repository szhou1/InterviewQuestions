package ctci.ch16_moderate;

import org.junit.Test;

public class NumberMax {
    
    public int flip(int bit) {
        return 1^bit;
    }
    
    public int sign(int a) {
        
        System.out.println("Number: " + a);
        int v = (a >> 31);
        System.out.println("After shift: " + v);
        
        int and = v & 0x1;
        System.out.println("After and: " + and);
        
        return flip(and);
    }
    
    public int getMax(int a, int b) {
        int k = sign(a - b);
        int q = flip(k);
        return a * k + b * q;
    }
    
    @Test
    public void test() {
        
        System.out.println(getMax(10, 13));
        System.out.println(getMax(15, 13));
        System.out.println(getMax(15, -13));
        System.out.println(getMax(-15, 13));
        System.out.println(getMax(-15, 0));

    }

}
