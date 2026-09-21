class Solution {
    public int totalNQueens(int n) {
        List<List<String>> ans= new ArrayList<>();

        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        nQueens(board,0,n,ans);

        return ans.size();
    }
    public void nQueens(char[][] board,int row,int n,List<List<String>> ans){

        if(row == n){
            List<String> temp = new ArrayList<>();
            for(char[] r : board){
                temp.add(new String(r));
            }
            ans.add(temp);
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(board,row,col,n)){
                board[row][col]='Q';
                nQueens(board,row+1,n,ans);
                board[row][col]='.';
            }
        }
    }

    public boolean isSafe(char[][] board,int row,int col,int n){

        for(int i=0;i<row;i++){
            if(board[i][col] == 'Q'){
                return false;
            }    
        }

        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}