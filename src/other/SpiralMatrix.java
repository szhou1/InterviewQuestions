package other;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Populate result;
        if (a.size() == 1 && a.get(0).size() == 1) {
            result.add(a.get(0).get(0));
            return result;
        }

        int top = 0;
        int bot = a.size() - 1;
        int left = 0;
        int right = a.get(0).size() - 1;
        int dir = 0;

        while (top <= bot && left <= right) {
            if (dir == 0) {
                // System.out.println("go from left to right");
                for (int i = left; i <= right; i++) {
                    // System.out.println(a.get(top).get(i));
                    result.add(a.get(top).get(i));
                }
                top++;
                dir = 1;
            } else if (dir == 1) {
                // System.out.println("go from top to bottom");
                for (int i = top; i <= bot; i++) {
                    // System.out.println(i + " " + right);
                    // System.out.println(a.get(i).get(right));
                    result.add(a.get(i).get(right));
                }
                right--;
                dir = 2;
            } else if (dir == 2) {
                // System.out.println("go from right to left");
                for (int i = right; i >= left; i--) {
                    // System.out.println(a.get(bot).get(i));
                    result.add(a.get(bot).get(i));
                }
                bot--;
                dir = 3;
            } else if (dir == 3) {
                // System.out.println("go from bottom to top");
                for (int i = bot; i >= top; i--) {
                    // System.out.println(a.get(i).get(left));
                    result.add(a.get(i).get(left));
                }
                left++;
                dir = 0;
            }
        }

        return result;
    }
}
