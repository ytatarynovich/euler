package tasks.p20;

import utils.EulerUtils;
import java.util.ArrayList;
import java.util.List;

public class P27 {
    public static void main(String[] args) {
        int am = 0;
        int bm = 0;
        int maxN = 0;
        List<Integer> m = new ArrayList<>();
        List<Long> v = new ArrayList<>();
        for (int a = -999; a < 1000; a++) {
            for (int b = -999; b < 1000; b++) {
                int n = 0;
                while (true) {
                    long value = n * n + a * n + b;
                    if (!EulerUtils.isPrime(value)) {
                        
                        break;
                    }
                    v.add(value);
                    n++;
                }

                if (n > maxN) {
                    maxN = n;
                    am = a;
                    bm = b;
                    m.add(maxN);
                    System.out.println("Coef: " + am + " = " + bm + " max:" +maxN);
                    System.out.println(v);
                }
                v.clear();
                
            }

        }
        System.out.println(am + " * " + bm + " = " + am * bm);
        
    }
}
