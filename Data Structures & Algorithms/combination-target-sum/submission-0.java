class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        rec(0, nums,target,new ArrayList<>(), res);
        return res;
    }


    private void rec(int ind, int[] nums, int target, List<Integer> comb, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(comb));
            return;
        }

        if(nums.length <= ind || target < 0){
            return;
        }
        
        comb.add(nums[ind]);
        rec(ind, nums, target - nums[ind], comb, res);
        comb.remove(comb.size() - 1);
        rec(ind + 1, nums, target, comb, res);
    }
}
