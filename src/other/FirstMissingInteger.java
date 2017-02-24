package other;

import java.util.ArrayList;

public class FirstMissingInteger {
    
    static void swap(Integer [] arr, Integer a, Integer b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static int findMissingPositive2(ArrayList<Integer> input) {
         
        Integer [] arr = (Integer[]) input.toArray(new Integer[input.size()]);
        
        int size = arr.length;

        if (size == 0)
            return 1;

        for (int i = 0; i < size; i++) {
            int currentVal = arr[i];

            if (currentVal <= size && currentVal > 0 && currentVal != i + 1) {
                if (arr[currentVal - 1] != currentVal) {
                    swap(arr, currentVal - 1, i);
                    i--;
                }
            }
        }

        for (int i = 0; i < size; i++)
            if (arr[i] != i + 1)
                return i + 1; // 1 is added because indexes start from 0

        return size + 1;
    }

    public static void main(String[] a) {
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(2);
        input.add(1);
        input.add(3);
        input.add(5);
        input.add(6);
        int r = findMissingPositive2(input);
        System.out.println(r);
        
    }

}
