class Solution {
    public int findMin(int[] nums) {
        int len = nums.length-1;
        if(nums[0] <= nums[len])return nums[0];
        int hi = len, lo = 0;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;

            if(mid < len && nums[mid] < nums[mid+1] && mid > 0 && nums[mid] < nums[mid - 1]){
                return nums[mid];
            }

            if(nums[mid] < nums[len]){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return nums[lo];
    }
}
