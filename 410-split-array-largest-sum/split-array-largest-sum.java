class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num); // Minimum possible largest sum
            high += num;             // Maximum possible largest sum
        }

        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                result = mid;
                high = mid - 1; // Try finding a smaller valid maximum sum
            } else {
                low = mid + 1;  // Increase allowed capacity
            }
        }

        return result;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = 0;
            }
            currentSum += num;
        }

        return count <= k;
    }
}