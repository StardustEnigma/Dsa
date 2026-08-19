class Solution {
    public int largestInteger(int[] nums, int k) {

        int[] subarrayCount = new int[51]; 

        for (int i = 0; i <= nums.length - k; i++) {
            boolean[] seenInCurrentWindow = new boolean[51];
            
            for (int j = i; j < i + k; j++) {
                if (!seenInCurrentWindow[nums[j]]) {
                    seenInCurrentWindow[nums[j]] = true;
                    subarrayCount[nums[j]]++;
                }
            }
        }

        for (int i = 50; i >= 0; i--) {
            if (subarrayCount[i] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}