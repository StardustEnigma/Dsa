class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans= new ArrayList<>();
        List<String> list=new ArrayList<>();
        partitions(s,ans,list,0);
        return ans;
    }
    public void partitions(String s,List<List<String>> ans, List<String> list, int index){
        if(index == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=index;i<s.length();i++){
            String sub=s.substring(index,i+1);
            boolean palindrome=checkPalindrome(sub);

            if(palindrome){
                list.add(sub);
                partitions(s,ans,list,i+1);
                list.remove(list.size()-1);
            }            
        }

    }
    public boolean checkPalindrome(String s){

        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}