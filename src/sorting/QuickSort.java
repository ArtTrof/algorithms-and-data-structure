package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//same as binary search, but it's sorting
//O(N logN)
public class QuickSort {
    public static void main(String[] args) {
        int[] sortArr = {12, 6, 4, 1, 15, 10};
        quickSort(sortArr, 0, sortArr.length - 1);
        for (int i = 0; i < sortArr.length; i++) {
            System.out.print(sortArr[i] + "\n");
        }
    }

    public static void quickSort(int[] sortArr, int low, int high) {
        if (sortArr.length == 0 || low >= high) return;
        int middle = low + (high - low) / 2;
        int border = sortArr[middle];
        int i = low, j = high;
        while (i <= j) {
            while (sortArr[i] < border) i++;
            while (sortArr[j] > border) j--;
            if (i <= j) {
                int swap = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
        }
        //recursive sort of right and left part
        if (low < j) quickSort(sortArr, low, j);
        if (high > i) quickSort(sortArr, i, high);
    }
}