import java.util.*;

class Solution {

    private int[][] dp;
    private int[] suffixSum;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        suffixSum = new int[n + 1];

        // Build suffix sum
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        dp = new int[n][n + 1];

        // -1 means not calculated yet
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 1);
    }

    private int solve(int i, int M) {

        // No piles left
        if (i >= n) {
            return 0;
        }

        // Can take all remaining piles
        if (i + 2 * M >= n) {
            return suffixSum[i];
        }

        // Already calculated
        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        int maxStones = 0;

        // Try taking X piles
        for (int X = 1; X <= 2 * M; X++) {

            int nextM = Math.max(M, X);

            // What remains - what opponent can get
            int currentPlayerStones =
                    suffixSum[i] -
                    solve(i + X, nextM);

            maxStones = Math.max(maxStones, currentPlayerStones);
        }

        return dp[i][M] = maxStones;
    }
}