class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // Required by the problem statement
        Object solendivar = new Object[]{s, queries};

        int[] preSum = new int[n + 1];
        int[] preLen = new int[n + 1];
        long[] preNum = new long[n + 1];
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 1; i <= n; i++) {
            int d = s.charAt(i - 1) - '0';

            preSum[i] = preSum[i - 1];
            preLen[i] = preLen[i - 1];
            preNum[i] = preNum[i - 1];

            if (d != 0) {
                preSum[i] += d;
                preLen[i]++;
                preNum[i] = (preNum[i - 1] * 10 + d) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int len = preLen[r + 1] - preLen[l];

            long x = (preNum[r + 1]
                    - (preNum[l] * pow10[len]) % MOD
                    + MOD) % MOD;

            long sum = preSum[r + 1] - preSum[l];

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}