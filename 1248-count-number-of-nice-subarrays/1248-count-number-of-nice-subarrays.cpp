class Solution {
public:
    int atmost(vector<int>& nums,int k){
        if(k<0) return 0;

        int odd=0,i=0,ans=0;

        for(int j=0;j<nums.size();j++){
            if(nums[j]%2 != 0){
                odd++;
            }

            while(odd > k){
                if(nums[i] %2 !=0){
                    odd--;
                }
                i++;
            }
            ans += j-i+1;
        }
        return ans;
    }

    int numberOfSubarrays(vector<int>& nums, int k) {
        return atmost(nums,k) - atmost(nums,k-1);
    }
};