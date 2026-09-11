class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;

        // d1: Hundreds place (1-9)
        for (int d1 = 1; d1 <= 9; d1++) {
            if (freq[d1] == 0) continue;
            freq[d1]--;

            // d2: Tens place (0-9)
            for (int d2 = 0; d2 <= 9; d2++) {
                if (freq[d2] == 0) continue;
                freq[d2]--;

                // d3: Units place (even digits: 0, 2, 4, 6, 8)
                for (int d3 = 0; d3 <= 8; d3 += 2) {
                    if (freq[d3] > 0) {
                        count++;
                    }
                }

                freq[d2]++; // Backtrack d2
            }

            freq[d1]++; // Backtrack d1
        }

        return count;
    }
}