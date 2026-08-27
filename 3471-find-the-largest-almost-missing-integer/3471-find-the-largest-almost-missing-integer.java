import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        // Case 1: k == 1
        if (k == 1) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int ans = -1;

            for (int num : nums) {
                if (map.get(num) == 1) {
                    ans = Math.max(ans, num);
                }
            }

            return ans;
        }

        // Case 2: k == n
        if (k == n) {
            int max = -1;

            for (int num : nums) {
                max = Math.max(max, num);
            }

            return max;
        }

        // Case 3: Only first and last can work
        int ans = -1;

        int first = nums[0];
        int last = nums[n - 1];

        int firstCount = 0;
        int lastCount = 0;

        for (int num : nums) {
            if (num == first) firstCount++;
            if (num == last) lastCount++;
        }

        if (firstCount == 1) {
            ans = Math.max(ans, first);
        }

        if (lastCount == 1) {
            ans = Math.max(ans, last);
        }

        return ans;
    }
}