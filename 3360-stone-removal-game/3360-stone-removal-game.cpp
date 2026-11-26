class Solution {
public:
    bool canAliceWin(int n) {
        
        int count =0,i=10;
        
        while(n >=i && i >0){
            n-=i;
            i--;
            count++;
        }
        return count %2==1;
    }
};