class Solution {
    public int missingNumber(int[] nums) {
        int xor1=0, xor2=0, i=0;
        int n= nums.length;
        for(i=0; i<n; i++){
            xor1 = xor1^(i+1);
            xor2 = xor2^nums[i];
        }
        return(xor1^xor2);
    }
}