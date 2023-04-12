import java.util.Arrays;
import java.util.Collections;

public class GreedyAlgorithmsMaxNumber {
    public static void main(String[] args) {
        int[] digits = {3, 1, 7, 9, 9, 5};
        System.out.println(maxNumberFromDigits(digits));
    }

    public static String maxNumberFromDigits(int[] digits) {
        return String.join("", Arrays.stream(digits).boxed()
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .toArray(String[]::new));

//        Arrays.sort(digits);
//        StringBuilder str = new StringBuilder();
//        for (int i = digits.length - 1; i >= 0; i--) {
//            str.append(digits[i]);
//        }
//        return str.toString();
    }
}
