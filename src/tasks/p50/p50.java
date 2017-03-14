package tasks.p50;

import java.util.ArrayList;
import java.util.List;
import utils.EulerUtils;

public class p50 {

    public static void main(String[] args) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3;  i < 1_000_000; i += 2) {
            System.out.println(i);
            if(EulerUtils.isPrime(i)) {
                primes.add(i);
            }
        }
        
        long maxPrime = 0;
        int size = primes.size();
        int maxCount = 0;
        for (int i = 0; i < size; i++) {
            long sum = 0;
            System.out.println(i);
            for (int j = i; j < size; j++) {
                int value = primes.get(j);
                sum += value;
                if(sum > 1_000_000) {
                    break;
                }
                
                if(EulerUtils.isPrime(sum)) {
                    int count = j - i + 1;
                    if(count > maxCount) {
                        maxCount = count;
                        maxPrime = sum;
                    }
                }
            }
        }
            
        
        System.out.println("Result: " + maxCount);
        System.out.println("Result: " + maxPrime);
    }
}
