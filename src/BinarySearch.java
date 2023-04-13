public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{-1, 2, 3, 4, 5, 6, 9, 20, 100, 233}, 2));
    }

    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (key < a[middle]) {
                high = middle - 1;
            } else if (key > a[middle + 1]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
