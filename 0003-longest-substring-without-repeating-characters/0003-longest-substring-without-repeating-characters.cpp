class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char,int> freq;
        int i=0,j=0,ans=0;

        while(j<s.length()){
            freq[s[j]]++;

            if((int)freq.size() == j-i+1){
                ans= max(ans,j-i+1);
            }
            else{
                while((int)freq.size() < j-i+1){
                    freq[s[i]]--;
                    if(freq[s[i]]==0) freq.erase(s[i]);
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
};