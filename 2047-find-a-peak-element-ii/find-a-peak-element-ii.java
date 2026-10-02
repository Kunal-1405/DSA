class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int leftCol = 0;
        int rightCol = mat[0].length - 1;

        while (leftCol <= rightCol) {
            int midCol = leftCol + (rightCol - leftCol) / 2;

            // Find the row with the maximum value in the middle column
            int maxRow = 0;
            for (int r = 0; r < mat.length; r++) {
                if (mat[r][midCol] > mat[maxRow][midCol]) {
                    maxRow = r;
                }
            }

            // Check neighbors to the left and right
            boolean isLeftGreater = midCol > 0 && mat[maxRow][midCol - 1] > mat[maxRow][midCol];
            boolean isRightGreater = midCol < mat[0].length - 1 && mat[maxRow][midCol + 1] > mat[maxRow][midCol];

            if (!isLeftGreater && !isRightGreater) {
                // Peak found: maximum in column and strictly greater than left/right neighbors
                return new int[]{maxRow, midCol};
            } else if (isRightGreater) {
                // A higher element exists on the right; peak must exist in the right half
                leftCol = midCol + 1;
            } else {
                // A higher element exists on the left; peak must exist in the left half
                rightCol = midCol - 1;
            }
        }

        return new int[]{-1, -1};
    }
}