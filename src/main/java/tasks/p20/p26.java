package tasks.p20;

import java.util.ArrayList;
import java.util.List;

public class p26 {

    public static void main(String[] args) {
        int maxSize = 0;
        int value = 0;
        
        for (int i = 7; i < 1000; i += 2) {
            List<Integer> values = new ArrayList<>();
            List<Integer> nums = new ArrayList<>();
            int num = 1;
            int den = i;
            while (!nums.contains(num)) {
                nums.add(num);
                if (den > num) {
                    num *= 10;
                    values.add(num /den);
                    num %= den;
                }
            }
            
            if(values.size() > maxSize) {
                maxSize = values.size();
                value = i;
            }
            
            System.out.println(i + " = " + values);
        }
        
        System.out.println(value + ": " + maxSize);
    }
}
