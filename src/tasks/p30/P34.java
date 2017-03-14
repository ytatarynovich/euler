package tasks.p30;

import java.util.ArrayList;
import java.util.List;
import utils.EulerUtils;

public class P34 {

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            char[] chars = EulerUtils.splitNumber(new Long(i));
            int sum = 0;
            for (char ch : chars) {
                sum += EulerUtils.factorial(ch - 48);
            }

            if (sum == i) {
                result.add(i);
            }

        }

        System.out.println(result);
    }
}
