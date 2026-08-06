class Solution {
    public int splitArray(int[] nums, int k) {
        int max=nums[0];
        int sum=0;
        for(int num : nums){
            sum+=num;
            if(max < num){
                max=num;
            }
        }
        int left=max;
        int right=sum;

        while(left <= right){
            int mid=left+(right-left)/2;
            int result=sum(nums,k,mid);

            if(result==1){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
    public int sum(int[] nums,int k,int mid){
        int currSum=0;
        int subarrays=1;
        for(int i=0;i<nums.length;i++){
            

            if(currSum+nums[i] > mid){
                subarrays++;
                currSum=nums[i];
            }
            else currSum+=nums[i];
        }
        if(subarrays <= k){
            return 1;
        }
        return 0;
    }
}