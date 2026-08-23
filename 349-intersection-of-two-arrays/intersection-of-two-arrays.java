class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] seen = new boolean[1001];
        
        // Mark present numbers in nums1
        for (int num : nums1) {
            seen[num] = true;
        }

        int[] temp = new int[1001];
        int count = 0;

        // Collect matching numbers from nums2 and reset boolean flag to handle duplicates
        for (int num : nums2) {
            if (seen[num]) {
                temp[count++] = num;
                seen[num] = false; 
            }
        }

        // Trim result array to actual size
        int[] result = new int[count];
        System.arraycopy(temp, 0, result, 0, count);
        return result;
    }
}