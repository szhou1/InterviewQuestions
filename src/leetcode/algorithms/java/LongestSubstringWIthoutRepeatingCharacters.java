package leetcode.algorithms;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringWIthoutRepeatingCharacters {

	@Test
	public void test(){
		Assert.assertEquals(7, lengthOfLongestSubstring("abcdeefghijk"));
		Assert.assertEquals(0, lengthOfLongestSubstring(""));
		Assert.assertEquals(1, lengthOfLongestSubstring("a"));
		Assert.assertEquals(1, lengthOfLongestSubstring("aa"));
		Assert.assertEquals(1, lengthOfLongestSubstring("bbb"));
		Assert.assertEquals(2, lengthOfLongestSubstring("aaaabbb"));
		Assert.assertEquals(4, lengthOfLongestSubstring("asdfasdf"));
		Assert.assertEquals(8, lengthOfLongestSubstring("asdfzxcv"));
		Assert.assertEquals(11, lengthOfLongestSubstring("aavbnmjkloip"));
		Assert.assertEquals(3, lengthOfLongestSubstring("dvdf"));
		Assert.assertEquals(6, lengthOfLongestSubstring("abcdcdcdceefefeeefghijjk"));
	}
	
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        
        int maxLen = 0;
        int len = 0;
        int left = 0;
        HashMap<Character, Integer> visited = new HashMap<Character, Integer>();
        
        for(int i=0; i<s.length(); i++){

        	char c = s.charAt(i);
        	
        	if(visited.containsKey(c)){
        		left = Math.max(left, visited.get(c) + 1);
        		len = i - left + 1;
        		visited.put(c, i);
        	}
            else{
            	visited.put(c, i);
            	len++;
            }
        	
        	maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
	
}
