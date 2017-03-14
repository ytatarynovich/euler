package tasks.p60;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import tasks.p80.P87;
import utils.EulerUtils;

public class P60 {
    public static void main(String[] args) {
         List<Integer> primes = IntStream.rangeClosed(2, 10_000)
                .filter(EulerUtils::isPrime)
                .boxed()
                .collect(Collectors.toList());
         
         
         primes.stream()
                .flatMap(
                a -> primes.stream()
                .flatMap(
                b -> primes.stream()
                .flatMap(
                c -> primes.stream()
                .flatMap(
                d -> primes.stream()
                .flatMap(
                        b -> primes.stream().map(
                        c -> new int[]{a, b, c, d, e})))
                .parallel().mapToLong(P87::sumOfArray)
    }
}
