class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> cnt = new HashMap<>();

        for (int x : nums) {
            cnt.put((long) x, cnt.getOrDefault((long) x, 0) + 1);
        }

        int ans = 1;

        // Handle 1 separately
        if (cnt.containsKey(1L)) {
            int ones = cnt.get(1L);
            ans = Math.max(ans, (ones % 2 == 1) ? ones : ones - 1);
        }

        for (long x : cnt.keySet()) {
            if (x == 1L) continue;

            long cur = x;
            int len = 0;

            while (cnt.getOrDefault(cur, 0) >= 2) {
                len += 2;

                // Prevent overflow
                if (cur > 1000000000L / cur) break;

                cur *= cur;
            }

            if (cnt.getOrDefault(cur, 0) == 1) {
                len++;
            } else {
                len--;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}