class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        rec(0,nums,new ArrayList<>(), res);
        return res;
    }

    private void rec(int i, int[] nums, List<Integer> subset, List<List<Integer>> res){
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        rec(i+1, nums, subset, res);
        subset.remove(subset.size() - 1);
        rec(i+1, nums, subset, res);
    }
}
