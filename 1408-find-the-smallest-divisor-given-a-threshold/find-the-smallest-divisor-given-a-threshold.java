class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;

        // Find the maximum value in nums to set the upper search bound
        for (int num : nums) {
            right = Math.max(right, num);
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (getSum(nums, mid) <= threshold) {
                ans = mid;      // Try to find a smaller valid divisor
                right = mid - 1;
            } else {
                left = mid + 1; // Sum is too large, need a larger divisor
            }
        }

        return ans;
    }

    private int getSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            // Equivalent to Math.ceil((double) num / divisor) using integer arithmetic
            sum += (num + divisor - 1) / divisor;
        }
        return sum;
    }
}