class Solution {
    int minXor = Integer.MAX_VALUE;
    boolean[][][] visited;

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        visited = new boolean[m][n][1024]; 
        
        dfs(grid, 0, 0, grid[0][0]);
        return minXor;
    }

    public void dfs(int[][] grid, int i, int j, int xor) {
        if (visited[i][j][xor]) {
            return;
        }
        
        visited[i][j][xor] = true;

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            minXor = Math.min(minXor, xor);
            return;
        }

        if (i + 1 < grid.length) {
            dfs(grid, i + 1, j, xor ^ grid[i + 1][j]);
        }

        if (j + 1 < grid[0].length) {
            dfs(grid, i, j + 1, xor ^ grid[i][j + 1]);
        }
    }
}