class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        boolean isSorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) return 0;

        if (n == 2) return -1;
        

        char mn = 'z';
        char mx = 'a';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < mn) mn = c;
            if (c > mx) mx = c;
        }
        
        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) {
            return 1;
        }
        
        boolean minOnlyAtEnd = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == mn) {
                minOnlyAtEnd = false;
                break;
            }
        }
        
        boolean maxOnlyAtStart = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == mx) {
                maxOnlyAtStart = false;
                break;
            }
        }
        
        if (minOnlyAtEnd && maxOnlyAtStart) {
            return 3;
        }
        
        return 2;
    }
}