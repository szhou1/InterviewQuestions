package leetcode.algorithms;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class _020_ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if(stack.size() < 1) {
                return false;
            }
            
            Character last = stack.pop();
            
            if(c == ']' && last != '[') return false;
            if(c == '}' && last != '{') return false;
            if(c == ')' && last != '(') return false;
            
        }
        
        return stack.size() == 0; 
    }
    
    @Test
    public void test() {
        _020_ValidParenthesis p = new _020_ValidParenthesis();
        
        assertTrue(p.isValid("{[()]}"));
        assertTrue(p.isValid("{[()(){{[]}}]}"));
        assertTrue(p.isValid("{}[]()"));
        assertFalse(p.isValid("([)]"));
        assertFalse(p.isValid("["));
        assertTrue(p.isValid(""));
        assertFalse(p.isValid("]"));
        assertFalse(p.isValid("[]["));
        assertFalse(p.isValid("[["));
    }
}
