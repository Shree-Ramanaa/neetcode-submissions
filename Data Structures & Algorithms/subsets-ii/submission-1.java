class Solution {
    HashSet<String> hs = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
     List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
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
        int nxt = i+1;
        while(nxt < nums.length && nums[i] == nums[nxt])nxt++;
        rec(nxt, nums, subset, res);
    }
}
