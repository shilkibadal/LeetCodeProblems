class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1_000_000_007;
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

  
        for (int i = 0; i < m; i++) {
            up[i] = m - i - 1;  
            down[i] = i;         
        }

        for (int len = 3; len <= n; len++) {

            long[] newUp = new long[m];
            long[] newDown = new long[m];

          
            long suffix = 0;
            for (int i = m - 1; i >= 0; i--) {
                newUp[i] = suffix;
                suffix = (suffix + down[i]) % MOD;
            }

          
            long prefix = 0;
            for (int i = 0; i < m; i++) {
                newDown[i] = prefix;
                prefix = (prefix + up[i]) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}