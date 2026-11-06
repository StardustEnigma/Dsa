class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int numQueries = queries.length;
        int[][] sortedQueries = new int[numQueries][2];
        for (int i = 0; i < numQueries; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[numQueries];
        int[] counts = new int[n + 1];
        int zeroCount = n;
        
        int left = 0;
        int right = 0;
        
        for (int[] q : sortedQueries) {
            int queryTime = q[0];
            int originalIndex = q[1];
            
            int startTime = queryTime - x;
            int endTime = queryTime;
            
            while (right < logs.length && logs[right][1] <= endTime) {
                int serverId = logs[right][0];
                if (counts[serverId] == 0) {
                    zeroCount--;
                }
                counts[serverId]++;
                right++;
            }

            while (left < logs.length && logs[left][1] < startTime) {
                int serverId = logs[left][0];
                counts[serverId]--;
                if (counts[serverId] == 0) {
                    zeroCount++;
                }
                left++;
            }
            result[originalIndex] = zeroCount;
        }
        
        return result;
    }
}