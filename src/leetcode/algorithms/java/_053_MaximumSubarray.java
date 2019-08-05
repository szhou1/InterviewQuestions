package leetcode.algorithms;

public class _053_MaximumSubarray {

    /**
     * Find the contiguous subarray within an array (containing at least one
     * number) which has the largest sum.
     * 
     * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous
     * subarray [4,-1,2,1] has the largest sum = 6.
     */

//    static int maxSubArray(int[] A) {
//        if (A.length == 0)
//            return 0;
//
//        int minVal = Math.min(A[0], 0);
//        int res = A[0];
//        int sum = A[0];
//
//        for (int i = 1; i < A.length; ++i) {
//            sum += A[i];
//            res = Math.max(res, sum - minVal);
//            minVal = Math.min(minVal, sum);
//        }
//        return res;
//    }

    static int maxSubArray(int [] nums) {
        int n = nums.length;
        
        int sum = nums[0];
        int maxSub = nums[0];
        
        for(int i = 1; i < n; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSub = Math.max(maxSub, sum);
            System.out.println(nums[i] + "\t" + sum + "\t" + maxSub);
            
//            System.out.println(maxSub);
        }
        
        
        return maxSub;
    }
    
    public static void main(String[] args) {

        int[] a = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4, -20, 5};
        System.out.println("res:" + maxSubArray(a));
    }
}
