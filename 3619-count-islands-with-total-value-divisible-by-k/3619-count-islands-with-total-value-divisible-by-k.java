class Solution {
    public int countIslands(int[][] grid, int k) {
        int row=grid.length;
        int col= grid[0].length;
        int ans= 0;
        
        for(int i=0;i< row;i++){
            for(int j=0; j< col;j++){
                if(grid[i][j] > 0 && dfs(grid,i,j) % k == 0){
                    ans++;
                }
            }
        }
        return ans;

    }
    public long dfs(int[][] grid,int i,int j){
        if(i < 0 || j < 0|| i >= grid.length|| j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        long sum=0;
        sum += grid[i][j];
        grid[i][j]=0;

        sum += dfs(grid,i+1,j);
        sum += dfs(grid,i-1,j);
        sum += dfs(grid,i,j+1);
        sum += dfs(grid,i,j-1);

        return sum;

    }
}