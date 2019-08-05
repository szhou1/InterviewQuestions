package leetcode.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class _287_FindDuplicateNumber {

    public int findDuplicate(int[] nums) {

//        int slow = 0;
//        int fast = 3;
//        
//        while(nums[slow] != nums[fast] || slow == fast) {
//            slow = slow + 1 >= nums.length ? 0 : slow + 1;
//            fast = fast + 3 >= nums.length ? (fast + 3) % nums.length : fast + 3;
//            System.out.println(slow + " " + fast);
//        }
//        
//        return nums[slow];
        
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            System.out.println(slow + " ? " + fast);
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        System.out.println(slow + " = " + fast);
        
        fast = 0;
        
        while (slow != fast) {
            System.out.println(slow + " ?? " + fast);
            slow = nums[slow];
            fast = nums[fast];
        }        
        System.out.println(slow + " == " + fast);

        return slow;
    }

    @Test
    public void test() {
        _287_FindDuplicateNumber p = new _287_FindDuplicateNumber();
//         assertEquals(p.findDuplicate(new int []{1, 2, 2, 3, 5, 4}), 2);
//        assertEquals(p.findDuplicate(new int []{1, 2, 3, 2, 5, 4}), 2);
//         assertEquals(p.findDuplicate(new int []{2, 3, 2, 1, 5, 4}), 2);
//        assertEquals(p.findDuplicate(new int[] { 4, 3, 4, 1, 5, 2}), 4);
//        assertEquals(p.findDuplicate(new int[] { 2, 3, 1, 1, 5, 4}), 1);
//        assertEquals(p.findDuplicate(new int[] { 5, 3, 1, 2, 5, 4 }), 5);
        assertEquals(p.findDuplicate(new int []{1, 2, 3, 6, 7, 8, 9, 2, 5, 4}), 2);
    }
}
