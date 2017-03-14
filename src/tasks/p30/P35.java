package tasks.p30;

import java.util.ArrayList;
import java.util.List;
import utils.EulerUtils;

public class P35 {

    public static void main(String[] args) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i < 1000000; i += 2) {
            System.out.println(i);
            if (EulerUtils.isPrime(i)) {
                String str = String.valueOf(i);
                int j = 0;
                String newNum = str;
                for (j = 0; j < str.length(); j++) {
                    newNum = EulerUtils.rotateNumber(newNum);
                    int num = Integer.parseInt(newNum);
                    if (!EulerUtils.isPrime(num)) {
                        break;
                    }
                }
                if (j == str.length()) {
                    primes.add(i);
                }
            }

        }
        System.out.println("Count: " + primes.size());
    }
}
