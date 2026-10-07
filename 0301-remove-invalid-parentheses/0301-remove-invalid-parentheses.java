import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int leftToRemove = 0;
        int rightToRemove = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftToRemove++;
            } else if (c == ')') {
                if (leftToRemove == 0) {
                    rightToRemove++;
                } else {
                    leftToRemove--;
                }
            }
        }
        
        List<String> result = new ArrayList<>();
        dfs(s, 0, leftToRemove, rightToRemove, result);
        return result;
    }
    
    private void dfs(String s, int index, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            if (i != index && s.charAt(i) == s.charAt(i - 1)) {
                continue; 
            }
            
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String nextStr = s.substring(0, i) + s.substring(i + 1);

                if (right > 0 && s.charAt(i) == ')') {
                    dfs(nextStr, i, left, right - 1, result);
                } 
                else if (left > 0 && s.charAt(i) == '(') {
                    dfs(nextStr, i, left - 1, right, result);
                }
            }
        }
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') count--;
            
            if (count < 0) return false;
        }
        return count == 0;
    }
}