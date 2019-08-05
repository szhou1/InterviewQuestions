package leetcode.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindPeakElement {

	public int [] arr;

	/**
		 * 
		 * A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
		 * 
		 * 
		 */
	
	@Test
	public void tests(){
		assertEquals(3, caller(new int [] {40, 30, 20, 45, 30, 60, 70, 10}));
		assertEquals(6, caller(new int [] {40, 30, 20, 20, 30, 60, 70, 10}));
		assertEquals(7, caller(new int [] {40, 30, 20, 20, 30, 60, 70, 90}));
		assertEquals(0, caller(new int [] {40, 30, 20, 15, 30, 60, 70, 10}));
		assertEquals(0, caller(new int [] {40}));
		assertEquals(1, caller(new int [] {40, 50}));
		assertEquals(0, caller(new int [] {50, 40}));
//		assertEquals(0, caller(new int [] {50, 50}));
		assertEquals(0, caller(new int [] {1}));
		
		
	}
	
	public int caller(int [] arr){
//		this.arr = arr;
//		int s = 0;
//		int e = arr.length - 1;
//		int m = (s + e) / 2;
//		return findPeak(s, m , e);
		return findPeak(arr, 0 , arr.length-1);
	}
	
	public int findPeak(int [] arr, int s, int e){
		if(s == e){
			return s;
		}
		else if(s + 1 == e){
			if(arr[s] > arr[s+1]) {
				return s;
			}else{
				return e;
			}
		}
		else{
			int m = (s + e) / 2;
			
			if(arr[m] > arr[m-1] && arr[m] > arr[m+1]){
				// found peak
				return m;
			}
			else if(m != 0 && arr[m-1] > arr[m]){
				// traverse left
				return findPeak(arr, s, m - 1);
			}
			else{
				// traverse right
				return findPeak(arr, m + 1, e);
			}
		}
	}
	
//	public int findPeak(int s, int m, int e){
//		System.out.println("s: " + s + " m: " + m + " e: " + e);
//
//		if(arr == null || arr.length == 0){
//			// should return error
//			return 0;
//		}
//		if(arr.length == 1){
//			return 0;
//		}
//		
//		// check left end
//		if(m == 0 && arr[m] > arr[m+1]){
//			return m;
//		}
//		// check right end
//		if(m == arr.length-1 && arr[m] > arr[m-1]){
//			return m;
//		}
//		
//		if(m != 0 && m != arr.length-1 && arr[m] > arr[m-1] && arr[m] > arr[m+1]){
//			// found peak
//			return m;
//		}
//		else if(m != 0 && arr[m-1] > arr[m]){
//			// traverse left
//			return findPeak(s, (s+m)/2, m);
//		}
//		else{
//			// traverse right
//			return findPeak(m, (m+e)/2 + 1, e);
//		}
//		
//	}

}
