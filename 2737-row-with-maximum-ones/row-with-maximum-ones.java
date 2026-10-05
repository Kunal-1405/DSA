class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int rowIndex = 0;
        int maxOnes = 0;

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int val : mat[i]) {
                if (val == 1) {
                    count++;
                }
            }

            if (count > maxOnes) {
                maxOnes = count;
                rowIndex = i;
            }
        }

        return new int[]{rowIndex, maxOnes};
    }
}