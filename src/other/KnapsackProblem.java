package other;

import java.util.ArrayList;

import org.junit.Test;

public class KnapsackProblem {

	@Test
	public void test(){
//		int res = getOptimalValue(10, 0, new int [] {2, 2, 4, 5}, new int [] {3, 7, 2, 9});
		
		ListWithBenefits [][] optimalKnapsack = new ListWithBenefits[11][5];
		
		ListWithBenefits res = findOptimalItems(10, 0, new int [] {2, 2, 4, 5}, new int [] {3, 7, 2, 9}, optimalKnapsack);
		
		System.out.println(res);
	}
	
	ListWithBenefits findOptimalItems(int w, int n, int [] val, int [] weight, ListWithBenefits[][] optimalKnapsack)
    {
		// nothing can be added to Knapsack. 
		if ( w == 0 || n == weight.length)
		{
			 optimalKnapsack[w][n] = new ListWithBenefits(0); 
			 return optimalKnapsack[w][n]; 
				
		}
		    
		// this node can not be added to Knapsack.
		if(weight[n] > w)
		   return (optimalKnapsack[w][n+1] == null) ? findOptimalItems(w, n+1, val, weight, optimalKnapsack) : optimalKnapsack[w][n+1];		
		
		// compute optimal knapsack if we want to include this item in it.
		   ListWithBenefits include_n_benefit = (optimalKnapsack[w-weight[n]][n+1] == null) ? 
											new ListWithBenefits(findOptimalItems(w-weight[n], n+1, val, weight, optimalKnapsack))
											: new ListWithBenefits (optimalKnapsack[w-weight[n]][n+1]);
		
		//  now include this item and its benefit in the knapsack	        
		include_n_benefit.listItems.add(weight[n]);
		include_n_benefit.benefit += val[n];
		
		// compute optimal knapsack if we do not want to include this item in it.
		ListWithBenefits exclude_n_benefit = (optimalKnapsack[w][n+1] == null) ? 
											  new ListWithBenefits(findOptimalItems(w, n+1, val, weight, optimalKnapsack)) 
											: new ListWithBenefits (optimalKnapsack[w][n+1]);
				 
		// check which knapsack is gives us better benefit?
		if(include_n_benefit.benefit > exclude_n_benefit.benefit)
		{
			optimalKnapsack[w][n] = new ListWithBenefits (include_n_benefit); 
			return include_n_benefit;
		}
		
		optimalKnapsack[w][n] = new ListWithBenefits (exclude_n_benefit);
		return exclude_n_benefit;
    }

	
	public class ListWithBenefits{
		ArrayList<Integer> listItems;
		int benefit;
		
		public ListWithBenefits(int benefit){
			listItems = new ArrayList<Integer>();
			this.benefit = benefit;
		}
		public ListWithBenefits(ListWithBenefits list){
			listItems = new ArrayList<Integer>();
			for(int i = 0; i < list.listItems.size(); i++){
				listItems.add(list.listItems.get(i));
			}
			this.benefit = list.benefit;
		}
	}
	
	
	/**
	 * 
	 * @param w
	 * @param n
	 * @param weight
	 * @param value
	 * @return
	 */
	public int getOptimalValue(int w, int n, int[] weight, int[] value){
		
		if(w == 0 || n == weight.length){
			return 0;
		}
		
		if(w < weight[n]){
			return getOptimalValue(w, n+1, weight, value);
		}
		
		return Math.max(getOptimalValue(w-weight[n], n+1, weight, value) + value[n], 
				getOptimalValue(w, n+1, weight, value));
		
	}
}
