package leetcode.algorithms;

import org.junit.Test;

import other.Utilities;

public class _042_TrappingRainWater {
    public int trap(int[] height) {
        
        int n = height.length;
     
        int left [] = new int [n];
        int right [] = new int [n];
        
        int water = 0;
        
        left[0] = height[0];
        
        for(int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }
        
        right[n-1] = height[n-1];
        
        for(int i = n-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }
        
        Utilities.printArray(left);
        Utilities.printArray(right);
        
        for(int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - height[i];
        }
        
        return water;
    }
    
    @Test
    public void test() {
        _042_TrappingRainWater p = new _042_TrappingRainWater();
        int water = p.trap(new int [] {3, 0, 0, 2, 0, 4});
        System.out.println(water);
        water = p.trap(new int [] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(water);
    }
}
