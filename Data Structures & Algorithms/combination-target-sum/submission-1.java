public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);

        dfs(0, new ArrayList<>(), 0, nums, target);
        return res;
    }

    private void dfs(int i, List<Integer> cur, int total, int[] nums, int target) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (i >= nums.length || total + nums[i] > target) {
            return;
        }

        // Include nums[i]
        cur.add(nums[i]);
        dfs(i, cur, total + nums[i], nums, target);
        cur.remove(cur.size() - 1);

        // Exclude nums[i]
        dfs(i + 1, cur, total, nums, target);
    }
}