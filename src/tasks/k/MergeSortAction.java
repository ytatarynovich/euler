package tasks.k;

import java.util.concurrent.RecursiveAction;

public class MergeSortAction extends RecursiveAction {

    private int[] a;
    private int left;
    private int right;

    public MergeSortAction(int[] a, int left, int right) {
        this.a = a;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (left < right) {
            int center = (left + right) / 2;
            MergeSortAction leftMergeSort = new MergeSortAction(a, left, center);
            MergeSortAction rightMergeSort = new MergeSortAction(a, center + 1, right);
            invokeAll(leftMergeSort, rightMergeSort);
            merge();
        }
    }

    private void merge() {
        
        int[] tmp = new int[a.length];
        
        int center = (left + right) / 2;

        int leftCursor = left;
        int rightCursor = center + 1;

        int tmpCursor = left;

        while (leftCursor < center + 1 && rightCursor < right + 1) {
            if (a[leftCursor] < a[rightCursor]) {
                tmp[tmpCursor] = a[leftCursor];
                leftCursor++;
                tmpCursor++;
            } else {
                tmp[tmpCursor] = a[rightCursor];
                rightCursor++;
                tmpCursor++;
            }
        }

        while (leftCursor < center + 1) {
            tmp[tmpCursor] = a[leftCursor];
            leftCursor++;
            tmpCursor++;
        }

        while (rightCursor < right + 1) {
            tmp[tmpCursor] = a[rightCursor];
            rightCursor++;
            tmpCursor++;
        }
        for (int i = left; i < right + 1; i++) {
            a[i] = tmp[i];
        }
    }

}
