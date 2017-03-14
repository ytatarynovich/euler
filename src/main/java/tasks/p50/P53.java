package tasks.p50;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class P53 {
    
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
            for (int j = 1; j <= i; j++) {
                if(cn(i, j).compareTo(BigInteger.valueOf(1_000_000)) > 0){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static BigInteger cn(long n, long r) {
        return fact(n).divide(fact(r).multiply(fact(n - r == 0  ? 1 : n - r)));
    }

    static BigInteger fact(long n) {
        List<BigInteger> list = new ArrayList();
        for (int i = 1; i <= n; i++) {
            list.add(BigInteger.valueOf(i));
            
        }
        return list.stream()
                .reduce(BigInteger.valueOf(1), (BigInteger a, BigInteger b) -> a.multiply(b));
    }
}
