class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int n = matrix.length;  // no. of rows
        int m = matrix[0].length; //number of coloumns
        int left = 0, top = 0;
        int right = m-1, bottom = n-1;
        
        while(top <= bottom && left <= right){
            // Traverse from left to right

            for(int i = left ; i <= right ; i++){
                ans.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom
            for(int i = top ; i <= bottom ; i++){
                ans.add(matrix[i][right]);
            }
            right--;

            // Traverse from right to left
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            // Traverse from bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        //Return the ans
        return ans;
    }
}