package leetcode.algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class LongestIncreasingSubsequence {

    @Test
    public void test() {
        getLIS(new int[] { 20, 40, 30, 50, 10, 70, 60, 90, 80 });
        // assertArrayEquals(new int []{2, 4, 3, 5, 1, 7, 6, 9, 8}, getLIS(new
        // int []{20, 40, 30, 50, 10, 70, 60, 90, 80}));
        // assertEquals(4, lengthOfLISBinarySearch(new int []{10, 9, 2, 5, 3, 7,
        // 101, 18}));
        // assertEquals(4, lengthOfLIS2(new int []{3, 1, 5, 2, 6, 4, 9}));
        // assertEquals(1, lengthOfLIS(new int []{-1,-2,-3,-4}));
        // assertEquals(4, lengthOfLIS(new int []{1, 2, 3, 4}));
    }

    public int[] getLIS(int[] nums) {
        int[] seq = new int[nums.length];
        int[] parent = new int[nums.length];

        int len = 0;

        for (int i = 0; i < nums.length; i++) {

            int low = 1;
            int high = len;
            while (low <= high) {
                int mid = (int) Math.ceil((low + high) / 2);
                if (nums[seq[mid]] < nums[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            int pos = low;
            parent[i] = seq[pos - 1];
            seq[pos] = i;

            if (pos > len) {
                len = pos;
            }

        }
        
        for (int i = 0; i < len; i++) {
            System.out.println(seq[i]);
        }
        for (int i = 0; i < len; i++) {
            System.out.println(parent[i]);
        }

        int LIS[] = new int[len];
        int k = seq[len];
        for (int j = len - 1; j >= 0; j--) {
            LIS[j] = nums[k];
            k = parent[k];
        }

        for (int i = 0; i < len; i++) {
            System.out.println(LIS[i]);
        }

        return nums;
    }

    public int lengthOfLISBinarySearch(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            System.out.println("searching for [" + x + "] " + "with len: " + len);
            int i = Arrays.binarySearch(dp, 0, len, x);
            System.out.println("    i: " + i);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = x;
            for (int a = 0; a < dp.length; a++) {
                System.out.println("-------- dp: " + a + " : " + dp[a]);
            }
            // System.out.println("dp[i]: " + dp[i]);
            if (i == len) {
                len++;
            }
            // System.out.println(" len: " + len);
        }
        System.out.println(len);
        return len;
    }

    public int lengthOfLIS(int[] nums) {
        System.out.println("----------");
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // increasing
                    // System.out.println("increasing");
                    lis[i] = Math.max(lis[j] + 1, lis[i]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(lis[i]);
            result = (result > lis[i]) ? result : lis[i];
        }
        return result;

    }
}
