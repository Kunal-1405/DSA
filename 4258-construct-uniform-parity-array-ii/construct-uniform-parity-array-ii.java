class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        boolean hasOdd = false;

        // 1. Find the smallest odd element
        for (int x : nums1) {
            if (x % 2 != 0) {
                hasOdd = true;
                minOdd = Math.min(minOdd, x);
            }
        }

        // If there are no odd numbers, all elements are already even.
        if (!hasOdd) {
            return true;
        }

        // 2. To make everything odd, every even element must be > minOdd
        for (int x : nums1) {
            if (x % 2 == 0 && x < minOdd) {
                return false;
            }
        }

        return true;
    }
}