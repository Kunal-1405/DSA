import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        
        // Map stores <PrefixSum, Frequency>
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Base case: a sum of 0 has occurred once (handles subarrays starting from index 0)
        prefixSumMap.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            // If (currentSum - k) exists, add its frequency to the total count
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }
            
            // Update frequency of current prefix sum
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}