package tasks.p30;

import java.util.HashMap;
import java.util.Map;
import utils.EulerUtils;

public class P39 {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int p = 1; p <= 1000; p++) {
            System.out.println("P: " + p);
            int count = 0;
            for (int a = 1; a < 1000; a++) {
                for (int b = 1; b < 1000; b++) {
                    double c = Math.sqrt(a * a + b * b);
                    if (!EulerUtils.isInt(c)) {
                        continue;
                    }

                    int current = a + b + (int) c;
                    if (p == current) {
                        count++;
                    }
                }
            }
            map.put(p, count);
        }

        int max = 0;
        int maxP = 0;
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if (value > max) {
                max = value;
                maxP = key;
            }
        }

        System.out.println("Result: " + maxP);
    }
}
