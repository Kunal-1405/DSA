class Solution {
    public int reverseDegree(String s) {
        int totalSum = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            // 'z' - char + 1 gives reversed alphabet index ('a' = 26, ..., 'z' = 1)
            // (i + 1) gives 1-based index in string
            totalSum += ('z' - s.charAt(i) + 1) * (i + 1);
        }
        
        return totalSum;
    }
}