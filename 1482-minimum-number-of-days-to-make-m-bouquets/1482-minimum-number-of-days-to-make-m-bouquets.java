class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m * k >bloomDay.length){
            return -1;
        }
        
        int max=bloomDay[0];
        int min=bloomDay[0];

        for(int num : bloomDay){
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        int left=min;
        int right=max;

        while(left <= right){
            int mid = left +(right - left)/2;

            int result=days(mid,m,k,bloomDay);

            if(result == 1){
                right = mid-1;
            }
            else if (result == 0){
                left=mid +1;
            }
        }
        return left;
    }
    public int days(int mid,int m ,int k,int []bloomDay){

        int flowers = 0;
        int bouquets = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i] <= mid){
                flowers++;
            }
            else if(bloomDay[i] > mid){
                flowers=0;
            }  

            if(flowers == k){
                bouquets++;
                flowers=0;
            }
    }
    if(bouquets >=m){
        return 1;
    }
    return 0;
    }
}