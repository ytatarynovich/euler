package tasks.p40;

import utils.EulerUtils;

public class P43 {

    public static void main(String[] args) {
        long sum = 0;
        long i = 1020000000L;
        while (i < 10000000000L) {
            System.out.println("" + i + ": " + sum);
            boolean as = true;
            String number = String.valueOf(i);
            for (int j = 9; j > -1; j--) {
                char a = number.charAt(j);
                int d = number.substring(0, j).indexOf(a);
                if (d > -1) {
                    i += Math.pow(10, (10 - j - 1));
                    as = false;
                    break;
                }
            }

            if (as) {
                i++;
            }

            if (getNum(number, new int[]{2, 3, 4}) % 2 == 0
                    && getNum(number, new int[]{3, 4, 5}) % 3 == 0
                    && getNum(number, new int[]{4, 5, 6}) % 5 == 0
                    && getNum(number, new int[]{5, 6, 7}) % 7 == 0
                    && getNum(number, new int[]{6, 7, 8}) % 11 == 0
                    && getNum(number, new int[]{7, 8, 9}) % 13 == 0
                    && getNum(number, new int[]{8, 9, 10}) % 17 == 0) {
                if (EulerUtils.isPandigital(number, '0')) {
                    sum += Long.parseLong(number);
                }
            }
        }
        System.out.println("Sum: " + sum);
    }

    static int getNum(String str, int[] pos) {
        StringBuilder builder = new StringBuilder();
        for (int i : pos) {
            i--;
            builder.append(str.charAt(i));
        }
        return Integer.parseInt(builder.toString());
    }
}
