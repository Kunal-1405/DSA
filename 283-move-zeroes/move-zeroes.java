class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int left=0,right=0;
        if(n<=1){
            return;
        }
        for(right=0; right< n; right++){
            if(nums[right]!=0){         //check whether the element is zero or not.
                int temp = nums[left];  // if not a zero swap the element to the left since all the non-zero elements are to the left
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
        

    }
}