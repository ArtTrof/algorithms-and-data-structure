package leetcode;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] a = new char[]{'h', 'e', 'l', 'l', 'o'};
        System.out.println(a);
        new ReverseString().reverseString(a);
        System.out.println(a);
    }

    public void reverseString(char[] s) {
        int len = s.length;
        char[] res = new char[len];
        for (int i = 0; i < s.length; i++) {
            res[i] = s[s.length - i - 1];
        }
        for (int i = 0; i < s.length; i++) {
            s[i] = res[i];
        }
    }
}
