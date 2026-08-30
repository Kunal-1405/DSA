class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                
                /* Swap nums[low] and nums[mid], then 
                move both low and mid pointers forward*/
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
                
            } else if (nums[mid] == 1) {
                // Move mid pointer forward
                mid++;
            } else {
                /* Swap nums[mid] and nums[high], 
                then move high pointer backward*/
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}