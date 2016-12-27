package sedgwickwayne.ch1_fundamentals;

/**
 * Improved the QuickUnion algorithm to keep track of the sizes of each tree and keep trees balanced
 * Worst case to union N elements: O(n)
 * Worst case find(): O(log(n))
 * Worst case connected(): O(log(n))
 * @author szhou
 *
 */
public class UnionFind {

	int [] arr;
	int [] size;

	public UnionFind(int N) {
		arr = new int [N];
		size = new int [N];
		for(int i = 0; i < N; i++) {
			arr[i] = i;
			size[i] = 1;
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
		int rootP = root(p);
		int rootQ = root(q);
		
		if(rootP == rootQ) return;
		
		if(size[rootP] < size[rootQ]) {
			arr[rootP] = rootQ;
			size[q] += size[p];
		} else {
			arr[rootQ] = rootP;
			size[p] += size[q];
		}
	}
	
	public static void main(String[] args) {
		UnionFind qf = new UnionFind(5);
		
		System.out.println(qf.connected(1, 2));
		qf.union(1, 2);
		qf.union(3, 4);
		qf.union(1, 4);
		qf.union(0, 2);
//		System.out.println(qf.connected(1, 2));
//		System.out.println(qf.connected(1, 3));
//		System.out.println(qf.connected(1, 4));
//		System.out.println(qf.connected(2, 3));
		
		for(int i=0; i<qf.arr.length; i++) {
			System.out.print(qf.arr[i]);
		}
		System.out.println();
		for(int i=0; i<qf.size.length; i++) {
			System.out.print(qf.size[i]);
		}
		
	}
}
