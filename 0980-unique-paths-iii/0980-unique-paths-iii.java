class Solution {
    public int uniquePathsIII(int[][] grid) {
        int count = 1;
        int boxes=0;
        int row=0;
        int col=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==-1){
                    continue;
                }
                if(grid[i][j]==1){
                    row=i;
                    col=j;
                }
                boxes++;
            }
        }
        
        return dfs(grid,count,boxes,row,col);
    }

    public int dfs(int[][] grid,int count,int boxes ,int row,int col){
        if(!isValid(grid,row,col)){
            return 0;
        }
        int ans=0;
        if(count == boxes && grid[row][col]==2){
            return 1;
        }

            int temp=grid[row][col];
            grid[row][col]=9;
            ans += dfs(grid,count+1,boxes,row+1,col)+
            dfs(grid,count+1,boxes,row-1,col)+
            dfs(grid,count+1,boxes,row,col-1)+
            dfs(grid,count+1,boxes,row,col+1);
            grid[row][col]=temp;
        
        return ans;
    }
    public boolean isValid(int[][] grid,int row,int col){
        if(row >= grid.length || col >= grid[0].length || row  < 0 || col  <0){
            return false;
        }
        if(grid[row][col]==9 || grid[row][col]==-1){
            return false;
        }
        return true;
    }
}