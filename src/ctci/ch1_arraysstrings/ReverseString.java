/**
 * 
 */
package ctci.ch1_arraysstrings;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Outputs the reverse of input string
 * @author szhou
 *
 */
public class ReverseString {

	public String reverseStringBuffer(String s) {
		if(s.length() < 2) {
			return s;
		}
		
		int start = 0;
		int end = s.length() - 1;
		
		StringBuffer sb = new StringBuffer(s);
		
		while(start < end) {
			char temp = sb.charAt(start);
			sb.replace(start, start+1, String.valueOf(sb.charAt(end)));
			sb.replace(end, end+1, String.valueOf(temp));
			start++;
			end--;
		}
		return sb.toString();
	}
	
	public String reverseStringBuilder(String s) {
		if(s.length() < 2) {
			return s;
		}
		
		int start = 0;
		int end = s.length() - 1;
		
		StringBuilder sb = new StringBuilder(s);
		
		while(start < end) {
			char temp = sb.charAt(start);
			sb.replace(start, start+1, String.valueOf(sb.charAt(end)));
			sb.replace(end, end+1, String.valueOf(temp));
			start++;
			end--;
		}
		return sb.toString();
	}
	
	@Test
	public void test() {
		assertEquals(reverseStringBuilder("szhou"), "uohzs");
		assertEquals(reverseStringBuilder("111"), "111");
		assertEquals(reverseStringBuilder("111"), "111");
		assertEquals(reverseStringBuilder("abcdefg"), "gfedcba");
		assertEquals(reverseStringBuilder("    "), "    ");
	}
	
	@Test
	public void loadTestStringBuffer() {
		for(int i = 0; i<1000000; i++) {
			reverseStringBuffer("asdfasdfasdfasdfasdfasdfasdfasdf");
		}
	}
	
	@Test
	public void loadTestStringBuilder() {
		for(int i = 0; i<1000000; i++) {
			reverseStringBuilder("asdfasdfasdfasdfasdfasdfasdfasdf");
		}
	}
}
