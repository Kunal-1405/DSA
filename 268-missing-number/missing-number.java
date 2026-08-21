class Solution {
    public int missingNumber(int[] nums) {
        int i=0,sum=0,sum1=0;
        int n = nums.length;
        sum = (n*(n+1))/2;
        for(i=0; i<n; i++){
            sum1 += nums[i];
        }
        int miss = sum-sum1;
        return miss;
    }
}