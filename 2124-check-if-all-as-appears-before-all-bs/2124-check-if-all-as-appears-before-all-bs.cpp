class Solution {
public:
    bool checkString(string s) {
        
        bool prevB=false;

        for(int i=0;i<s.length();i++){

            if(s[i]=='b'){
                prevB=true;
            }
            else if(s[i]=='a' && prevB==true){
                return false;
            }
        }
        return true;
    }
};