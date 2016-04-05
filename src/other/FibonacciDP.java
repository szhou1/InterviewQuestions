package other;

import java.util.Arrays;

import org.junit.Test;

public class FibonacciDP {
	
	private int [] arr;

	@Test
	public void testDP(){
		
		int NUM = 100;
		arr = new int [NUM+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		int res = fibonacciDP(NUM);
		
		System.out.println(res);
	}
	
	@Test
	public void testDPBottomUp(){
		
		int NUM = 100;
		int res = fibonacciBottomUp(NUM);
		
		System.out.println(res);
	}
	
	/**
	 * bottom up / tabulated approach
	 * @param n
	 * @return
	 */
	public int fibonacciBottomUp(int n){
		int [] arr = new int [n+1];
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i = 2; i <= n; i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		return arr[n];
	}

	/**
	 * dynamic programming using memoization - no wasted calculations
	 * @param n
	 * @return
	 */
	public int fibonacciDP(int n){
		if(arr[n] == Integer.MAX_VALUE){
			if(n <= 1){
				arr[n] = n;
			}else{
				System.out.println("new sub problem for: " + n);
				arr[n] = fibonacciDP(n-1) + fibonacciDP(n-2);
			}
		}
		
		return arr[n];
	}

	@Test
	public void testNoDP(){
		
		int NUM = 30;
		int res = fibonacciNoDP(NUM);
		
		System.out.println(res);
	}
	
	/**
	 * non DP - there are many wasted calculations
	 * @param n
	 * @return
	 */
	public int fibonacciNoDP(int n){
		if(n <= 1){
			return n;
		}
		System.out.println("new sub problem for: " + n);

		return fibonacciNoDP(n-1) + fibonacciNoDP(n-2);
	}
}
