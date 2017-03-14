package tasks.p10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import utils.EulerUtils;

public class P12 {

    static AtomicLong current = new AtomicLong(1L);
    static AtomicInteger maxCount = new AtomicInteger(1);

        public static void main(String[] args) throws ParseException {
        String first = "4/17/2001";
        String two = "17-APR-2001";
            SimpleDateFormat dateParser=new SimpleDateFormat("MM/dd/yyyy");
            Date firstIssueDate = dateParser.parse(first);
            SimpleDateFormat dateParser2=new SimpleDateFormat("d-MMM-yyyy");
            String two2 = dateParser2.format(firstIssueDate).toUpperCase();
            
            System.out.println(two2);
            
    }
//    public static void main(String[] args) {
//        int procCount = Runtime.getRuntime().availableProcessors();
//        ExecutorService executor = Executors.newFixedThreadPool(procCount);
//        for (int i = 0; i < procCount; i++) {
//            Runnable solver = new Solver();
//            executor.execute(solver);
//        }
//
//        executor.shutdown();
//        while (!executor.isTerminated());
//        System.out.println("Result: " + current.longValue());
//    }
}

class Solver implements Runnable {

    @Override
    public void run() {
        while (P12.maxCount.intValue() < 500) {
            long currentValue = P12.current.getAndAdd(1);
            long value = EulerUtils.triangleNumber(currentValue);
            if (value % 2 == 0) {
                Set<Long> divs = EulerUtils.getDivisors(value);
                synchronized (P12.maxCount) {
                    if (divs.size() > P12.maxCount.longValue()) {
                        P12.maxCount.set(divs.size());
                        System.out.println("V: " + value + " = M: " + P12.maxCount.longValue());
                    }
                }
            }
        }
    }

}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnot {
}