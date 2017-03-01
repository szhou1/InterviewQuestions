package leetcode.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class _011_MaxArea {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        
        while(left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
    
    @Test
    public void test() {
        _011_MaxArea p = new _011_MaxArea();
        
        assertEquals(p.maxArea(new int []{1, 1}), 1);
        assertEquals(p.maxArea(new int []{1, 2}), 1);
        assertEquals(p.maxArea(new int []{2, 2}), 2);
        assertEquals(p.maxArea(new int []{2, 3}), 2);
        assertEquals(p.maxArea(new int []{3, 3}), 3);
        assertEquals(p.maxArea(new int []{1, 1, 1}), 2);
        assertEquals(p.maxArea(new int []{1, 2, 2}), 2);
        assertEquals(p.maxArea(new int []{2, 2, 2}), 4);
        assertEquals(p.maxArea(new int []{2, 1, 2}), 4);
        assertEquals(p.maxArea(new int []{1, 2, 1, 3, 1, 1}), 5);
        assertEquals(p.maxArea(new int []{1, 2, 1, 3, 1, 4}), 8);
        
    }
}
