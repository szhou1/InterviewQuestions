package leetcode.algorithms;

import java.util.Arrays;

public class _152_MaximumProductSubarray {

    static int maxProduct(int [] nums) {
        
        int result = Integer.MIN_VALUE;
        
        int [] pos = new int [nums.length];
        int [] neg = new int [nums.length];
        Arrays.fill(pos, 1);
        Arrays.fill(neg, 1);
        
        pos[0] = nums[0];
        neg[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            pos[i] = Math.max(nums[i], Math.max(nums[i] * pos[i-1], nums[i] * neg[i-1]));
            neg[i] = Math.min(nums[i], Math.min(nums[i] * pos[i-1], nums[i] * neg[i-1]));
            result = Math.max(result, Math.max(pos[i], neg[i]));
        }
        
        return result;
    }
    
    public static void main(String args[]) {
        System.out.println(maxProduct(new int []{2, 3, -2, 4, -3, -100}));
        
    }
}
