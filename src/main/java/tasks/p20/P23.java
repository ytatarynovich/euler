package tasks.p20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.EulerUtils;

public class P23 {
    public static void main(String[] args) {
        List<Long> abundant = new ArrayList<>();
        for (long i = 1; i < 28123; i += 1) {
            List<Long> divisors = new ArrayList(EulerUtils.getDivisors(i));
            divisors.remove(new Long(i));
            long sum = EulerUtils.sum(divisors);
            
            if(sum > i) {
                abundant.add(i);
            }
        }
        
        long current = 28123;
        List<Long> result = new ArrayList<>();
        int size = abundant.size();
        while(current > 0) {
            System.out.println("Current: " + current);
            boolean flag = true;
            long i;
            for (i = 0; i < size && flag; i++) {
                for (long j = size - 1; j > -1; j--) {
                    long a1 = abundant.get((int)i);
                    long a2 = abundant.get((int)j);
                    if(current == a1 + a2) {
                        System.out.println(current + " = " + a1 + " + " + a2);
                        flag = false;
                        break;
                    }
                    
                }
            }
            
            if(flag) {
                result.add(current);
            }
            current--;
        }
        System.out.println(result);
        System.out.println("Result: " + EulerUtils.sum(result));
        
    }
}
