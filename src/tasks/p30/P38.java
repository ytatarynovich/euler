package tasks.p30;

import utils.EulerUtils;

public class P38 {
    public static void main(String[] args) {
        long maxNumber = 0;
        long i = 1;
        while(i < 10_000) {
            int j = 1;
            StringBuilder builder = new StringBuilder();
            while(builder.length() < 9) {
                builder.append(String.valueOf(i * j));
                j++;
            }
            
            if(builder.length() == 9) {
                String str = builder.toString();
                if(EulerUtils.isPandigital(str, '1')) {
                    long value = Long.parseLong(str);
                    if(value > maxNumber) {
                        maxNumber = value;
                    }
                };
            }
            
            i++;
        }
        
        System.out.println("Result is: " + maxNumber);
        
    }
}
