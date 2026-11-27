class Solution {
public:
    int maximumSaleItems(vector<vector<int>>& items, int budget) {
        int n = items.size();
        const int MAX_F = 1500;

        vector<int> freq(MAX_F + 1, 0);
        for (const auto& item : items) {
            freq[item[0]]++;
        }
        
        vector<int> divisibleCount(MAX_F + 1, 0);
        for (int f = 1; f <= MAX_F; ++f) {
            if (freq[f] == 0) continue;
            for (int multiple = f; multiple <= MAX_F; multiple += f) {
                divisibleCount[f] += freq[multiple];
            }
        }
        
        vector<int> dp(budget + 1, 0);
        
        for (int i = 0; i < n; ++i) {
            int f = items[i][0];
            int p = items[i][1];
            if (p > budget) continue;
            
            int firstGain = divisibleCount[f];
            
            for (int b = budget; b >= p; --b) {
                dp[b] = max(dp[b], dp[b - p] + firstGain);
            }

            for (int b = p; b <= budget; ++b) {
                dp[b] = max(dp[b], dp[b - p] + 1);
            }
        }
        
        return dp[budget];
    }
};