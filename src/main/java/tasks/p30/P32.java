package tasks.p30;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Set;
import utils.EulerUtils;

public class P32 {

    public static void main(String[] args) {

        Set<Long> result = new HashSet<>();
        long i = 1;
        while (i < 100) {
//            System.out.println(i);
            i = EulerUtils.nextDifNumber(i);
            long j = i;
//            int iCount = String.valueOf(i).length();
//            int jCount = (9 - iCount) / 2;
//            long j = (int) Math.pow(10, jCount);
//            int limit =  (int) Math.pow(10, 9 - iCount - jCount);
            while (j < 10000) {
                j = EulerUtils.nextDifNumber(j);
                long product = i * j;
                String productStr = String.valueOf(product);
                StringBuilder builder = new StringBuilder(productStr);
                builder.append(i).append(j);
                String builderStr = builder.toString();
                if (builderStr.length() == 9 && EulerUtils.isPandigital(builder.toString(), '1')) {
                    System.out.println(i + " * " + j + " = " + product);
                    result.add(product);
                }
            }
        }
        System.out.println(result);
        System.out.println("Result: " + EulerUtils.sum(new ArrayList<Long>(result)));
    }
}
