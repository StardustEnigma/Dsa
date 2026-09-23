class Solution {
    public void solveSudoku(char[][] board) {
        sudoku(board,0,0);
    }

    public boolean sudoku(char[][] board,int row,int col){

        if( row == 9){
            return true;
        }
            int nextRow=row;
            int nextCol=col+1;
        if(nextCol == 9){
            nextRow = row + 1;
            nextCol=0;
        }

        if(board[row][col] != '.'){
            return sudoku(board,nextRow,nextCol);
        }

        for(char dig ='1'; dig<='9';dig++){
            if(isSafe(board,row,col,dig)){
                board[row][col]=dig;
                if(sudoku(board,nextRow,nextCol)){
                    return true;
                }
                board[row][col]='.';
            }
        }
        return false;
    }
    public boolean isSafe(char[][] board,int row,int col,char dig){
        for(int j=0;j<9;j++){
            if(board[row][j] == dig)
                return false;
        }
        for(int i=0;i<9;i++){
            if(board[i][col] == dig)
                return false;
        }
        int srow = (row/3)*3;
        int scol = (col/3)*3;
        for(int i=srow;i<srow+3;i++){
            for(int j=scol;j<scol+3;j++){
                if(board[i][j] == dig)
                    return false;
            }
        }
        return true;
    }
}