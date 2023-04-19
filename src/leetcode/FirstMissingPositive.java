package leetcode;

/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 * Example 1:
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println( firstMissingPositive(new int[]{1,2,0}));
    }
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int a = nums[i];
            if (a >= 1 && a <= n) {
                if (nums[a - 1] != a) {
                    nums[i] = nums[a - 1];
                    nums[a - 1] = a;
                } else i++;
            } else {
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) return j + 1;
        }
        return n + 1;
    }
}
