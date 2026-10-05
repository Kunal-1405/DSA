class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // Impossible if total required flowers exceed total available flowers
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                result = mid;
                high = mid - 1; // Try finding a smaller valid number of days
            } else {
                low = mid + 1;  // Need more days for flowers to bloom
            }
        }

        return result;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0;
        int count = 0;

        for (int day : bloomDay) {
            if (day <= days) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                    if (bouquets >= m) {
                        return true;
                    }
                }
            } else {
                count = 0; // Reset contiguous sequence
            }
        }

        return bouquets >= m;
    }
}