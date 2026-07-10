class Solution {
     public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] pos = new int[n];
        int[] comp = new int[n];

        int cid = 0;
        for (int i = 0; i < n; i++) {
            pos[arr[i][1]] = i;
            if (i > 0 && arr[i][0] - arr[i - 1][0] > maxDiff)
                cid++;
            comp[i] = cid;
        }

        int[] next = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j + 1 < n && arr[j + 1][0] - arr[i][0] <= maxDiff)
                j++;
            next[i] = j;
        }

        int LOG = 20;
        int[][] jump = new int[LOG][n];

        for (int i = 0; i < n; i++)
            jump[0][i] = next[i];

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                jump[k][i] = jump[k - 1][jump[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {

            int u = pos[queries[qi][0]];
            int v = pos[queries[qi][1]];

            if (u > v) {
                int t = u;
                u = v;
                v = t;
            }

            if (comp[u] != comp[v]) {
                ans[qi] = -1;
                continue;
            }

            if (u == v) {
                ans[qi] = 0;
                continue;
            }

            int cur = u;
            int steps = 0;

            for (int k = LOG - 1; k >= 0; k--) {
                if (jump[k][cur] < v) {
                    cur = jump[k][cur];
                    steps += 1 << k;
                }
            }

            ans[qi] = steps + 1;
        }

        return ans;
    }
}