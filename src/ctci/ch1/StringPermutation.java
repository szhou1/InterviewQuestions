package ctci.ch1;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Hashtable;

import org.junit.Test;

public class StringPermutation {

	/**
	 * Determines if string b is a permutation of string a
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean isPermutation(String a, String b) {
		
		if(a.length() != b.length()) {
			return false;
		}
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<a.length(); i++) {
			if(map.containsKey(a.charAt(i))) {
				int val = map.get(a.charAt(i));
				if(val == -1) {
					map.remove(a.charAt(i));
				} else {
					map.put(a.charAt(i), val+1);					
				}
			} else {
				map.put(a.charAt(i), 1);
			}
			if(map.containsKey(b.charAt(i))) {
				int val = map.get(b.charAt(i));
				if(val == 1) {
					map.remove(b.charAt(i));
				} else {					
					map.put(b.charAt(i), val-1);
				}
			} else {
				map.put(b.charAt(i), -1);
			}
			
		}
		return map.size() == 0;
		
	}
	
	/**
	 * Determine if string b is a permutation of string a
	 * Uses Hashtable: synchronized, slower, thread-safe
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean isPermutationHashTable(String a, String b) {
		
		if(a.length() != b.length()) {
			return false;
		}
		
		Hashtable<Character, Integer> map = new Hashtable<Character, Integer>();
		for(int i=0; i<a.length(); i++) {
			if(map.containsKey(a.charAt(i))) {
				int val = map.get(a.charAt(i));
				if(val == -1) {
					map.remove(a.charAt(i));
				} else {
					map.put(a.charAt(i), val+1);					
				}
			} else {
				map.put(a.charAt(i), 1);
			}
			if(map.containsKey(b.charAt(i))) {
				int val = map.get(b.charAt(i));
				if(val == 1) {
					map.remove(b.charAt(i));
				} else {					
					map.put(b.charAt(i), val-1);
				}
			} else {
				map.put(b.charAt(i), -1);
			}
			
		}
		return map.size() == 0;
		
	}
	
	
	@Test
	public void test() {
		assertTrue(isPermutation("abc", "cba"));
		assertTrue(isPermutation("this is something i want to scramble", " lrssinmaicoti ettsgis  h om nbhatew"));
		
		assertFalse(isPermutation("aaaa", "aaaaa"));
		assertFalse(isPermutation("aaaa", "bbbb"));
	}
	
	@Test
	public void performanceTestHashMap() {
		for(int i=0; i< 1000000; i++) {			
			isPermutation("this is something i want to scramble", " lrssinmaicoti ettsgis  h om nbhatew");
		}
	}
	
	@Test
	public void performanceTestHashtable() {
		for(int i=0; i< 1000000; i++) {			
			isPermutationHashTable("this is something i want to scramble", " lrssinmaicoti ettsgis  h om nbhatew");
		}
	}
}
