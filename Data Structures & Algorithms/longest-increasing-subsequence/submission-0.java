class Solution {
    int[] memo;
    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length];
        int res = 1;
        for(int i=0; i<nums.length-1; i++){
            res = Math.max(res, helper(nums, i));
        }

        return res;
    }

    private int helper(int[] nums, int i){
        if(i == nums.length)return 0;
        if(memo[i] != 0)return memo[i];
        
        int res = 1;
        for(int j=i+1; j<nums.length; j++){
            if(nums[j] > nums[i]){
                res = Math.max(res, 1 + helper(nums, j));
            }
        }

        return memo[i] = res;
    }
}
