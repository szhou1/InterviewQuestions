package leetcode.algorithms;

public class _198_HouseRobber {

    /**
     * Linear time
     * Linear memory
     * 
     * @param nums
     * @return
     */
    static int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int [] memo = new int [nums.length+1];
        memo[0] = 0;
        memo[1] = nums[0];
        
        for(int i = 2; i <= nums.length; i++) {
            memo[i] = Math.max(memo[i - 1], memo[i - 2] + nums[i - 1]);
        }
        
        return memo[memo.length-1];
    }

    /**
     * Linear time
     * Constant Memory
     * 
     * @param nums
     * @return
     */
    static int rob2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int [] memo = new int [3];
        memo[0] = 0;
        memo[1] = nums[0];
        
        for(int i = 2; i <= nums.length; i++) {
            memo[2] = Math.max(memo[1], memo[0] + nums[i - 1]);
            memo[0] = memo[1];
            memo[1] = memo[2];
        }
        
        return memo[memo.length-1];
    }

    
    public static void main(String [] args) {
        
        int [] arr = new int[] {1, 5, 30, 2, 1, 5, 3};
        
        System.out.println(rob2(arr));
    }
}
