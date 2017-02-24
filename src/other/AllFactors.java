package other;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class AllFactors {

    public ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        res.add(1);
        if (a == 1) {
            return res;
        }
        res.add(a);

        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                res.add(i);
                if (i != Math.sqrt(a)) {
                    res.add(a / i);
                }
            }
        }
        Collections.sort(res);

        return res;
    }

    @Test
    public void test() {
        ArrayList<Integer> list = allFactors(10004);
        System.out.println(list.size());
    }
}
