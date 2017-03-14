package tasks.p20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import utils.EulerUtils;

public class P24 {
    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        List<Integer> digits = new ArrayList<>();
        digits.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        int current = 0;
        for (long i = 9; i >= 0; i--) {
            int index = 0;
            long factorial = EulerUtils.factorial(i);
            while(current < 1_000_000) {
                if(current + factorial >= 1_000_000) {
                    break;
                }
                current += factorial;
                index++;
            }
            
            result.add(digits.remove(index));
        }
        System.out.println("Result: " + result);
    }
    
}
