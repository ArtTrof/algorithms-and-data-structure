package sorting;
//О(n2)
public class SelectionSort {
    public static void main(String[] args) {
        int[] sortArr = {12, 6, 4, 1, 15, 10};
        selectionSort(sortArr);
        for(int i = 0; i < sortArr.length; i++){
            System.out.print(sortArr[i] + "\n");
        }
    }

    public static void selectionSort(int[] sortArr) {
        for (int i = 0; i < sortArr.length; i++) {
            int pos = i;
            int min = sortArr[i];
            //cycle of choosing min element
            for (int j = i + 1; j < sortArr.length; j++) {
                if (sortArr[j] < min) {
                    //pos - index of minimal element
                    pos = j;
                    min = sortArr[j];
                }
            }
            sortArr[pos] = sortArr[i];
            //swapping places min with sortArr[i]
            sortArr[i] = min;
        }
    }
}
