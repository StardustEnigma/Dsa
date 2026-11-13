class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
 
        int sum=0;
        for(int x : cardPoints){
            sum += x;
        }

        int n = cardPoints.size();
        int window= n-k;
        if (k == n) {
        return sum; 
}
        int minScore = sum;
        int score=0;

        int i=0,j=0;
        while(j < n){
            score += cardPoints[j];

            if(j-i+1 < window){
                j++;
            }
            else if(j-i+1 == window){
                minScore=min(minScore,score);
                score -= cardPoints[i];
                i++;
                j++;
            }
        }
        return sum-minScore;
    }
};