package leetcode.algorithms;

import java.util.Arrays;

import org.junit.Test;

public class PerfectSquares {

	@Test
	public void testing(){
		
		int x = 10;
		
//        System.out.println("result: " + perfectSquares(x));
        System.out.println("result: " + perfectSquares2(x));
	}
	
	public int perfectSquares2(int n) {
	    int [] dp = new int [n+1];
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    
	    dp[0] = 0;
	    
	    for(int i = 1; i <= n; i++) {
	        int min = Integer.MAX_VALUE;
	        int j = 1;
	        System.out.println(i);
	        while(i - j*j >= 0) {
	            System.out.println("  " + min + " OR " +  dp[i - j*j] + " + 1");
	            min = Math.min(min, dp[i - j*j] + 1);
	            j++;
	        }
	        dp[i] = min;
	    }
	    
	    return dp[n];
	}

	/**
	 * using dynamic programming
	 * @param n
	 * @return
	 */
	public int perfectSquares(int n){
		int [] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i=0 ; i<n; i++){
			System.out.println("i = " + i);
			for(int j = 1; (i + j*j) <= n; j++){
				System.out.println("\tj = " + j);

				System.out.println("\t\tmin(" + dp[i + j*j] +" , " + (dp[i] + 1) + ")");

				dp[i + j*j] = Math.min(dp[i + j*j], dp[i] + 1);
				System.out.println("\t\tdp [ " + (i+j*j) + " = " + dp[i+j*j] + " ]");
			}
			
			
		}
		
		for(int i=0; i<dp.length; i++){
			System.out.println(i + " : " + dp[i]);
		}
		
		return dp[n];
		
		
	}
	
//	public int perfectSquares(int x, int y){
//		if(Math.sqrt(x) % 1 == 0){
//			System.out.println("found perfect square: " + x);
//			return 1;
//		}
//		else{
//			System.out.println("not a perfect square: " + x + ", y = " + y);
//			int minusOne = Math.min(perfectSquare(x - 1, x), x) + 1;
//			
//			return minusOne;
//		}
//	}

}
