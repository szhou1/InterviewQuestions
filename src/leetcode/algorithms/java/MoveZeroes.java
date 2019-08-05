package leetcode.algorithms;

public class MoveZeroes {
	public static void main(String [] args){
/**		Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

		For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

		Note:
		You must do this in-place without making a copy of the array.
		Minimize the total number of operations.
**/
		
//		int [] nums = {0,5,0,3,7};
		int [] nums ={3,0,2,6,0};
		
//		for(int i = 0; i < nums.length; i++){
//			// insertion sort
//			if(nums[i] == 0){
//				//search for nonzero and swap
//				for(int j = i; j< nums.length; j++){
//					if(nums[j] != 0){
//						//swap
//						nums[i] = nums[j];
//						nums[j] = 0;
//						break;
//					}
//				}
//			}			
//		}
		
		if(nums == null || nums.length < 2){
			return;
		}

		int n = 0;
		for(int i=0; i<nums.length; i++){
			if(nums[i]!=0){
				nums[n] = nums[i];
				n++;
			}
		}
		
		while(n<nums.length){
			nums[n++] = 0;
		}
		
		for(int num : nums){			
			System.out.println(num);
		}
	}

}
