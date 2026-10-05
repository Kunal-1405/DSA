import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int low = 1;
        int high = position[position.length - 1] - position[0];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(position, m, mid)) {
                result = mid;
                low = mid + 1; // Try finding a larger valid force
            } else {
                high = mid - 1; // Decrease target distance
            }
        }

        return result;
    }

    private boolean canPlace(int[] position, int m, int minDistance) {
        int count = 1;
        int lastPlaced = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPlaced >= minDistance) {
                count++;
                lastPlaced = position[i];
                if (count >= m) {
                    return true;
                }
            }
        }

        return count >= m;
    }
}