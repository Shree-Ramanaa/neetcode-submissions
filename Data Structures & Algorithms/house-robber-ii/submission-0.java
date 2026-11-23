class Solution {
    public int rob(int[] nums) {
        int n = nums.length-1;
        if(n == 0)return nums[0];

        return Math.max(robRange(nums,0,n-1), robRange(nums, 1, n));
    }


    private int robRange(int []nums, int start, int end){
        int prev2 = 0, prev1 = 0;
        int cur = 0;
        for(int i=start; i<=end; i++){
            cur = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }

        return cur;
    }
}