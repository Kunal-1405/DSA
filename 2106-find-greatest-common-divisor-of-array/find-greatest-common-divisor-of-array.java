class Solution {
    public int findGCD(int[] nums) {
        int max=nums[0],min=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
            if(nums[i]<min){
                min=nums[i];
            }
        }
        return gcdHelp(min,max);
    }
    public int gcdHelp(int n1,int n2){
        while(n1!=0 && n2!=0){
            if(n1>n2){
                n1%=n2;
            }else{
                n2%=n1;
            }
        }
        if(n1==0){
            return n2;
        }
        return n1;
    } 
}