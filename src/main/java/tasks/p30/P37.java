package tasks.p30;

import java.util.ArrayList;
import java.util.List;
import utils.EulerUtils;

public class P37 {

    public static void main(String[] args) {
        List<Long> result = new ArrayList<>();
        long value = 10;
        while (result.size() < 11) {
            System.out.println(value + ": " + result.size());
            boolean isTrunc = true;
            String number = String.valueOf(value);
            String strRight = new String(number);
            String strLeft = new String(number);
            if (EulerUtils.isPrime(value)) {
                for (int i = 0; i < number.length() - 1; i++) {
                    strRight = EulerUtils.truncateRightNumber(strRight);
                    strLeft = EulerUtils.truncateLeftNumber(strLeft);
                    if (!EulerUtils.isPrime(Long.valueOf(strRight))
                            || !EulerUtils.isPrime(Long.valueOf(strLeft))) {
                        isTrunc = false;
                        break;
                    }
                }

                if (isTrunc) {
                    if(number.charAt(number.length() - 1) != '1' && number.charAt(0) !='1') {
                        result.add(value);
                    }
                }
            }
            value++;
        }


        System.out.println("Size: " + result.size());
        System.out.println("Result: " + result);
        System.out.println("Sum: " + EulerUtils.sum(result));
    }
}
