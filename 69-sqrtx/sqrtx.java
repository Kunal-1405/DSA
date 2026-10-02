class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Use division (mid <= x / mid) to avoid integer overflow instead of (mid * mid <= x)
            if (mid <= x / mid) {
                ans = mid;     // mid is a potential answer, search right for a larger one
                left = mid + 1;
            } else {
                right = mid - 1; // mid * mid > x, search left
            }
        }

        return ans;
    }
}