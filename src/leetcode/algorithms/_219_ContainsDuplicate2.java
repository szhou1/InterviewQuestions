package leetcode.algorithms;

import java.util.HashMap;

public class _219_ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(set.containsKey(nums[i]) && Math.abs(set.get(nums[i]) - i) <= k) {
                return true;
            }
            set.put(nums[i], i);
        }
        
        return false;
    }
}
