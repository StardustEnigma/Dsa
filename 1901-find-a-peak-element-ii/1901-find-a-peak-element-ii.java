class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int top=0;
        int bottom=m-1;

        while(top <= bottom){
            int midRow=top + (bottom - top) / 2;

            int maxCol=0;
            for(int j=1;j<n;j++){
                if(mat[midRow][j] > mat[midRow][maxCol]){
                    maxCol=j;
                }
            }
            int max=mat[midRow][maxCol];

            int topElement = midRow == 0 ? -1 : mat[midRow - 1][maxCol];
            int bottomElement = midRow == m - 1 ? -1 : mat[midRow + 1][maxCol];

            if(max> topElement && max > bottomElement){
                return new int[]{midRow,maxCol};
            }
            else if (topElement > max){
                bottom=midRow-1;
            }
            else{
                top=midRow+1;
            }
        }
        return new int[]{-1, -1};
    }
}