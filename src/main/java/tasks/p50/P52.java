package tasks.p50;

import utils.EulerUtils;

public class P52 {

    public static void main(String[] args) {
        long current = 1;

        while (true) {
            long i;
            for (i = 2; i < 7; i++) {
                if (!EulerUtils.isEquals(current, current * i)) {
                    break;
                }
            }

            if (i == 7) {
                break;
            }
            current++;
        }

        System.out.println("Answer: " + current);
    }
}
