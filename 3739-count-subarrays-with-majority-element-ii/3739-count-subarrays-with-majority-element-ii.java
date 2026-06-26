class Solution {

    class BIT {
        int[] tree;
        int n;

        BIT(int n) {
            this.n = n;
            tree = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx <= n) {
                tree[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int k) {
        int n = nums.length;

        BIT bit = new BIT(2 * n + 5);

        int offset = n + 2;
        int prefix = offset;

        bit.update(prefix, 1);

        long ans = 0;

        for (int x : nums) {
            if (x == k)
                prefix++;
            else
                prefix--;

            ans += bit.query(prefix - 1);
            bit.update(prefix, 1);
        }

        return ans;
    }
}