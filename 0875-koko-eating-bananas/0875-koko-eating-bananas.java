class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=maxArray(piles);
        int minAns=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            boolean valid=isValid(piles,h,mid);
            
            if(valid){
                high=mid-1;
                minAns=Math.min(minAns,mid);
            }
            else{
                low=mid+1;
            }
        }
        return minAns;       
    }
    public boolean isValid(int[] piles,int h,int mid){
        long hours=0;
        for(int i=0;i<piles.length;i++){
            hours=hours +(piles[i]+(long)mid-1)/mid;
        }

        if(hours>h){
            return false;
        }
        return true;
    }

    public int maxArray(int [] piles){
        int max=piles[0];
        for(int i=0;i<piles.length;i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }
        return max;
    }
}