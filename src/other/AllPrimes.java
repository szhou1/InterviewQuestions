package other;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Sieve of Eratosthenes
 * @author szhou
 *
 */
public class AllPrimes {
    public ArrayList<Integer> sieve(int a) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (a < 2) {
            return res;
        }

        ArrayList<Boolean> sieve = new ArrayList<Boolean>();
        sieve.add(false);
        sieve.add(false);
        for (int i = 2; i <= a; i++) {
            sieve.add(true);
        }
        for (int i = 0; i <= Math.sqrt(a); i++) {
            System.out.println("**** " + i);
            if (sieve.get(i) == true) {
                for (int j = 2; j * i <= a; j++) {
                    System.out.println("set " + i * j + " to false");
                    sieve.set(i * j, false);
                }
            }
        }

        for (int i = 2; i < sieve.size(); i++) {
            if (sieve.get(i) == true) {
                res.add(i);
            }
        }

        return res;

    }
    
    @Test
    public void test() {
        ArrayList<Integer> res = sieve(100);
        System.out.println(res.size());
        for(Integer i : res) {
            System.out.println(i + " ");
        }
    }

}
