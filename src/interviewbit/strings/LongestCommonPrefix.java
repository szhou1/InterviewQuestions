package interviewbit.strings;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class LongestCommonPrefix {

    public String longestCommonPrefix(ArrayList<String> a) {
        if(a.size() == 0) {
            return "";
        }
        if(a.size() == 1) {
            return a.get(0);
        }

        int min = Integer.MAX_VALUE;
        for (String s : a) {
            min = s.length() < min ? s.length() : min;
        }
        
        StringBuffer sb = new StringBuffer();
        
        Character c = null;
        int i = 0;
        boolean done = false;
        while(i < min) {
            c = a.get(0).charAt(i);
            for(int string = 1; string < a.size(); string++) {
                if(a.get(string).charAt(i) != c) {
                    done = true;
                    break;
                }
            }
            if(done) break;
            sb.append(c);
            i++;
        }

        return sb.toString();
    }

    @Test
    public void test() {
        ArrayList<String> a = new ArrayList<>(Arrays.asList("abc", "ae", "ab"));
        assertEquals("a", longestCommonPrefix(a));
        a = new ArrayList<>(Arrays.asList("abc", "ab", "ab"));
        assertEquals("ab", longestCommonPrefix(a));
        

    }
}
