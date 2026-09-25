class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans= new ArrayList<>();
        StringBuilder curr= new StringBuilder();

        backtrack(n,ans,curr,0,0);
        return ans;
    }
    public void backtrack(int n,List<String> ans,StringBuilder curr,int open,int close){

        if(curr.length()== 2*n){
            ans.add(curr.toString());
            return;
        }
        if(open < n){
            curr.append("(");
            backtrack(n,ans,curr,open+1,close);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close < open){
            curr.append(")");
            backtrack(n,ans,curr,open,close+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}