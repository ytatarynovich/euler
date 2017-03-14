package tasks.p40;

import java.util.ArrayList;
import java.util.List;
import utils.EulerUtils;

public class P44 {

    public static void main(String[] args) {
        int i = 1;
        List<Long> pentagon = new ArrayList<>();
        for (int j = 1; j < 10000; j++) {
            pentagon.add(EulerUtils.pentagonalNumber(j));
        }

        int k = 1;
        boolean flag = true;
        while (flag && k < 10000) {
            long value = EulerUtils.pentagonalNumber(k);
            System.out.println(k);
            for (int y = k; y < pentagon.size(); y++) {
                long item = pentagon.get(y);
                long sum = value + item;
                if (pentagon.contains(sum)) {
                    if (pentagon.contains(item - value)) {
                        flag = false;
                        System.out.println("Result is: " + (item - value));
                        break;
                    }

                }
            }
            
            k++;
        }
    }
}
