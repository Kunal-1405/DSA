class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        int n = nums.length;
        int[][] sortedWithIndices = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            sortedWithIndices[i][0] = nums[i];
            sortedWithIndices[i][1] = i;
        }
        
        // Sort elements by value
        Arrays.sort(sortedWithIndices, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[n];
        int i = 0;
        
        while (i < n) {
            int j = i;
            // Identify connected component boundary
            while (j + 1 < n && sortedWithIndices[j + 1][0] - sortedWithIndices[j][0] <= limit) {
                j++;
            }
            
            // Extract and sort indices belonging to the current group
            int groupSize = j - i + 1;
            int[] originalIndices = new int[groupSize];
            for (int k = 0; k < groupSize; k++) {
                originalIndices[k] = sortedWithIndices[i + k][1];
            }
            Arrays.sort(originalIndices);
            
            // Place sorted values back into sorted original positions
            for (int k = 0; k < groupSize; k++) {
                result[originalIndices[k]] = sortedWithIndices[i + k][0];
            }
            
            i = j + 1;
        }
        
        return result;
    }
}