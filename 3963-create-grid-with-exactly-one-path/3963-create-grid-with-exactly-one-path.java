class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans= new String[m];
        for(int i=0;i<m;i++){
            ans[i] ="";
            for(int j=0;j<n;j++){

                if(i == m-1 || j == 0){
                    ans[i] += ".";
                }
                else{
                    ans[i] +="#";
                }
            }
        }
        return ans;

    }
}