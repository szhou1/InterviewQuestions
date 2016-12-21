package other;

import org.junit.Test;

public class SquareUp {

	@Test
	public void test() {
		int[] arr = squareUp(2);

		System.out.println("*******");
		for (Integer i : arr) {
			System.out.println(i);
		}
	}

	public int[] squareUp(int n) {
		int[] arr = new int[n * n];

		int x = 1;
		for (int i = 0; i < arr.length; i += n) {
			int y = 1;
			boolean zero=false;
			for (int m = n, j = i + n - 1; m > 0;) {
				// System.out.println(i); // 0 0 0 0 4 4 4 4 8 8 8 8
				// System.out.println(j);	// 3 2 1 0 7 6 5 4 11 10 9 8
//				 System.out.println(m);		// 4 3 2 1 4 3 2 1 4 3 2 1 4 3 2 1
//				 System.out.println(x);		// 1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4
//				 System.out.println(y);		// 1 0 0 0 1 2 0 0 1 2 3 0 1 2 3 4
				 arr[j] = y;
				 if (y < x && zero==false) {
					 y++;
				 }else{
					 zero=true;
					 y = 0;
				 }

				j--;
				m--;
			}
			x++;
		}
		return arr;
	}

}
