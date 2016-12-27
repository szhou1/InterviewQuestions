package sedgwickwayne.ch1_fundamentals;

/**
 * Lazy approach algorithm that improves the QuickFind algorithm by creating trees for each connected component
 * Runtime to union N elements: O(n)
 * Worst case to find: O(n)
 * This algorithm is still too slow and trees can get very tall thus find O(n)
 * @author szhou
 *
 */
public class QuickUnion {

	int [] arr;
	int count;

	public QuickUnion(int N) {
		arr = new int [N];
		count = N;
		for(int i = 0; i < N; i++) {
			arr[i] = i;
		}
	}
	
	public int root(int i) {
		while(arr[i] != i) {
			i = arr[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		arr[root(p)] = root(q);
		count--;
	}
	
	public static void main(String[] args) {
		QuickUnion qf = new QuickUnion(5);
		
		System.out.println(qf.connected(1, 2));
		qf.union(1, 2);
		qf.union(3, 4);
		qf.union(1, 4);
		System.out.println(qf.connected(1, 2));
		System.out.println(qf.connected(1, 3));
		System.out.println(qf.connected(1, 4));
		System.out.println(qf.connected(2, 3));
		
		System.out.println(qf.count);
	}
}
