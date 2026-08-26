import java.util.*;
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }

        // If there are fewer than k '1's in the entire string, return empty
        if (ones.size() < k) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        String result = "";

        // Iterate through all windows of size k in the 'ones' list
        for (int i = 0; i <= ones.size() - k; i++) {
            int start = ones.get(i);
            int end = ones.get(i + k - 1);
            int currentLen = end - start + 1;

            // Found a strictly shorter beautiful substring
            if (currentLen < minLen) {
                minLen = currentLen;
                result = s.substring(start, end + 1);
            } 
            // Found a same-length beautiful substring: pick lexicographically smaller one
            else if (currentLen == minLen) {
                String candidate = s.substring(start, end + 1);
                if (candidate.compareTo(result) < 0) {
                    result = candidate;
                }
            }
        }
        return result;
    }
}