package tasks.p50;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P58 {
    
    public static void main(String[] args) {
        float percent = 100;
        int level = 2;
        int sum = 1;
        int primeCount = 0;
        while(percent >= 0.1) {
            List<Integer> list = generateLevel(level);
            List<Integer> diagonal = diagonal(list);
            sum += 4;
            primeCount += diagonal.stream().filter(P58::isPrime).count();
            percent = primeCount / (float)sum;
            level++;
            System.out.println(percent);
        }
        
        System.out.println((level - 1) * 2 - 1);
        System.out.println(percent);
    }
    
    private static List<Integer> generateLevel(int level) {
        int levelCount = level * 2  - 1;
        int prevLevelCount = (level - 1) * 2  - 1;
        int startValue = (prevLevelCount) * (prevLevelCount) + 1;
        List<Integer> result =  Stream.iterate(startValue, n -> n + 1)
                                      .limit((levelCount - 1) * 4)
                                      .collect(toList());
        
        return result;
    }
    
    
    private static List<Integer> diagonal(List<Integer> items) {
        int level = items.size() / 4  + 1; 
        int step = (level - 1);
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            result.add(items.get(i * step - 1));
        }
        return result;
    }
    
    private static boolean isPrime(int value) {
        int root = (int) Math.sqrt(value);
        
        return IntStream.rangeClosed(2, root).noneMatch(i -> value % i == 0);
    }
}
