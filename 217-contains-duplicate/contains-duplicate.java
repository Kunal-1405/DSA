class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create a HashSet to keep track of elements we've already seen.
        // Sets only store unique elements 
        Set<Integer> seen = new HashSet<>();
        
        // Iterate through each number in the array
        for (int num : nums) {
            // Check if the number is already inside our HashSet
            if (seen.contains(num)) {
                // Duplicate found, Return true 
                return true; 
            }
            // Otherwise, add the current number to the set and continue checking
            seen.add(num);
        }
        // If we loop through the entire array without finding duplicates, return false
        return false;
    }
}