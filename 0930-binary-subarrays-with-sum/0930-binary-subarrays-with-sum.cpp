class Solution {
public:
    int atmost(vector<int>& nums,int goal){
        if(goal < 0) return 0;
        int ones=0,i=0,ans=0;

        for(int j=0;j<nums.size();j++){
            if(nums[j]==1){
                ones++;
            }
            while(ones > goal){
                if(nums[i]==1){
                    ones--;
                }
                i++;
            }
            ans += j-i+1;
        }
        return ans;
    }

    int numSubarraysWithSum(vector<int>& nums, int goal) {
        return atmost(nums,goal) - atmost(nums,goal-1);
    }
};