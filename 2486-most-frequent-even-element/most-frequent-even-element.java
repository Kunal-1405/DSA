class Solution {
    public int mostFrequentEven(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for(int num : nums){
            max = Math.max(max,num);
        }
        int[] hash = new int[max+1];
        for(int i = 0; i<n; i++){
            hash[nums[i]]++;
        }
        int maxf = 0;
        int answer = -1;
        for(int i = 0; i<max+1; i+=2){
            if(hash[i] > maxf){
                maxf = hash[i];
                answer = i;
            }
        }
        return answer;
    }
}