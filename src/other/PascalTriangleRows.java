package other;

import java.util.ArrayList;

public class PascalTriangleRows {
    public ArrayList<ArrayList<Integer>> generate(int a) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> zero = new ArrayList<Integer>();
        zero.add(1);
        ArrayList<Integer> one = new ArrayList<Integer>();
        one.add(1);
        one.add(1);
        
        if(a <= 0) { return res; }
        
        res.add(zero);
        if(a == 1) { return res; }
        
        res.add(one);
        if(a == 2) { return res; }
        
        for(int i = 2; i < a; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for(int j = 1; j < i; j++) {
                ArrayList<Integer> prevRow = res.get(i - 1);
                int toAdd = prevRow.get(j) + prevRow.get(j - 1);
//                System.out.println(prevRow.get(j) + prevRow.get(j - 1));
                row.add(toAdd);
            }
            row.add(1);
            res.add(row);
        }
        
        return res;
        
    }
    
    public void print(ArrayList<ArrayList<Integer>> a) {
        for(int i = 0; i < a.size(); i++) {
            for(int j = 0; j < a.get(i).size(); j++) {
                System.out.print(a.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String [] a) {
        PascalTriangleRows pascal = new PascalTriangleRows();
        ArrayList<ArrayList<Integer>> res = pascal.generate(6);
        pascal.print(res);
    }

}
