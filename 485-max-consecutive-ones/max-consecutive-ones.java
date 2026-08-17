class Solution {
    public int findMaxConsecutiveOnes(int[] nums) { 
        int count = 0;   // Initialize count and max_count  to track current and maximum consecutive 1s 
        int max = 0;
        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is 1, increment the count
            if (nums[i] == 1) {
                count++;
                max = Math.max(max, count); // Update maxi if current count is greater than maxi
            } else {
                count = 0; // If the current element is 0, reset the count
            }
        }
        // Return the maximum count of consecutive 1s
        return max;
    }

}
