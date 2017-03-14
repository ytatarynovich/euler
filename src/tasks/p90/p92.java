package tasks.p90;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import utils.EulerUtils;

public class p92 {

    static final Map<Long, Boolean> cash = Collections.synchronizedMap(new HashMap<Long, Boolean>());
    static final AtomicInteger threadCount = new AtomicInteger(0);
    static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        int procCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(procCount);

        int part = 10_000_000 / procCount;
        long start;
        long end;
        for (int i = 0; i < 4; i++) {
            start = part * i;
            if(start == 0) {
                start = 1;
            }
            end = part * (i + 1);
            Runnable solver = new Solver(start, end);
            executor.execute(solver);
        }

        executor.shutdown();
        while(!executor.isTerminated());
        System.out.println("Result: " + count.toString());

    }
}

class Solver implements Runnable {

    private final long start;
    private final long end;

    Solver(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (long i = start; i < end; i++) {
            long current = i;
            while (current != 89 && current != 1) {
                if (p92.cash.containsKey(current)) {
                    if (p92.cash.get(current)) {
                        current = 89L;
                    }

                    break;
                }

                char[] digits = EulerUtils.splitNumber(current);
                long sum = 0;
                for (char digit : digits) {
                    long num = digit - 48;
                    sum += num * num;
                }
                current = sum;
            }

            if (current == 89L) {
                p92.cash.put(i, Boolean.TRUE);
                p92.count.incrementAndGet();
            } else {
                p92.cash.put(i, Boolean.FALSE);
            }
        }
        p92.threadCount.incrementAndGet();
    }
    
    
}
