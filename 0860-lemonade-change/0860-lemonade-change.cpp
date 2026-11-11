class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int fives=0,tens=0;

        for(int i=0;i<bills.size();i++){
            if(bills[i]==5){
                fives++;
            }
            else if(bills[i]==10){
                if(fives==0){
                    return false;
                }
                fives--;
                tens++;
            }
            else{
                if(fives >=1 && tens >=1){
                    fives--;
                    tens--;
                }
                else if(fives >=3){
                    fives -=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
};