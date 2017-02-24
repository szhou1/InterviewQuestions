package other;

import java.util.Stack;

/*
 * Complete the function below.
 */
public class MatchingBrackets {
    static String processString(String value) {
        Stack<Character> s = new Stack<Character>();
        if(value.length() == 0) {
            return "YES";
        }
        if(value.length() % 2 != 0) {
            return "NO";
        }
        System.out.println("for loop");
        
        for(int i = 0; i < value.length(); i++) {
            Character v = value.charAt(i);
    //        System.out.println(s.size());
            if((v == '(' || v == '{' || v == '['))  {
                s.push(v);            
            }
            
            if(v == ')' && s.pop() != '(') {
  //              System.out.println("fail " + v);
                return "NO";
            }            
            if(v == '}' && s.pop() != '{') {
//                System.out.println("fail " + v);
                return "NO";
            }            
            if(v == ']' && s.pop() != '[') {
//                System.out.println("fail " + v);
                return "NO";
            }
            
        }
        System.out.println(s.size());

        if(s.size() == 0) {
            return "YES";
        } else {
            return "NO";
        }

    }

    static String[] braces(String[] values) {
        String [] res = new String [values.length];
        
        for(int i = 0; i < values.length; i++) {
            res[i] = processString(values[i]);
        }
        
        return res;
    }
}
