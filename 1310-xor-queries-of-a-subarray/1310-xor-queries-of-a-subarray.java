class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length];
        int xor=0;
        for(int i=0; i< arr.length;i++){
            prefix[i] = xor ^ arr[i];
            xor=prefix[i];
        }

        int[] ans= new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            
            if (left==0){
                ans[i]=prefix[right];
            }
            else{
                ans[i]=prefix[right] ^ prefix[left-1];
            }
        }
        return ans;
    }
}