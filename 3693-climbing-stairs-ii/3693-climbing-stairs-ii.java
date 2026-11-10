class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            int stepCost = costs[i - 1];
            
            if (i >= 1 && dp[i - 1] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 1] + stepCost + 1);
            }
            
            if (i >= 2 && dp[i - 2] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 2] + stepCost + 4);
            }

            if (i >= 3 && dp[i - 3] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 3] + stepCost + 9);
            }
        }
        
        return dp[n];
    }
}