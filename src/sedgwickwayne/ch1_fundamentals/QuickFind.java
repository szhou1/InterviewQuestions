package sedgwickwayne.ch1_fundamentals;

/**
 * Eager algorithm that creates unions between pairs of data sets
 * Runtime for this algorithm to union N elements is O(n^2) which is just terrible
 * @author szhou
 *
 */
public class QuickFind {
	
	int [] arr;
	int count;

	public QuickFind(int N) {
		arr = new int [N];
		count = N;
		for(int i = 0; i < N; i++) {
			arr[i] = i;
		}
	}
	
	public boolean connected(int p, int q) {
		return arr[p] == arr[q];
	}
	
	public void union(int p, int q) {
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == arr[p]) {
				arr[i] = arr[q];
			}
		}
		count--;
	}
	
	public static void main(String[] args) {
		QuickFind qf = new QuickFind(5);
		System.out.println(qf);
		
		System.out.println(qf.connected(1, 2));
		qf.union(1, 2);
		System.out.println(qf.connected(1, 2));
		System.out.println(qf.count);
	}
}
