class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Try to match target[0...i] as long as possible
        int matchLen = 0;
        int[] freq = count.clone();
        for (int i = 0; i < n; i++) {
            int idx = target.charAt(i) - 'a';
            if (freq[idx] > 0) {
                freq[idx]--;
                matchLen++;
            } else {
                break;
            }
        }

        // Backtrack from matchLen down to 0 to find the first index 
        // where we can pick a character strictly larger than target[i]
        for (int i = matchLen; i >= 0; i--) {
            // Reconstruct the frequency table up to index i
            int[] currentFreq = count.clone();
            for (int j = 0; j < i; j++) {
                currentFreq[target.charAt(j) - 'a']--;
            }

            // If we are at index i, look for the smallest character > target[i]
            int targetChar = (i < n) ? (target.charAt(i) - 'a') : -1;
            
            for (int c = targetChar + 1; c < 26; c++) {
                if (currentFreq[c] > 0) {
                    // Found valid split point! Construct the result.
                    char[] res = new char[n];
                    
                    // Copy exact matching prefix
                    for (int j = 0; j < i; j++) {
                        res[j] = target.charAt(j);
                    }
                    
                    // Place the strictly greater character at position i
                    res[i] = (char) ('a' + c);
                    currentFreq[c]--;
                    
                    // Fill the remaining positions (i + 1 to n - 1) with smallest remaining chars
                    int ptr = i + 1;
                    for (int ch = 0; ch < 26; ch++) {
                        while (currentFreq[ch] > 0) {
                            res[ptr++] = (char) ('a' + ch);
                            currentFreq[ch]--;
                        }
                    }
                    
                    return new String(res);
                }
            }
        }

        return "";
    }
}