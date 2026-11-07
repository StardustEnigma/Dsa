class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; 
            return a[1] - b[1];                 
        });

        PriorityQueue<long[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]); 
            if (a[1] != b[1]) return Long.compare(a[1], b[1]); 
            return Long.compare(a[2], b[2]);                  
        });

        for (int i = 0; i < servers.length; i++) {
            freeServers.offer(new int[]{servers[i], i});
        }

        int[] ans = new int[tasks.length];
        long time = 0;

        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);

            if (freeServers.isEmpty()) {
                time = busyServers.peek()[0];
            }

            while (!busyServers.isEmpty() && busyServers.peek()[0] <= time) {
                long[] curr = busyServers.poll();
                freeServers.offer(new int[]{(int)curr[1], (int)curr[2]});
            }

            int[] server = freeServers.poll();
            ans[i] = server[1];
            
            busyServers.offer(new long[]{time + tasks[i], server[0], server[1]});
        }

        return ans;
    }
}