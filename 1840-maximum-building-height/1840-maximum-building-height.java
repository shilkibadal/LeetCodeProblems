class Solution {
    public int maxBuilding(int n, int[][] restrictions) {

        int m = restrictions.length;
        int[][] arr = new int[m + 1][2];

        // Add building 1 with height 0
        arr[0][0] = 1;
        arr[0][1] = 0;

        for (int i = 0; i < m; i++) {
            arr[i + 1] = restrictions[i];
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // Forward pass
        for (int i = 1; i <= m; i++) {
            arr[i][1] = Math.min(arr[i][1],
                    arr[i - 1][1] + (arr[i][0] - arr[i - 1][0]));
        }

        // Backward pass
        for (int i = m - 1; i >= 0; i--) {
            arr[i][1] = Math.min(arr[i][1],
                    arr[i + 1][1] + (arr[i + 1][0] - arr[i][0]));
        }

        int ans = 0;

        // Find maximum possible peak between consecutive restrictions
        for (int i = 1; i <= m; i++) {
            int x1 = arr[i - 1][0];
            int h1 = arr[i - 1][1];
            int x2 = arr[i][0];
            int h2 = arr[i][1];

            int d = x2 - x1;

            int peak = (h1 + h2 + d) / 2;

            ans = Math.max(ans, peak);
        }

        // After the last restriction
        ans = Math.max(ans, arr[m][1] + (n - arr[m][0]));

        return ans;
    }
}