package leetcode.contest20;

import static org.junit.Assert.*;

import org.junit.Test;

public class DetectCapitals {

    
    public boolean detectCapitalUse(String word) {
        
        int countCaps = 0;
        
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(Character.isUpperCase(c)) {
                if(i != 0 && countCaps == 0) {
                    return false;
                }
                countCaps++;
            }
            
        }
        
        boolean allCaps = word.length() == countCaps;
        
        return allCaps || countCaps == 1 || countCaps == 0;
        
    }
    
    @Test
    public void test() {
        assertTrue(detectCapitalUse("USA"));
        assertTrue(detectCapitalUse("Usa"));
        assertTrue(detectCapitalUse("usa"));
        assertTrue(detectCapitalUse("usaaklsdjfklasdjflakfd"));
        
        assertFalse(detectCapitalUse("uSA"));
        assertFalse(detectCapitalUse("usA"));
        assertFalse(detectCapitalUse("UsA"));
        assertFalse(detectCapitalUse("usaaklsdjfklasdjflAkfd"));
        
    }
}
