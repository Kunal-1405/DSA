import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, -1);
        
        // Step 1: Find the first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (left[c] == -1) left[c] = i;
            right[c] = i;
        }

        List<String> result = new ArrayList<>();
        int rightmostBound = -1;

        // Step 2: Iterate through the string to check valid valid substrings greedily
        for (int i = 0; i < n; i++) {
            // Only evaluate candidate substrings starting at the first occurrence of a character
            int c = s.charAt(i) - 'a';
            if (i != left[c]) continue;

            int newRight = checkValidSubstring(s, i, left, right);
            if (newRight == -1) continue;

            // If non-overlapping with previous, create a new substring
            if (i > rightmostBound) {
                result.add("");
            }
            
            // Greedily shrink/replace with the shortest valid substring ending earlier
            rightmostBound = newRight;
            result.set(result.size() - 1, s.substring(i, rightmostBound + 1));
        }

        return result;
    }

    private int checkValidSubstring(String s, int start, int[] left, int[] right) {
        int maxRight = right[s.charAt(start) - 'a'];
        
        for (int j = start; j <= maxRight; j++) {
            int c = s.charAt(j) - 'a';
            // If an inner character appears before the start, this start point is invalid
            if (left[c] < start) return -1;
            maxRight = Math.max(maxRight, right[c]);
        }
        
        return maxRight;
    }
}