package other;

import java.util.ArrayList;
import java.util.Arrays;

public class PrettyPrint {

    /**
     * Prints concentric circles
     * @param a
     * @return
     */
    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {

        int n = (a * 2) - 1;
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < a; i++) {
            int left = 0;
            int right = n - 1;
            
            Integer [] arr = new Integer [n];
            int v = a;
            Arrays.fill(arr, v-i);
            for(int l = left, r = right, count = i; l <= r && count >= 0; ) {
                arr[l++] = v;
                arr[r--] = v;
                
                v--;
                count--;
            }
            left++;
            right--;
            res.add(new ArrayList<Integer>(Arrays.asList(arr)));
        }
        
        for(int i = res.size()-2; i >= 0; i--) {
            res.add(new ArrayList<Integer>(res.get(i)));
        }
        
        return res;
    }
    
    public static void main(String [] a) {
        PrettyPrint p = new PrettyPrint();
        ArrayList<ArrayList<Integer>> res = p.prettyPrint(6);
        
        
        Utilities<Integer> u = new Utilities<Integer>();
        u.print2DArrayList(res);
    }
}
