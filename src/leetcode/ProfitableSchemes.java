package leetcode;

/**
 * This is a group of n members, and a list of various crimes they could commit. The ith crime generates a profit[i] and requires group[i] members to participate in it. If a member participates in one crime, that member can't participate in another crime.
 * Let's call a profitable scheme any subset of these crimes that generates at least minProfit profit, and the total number of members participating in that subset of crimes is at most n.
 * Return the number of schemes that can be chosen. Since the answer may be very large, return it modulo 109 + 7.
 * Example 1:
 * Input: n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 * Output: 2
 * Explanation: To make a profit of at least 3, the group could either commit crimes 0 and 1, or just crime 1.
 * In total, there are 2 schemes.
 */
public class ProfitableSchemes {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = (int)1e9 + 7;
        int N = group.length;
        int[][][] dp = new int[N+1][n+1][minProfit+1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= N; i++) {
            int g = group[i-1];
            int p = profit[i-1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = (dp[i-1][j][k] + (j >= g ? dp[i-1][j-g][Math.max(0, k-p)] : 0)) % MOD;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j <= n; j++) {
            ans = (ans + dp[N][j][minProfit]) % MOD;
        }
        return ans;
    }
}
