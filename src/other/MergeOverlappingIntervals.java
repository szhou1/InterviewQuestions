package other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverlappingIntervals {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        if (intervals.size() < 2) {
            return intervals;
        }
        
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        Stack<Interval> stack = new Stack<Interval>();
        stack.push(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval b = intervals.get(i);
            
//            if (stack.isEmpty() == false) {
                Interval a = stack.pop();
                if (a.end < b.start) {
                    System.out.println("push");
                    stack.push(a);
                    stack.push(b);
                } else {
                    Interval n = new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
                    System.out.println("new push" + n.start + " " + n.end);
                    stack.push(n);
                }
//            }
        }
        
        Stack<Interval> stack2 = new Stack<Interval>();
        for(Interval i : stack) {
            stack2.push(i);
        }

        ArrayList<Interval> res = new ArrayList<Interval>();
        for(Interval i : stack2) {
            res.add(i);
        }
        
        

        return res;

    }
    
    public static void main(String [] args) {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        MergeOverlappingIntervals merge = new MergeOverlappingIntervals();
        
        intervals.add(merge.new Interval(8, 10));
        intervals.add(merge.new Interval(1, 3));
        intervals.add(merge.new Interval(2, 6));
        intervals.add(merge.new Interval(15, 18));
        
        ArrayList<Interval> result = merge.merge(intervals);
        
        for(Interval i : result) {
            System.out.println(i.start + " " + i.end);
        }
        
    }

}
