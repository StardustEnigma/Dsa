class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 0) dfs(grid, 0, j);
            if (grid[rows - 1][j] == 0) dfs(grid, rows - 1, j);
        }
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 0) dfs(grid, i, 0);
            if (grid[i][cols - 1] == 0) dfs(grid, i, cols - 1);
        }

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 0) {
            return;
        }
        
        grid[i][j] = 1;
        
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}