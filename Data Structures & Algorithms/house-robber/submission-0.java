
class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        memo[0] = nums[0];

        return helper(nums,0, nums.length-1);
    }

    private int helper(int[] nums, int sum, int i){
        if(i<0){
            return sum;
        }

        if(memo[i] != -1){
            return memo[i];
        }
         
        memo[i] = Math.max(helper(nums,sum,i-2) + nums[i], helper(nums,sum,i-1));

        return memo[i];
    }
}