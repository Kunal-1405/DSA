class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;     // Pointer for last valid element in nums1
        int j = n - 1;     // Pointer for last element in nums2
        int k = m + n - 1; // Pointer for insertion position in nums1

        // Compare elements from the back and place the larger element at position k
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        // Copy any remaining elements from nums2 into nums1
        // (If elements remain in nums1, they are already in their correct sorted positions)
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}