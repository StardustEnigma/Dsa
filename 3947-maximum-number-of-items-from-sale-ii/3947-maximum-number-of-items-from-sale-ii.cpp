class Solution {
public:
    int maximumSaleItems(vector<vector<int>>& items, int budget) {
        int n = items.size();
        vector<int> freq(n + 1, 0);
        long long min_price = LLONG_MAX;
        
        for (const auto& item : items) {
            freq[item[0]]++;
            min_price = min(min_price, (long long)item[1]);
        }
        
        vector<int> mult_count(n + 1, 0);
        for (int f = 1; f <= n; ++f) {
            if (freq[f] == 0) continue;
            for (int m = f; m <= n; m += f) {
                mult_count[f] += freq[m];
            }
        }
        
        vector<pair<long long, long long>> sorted_items;
        sorted_items.reserve(n);
        for (const auto& item : items) {
            int f = item[0];
            long long p = item[1];
            long long gain = mult_count[f] - 1;
            sorted_items.push_back({p, gain});
        }
        
        sort(sorted_items.begin(), sorted_items.end());
        
        long long rem_budget = budget;
        long long total_items = 0;
        
        for (const auto& [price, gain] : sorted_items) {
            if (rem_budget < price) break;
            if (gain == 0) continue;
            if (price >= 2LL * min_price) break;
            
            long long can_buy = min(gain, rem_budget / price);
            total_items += can_buy * 2;
            rem_budget -= can_buy * price;
        }
        
        total_items += rem_budget / min_price;
        
        return (int)total_items;
    }
};