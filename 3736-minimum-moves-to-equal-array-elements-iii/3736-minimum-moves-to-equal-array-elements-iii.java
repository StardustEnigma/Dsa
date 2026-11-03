class Solution {
    public int minMoves(int[] nums) {
        int max=maxElement(nums);

        int ans=0;
        for(int i=0; i< nums.length;i++){
            ans +=Math.abs(max-nums[i]);
        }
        return ans;
    }
    public int maxElement(int[] nums){
        int max=nums[0];

        for(int i=0;i<nums.length;i++){
            if(max < nums[i]){
                max=nums[i];
            }
        }
        return max;
    }
}