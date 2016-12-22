package ctci.ch1;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

/**
 * Determines if a string has all unique characters
 * @author szhou
 *
 */
public class AllUniqueChars {
	
	public boolean allUnique(String s) {
		HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
		for(int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				return false;
			} else {
				map.put(s.charAt(i), true);
			}
		}
		return true;
	}
	
	@Test
	public void test() {
		assertFalse(allUnique("aa"));
		assertFalse(allUnique("  "));
		assertFalse(allUnique("\n\n"));
		assertFalse(allUnique("asdfalksjdfasdf"));

		assertTrue(allUnique("abcd"));
		assertTrue(allUnique("abcdefghijkl!@#(*&^%$\n\t\r"));
		assertTrue(allUnique("a"));
		assertTrue(allUnique(""));
		assertTrue(allUnique(" "));
	}
	
}
