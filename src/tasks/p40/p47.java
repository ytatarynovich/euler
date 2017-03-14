package tasks.p40;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.EulerUtils;

public class p47 {

    public static void main(String[] args) {
        List<Long> result = new ArrayList<>();
        int count = 0;
        long current = 1;
        while(count != 4) {
            System.out.println(current);
            if(isAllDivisorsPrimes(current)) {
                result.add(current);
                count++;
            } else {
                result.clear();
                count = 0;
            }
            current++;
        }
        System.out.println("Result: " + result);
    }

    private static boolean isAllDivisorsPrimes(long value) {
        Set<Long> divs = new HashSet<>(EulerUtils.getDistinctDivisors(value));
        boolean result = false;
        int count = 0;
        for (Long div : divs) {
            if (EulerUtils.isPrime(div)) {
                count++;
                if (count > 3) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }
}
