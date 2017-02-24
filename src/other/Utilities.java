package other;

import java.util.ArrayList;
import java.util.Iterator;

public class Utilities<T> {
    
    public static void printArray(int [] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public static void printArray(Object [] arr) {
        for(Object i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public static void printArray(ArrayList<?> arr) {
        Iterator<?> it = arr.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString() + " ");
        }
        System.out.println();
    }
    
    public void print2DArrayList(ArrayList<ArrayList<T>> arr) {
        Iterator<ArrayList<T>> it = arr.iterator();

        while(it.hasNext()) {
            ArrayList<T> a = (ArrayList<T>) it.next();
            Iterator<T> it2 = a.iterator();
            while(it2.hasNext()) {
                System.out.print(it2.next().toString() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void print2DArray(int [][] arr) {
        for(int[] i : arr) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    
    public static void print2DArray(Object [][] arr) {
        for(Object[] i : arr) {
            for(Object j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
