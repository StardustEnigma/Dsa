class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans = 0;
        int start =0;
        int end= nums.length-1;


        for(int i=0;i<nums.length;i++){
            nums[i]=Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        while(start < end){
            long score = (nums[end] * nums[end]) - (nums[start]*nums[start]);
            ans += score;
            start++;
            end--;
        }
        if(start == end){
            ans += (nums[end]*nums[end]);
        }
        return ans;
    }       
}