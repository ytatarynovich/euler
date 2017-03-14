package tasks.p200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import utils.EulerUtils;

public class P206 {

    public static void main(String[] args) {
        int current = 10_000_000;
        long value = 10_203_040_506_070_809L;
        while (true) {
            char[] digits = EulerUtils.splitNumber(Long.valueOf(current));
            long sum = 0;
            for (int i = digits.length - 1; i > -1; i--) {
                sum += (digits[i] - 48) * (long)Math.pow(10, i * 2 + 1);
            }
            if (EulerUtils.isInt(Math.sqrt(value + sum))) {
                break;
            }
            System.out.println(value + sum);
            current++;
        }
        System.out.println(Math.sqrt(value));
    }
}

