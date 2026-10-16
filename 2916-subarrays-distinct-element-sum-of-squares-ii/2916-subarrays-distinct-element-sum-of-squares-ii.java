
class Solution {
    private long[] sum1;
    private long[] sum2;
    private long[] lazy;
    private final int MOD = 1000000007;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum1 = new long[4 * n + 1];
        sum2 = new long[4 * n + 1];
        lazy = new long[4 * n + 1];
        
        Map<Integer, Integer> lastOccur = new HashMap<>();
        long totalSum = 0;
        
        for (int i = 1; i <= n; i++) {
            int val = nums[i - 1];
            int last = lastOccur.getOrDefault(val, 0);

            update(1, 1, n, last + 1, i, 1);

            totalSum = (totalSum + sum2[1]) % MOD;
            
            lastOccur.put(val, i);
        }
        
        return (int) totalSum;
    }
    
    private void pushDown(int node, int start, int end) {
        if (lazy[node] != 0) {
            int mid = start + (end - start) / 2;
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;
            long v = lazy[node];
            
            long lenLeft = mid - start + 1;
            long lenRight = end - mid;
            
            sum2[leftChild] = (sum2[leftChild] + 2 * v * sum1[leftChild] % MOD + v * v % MOD * lenLeft % MOD) % MOD;
            sum1[leftChild] = (sum1[leftChild] + v * lenLeft % MOD) % MOD;
            lazy[leftChild] = (lazy[leftChild] + v) % MOD;
            
            sum2[rightChild] = (sum2[rightChild] + 2 * v * sum1[rightChild] % MOD + v * v % MOD * lenRight % MOD) % MOD;
            sum1[rightChild] = (sum1[rightChild] + v * lenRight % MOD) % MOD;
            lazy[rightChild] = (lazy[rightChild] + v) % MOD;
            
            lazy[node] = 0;
        }
    }
    
    private void update(int node, int start, int end, int l, int r, long val) {
        if (l > end || r < start) return;
        
        if (l <= start && end <= r) {
            long len = end - start + 1;
            sum2[node] = (sum2[node] + 2 * val * sum1[node] % MOD + val * val % MOD * len % MOD) % MOD;
            sum1[node] = (sum1[node] + val * len % MOD) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
            return;
        }
        
        pushDown(node, start, end);
        int mid = start + (end - start) / 2;
        
        update(2 * node, start, mid, l, r, val);
        update(2 * node + 1, mid + 1, end, l, r, val);
        
        sum1[node] = (sum1[2 * node] + sum1[2 * node + 1]) % MOD;
        sum2[node] = (sum2[2 * node] + sum2[2 * node + 1]) % MOD;
    }
}