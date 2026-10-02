class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        // Start from top-right corner
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                // Target is smaller, so it can't be in this column
                col--;
            } else {
                // Target is larger, so it can't be in this row
                row++;
            }
        }

        return false;
    }
}