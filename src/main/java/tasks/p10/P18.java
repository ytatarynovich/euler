package tasks.p10;

import utils.EulerUtils;

public class P18 {

    public static void main(String[] args) {
        int[][] data = EulerUtils.getData("", 20);

        for (int i = 1; i < data.length; i++) {
            int[] line = data[i];
            for (int j = 0; j < line.length; j++) {
                int current = line[j];
                int nextLineValue = 0;
                int previousLineValue = 0;

                if (j < line.length - 1) {
                    nextLineValue = data[i - 1][j];
                }
                if (j > 0) {
                    previousLineValue = data[i - 1][j - 1];
                }

                int max = (int) EulerUtils.max(nextLineValue + current, current + previousLineValue);
                line[j] = max;
            }
        }

        int[] lastLine = data[data.length - 1];
        int maxIndex = 0;
        long maxValue = 0;
        int index = 0;
        for (int n : lastLine) {
            if (n > maxValue) {
                maxValue = n;
                maxIndex = index;
            }
            index++;
        }

        System.out.println("MAX: " + maxValue);
    }
}
