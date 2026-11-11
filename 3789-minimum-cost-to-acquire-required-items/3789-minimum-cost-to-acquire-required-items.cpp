class Solution {
public:
    long long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long long c1 = cost1, c2 = cost2, cb = costBoth;
        long long n1 = need1, n2 = need2;

        long long m= min(need1,need2);
        long long M=max(need1,need2);

        long long a = n1 * c1 + n2 * c2;
        long long b = m * cb + (n1 - m) * c1 + (n2 - m) * c2;
        long long c = M * cb;

        return min({a,b,c});
    }
};