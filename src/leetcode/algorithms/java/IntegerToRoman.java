package leetcode.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerToRoman {

    private String[] M = { "", "M", "MM", "MMM" };
    private String[] C = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
    private String[] X = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
    private String[] I = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

    public String intToRoman(int N) {

        StringBuffer sb = new StringBuffer();

        sb.append(M[N / 1000]);
        sb.append(C[(N % 1000) / 100]);
        sb.append(X[(N % 100) / 10]);
        sb.append(I[N % 10]);

        return sb.toString();

    }

    @Test
    public void test() {
        assertEquals("CMXLI", intToRoman(941));
        assertEquals("MCMXCI", intToRoman(1991));
    }

}
