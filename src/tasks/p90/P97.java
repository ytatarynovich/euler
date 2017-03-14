package tasks.p90;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P97 {
    public static void main(String[] args) {
        String word = "1 2\n 3 5\n 8";
        
        int index = word.indexOf("\n");
        List<Integer> list = new ArrayList<>();
        while (index >= 0) {
            list.add(index);
            index = word.indexOf("\n", index + 1);
        }
        
        System.out.println("Replaced: "  + word.replaceAll("\n", ""));
        String text = word.replaceAll("\n", "");
        String[] s = text.split("");
        List<String> as = new ArrayList();
        for (String a : s) {
            as.add(a);
        }
        for (Integer asd : list) {
            as.add(asd, "\n");
        }
        
        String commaSeparatedNumbers = as.stream()
     .collect(Collectors.joining(""));
        System.out.println("Again: " + commaSeparatedNumbers);
    }
    
}
