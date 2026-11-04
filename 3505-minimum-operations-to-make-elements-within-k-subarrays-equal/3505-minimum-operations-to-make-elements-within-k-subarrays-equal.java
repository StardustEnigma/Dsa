import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        Window window = new Window();
        
        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }
        cost[0] = window.getCost();
        
        for (int i = x; i < n; i++) {
            window.add(nums[i]);
            window.remove(nums[i - x]);
            cost[i - x + 1] = window.getCost();
        }
        long[][] dp = new long[n + 1][k + 1];
        long INF = (long) 1e18;
        
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0; 
        }
        
        for (int i = n - x; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], cost[i] + dp[i + x][j - 1]);
            }
        }
        
        return dp[0][k];
    }
    
    class Window {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        long sumLeft = 0;
        long sumRight = 0;
        int sizeLeft = 0;
        int sizeRight = 0;
        
        void add(int val) {
            if (left.isEmpty() || val <= left.lastKey()) {
                left.put(val, left.getOrDefault(val, 0) + 1);
                sumLeft += val;
                sizeLeft++;
            } else {
                right.put(val, right.getOrDefault(val, 0) + 1);
                sumRight += val;
                sizeRight++;
            }
            balance();
        }
        
        void remove(int val) {
            if (left.containsKey(val)) {
                int count = left.get(val);
                if (count == 1) left.remove(val);
                else left.put(val, count - 1);
                sumLeft -= val;
                sizeLeft--;
            } else {
                int count = right.get(val);
                if (count == 1) right.remove(val);
                else right.put(val, count - 1);
                sumRight -= val;
                sizeRight--;
            }
            balance();
        }
        
        void balance() {

            int targetLeftSize = (sizeLeft + sizeRight + 1) / 2;
            
            while (sizeLeft > targetLeftSize) {
                int val = left.lastKey();
                int count = left.get(val);
                if (count == 1) left.remove(val);
                else left.put(val, count - 1);
                sumLeft -= val;
                sizeLeft--;
                
                right.put(val, right.getOrDefault(val, 0) + 1);
                sumRight += val;
                sizeRight++;
            }
            
            while (sizeLeft < targetLeftSize) {
                int val = right.firstKey();
                int count = right.get(val);
                if (count == 1) right.remove(val);
                else right.put(val, count - 1);
                sumRight -= val;
                sizeRight--;
                
                left.put(val, left.getOrDefault(val, 0) + 1);
                sumLeft += val;
                sizeLeft++;
            }
        }
        
        long getCost() {
            if (sizeLeft == 0) return 0;
            long median = left.lastKey();
            return sumRight - sumLeft + (long)(sizeLeft - sizeRight) * median;
        }
    }
}