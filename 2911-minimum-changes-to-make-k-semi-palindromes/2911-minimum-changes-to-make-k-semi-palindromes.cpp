class Solution {
public:
    int minimumChanges(string s, int k) {
        int n = s.length();
        
        vector<vector<int>> cost(n, vector<int>(n, 1e9));
        
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int len = j - i + 1;
                for (int d = 1; d < len; ++d) {
                    if (len % d == 0) {
                        int current_cost = 0;
                        for (int offset = 0; offset < d; ++offset) {
                            int left = i + offset;
                            int right = j - d + 1 + offset;
                            
                            while (left < right) {
                                if (s[left] != s[right]) {
                                    current_cost++;
                                }
                                left += d;
                                right -= d;
                            }
                        }
                        cost[i][j] = min(cost[i][j], current_cost);
                    }
                }
            }
        }
        
        vector<vector<int>> dp(n + 1, vector<int>(k + 1, 1e9));
        dp[0][0] = 0;
        
        for (int i = 1; i <= n; ++i) {
            for (int parts = 1; parts <= k; ++parts) {
                for (int j = 0; j < i; ++j) {
                    if (dp[j][parts - 1] != 1e9 && cost[j][i - 1] != 1e9) {
                        dp[i][parts] = min(dp[i][parts], dp[j][parts - 1] + cost[j][i - 1]);
                    }
                }
            }
        }
        
        return dp[n][k];
    }
};