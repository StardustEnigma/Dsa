class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
        int even = 1;
        int odd = 0;
        long long ans = 0;
        long long currentSum = 0;
        int MOD = 1e9 + 7;

        for(int i = 0; i < arr.size(); i++) {
            currentSum += arr[i];

            if(currentSum % 2 == 0) {
                ans += odd;
                even++;
            } 

            else {
                ans += even;
                odd++;
            }
        }

        return ans % MOD;
    }
};