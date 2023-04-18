package sorting;
//O(N^2)
public class InsertionSort {
    public static void main(String[] args) {
        int[] sortArr = {12, 6, 4, 1, 15, 10};
        insertionSort(sortArr);
        for (int i = 0; i < sortArr.length; i++) {
            System.out.print(sortArr[i] + "\n");
        }
    }

    public static void insertionSort(int[] sortArr) {
        int j;
        //start sorting from 2nd element
        for (int i = 1; i < sortArr.length; i++) {
            //saving reference on index of element before
            int swap = sortArr[i];
            for (j = i; j > 0 && swap < sortArr[j - 1]; j--) {
                //elements of sorted part moving forward,if their value is bigger then element for insertion
                sortArr[j] = sortArr[j - 1];
            }

            sortArr[j] = swap;
        }
    }
}
