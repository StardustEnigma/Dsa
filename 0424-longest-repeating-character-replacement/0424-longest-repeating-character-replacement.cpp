class Solution {
public:
    int characterReplacement(string s, int k) {
        vector<int> freq(26);
        int i=0,j=0,maxLength=0;
        int maxFreq=0;

        while(j<s.length()){
            freq[s[j]-'A']++;
            maxFreq=max(maxFreq,freq[s[j] - 'A']);

            if((j-i+1) - maxFreq > k){
                freq[s[i]-'A']--;
                i++;
            }

            maxLength = max(maxLength,j-i+1);
            j++;
        }
        return maxLength;
    }
};