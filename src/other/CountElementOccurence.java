package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CountElementOccurence {
    
    public enum Type {
        LEFTMOST_INDEX,
        RIGHTMOST_INDEX
    }
    
    private int findCountHelper(List<Integer> a, int b, Type t) {
        
        int low = 0; 
        int high = a.size() - 1;
        int index = -1;

        while(low <= high) {
            int mid = (low + high) / 2;
            
            if(a.get(mid) > b) {
                // go left
                high = mid - 1;
            } else if(a.get(mid) < b) {
                low = mid + 1;
            } else {
                index = mid;
                if(t == Type.LEFTMOST_INDEX) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
        }
        
        
        return index;
    }    
    public int findCount(final List<Integer> a, int b) {
        
        int l = findCountHelper(a, b, Type.LEFTMOST_INDEX);
        int r = findCountHelper(a, b, Type.RIGHTMOST_INDEX);
        System.out.println(l + " " +  r);
        return l == -1 ? 0 : r - l + 1;
    }
    
    @Test
    public void test(){
        Integer [] a = new Integer []{1, 2, 2, 2, 2, 2, 3, 4, 5, 6, 7, 7, 7, 8};
        
        int res = findCount(new ArrayList<Integer>(Arrays.asList(a)), 9);
        System.out.println(res);
    }
}
