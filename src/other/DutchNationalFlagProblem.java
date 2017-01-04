package other;

/**
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last.
 The trick is to do this with n moves and n checks
Example
Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

 * @author szhou
 *
 */
public class DutchNationalFlagProblem {

    private int[] arr;

    public DutchNationalFlagProblem(int[] arr) {
        this.arr = arr;
    }

    public int[] sort() {
        int top = 0;
        int j = 0;
        int bot = arr.length - 1;
        int mid = 1;

        while (j <= bot) {
            if (arr[j] < mid) {
                int temp = arr[top];
                arr[top] = arr[j];
                arr[j] = temp;
                top++;
                j++;
            } else if (arr[j] > mid) {
                int temp = arr[bot];
                arr[bot] = arr[j];
                arr[j] = temp;
                bot--;
            } else {
                j++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

        DutchNationalFlagProblem d = new DutchNationalFlagProblem(arr);

        arr = d.sort();
        
        for (int i : arr) {
            System.out.println(i + " ");
        }

    }
}
