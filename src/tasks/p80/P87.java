package tasks.p80;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import utils.EulerUtils;

public class P87 {

    public static void main(String[] args) {
        List<Integer> primes = IntStream.rangeClosed(2, 1_100)
                .filter(EulerUtils::isPrime)
                .boxed()
                .collect(Collectors.toList());

        int count = (int) 
                primes.stream()
                .flatMap(
                        a -> primes.stream().flatMap(
                        b -> primes.stream().map(
                        c -> new int[]{a, b, c})))
                .parallel().mapToLong(P87::sumOfArray)
                .filter(a -> a < 50_000_000)
                .distinct()
                .count();
        
        System.out.println(count);

    }

    public static long sumOfArray(int[] array) {
        long sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += Math.pow(array[i], i + 2);
        }

        return sum;
    }

}
