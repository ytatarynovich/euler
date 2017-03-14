package tasks.p30;

import java.util.Arrays;

public class p31 {
    final static int[] MONEY = new int[] {1, 2, 5, 10, 20, 50, 100, 200};
        
    public static void main(String[] args) {
        System.out.println("asd");
        for (int i = 0; i < 10; i++) {
            
        }
    }
    
    
    public boolean isMappable(int value) {
        return value > 1 && Arrays.stream(MONEY).anyMatch(coin -> {
            return value % coin == 0;
        });
    }
}
