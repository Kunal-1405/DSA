class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        return BinarySearch(nums,0,n-1,target);
    
    }
    private int BinarySearch(int[] arr,int low,int high,int target){
        if(low>high){
            return -1;
        }
        int mid = (low + high)/2;
        if(arr[mid] == target){
            return mid;
        }else if(target > arr[mid]){
            return BinarySearch(arr,mid+1,high,target);
        }else{
            return BinarySearch(arr,low,mid-1,target);
        }
    }
}