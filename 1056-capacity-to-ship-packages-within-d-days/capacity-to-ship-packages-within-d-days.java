class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight); // Minimum capacity must be at least the heaviest single item
            high += weight;             // Maximum capacity is shipping everything in 1 day
        }

        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                result = mid;
                high = mid - 1; // Try to find a smaller valid capacity
            } else {
                low = mid + 1;  // Increase capacity
            }
        }

        return result;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int requiredDays = 1;
        int currentWeight = 0;

        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                requiredDays++;
                currentWeight = 0;
            }
            currentWeight += weight;
        }

        return requiredDays <= days;
    }
}