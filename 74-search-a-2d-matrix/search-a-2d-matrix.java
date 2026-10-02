class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        // Treat the 2D matrix as a flattened 1D sorted array
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Map 1D mid index back to 2D matrix row and column
            int midVal = matrix[mid / cols][mid % cols];

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}