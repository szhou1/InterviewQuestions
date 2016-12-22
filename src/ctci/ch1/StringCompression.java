package ctci.ch1;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCompression {

	/**
	 * Returns a simple compressed version of a [a-zA-Z] string
	 * 
	 * @param s
	 * @return
	 */
	public String compressString(String s) {
		StringBuilder str = new StringBuilder();
		char c = 0;
		int n = 0;
		
		for(int i=0; i<s.length(); i++, n++) {
			if(c != s.charAt(i)) {
				if(n > 0) {
					str.append(String.valueOf(c) + n);
					n = 0;
				}
				c = s.charAt(i);
			}
		}

		if(n > 0) {
			str.append(String.valueOf(c) + n);
		}
		
		return str.toString();
	}
	
	@Test
	public void test() {
		assertEquals("a2b2c2", compressString("aabbcc"));
		assertEquals("a1b1c1", compressString("abc"));
		assertEquals("a2b3c5b2", compressString("aabbbcccccbb"));
		assertEquals("A1a1", compressString("Aa"));
		assertEquals("A1a1B1b1B1", compressString("AaBbB"));
		assertEquals("z5", compressString("zzzzz"));
	}
	
	@Test
	public void testPerformance() {
		for(int i=0; i<1000000; i++) {
			compressString("aabbbcccccbbddddeefghh");			
		}
	}
}
