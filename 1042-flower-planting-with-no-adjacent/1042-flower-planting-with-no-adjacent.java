class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] path : paths) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }
        
        int[] ans = new int[n];
        
        colorGraph(1, n, graph, ans);
        
        return ans;
    }
    
    private boolean colorGraph(int node, int n, List<List<Integer>> graph, int[] ans) {
        if (node > n) {
            return true;
        }
        
        for (int c = 1; c <= 4; c++) {
            if (isSafe(node, c, graph, ans)) {
                ans[node - 1] = c;
                
                if (colorGraph(node + 1, n, graph, ans)) {
                    return true;
                }
                
                ans[node - 1] = 0; 
            }
        }

        return false;
    }
    
    private boolean isSafe(int node, int color, List<List<Integer>> graph, int[] ans) {
        for (int neighbor : graph.get(node)) {
            if (ans[neighbor - 1] == color) {
                return false; 
            }
        }
        return true; 
    }
}