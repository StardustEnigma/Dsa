class Solution {
    public int minMoves(int[] nums) {
        int min = minElement(nums);

        int moves =0;

        for(int i=0;i<nums.length;i++){
            moves += (nums[i]-min);
        }
        return moves;
    }
    public int minElement(int[] nums){
        int min=nums[0];

        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
            }
        }
        return min;
    }
}