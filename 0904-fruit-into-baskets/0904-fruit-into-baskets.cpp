class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        int ans=0,i=0,j=0;
        unordered_map<int,int> freq;

        while(j<fruits.size()){
            freq[fruits[j]]++;

            if((int)freq.size()<=2){
                ans= max(ans,j-i+1);
            }
            else if((int)freq.size() > 2){
                while((int)freq.size() > 2){
                    freq[fruits[i]]--;

                    if(freq[fruits[i]]==0){
                        freq.erase(fruits[i]);
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
};