class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;

        // Iterate through all 3-digit even numbers
        for (int i = 100; i < 1000; i += 2) {
            int d1 = i / 100;       // Hundreds digit
            int d2 = (i / 10) % 10; // Tens digit
            int d3 = i % 10;        // Units digit

            // Count required frequency for the current number
            int[] currentFreq = new int[10];
            currentFreq[d1]++;
            currentFreq[d2]++;
            currentFreq[d3]++;

            // Verify if digits are available
            if (currentFreq[d1] <= freq[d1] && 
                currentFreq[d2] <= freq[d2] && 
                currentFreq[d3] <= freq[d3]) {
                count++;
            }
        }

        return count;
    }
}