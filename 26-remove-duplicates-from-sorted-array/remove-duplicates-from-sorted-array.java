class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=0; j<nums.length; j++){
            if(nums[i] != nums[j]){
                i++;                //Move to the next position in the array for the unique element
                nums[i] = nums[j];   // Update the current position with the unique element
            }
        }
        return i+1;
    }
}