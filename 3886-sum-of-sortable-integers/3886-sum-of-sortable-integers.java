class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean sortable = true;
            int previousMax = Integer.MIN_VALUE;

            for (int start = 0; start < n; start += k) {
                if (!isSortable(nums, start, k)) {
                    sortable = false;
                    break;
                }

                int min = nums[start];
                int max = nums[start];

                for (int i = start + 1; i < start + k; i++) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);
                }

                if (previousMax > min) {
                    sortable = false;
                    break;
                }

                previousMax = max;
            }

            if (sortable) {
                ans += k;
            }
        }

        return ans;
    }
    private boolean isSortable(int[] nums, int start, int k) {
        int decreases = 0;

        for (int i = start; i < start + k - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                decreases++;
            }
        }

        if (nums[start + k - 1] > nums[start]) {
            decreases++;
        }

        return decreases <= 1;
    }
}