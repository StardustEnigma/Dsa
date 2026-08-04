class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=max(piles);
        int k=Integer.MAX_VALUE;
        while(left <= right){
            int mid=left+(right-left)/2;

            long totalHours=totalHours(piles,mid);

            if(totalHours <= h){
                k=mid;
                right=mid-1;

            }
            else{
                left=mid+1;
            } 
        }
        return k;
    }
    public long totalHours(int[] piles,int mid){
        long total=0;

        for(int i=0;i<piles.length;i++){
            total+= (piles[i]+mid-1)/mid;
        }
        return total;
    }

    public int max(int[] piles){
        int maxInt=piles[0];

        for(int i=0;i<piles.length;i++){
            if(maxInt < piles[i]){
                maxInt=piles[i];
            }
        }
        return maxInt;
    }
}