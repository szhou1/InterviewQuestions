package interviewcake.algorithms;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class _04_MergeOverlappingIntervals {

    public class Interval {
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() < 2) {
            return intervals;
        }
        
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        
        List<Interval> res = new ArrayList<>();
        
        Interval interval = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++) {
            if(interval.end < intervals.get(i).start) {
                res.add(interval);
                interval = intervals.get(i);
            } else {
                interval.end = Math.max(interval.end, intervals.get(i).end);
            }
            
        }
        res.add(interval);
        
        return res;
    }
    
    @Test
    public void test() {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(15, 18));
        
        List<Interval> result = merge(intervals);
        
        assertEquals(result.size(), 3);
        
        ArrayList<Interval> result1 = new ArrayList<>();
        result1.add(new Interval(1, 6));
        result1.add(new Interval(8, 10));
        result1.add(new Interval(15, 18));

        for(int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).start, result1.get(i).start);
            assertEquals(result.get(i).end, result1.get(i).end);
        }
        
    }

    @Test
    public void test1() {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 3));
        
        List<Interval> result = merge(intervals);
        
        assertEquals(result.size(), 1);
        
        ArrayList<Interval> result1 = new ArrayList<>();
        result1.add(new Interval(1, 4));

        for(int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).start, result1.get(i).start);
            assertEquals(result.get(i).end, result1.get(i).end);
        }
        
        
    }
}
