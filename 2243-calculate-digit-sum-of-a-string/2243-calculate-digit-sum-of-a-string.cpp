class Solution {
public:
    string digitSum(string s, int k) {
        
        while(s.length() > k){
            string next="";

            for(int i=0;i<s.length();i+=k){
                int groupSum=0;

                for(int j = i;j<i+k && j<s.length();++j){
                    groupSum +=s[j]-'0';
                }
                next += to_string(groupSum);
            }
            s=next;
        }
        return s;
    }
};