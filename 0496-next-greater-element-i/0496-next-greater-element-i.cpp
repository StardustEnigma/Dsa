class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
       vector<int> arr(nums2.size());
        stack<int> st;

        for(int i=nums2.size()-1;i>=0;i--){

            if(st.empty()){
                arr.push_back(-1);
            }
            else if(st.size() != 0 && st.top() > nums2[i]){
                arr.push_back(st.top());
            }
            else if(st.size() != 0 && st.top() <= nums2[i]){
                while(st.size() != 0 && st.top() <= nums2[i]){
                    st.pop();
                }
                if(st.empty()){
                    arr.push_back(-1);
                }
                else{
                    arr.push_back(st.top());
                }
            }
            st.push(nums2[i]);
        }
        reverse(arr.begin(),arr.end());
        
        unordered_map<int,int> mp;
        for(int i=0;i<nums2.size();i++){
            mp[nums2[i]]=arr[i];
        }
        vector<int> ans;

        for(int i=0;i<nums1.size();i++){
            ans.push_back(mp[nums1[i]]);
        }
        return ans;
    }
};