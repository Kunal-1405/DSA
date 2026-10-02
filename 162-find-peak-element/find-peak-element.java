class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // Peak lies on the right side
                left = mid + 1;
            } else {
                // Peak lies on the left side (or is mid itself)
                right = mid;
            }
        }

        return left; // 'left' and 'right' converge on a peak index
    }
}