
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj[u].add(new int[]{v, w});
        }

        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];
            int count = curr[2];

            if (u == n - 1) {
                return d;
            }

            if (d > dist[u][count]) continue;

            for (int[] edge : adj[u]) {
                int v = edge[0];
                int w = edge[1];
                
                int newCount = (labels.charAt(u) == labels.charAt(v)) ? count + 1 : 1;

                if (newCount <= k) {
                    int newDist = d + w;
                    if (newDist < dist[v][newCount]) {
                        dist[v][newCount] = newDist;
                        pq.offer(new int[]{newDist, v, newCount});
                    }
                }
            }
        }

        return -1;
    }
}