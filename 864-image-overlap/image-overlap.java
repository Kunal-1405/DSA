class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int[] list1 = new int[n * n];
        int[] list2 = new int[n * n];
        int count1 = 0, count2 = 0;

        // Encode coordinates as single integers: (row * 100 + col)
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) list1[count1++] = r * 100 + c;
                if (img2[r][c] == 1) list2[count2++] = r * 100 + c;
            }
        }

        // Use a 1D frequency array for offset tracking
        // Offsets range from -3000 to +3000, so size 6000 with a offset of 3000 is sufficient
        int[] count = new int[6000];
        int maxOverlap = 0;

        for (int i = 0; i < count1; i++) {
            for (int j = 0; j < count2; j++) {
                int diff = list1[i] - list2[j] + 3000;
                count[diff]++;
                if (count[diff] > maxOverlap) {
                    maxOverlap = count[diff];
                }
            }
        }

        return maxOverlap;
    }
}