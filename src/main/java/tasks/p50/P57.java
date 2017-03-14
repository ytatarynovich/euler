package tasks.p50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import utils.EulerUtils;

public class P57 {

    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        int i = 3;
        while (i < 100_000) {
            if (EulerUtils.isPrime(i)) {
                String str = String.valueOf(i);
                char[] digits = str.toCharArray();
                Arrays.sort(digits);
                String newStr = new String(digits);

                List<Integer> value = map.get(newStr);
                if (value == null) {
                    value = new ArrayList<>();
                    map.put(newStr, value);
                    value.add(i);
                }
            }
            i++;
            
//            Set s;
//            s.retainAll(s)
        }
    }
}
