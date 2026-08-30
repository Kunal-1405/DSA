class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int minIdx = 0, maxIdx = 0;
        for (int k = 0; k < n; k++) {
            if (nums[k] < nums[minIdx]) minIdx = k;
            if (nums[k] > nums[maxIdx]) maxIdx = k;
        }

        int i = Math.min(minIdx, maxIdx);
        int j = Math.max(minIdx, maxIdx);

        int removeFront = j + 1;
        int removeBack = n - i;
        int removeBoth = (i + 1) + (n - j);

        return Math.min(removeFront, Math.min(removeBack, removeBoth));
    }
}