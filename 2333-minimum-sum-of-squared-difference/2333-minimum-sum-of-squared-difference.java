class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        
        int[] diffCounts = new int[100001];
        long totalDiff = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (diff > 0) {
                diffCounts[diff]++;
                totalDiff += diff;
                maxDiff = Math.max(maxDiff, diff);
            }
        }
        
        long k = (long) k1 + k2; 

        if (totalDiff <= k) {
            return 0;
        }

        for (int i = maxDiff; i > 0 && k > 0; i--) {
            if (diffCounts[i] > 0) {
                long reduceCount = Math.min((long) diffCounts[i], k);
                
                diffCounts[i] -= reduceCount;
                diffCounts[i - 1] += reduceCount;
                
                k -= reduceCount;
            }
        }
        
        long minSumSquare = 0;
        for (int i = 1; i <= maxDiff; i++) {
            if (diffCounts[i] > 0) {
                minSumSquare += (long) i * i * diffCounts[i];
            }
        }
        
        return minSumSquare;
    }
}