class Solution {
public:
    string minWindow(string s, string t) {
        vector<int> freq(128,0);
        int required=0;

        for(int i=0;i<t.length();i++){
            if(freq[t[i]]==0){
                required++;
            }
            freq[t[i]]++;
        }

        int start=0,end=0;
        int i=0,j=0;
        int minLen=INT_MAX;
        int formed =0;

        vector<int> window(128,0);

        while(j<s.length()){
            char rightChar=s[j];
            window[rightChar]++;

            if(freq[rightChar] > 0 && window[rightChar]==freq[rightChar]){
                formed++;
            }

            while(formed==required){
                if(j-i+1 <minLen){
                    minLen=j-i+1;
                    start=i;
                }

                char leftChar=s[i];
                window[leftChar]--;

                if (freq[leftChar] > 0 && window[leftChar] < freq[leftChar]) {
                    formed--;
                }
                i++;
            }
            j++;

        }
    return minLen == INT_MAX ? "" : s.substr(start, minLen);
    }
};