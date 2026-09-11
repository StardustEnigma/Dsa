class Solution { 
    public int totalNumbers(int[] digits) { 
        int[] freq = new int[10];
        
    for (int d : digits) { 
        freq[d]++; 
        } 
        
        int ans = 0;
        for (int h = 1; h <= 9; h++) {
         for (int t = 0; t <= 9; t++) {
             for (int u = 0; u <= 8; u += 2) {
                 int[] need = new int[10];
                 need[h]++;
                 need[t]++;
                 need[u]++; 
                 boolean possible = true; 
                 for (int d = 0; d <= 9; d++) { 
                    if (need[d] > freq[d]) { 
                        possible = false; break; 
                        } 
                        } 
                        if (possible) {
                             ans++; 
                            } 
                } 
            } 
        } 
        return ans; 
    } 
}