package leetcode.algorithms;

public class _486_PredictTheWinner {

    
    static boolean PredictTheWinner(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) { dp[i][i] = nums[i]; }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                System.out.println(len);
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        
        return dp[0][n - 1] >= 0;
    }
    
    public static void main(String args[]) {
//        boolean b = PredictTheWinner(new int[] {1, 5, 20, 7});
        boolean c = PredictTheWinner(new int[] {3, 9, 1, 2});
        System.out.println(c);
    }
}
