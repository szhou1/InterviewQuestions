package leetcode.algorithms;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class _015_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        return null;
        
    }
    
    @Test
    public void test() {
        int [] nums = new int []{-1, 0, 1, 2, -1, 4};
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(Arrays.asList(-1, 0, 1));
        res.add(Arrays.asList(-1, -1, 2));
        
        assertEquals(res, threeSum(nums));
    }
    
}
