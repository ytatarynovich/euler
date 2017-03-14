package tasks.p40;

import utils.EulerUtils;

public class P41 {
    public static void main(String[] args) {
        long max = 0;
        long current = 1L;
        while(current < 1_000_000_000L) {
            System.out.println("C: " + current + " = " + max);
            current = EulerUtils.nextDifNumber(current);
            String number = String.valueOf(current);
            if(EulerUtils.isPandigital(number, '1')) {
                if(EulerUtils.isPrime(current)) {
                    max = current;
                }
            }
        }
            
        System.out.println("Max: " + max);
    }
    
}
