package leetcode.algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class LongestIncreasingSubsequence {

	@Test
	public void test(){
		assertEquals(4, lengthOfLISBinarySearch(new int []{10, 9, 2, 5, 3, 7, 101, 18}));
//		assertEquals(1, lengthOfLIS(new int []{-1,-2,-3,-4}));
	}
	
	public int lengthOfLISBinarySearch(int [] nums){
		int [] dp = new int [nums.length];
		int len = 0;
		
		for(int x : nums){
			System.out.println("searching for [" + x + "] " + "with len: " + len);
			int i = Arrays.binarySearch(dp, 0, len, x);
			System.out.println("    i: " + i);
			if(i < 0){
				i = -(i + 1);
			}
			dp[i] = x;
			for(int a=0; a<dp.length; a++){
				System.out.println("-------- dp: " + a + " : " + dp[a]);
			}
//			System.out.println("dp[i]: " + dp[i]);
			if(i == len){
				len++;
			}
//			System.out.println("  len: " + len);
		}
		System.out.println(len);
		return len;
	}
	
	public int lengthOfLIS(int [] nums){
		System.out.println("----------");
		int [] lis = new int [nums.length];
		Arrays.fill(lis, 1);
		
		for(int i=1; i<nums.length; i++){
			for(int j=0; j<i; j++){
				if(nums[j] < nums[i]){
					// increasing
//					System.out.println("increasing");
					lis[i] = Math.max(lis[j] + 1, lis[i]);
				}
			}
		}
		
		int result = 0;
		for(int i=0; i<nums.length; i++){
			System.out.println(lis[i]);
			result = (result > lis[i]) ? result : lis[i];
		}
		return result;
		
	}
}
