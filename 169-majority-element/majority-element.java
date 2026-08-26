class Solution {
    public int majorityElement(int[] nums) {
        // candidate will hold the number we currently think is the majority
        int candidate = 0;
        // count keeps track of the "strength" of our current candidate
        int count = 0;

        for (int num : nums) {
            // If count hits 0, it means all previous numbers canceled each other out.
            // Pick the current number as our new potential candidate!
            if (count == 0) {
                candidate = num;
            }
            // If we see our candidate again, boost its count (+1).
            // If we see a different number, it cancels out one candidate (-1).
            if (num == candidate) {
                     count++;
            } else {
                count--;
            }
        }
        // Since a majority element appears more than n/2 times, 
        // it is guaranteed to be the last candidate surviving!
        return candidate;
    }
}