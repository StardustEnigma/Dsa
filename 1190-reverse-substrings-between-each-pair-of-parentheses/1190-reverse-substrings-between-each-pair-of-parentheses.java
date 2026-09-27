class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();

        String curr="";

        for(char c : s.toCharArray()){

            if( c=='('){
                stack.push(curr);
                curr="";
            }
            else if(c == ')'){
                curr=reverse(curr);
                curr=stack.pop()+curr;

            }
            else{
                curr += c;
            }
        } 
        return curr;
    }
    public String reverse(String curr){
        return new StringBuilder(curr).reverse().toString();
    }
}