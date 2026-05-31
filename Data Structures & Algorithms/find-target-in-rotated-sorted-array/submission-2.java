class Solution {
    public int search(int[] nums, int target) {
        int min = findMin(nums);
        int res = -1;
        if(nums[nums.length-1] >= target){
            res = search(nums,target, min, nums.length-1);
        }else{
            res = search(nums,target, 0, min-1);
        }
        return res;
    }

    private int findMin(int[] nums) {
        int len = nums.length-1;
        if(nums[0] <= nums[len])return 0;
        int hi = len, lo = 0;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;

            if(mid < len && nums[mid] < nums[mid+1] && mid > 0 && nums[mid] < nums[mid - 1]){
                return mid;
            }

            if(nums[mid] < nums[len]){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public int search(int[] nums, int target, int start, int end) {
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
