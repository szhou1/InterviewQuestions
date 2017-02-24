package other;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
import java.util.*;
public class Baseball
{ 
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int totalScore(String[] blocks, int n)
    {
        
        if(n <= 0) {
            return 0;
        } else if(n == 1) {
            return Integer.parseInt(blocks[0]);
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < n; i++) {
            String v = blocks[i];
            
            try {
                Integer num = Integer.parseInt(v);
                System.out.println("number: "+ num);
                stack.push(num);
                
            } catch(NumberFormatException e) {
                if(v.equals("X")) {
                    System.out.println("it's an X");
                    Integer p = stack.peek() * 2;
                    System.out.println("    pushing " + p);
                    stack.push(p);
                    
                } else if(v.equals("+")) {
                    System.out.println("it's a +");
                    Integer last = 0;
                    Integer last2 = 0;
                    
                    if(stack.size() == 1) {
                        last = stack.pop();
                    } else if(stack.size() >= 2) {
                        last = stack.pop();
                        last2 = stack.pop();
                    }
                    System.out.println(last + " " + last2);
                    Integer sum = last + last2;
                    stack.push(last2);
                    stack.push(last);
                    System.out.println("    pushing " + sum + " (" + last + " + " + last2 +")");
                    stack.push(sum);
                    
                } else if(v.equals("Z")) {
                    System.out.println("it's a Z");
                    Integer removed = stack.pop();
                    System.out.println("    removed " + removed);
                } else {
                    System.out.println("unknown operator: " + v);
                }
            }
            
            
        }
        
        int res = 0;
        while(stack.isEmpty() == false) {
            res += stack.pop();
        }

        return res;
    }
    // METHOD SIGNATURE ENDS
    
    public static void main(String [] a) {
        Baseball b = new Baseball();
        
        String [] blocks = new String []{"1", "2", "+", "Z"};
        Integer res = b.totalScore(blocks, blocks.length);
        System.out.println(res);
        b.totalScore(new String []{"+"}, 1);
    }
}