package SmallestPosInteger;

import java.util.HashMap;
import java.util.Map;

public class SmallestPosInteger {
    public static int getSecondMax(int[] a) {
        if (a.length == 0) {
            return 1;
        }

        int max = Math.max(a[0], a[1]);
        int secondMax = Math.min(a[0], a[1]);
        System.out.println("max " + max);
        System.out.println("second " + secondMax);
        if (max < 0) {
            return 1;
        }

        if (secondMax < 0 && max > 0) {
            return 1;
        }

        for (int i = 2; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            } else if (a[i] > secondMax) {
                secondMax = a[i];
            }
        }

        if (secondMax + 1 == max) {
            return max + 1;
        } else {
            return secondMax + 1;
        }
    }


    public static void main(String[] args) {
        int[] a = {100, 100, 100, -1};
        System.out.println((getSecondMax(a)));
    }
}
