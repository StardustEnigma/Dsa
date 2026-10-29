import java.util.ArrayList;
import java.util.List;

class Solution {
    int LOG = 17;
    int[][] up;
    int[] depth;
    int[] tin;
    int[] tout;
    int timer = 0;
    int[] bit;
    int n;

    void updateBIT(int idx, int val) {
        for (; idx <= n; idx += idx & -idx) {
            bit[idx] ^= val;
        }
    }

    void rangeUpdate(int L, int R, int val) {
        updateBIT(L, val);
        updateBIT(R + 1, val);
    }

    int queryBIT(int idx) {
        int res = 0;
        for (; idx > 0; idx -= idx & -idx) {
            res ^= bit[idx];
        }
        return res;
    }

    void dfs(int u, int p, int d, List<Integer>[] adj) {
        tin[u] = ++timer;
        up[u][0] = p;
        for (int i = 1; i < LOG; i++) {
            up[u][i] = up[up[u][i - 1]][i - 1];
        }
        depth[u] = d;
        for (int v : adj[u]) {
            if (v != p) {
                dfs(v, u, d + 1, adj);
            }
        }
        tout[u] = timer;
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u; u = v; v = temp;
        }
        int diff = depth[u] - depth[v];
        for (int i = 0; i < LOG; i++) {
            if (((diff >> i) & 1) == 1) {
                u = up[u][i];
            }
        }
        if (u == v) return u;
        for (int i = LOG - 1; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
            }
        }
        return up[u][0];
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        up = new int[n][LOG];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        bit = new int[n + 2];
        timer = 0;

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        dfs(0, 0, 0, adj);

        int[] charMask = new int[n];
        for (int i = 0; i < n; i++) {
            charMask[i] = 1 << (s.charAt(i) - 'a');

            rangeUpdate(tin[i], tout[i], charMask[i]);
        }

        List<Boolean> ans = new ArrayList<>();
        
        for (String q : queries) {
            if (q.charAt(0) == 'u') { 
                int secondSpace = q.indexOf(' ', 7);
                int u = Integer.parseInt(q.substring(7, secondSpace));
                char c = q.charAt(secondSpace + 1);
                
                int newMask = 1 << (c - 'a');
                int diff = charMask[u] ^ newMask;
                charMask[u] = newMask;

                rangeUpdate(tin[u], tout[u], diff);
            } else { 
                int secondSpace = q.indexOf(' ', 6);
                int u = Integer.parseInt(q.substring(6, secondSpace));
                int v = Integer.parseInt(q.substring(secondSpace + 1));

                int L = lca(u, v);

                int mask = queryBIT(tin[u]) ^ queryBIT(tin[v]) ^ charMask[L];

                ans.add(mask == 0 || (mask & (mask - 1)) == 0);
            }
        }
        return ans;
    }
}