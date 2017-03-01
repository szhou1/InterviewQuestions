package leetcode.algorithms;

import static org.junit.Assert.*;

import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;
import org.junit.Test;

public class _005_LongestPalindromicSubstring {
    
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        
        int start = 0, end = 0;
        
        for(int i = 0; i < s.length(); i++) {
            int len1 = searchPalindrome(s, i, i);
            int len2 = searchPalindrome(s, i, i+1);
            
            int len = Math.max(len1, len2);
            
            if(len > end - start) {
                start = i - (len - 1) / 2;
                end = i + (len / 2);
            }
        }
        
        return s.substring(start + 1, end);
    }
    
    private int searchPalindrome(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        
        return j - i + 1;
    }

    @Test
    public void test() {
        _005_LongestPalindromicSubstring p = new _005_LongestPalindromicSubstring();
        assertEquals("aba", p.longestPalindrome("aba"));
        assertEquals("abba", p.longestPalindrome("abba"));
        assertEquals("abbba", p.longestPalindrome("abbba"));
        assertEquals("abbba", p.longestPalindrome("abbbaeee"));
        assertEquals("abbba", p.longestPalindrome("qqqabbbaeee"));
        assertEquals("a", p.longestPalindrome("a"));
        assertThat(p.longestPalindrome("baba"), AnyOf.anyOf(Is.is("aba"), Is.is("bab")));
        assertEquals("bb", p.longestPalindrome("cbbd"));
        assertThat(p.longestPalindrome("112233"), AnyOf.anyOf(Is.is("11"), Is.is("22"), Is.is("33")));
        assertEquals("2222", p.longestPalindrome("1112222333"));
        assertEquals("33333", p.longestPalindrome("111222233333"));
        assertEquals("racecar", p.longestPalindrome("racecar"));
        assertEquals("1234567890987654321", p.longestPalindrome("1234567890987654321"));
        assertEquals("11111", p.longestPalindrome("11111222"));
        assertEquals("d", p.longestPalindrome("asd"));
        assertThat(p.longestPalindrome("ab"), AnyOf.anyOf(Is.is("a"), Is.is("b")));
        assertEquals("a", p.longestPalindrome("a"));
        assertEquals("", p.longestPalindrome(""));
        assertEquals("aa", p.longestPalindrome("aa"));
        assertEquals("aa aa", p.longestPalindrome("aa aa"));
        assertEquals("    ", p.longestPalindrome("    "));

    }
    
//    @Test
//    public void longstring() {
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        _005_LongestPalindromicSubstring p = new _005_LongestPalindromicSubstring();
//
//        String end = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        assertEquals(end, p.longestPalindrome(s));
//
//    }
}
