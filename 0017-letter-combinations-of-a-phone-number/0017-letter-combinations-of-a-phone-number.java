class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    
    List<String> ans= new ArrayList<>();
    if(digits.length()==0){
        return ans;
    }
    combinations(digits,map,ans,0,"");

    return ans;
    }

    public void combinations(String digits,String[] map,List<String> ans,int index,String curr){
        
        if(index==digits.length()){
            ans.add(curr);
            return;
        }

        String letter = map[digits.charAt(index) - '0'];

        for(int i=0;i<letter.length();i++){

            curr = curr + letter.charAt(i);
            combinations(digits,map,ans,index+1,curr);
            curr = curr.substring(0, curr.length() - 1);
        }

    }
}