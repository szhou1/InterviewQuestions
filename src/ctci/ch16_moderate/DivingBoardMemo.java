package ctci.ch16_moderate;

import java.util.HashSet;

import org.junit.Test;

public class DivingBoardMemo {
    
    public HashSet<Integer> getAllLengths(int k, int shorter, int longer) {
        
        HashSet<Integer> lengths = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        
        getLengths(k, 0, shorter, longer, lengths, visited);
        
        return lengths;
        
    }
    
    public void getLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths, HashSet<String> visited) {
        if(k == 0) {
            lengths.add(total);
            return;
        }
        String key = k + " " + total;
        if(visited.contains(key)) {
            return;
        }
        
        getLengths(k - 1, total + shorter, shorter, longer, lengths, visited);
        getLengths(k - 1, total + longer, shorter, longer, lengths, visited);
        visited.add(key);
    }
    
    @Test
    public void test() {
        for(Integer i : getAllLengths(1000, 2, 10)){
            System.out.println(i);
        }
    }
}
