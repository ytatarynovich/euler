package tasks.p50;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

public class P59 {
    public static void main(String[] args) throws IOException {
        
        
        Stream<String> lines = Files.lines(Paths.get("cipher.txt"));
        List<String> numbers = lines.map(line -> line.split(","))
             .flatMap(Arrays::stream).collect(toList());

        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        List<String> l3 = new ArrayList<>();
        
        int current = 0;
        while(current < numbers.size()) {
            if(current % 3 == 0) {
                l1.add(numbers.get(current));
            } else if(current % 3 == 1) {
                l2.add(numbers.get(current));
            } else {
                l3.add(numbers.get(current));
            }
            
            current++;
        }

        Map<String, Long> counters1 = l1.stream().collect(Collectors.groupingBy(s -> s, 
                                  Collectors.counting()));
        Map<String, Long> counters2 = l2.stream().collect(Collectors.groupingBy(s -> s, 
                                  Collectors.counting()));
        Map<String, Long> counters3 = l3.stream().collect(Collectors.groupingBy(s -> s, 
                                  Collectors.counting()));
        
        
        Map<String, Long> m1 = new TreeMap<>(Comparator.comparing(e -> counters1.get(e)));
        m1.putAll(counters1);
        System.out.println(m1);
        Map<String, Long> m2 = new TreeMap<>(Comparator.comparing(e -> counters2.get(e)));
        m2.putAll(counters2);
        System.out.println(m2);
        Map<String, Long> m3 = new TreeMap<>(Comparator.comparing(e -> counters3.get(e)));
        m3.putAll(counters3);
        System.out.println(m3);
        
        Map<Character, List<Case>> map = new HashMap<>();
        for (char i = 'a'; i < 'z' + 1; i++) {
            List<Case> cases = new ArrayList<>();
            map.put(i, cases);
            for (char j = ' '; j < '~'; j++) {
                Case newCase = new Case();
                newCase.ch1 = j;
                int c = i ^ j;
                newCase.value = c;
                cases.add(newCase);
            }
        }
        
        List<Character> as1 = new ArrayList<>();
        List<Character> as2 = new ArrayList<>();
        List<Character> as3 = new ArrayList<>();
        for (Character key : map.keySet()) {
            List<Integer> values = map.get(key).stream().map(p -> p.value).collect(toList());
            if(l1.stream().allMatch(valu -> values.contains(Integer.valueOf(valu)))) {
                as1.add(key);
            }
            
            if(l2.stream().allMatch(valu -> values.contains(Integer.valueOf(valu)))) {
                 as2.add(key);
            }
             
            if(l3.stream().allMatch(valu -> values.contains(Integer.valueOf(valu)))) {
                 as3.add(key);
            }
        }
        
        
        for (Character as11 : as1) {
            System.out.println("l1: " +  as11);
        }
        
        for (Character as12 : as2) {
            System.out.println("l2: " +  as12);
        }
        
        for (Character as13 : as3) {
            System.out.println("l3: " +  as13);
        }
        
        char max1 = 71;
        char max2 = 79;
        char max3 = 68;
        
        System.out.println("pos 1: ");
         for (Character as11 : as1) {
            System.out.println((char)max1 ^ as11);
        }
        
          System.out.println("pos 2: ");
        for (Character as12 : as2) {
            System.out.println((char)max2 ^ as12);
        }
        
         System.out.println("pos 3: ");
        for (Character as13 : as3) {
            System.out.println((char)max3 ^ as13);
        }
        
        
        List<Integer> c1 = l1.stream().map(val -> {
           char v = (char) (int)Integer.parseInt(val);
            return  v ^ 'g';
        }).collect(toList());
        List<Integer> c2 = l2.stream().map(val -> {
           char v = (char) (int)Integer.parseInt(val);
            return  v ^ 'o';
        }).collect(toList());
        List<Integer> c3 = l3.stream().map(val -> {
           char v = (char) (int)Integer.parseInt(val);
            return  v ^ 'd';
        }).collect(toList());
        
        List<String> text = new ArrayList<>();
        for (int j = 0; j < c1.size(); j++) {
            char x = (char) (int)c1.get(j);
            text.add(String.valueOf(x));
            if(j < c2.size()) {
                x = (char) (int)c2.get(j);
                 text.add(String.valueOf(x));
            }
            if(j < c3.size()) {
                x = (char) (int)c3.get(j);
                text.add(String.valueOf(x));
            }
        }
        
        
        int sum = text.stream().map(st -> {
            return (int)st.charAt(0);
        }).reduce(0, Integer::sum);
        
        
        System.out.println(sum);
    }
}


class Case {
    char ch1;
    char ch2;
    
    int value;
}
