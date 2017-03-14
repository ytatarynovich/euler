package tasks.p40;

import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.EulerUtils;

public class P49 {

    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 1487; i < 10_000; i++) {
            if (EulerUtils.isPrime(i)) {
                String str = String.valueOf(i);
                char[] digits = str.toCharArray();
                Arrays.sort(digits);
                String newStr = new String(digits);

                List<Integer> value = map.get(newStr);
                if (value == null) {
                    value = new ArrayList<>();
                    map.put(newStr, value);
                }
                value.add(i);
            }

        }

        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : map.values()) {
            for (int i = 1; i < list.size() - 1; i++) {
                int current = list.get(i);
                List<Integer> diffs = new ArrayList<>();
                for (int j = 0; j < list.size(); j++) {
                    int next = list.get(j);
                    int currentDiff = Math.abs(current - next);
                    if (diffs.contains(currentDiff)) {
                        List<Integer> item = new ArrayList<>();
                        item.add(next);
                        item.add(current);
                        if(list.contains(current - currentDiff)) {
                            item.add(current - currentDiff);
                        }
                        result.add(item);
                    }
                    if(currentDiff > 0)
                    diffs.add(currentDiff);
                }
            }
        }

        System.out.println(result);
    }
}
