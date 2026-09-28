class Solution {
    public int maxDepth(String s) {
        int counter=0;
        int maxCounter=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                counter++;
                maxCounter = Math.max(maxCounter,counter);
            }
            if(s.charAt(i)==')'){
                counter--;
            }
        }
        return maxCounter;
    }
}