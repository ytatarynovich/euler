package tasks.p40;

import java.util.ArrayList;
import java.util.List;
import utils.EulerUtils;

public class P46 {
    public static void main(String[] args) {
        List<Long> primes = new ArrayList<>();
        for (long i = 3; i < 100000; i += 2) {
            if(EulerUtils.isPrime(i)) {
                primes.add(i);
            }
        }
        
        long i = 5;
        
        while(true) {
            if(EulerUtils.isPrime(i)) {
                i += 2;
                continue;
            }
            
            boolean isExists = false;
            for(Long prime : primes) {
                long current = prime;
                int square = 1;
                while(current <= i) {
                    current = prime + 2 * square * square;
                    if(current == i) {
                        System.out.println(current + " = " + prime + " + 2 * " + square + " ^ 2");
                        isExists = true;
                        break;
                    }
                    square++;
                }
                
                if(isExists) {
                    break;
                }
            }
            
            
            if(!isExists) {
                break;
            }
            i += 2;
        }
        
        System.out.println("Result is: " + i);
    }
}
