class Solution {
    public int search(int[] nums, int target) {
        int start=0,end=nums.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            
           if(nums[start]==target)return start;
           else if(nums[end]==target)return end;
           else if(nums[mid]==target)return mid;
           else if(target<nums[mid])end=mid-1;
           else start=mid+1;
        }
        return -1;
    }
}