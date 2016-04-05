package leetcode.algorithms;

import java.util.HashMap;

public class TwoSum {
	
	public static void main(String [] args){
		int [] result = twoSum(new int [] {3,2,4,5}, 9);
		System.out.println(result[0] + " " + result[1]);
		
	}
	
	public static int [] twoSum(int[]numbers, int target){
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<numbers.length;i++){
        	//loop through each value
        	if(map.containsKey(numbers[i])){
        		int index = map.get(numbers[i]);
        		res[0] = index;
        		res[1] = i;
        	}else{
        		//value not in map, then put key=target-value inside map
        		map.put(target - numbers[i], i);
        	}
        }
        return res;

		
	}

}
