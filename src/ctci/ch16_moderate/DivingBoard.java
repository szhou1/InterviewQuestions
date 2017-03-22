package ctci.ch16_moderate;

import java.util.HashSet;

import org.junit.Test;

public class DivingBoard {

    public HashSet<Integer> getAllLengths(int k, int shorter, int longer) {
        
        HashSet<Integer> lengths = new HashSet<>();
        
        getLengths(k, 0, shorter, longer, lengths);
        
        return lengths;
        
    }
    
    public void getLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths) {
        if(k == 0) {
            lengths.add(total);
            return;
        }
        
        getLengths(k - 1, total + shorter, shorter, longer, lengths);
        getLengths(k - 1, total + longer, shorter, longer, lengths);
        
    }
    
    @Test
    public void test() {
        for(Integer i : getAllLengths(26, 1, 3)){
            System.out.println(i);
        }
    }
    
}
