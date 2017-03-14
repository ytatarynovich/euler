package tasks.p80;

import java.math.BigDecimal;
import java.util.stream.IntStream;

public class P80 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).mapToObj(num -> BigDecimal.valueOf(Math.sqrt(num)))
//                .filter(fraction -> fraction > 0)
                .forEach(System.out::println);
    }
    
//    private static double getFraction(double num) {
//    }
}
