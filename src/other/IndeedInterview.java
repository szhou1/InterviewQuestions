package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class IndeedInterview {

 // This is the text editor interface. 
 // Anything you type or change here will be seen by the other person in real time.

 //3, 5, 6, 7, 8, 9, 13
 //-1, 3, 9, 15, 19
 //3, 3, 7, 17, 21
 //m

 //k

 //k-most frequent integers

 //k = 3, 3 most frequent integers. 
 //3, 7, 9
 //k = 1
 //3
 //k = 2
 //3, 7

 // any valid int
 // any size arrays
     
  class MyMap {
     int value;
     int count;
     public MyMap(int value, int count) {
         this.value = value;
         this.count = count;
     }
 }

 public List<Integer> getKMostFreq(List<List<Integer>> m, int k) {
     
     HashMap<Integer, MyMap> map = new HashMap<>();
     
     for(List<Integer> list : m) {
         
         for(Integer i : list) {
             if(map.containsKey(i)) {
                 map.put(i, new MyMap(i, map.get(i).count + 1));
             } else {
                 map.put(i, new MyMap(i, 1));
             }
         }
         
     }
     
     Iterator<Map.Entry<Integer, MyMap>> it = map.entrySet().iterator();
     PriorityQueue<MyMap> heap = new PriorityQueue<MyMap>(new Comparator<MyMap>() {
             @Override
             public int compare(MyMap a, MyMap b) {
                 return a.count - b.count;
             }
         });
     
     while(it.hasNext()) {
         Map.Entry<Integer, MyMap> entry = it.next();
         if(heap.size() >= k && heap.peek().count < entry.getValue().count) {
             heap.poll();
             heap.offer(entry.getValue());

         } else {
             heap.offer(entry.getValue());
         }
         System.out.println("size: " + heap.size());
     }
     
     ArrayList<Integer> result = new ArrayList<>();
     
     while(heap.isEmpty() == false) {
         result.add(heap.poll().value);
     }
     
     return result;
     
 }

 public static void main(String [] args) {
     //3, 5, 6, 7, 8, 9, 13
 //-1, 3, 9, 15, 19
 //3, 3, 7, 17, 21

     List<Integer> list1 = Arrays.asList(3, 5, 6, 7, 8, 9, 13);
     List<Integer> list2 = Arrays.asList(-1, 3, 9, 15, 19);
     List<Integer> list3 = Arrays.asList(3, 3, 7, 17, 21);
     
     List<List<Integer>> allLists = Arrays.asList(list1, list2, list3);

     int k = 3;
     
     IndeedInterview s = new IndeedInterview();
     List<Integer> res = s.getKMostFreq(allLists, k);
     
     for(Integer i : res) {
         System.out.println(i);
     }
     
 }
     
     

 // O(m log(k))
    
}
