class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        // Find max pile size to set upper search bound
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canEatAll(piles, h, mid)) {
                ans = mid;      // Try a slower eating speed
                right = mid - 1;
            } else {
                left = mid + 1; // Speed too slow, must eat faster
            }
        }

        return ans;
    }

    private boolean canEatAll(int[] piles, int h, int k) {
        long totalHours = 0;
        for (int pile : piles) {
            // Equivalent to Math.ceil((double) pile / k) using integer arithmetic
            totalHours += (pile + k - 1L) / k;
        }
        return totalHours <= h;
    }
}