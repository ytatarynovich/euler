package tasks.k;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Multitreading {

    public static void main(String[] args) {
              
        int length = 10000;
        Random random = new Random();  
        int[] a = new int[length];
        
        for (int i = 0; i < length; i++) {
            a[i] = random.nextInt(length);
        }
        
        System.out.println("Origin: " + Arrays.toString(a));
        
        new ForkJoinPool().invoke(new MergeSortAction(a, 0, a.length - 1));
        
        System.out.println("Sorted: " + Arrays.toString(a));
    }
    
}
